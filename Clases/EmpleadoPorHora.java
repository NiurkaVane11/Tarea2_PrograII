/**
 * Clase Empleado por Hora
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

public class EmpleadoPorHora extends Empleado {

    // Atributo valorPorHora = 6.
    private double valorPorHora;

    /**
     * Sobrecarga de consturctores, con parametros inicales y heredados.
     *
     * @param apellido
     * @param edad
     * @param nombre
     * @param tipoEmpleado
     * @param valorPorHora
     * 
     */
    public EmpleadoPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public EmpleadoPorHora(double valorPorHora, String apellido, int edad, String nombre) {
        super(apellido, edad, nombre, "H");
        this.valorPorHora = valorPorHora;
    }

    // Generar get & set.
    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    /*
     * redefinir metodo toString mostrar informacion
     */

    @Override
    public String toString() {
        return super.toString() + "\nEmpleado por Hora" + "\nSalario por hora: $" + valorPorHora;
    }

}
