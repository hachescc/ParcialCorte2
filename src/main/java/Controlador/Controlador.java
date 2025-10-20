/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;
import Modelo.Estudiante;
import Modelo.Fecha;
import Modelo.Persona;
import Modelo.Profesor;
import Vista.Vista;
import java.util.ArrayList;
import java.util.Comparator;


/**
 *
 * @author hugo_ale.chavarro
 */
public class Controlador {

    public static void main(String[] args) {
        Vista vista = new Vista();
        ArrayList<Persona> personas = new ArrayList<>();


        personas.add(new Estudiante("Ana Gómez", "Calle 10", "3101234567", new Fecha(15, 3, 2005), "E001"));
        personas.add(new Estudiante("Luis Torres", "Carrera 5", "3207654321", new Fecha(20, 8, 2004), "E002"));

        Profesor prof1 = new Profesor("Carlos Rojas", "Avenida 20", "3001112233", new Fecha(5, 10, 1980), "C12345", "Matemáticas", 25000);
        prof1.registrarHorasDictadas(80, "Octubre");
        
        Profesor prof2 = new Profesor("Sofia Vergara", "Calle falsa 123", "3154445566", new Fecha(12, 1, 1990), "C67890", "Ciencias", 30000);
        prof2.registrarHorasDictadas(60);
        
        personas.add(prof1);
        personas.add(prof2);

        vista.mostrarMensaje(">>> REGISTRO DEL COLEGIO CARGADO <<<");
        vista.mostrarSeparador();

        vista.mostrarMensaje("--- REPORTE DE ESTUDIANTES ---");
        for (Persona p : personas) {
            if (p instanceof Estudiante) {
                vista.mostrarMensaje(p.toString());
                vista.mostrarMensaje("");
            }
        }
        vista.mostrarSeparador();

        vista.mostrarMensaje("--- REPORTE DE PROFESORES (Ordenado por salario de menor a mayor) ---");
        
        ArrayList<Profesor> profesores = new ArrayList<>();
        double totalPrestaciones = 0.0;

        for (Persona p : personas) {
            if (p instanceof Profesor) {
                profesores.add((Profesor) p);
            }
        }

        profesores.sort(Comparator.comparingDouble(Profesor::calcularSalarioMensual));

        for (Profesor prof : profesores) {
            vista.mostrarMensaje(prof.toString());
            totalPrestaciones += prof.calcularPrestaciones();
            vista.mostrarMensaje("");
        }
        
        vista.mostrarMensaje("------------------------------------------");
        vista.mostrarMensaje("TOTAL PRESTACIONES SOCIALES A PAGAR: $" + String.format("%.2f", totalPrestaciones));
        vista.mostrarSeparador();
    }
}