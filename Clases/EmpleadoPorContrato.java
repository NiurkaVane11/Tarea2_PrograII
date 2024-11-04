/**
 * Clase EmpleadoPorContrato, clase hija de Empleado. 
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

public class EmpleadoPorContrato extends Empleado {

    // Atributo
    private double salarioMensual;

    /**
     * Sobrecarga de constructores con parametros iniciales y heredados.
     * 
     * @param apellido
     * @param edad
     * @param nombre
     * @param tipoEmpleado
     * @param salarioMensual
     */
    public EmpleadoPorContrato(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public EmpleadoPorContrato(double salarioMensual, String apellido, int edad, String nombre) {
        super(apellido, edad, nombre, "E");
        this.salarioMensual = salarioMensual;
    }

    // Generar get & set
    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    // Metodo para calcular salario, con bono del 10%

    public double salarioEmpleadoContrato() {
        salarioMensual = 870 * 1.10;
        return salarioMensual;
    }

    /*
     * refedinir metodo toString
     * 
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Empleado por Contrato" +
                "\n" + "Salario mensual: $" + String.format("%.2f", salarioEmpleadoContrato());

    }

}
