/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author hugo_ale.chavarro
 */
public class Estudiante extends Persona {
    private String codigoEstudiante;

    public Estudiante(String nombre, String direccion, String telefono, Fecha fechaNacimiento, String codigoEstudiante) {
        super(nombre, direccion, telefono, fechaNacimiento);
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String toString() {
        return "--- ROL: ESTUDIANTE ---\n" +
               super.toString() + "\n" +
               "Código: " + codigoEstudiante;
    }
}