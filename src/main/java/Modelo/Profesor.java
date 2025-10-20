/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author hugo_ale.chavarro
 */
public class Profesor extends Persona {
    private String cedula;
    private String area;
    private double salarioPorHora;
    private int horasDictadasMes;

    public Profesor(String nombre, String direccion, String telefono, Fecha fechaNacimiento, String cedula, String area, double salarioPorHora) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.cedula = cedula;
        this.area = area;
        this.salarioPorHora = salarioPorHora;
        this.horasDictadasMes = 0;
    }

    public double calcularSalarioMensual() {
        double salarioBase = this.salarioPorHora * this.horasDictadasMes;
        double bonificacion = salarioBase * 0.20;
        return salarioBase + bonificacion;
    }

    public double calcularPrestaciones() {
        return calcularSalarioMensual() * 0.17;
    }


    public void registrarHorasDictadas(int horas) {
        if (horas > 0) {
            this.horasDictadasMes += horas;
        }
    }

    public void registrarHorasDictadas(int horas, String mes) {
        if (horas > 0) {
            this.horasDictadasMes += horas;
            System.out.println("Se han registrado " + horas + " horas para el profesor " + this.nombre + " en el mes de " + mes + ".");
        }
    }


    @Override
    public String obtenerRol() {
        return "Profesor";
    }

    @Override
    public String toString() {
        return "--- ROL: PROFESOR ---\n" +
               super.toString() + "\n" +
               "Cédula: " + cedula + "\n" +
               "Área: " + area + "\n" +
               "Salario Total Mensual: $" + String.format("%.2f", calcularSalarioMensual()) + "\n" +
               "Prestaciones Sociales: $" + String.format("%.2f", calcularPrestaciones());
    }
}