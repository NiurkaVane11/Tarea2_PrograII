/**
 * Clase EmpleadoHoraOrdinaio, clase hija de EmpleadoPorHora. 
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

public class EmpleadoHoraOrdinario extends EmpleadoPorHora {

    // Atributos

    private int trabajoHora;
    private double salarioOrdinario = 0;

    /**
     * Sobrecarga de constuctores, con parametros iniciales y heredados.
     *
     * @param valorPorHora
     * @param apellido
     * @param edad
     * @param nombre
     * @param trabajoHora
     * @param valorPorHora
     */
    public EmpleadoHoraOrdinario(double valorPorHora, String apellido, int edad, String nombre) {
        super(valorPorHora, apellido, edad, nombre);
    }

    public EmpleadoHoraOrdinario(int trabajoHora, double valorPorHora) {
        super(valorPorHora);
        this.trabajoHora = trabajoHora;
    }

    // Generar get & set
    public int getTrabajoHora() {
        return trabajoHora;
    }

    public void setTrabajoHora(int trabajoHora) {
        this.trabajoHora = trabajoHora;
    }

    /*
     * Metodo salarioEmpleadoOrdinario, calcula el salario del empleado
     * ordinario con bono.
     */

    public double salarioEmpleadoOrdinario() {

        try {

            salarioOrdinario = trabajoHora * getValorPorHora();
            return salarioOrdinario * 1.10;

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
        return super.toString() + "\nEmpleado Ordinario" + "\n" +
                "Horas trabajadas: " + trabajoHora + "\n" +
                "Salario: $" + String.format("%.2f", salarioEmpleadoOrdinario());
    }

}
