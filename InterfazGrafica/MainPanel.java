
/**
 * Clase MainPanel
 * Contendeor de componentes graficos del app. 
 *
 * @author Niurka Vanesa Yupanqui
 * @date 03/11/2024
 * @version 1.0
 * 
 * Programacion II
 * Tarea 2 Herencia
 * 
 * 
 */

import java.awt.*;
import javax.swing.*;
import Clases.Empleado;
import Clases.EmpleadoPorContrato;
import Clases.EmpleadoHoraOrdinario;
import Clases.EmpleadoHoraExtraordinario; // Asegúrate de importar la clase

public class MainPanel extends JPanel {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JComboBox<String> tipoEmpleadoBox;
    private JTextField salarioField;
    private JTextField horasOrdinariasField;
    private JTextField horasExtraordinariasField;
    private JTextArea resultadoArea;
    private JButton submitButton;

    public MainPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título de la aplicación
        JLabel titleLabel = new JLabel("MultiPapel");
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        // Cargar una imagen
        ImageIcon icon = new ImageIcon("m.jpeg");
        Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(imageLabel, gbc);

        // Inicialización de campos
        nombreField = new JTextField(15);
        apellidoField = new JTextField(15);
        edadField = new JTextField(3);
        tipoEmpleadoBox = new JComboBox<>(
                new String[] { "Selecciona", "E - Contrato", "H - Por Horas", "HE - Horas Extraordinarias" });
        salarioField = new JTextField(10);
        horasOrdinariasField = new JTextField(5);
        horasExtraordinariasField = new JTextField(5);
        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setPreferredSize(new Dimension(300, 100));
        submitButton = new JButton("Consultar");

        // Añadir componentes al panel
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        add(apellidoField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1;
        add(edadField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Tipo de Empleado:"), gbc);
        gbc.gridx = 1;
        add(tipoEmpleadoBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Salario/Valor Hora:"), gbc);
        gbc.gridx = 1;
        add(salarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Horas Ordinarias:"), gbc);
        gbc.gridx = 1;
        add(horasOrdinariasField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Horas Extraordinarias:"), gbc);
        gbc.gridx = 1;
        add(horasExtraordinariasField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String edadTexto = edadField.getText();
            String tipoEmpleado = (String) tipoEmpleadoBox.getSelectedItem();
            String salario = salarioField.getText();
            String trabajoHoraTexto = horasOrdinariasField.getText();
            String trabajoHora2Texto = horasExtraordinariasField.getText();

            int edad;
            double salarioNumerico;
            int trabajoHora = 0;
            int trabajoHora2 = 0;

            // Validar edad
            try {
                edad = Integer.parseInt(edadTexto);
                if (edad < 18) {
                    JOptionPane.showMessageDialog(this, "La edad debe ser 18 o mayor.", "Error edad",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduce una edad válida.", "Error edad",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validar salario
            try {
                salarioNumerico = Double.parseDouble(salario);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Introduce un salario o valor por hora válido.",
                        "Error salario", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Validar horas ordinarias y extraordinarias
            try {
                if ("H - Por Horas".equals(tipoEmpleado) || "HE - Horas Extraordinarias".equals(tipoEmpleado)) {
                    trabajoHora = Integer.parseInt(trabajoHoraTexto);
                    if (trabajoHora <= 0) {
                        JOptionPane.showMessageDialog(this,
                                "Introduzca horas ordinarias válidas.",
                                "Error de horas", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    trabajoHora2 = Integer.parseInt(trabajoHora2Texto);
                    if (trabajoHora2 < 0) {
                        JOptionPane.showMessageDialog(this, "Las horas no pueden ser negativas.",
                                "Error de horas",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    } else if (trabajoHora2 > 20) {
                        JOptionPane.showMessageDialog(this, "Las horas extraordinarias no pueden ser más de 20.",
                                "Error de horas", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (trabajoHora > 160) {
                        JOptionPane.showMessageDialog(this, "No puede trabajar más de 160 horas ordinarias.",
                                "Error de horas",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } else {
                    trabajoHora = 0;
                    trabajoHora2 = 0;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce solo números.",
                        "Error de horas", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Empleado empleado;
            if ("E - Contrato".equals(tipoEmpleado)) {
                empleado = new EmpleadoPorContrato(salarioNumerico, apellido, edad, nombre);
                resultadoArea.setText(empleado.toString());
            } else if ("H - Por Horas".equals(tipoEmpleado)) {
                EmpleadoHoraOrdinario empleadoHora = new EmpleadoHoraOrdinario(salarioNumerico, apellido, edad, nombre);
                empleadoHora.setTrabajoHora(trabajoHora);
                resultadoArea.setText(empleadoHora.toString());
            } else if ("HE - Horas Extraordinarias".equals(tipoEmpleado)) {
                EmpleadoHoraExtraordinario empleadoHoraExtra = new EmpleadoHoraExtraordinario(salarioNumerico, apellido,
                        edad, nombre);
                empleadoHoraExtra.setTrabajoHora2(trabajoHora2);
                empleadoHoraExtra.setTrabajoHora2(trabajoHora2);

                resultadoArea.setText(empleadoHoraExtra.toString());

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un tipo de empleado.", "Error de selección",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        });

        gbc.gridy++;
        add(scrollPane, gbc);
    }
}
