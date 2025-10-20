/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author hugo_ale.chavarro
 */
public abstract class Persona {
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected Fecha fechaNacimiento;

    public Persona(String nombre, String direccion, String telefono, Fecha fechaNacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
}