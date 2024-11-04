/**
 * Clase Empleado
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

public class Empleado {

    // Atributos

    private String nombre;
    private String apellido;
    private int edad;
    public String tipoEmpleado;

    /**
     * Sobrecarga de constructores, constructor sin y con parametros.
     *
     * @param apellido
     * @param edad
     * @param nombre
     * @param tipoEmpleado
     */
    public Empleado() {
    }

    public Empleado(String apellido, int edad, String nombre, String tipoEmpleado) {
        this.apellido = apellido;
        this.edad = edad;
        this.nombre = nombre;
        this.tipoEmpleado = tipoEmpleado;
    }

    // Generar get & set.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String gettipoEmpleado() {
        String typeMessage;
        if (tipoEmpleado.equalsIgnoreCase("E")) {
            typeMessage = "Empleado con contrato";
        } else if (tipoEmpleado.equalsIgnoreCase("H")) {
            typeMessage = "Empleado por horas";
        } else {
            return "Tipo de empleado no válido. Usa 'E' o 'H'.";
        }

        return String.format("Tipo: %s\nNombre: %s %s\nEdad: %d", typeMessage, nombre, apellido, edad, tipoEmpleado);
    }

    /*
     * Metodo mostrarInformacion(), define en la los datos de la clase.
     */

    public String mostrarInformacion() {
        return toString();
    }

    @Override
    public String toString() {
        return "\n" +
                "Empleado" + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Edad: " + edad + "\n" +
                "Tipo: " + tipoEmpleado;
    }

}
