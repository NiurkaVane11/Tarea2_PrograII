/**
 * Clase EmpleadoHoraExtraordinaio, clase hija de EmpleadoPorHora. 
 *
 * @author Niurka Vanesa Yupanqui
 * @date 03/11/2024
 * @version 1.0
 * 
 * Programacion II
 * Tarea 2 Herencia
 * 
 */

package Clases;

public class EmpleadoHoraExtraordinario extends EmpleadoPorHora {

    // Atributos
    private int trabajoHora2;
    private double salarioExtraordinario = 0;

    /**
     * Sobrecarga de constuctores, con parametros iniciales y heredados.
     *
     * @param valorPorHora
     * @param apellido
     * @param edad
     * @param nombre
     * @param trabajoHora2
     * @param valorPorHora
     */
    public EmpleadoHoraExtraordinario(double valorPorHora, String apellido, int edad, String nombre) {
        super(valorPorHora, apellido, edad, nombre);
    }

    public EmpleadoHoraExtraordinario(int trabajoHora2, double valorPorHora) {
        super(valorPorHora);
        this.trabajoHora2 = trabajoHora2;
    }

    // Generar get & set.
    public int getTrabajoHora2() {
        return trabajoHora2;
    }

    public void setTrabajoHora2(int trabajoHora2) {
        this.trabajoHora2 = trabajoHora2;
    }

    /*
     * Metodo salarioEmpleadoExtraordinario, calcula el salario del empleado
     * extraordinario con bono.
     */

    public double salarioEmpleadoExtraordinario() {

        try {

            salarioExtraordinario = trabajoHora2 * getValorPorHora() * 1.5;
            return salarioExtraordinario * 1.10;

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
            return 0;
        } catch (Exception e) {

            System.out.println("Error inesperado" + e.getMessage());
            return 0;
        }
    }

    /*
     * redefinir metodo toString mostrar informacion
     */

    @Override
    public String toString() {
        double salarioEmplExt = salarioEmpleadoExtraordinario(); // Calcula el salario
        return super.toString() + "\nEmpleado Extraordinario" + "\n" +
                "Horas trabajadas: " + trabajoHora2 + "\n" +
                "Salario Extraordinario: $" + String.format("%.2f", salarioEmplExt);
    }

}
