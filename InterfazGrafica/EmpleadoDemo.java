
/**
 * Clase EmpleadoDemo, clase principal.
 *
 * @author Niurka Vanesa Yupanqui
 * @date 03/11/2024
 * @version 1.0
 * 
 * Programacion II
 * Tarea 2 Herencia
 * 
 */

import javax.swing.*;

public class EmpleadoDemo {
    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("MultiPapel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // Añadir el MainPanel al JFrame
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);

        // Visible el JFrame
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
