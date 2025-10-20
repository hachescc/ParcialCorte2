/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.Estudiante;
import Modelo.Fecha;
import Modelo.Profesor;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author hugo_ale.chavarro
 */
public class TestIntegracionyUnitario {
    private Profesor profesorTest;
    private Estudiante estudianteTest;
    private final Fecha fechaNacimientoProf = new Fecha(10, 5, 1985);
    private final Fecha fechaNacimientoEst = new Fecha(20, 10, 2005);

    @BeforeEach
    public void setUp() {
        profesorTest = new Profesor("Profesor de Prueba", "Dir Prueba", "555-TEST", fechaNacimientoProf, "C-TEST", "Pruebas", 50000.0);
        estudianteTest = new Estudiante("Estudiante de Prueba", "Dir Estudiante", "123-TEST", fechaNacimientoEst, "E-TEST-01");
    }

    // aquí empiezo los unitarios
    @Test
    public void testCreacionProfesor() {
        assertEquals("Profesor de Prueba", profesorTest.getNombre());
        assertEquals(0.0, profesorTest.calcularSalarioMensual(), "El salario inicial debe ser 0 si no ha trabajado horas.");
    }
    
    @Test
    public void testCalculoSalarioProfesor() {
        profesorTest.registrarHorasDictadas(10);
        double salarioBase = 500000.0;
        double bonificacion = salarioBase * 0.20;
        double salarioEsperado = salarioBase + bonificacion;
        
        assertEquals(salarioEsperado, profesorTest.calcularSalarioMensual());
    }

    @Test
    public void testCalculoPrestacionesProfesor() {
        profesorTest.registrarHorasDictadas(10);
        double salarioMensual = profesorTest.calcularSalarioMensual();
        double prestacionesEsperadas = salarioMensual * 0.17;
        
        assertEquals(prestacionesEsperadas, profesorTest.calcularPrestaciones());
    }
    
    @Test
    public void testRolEstudiante() {
        assertEquals("Estudiante", estudianteTest.obtenerRol());
    }

    
    //aquí empiezo el de integración
    @Test
    public void testReporteProfesoresOrdenado() {
        Profesor prof1 = new Profesor("Profesor A", "Dir A", "111", new Fecha(1,1,1990), "C1", "Area 1", 20000);
        prof1.registrarHorasDictadas(100);
        
        Profesor prof2 = new Profesor("Profesor B", "Dir B", "222", new Fecha(2,2,1991), "C2", "Area 2", 30000);
        prof2.registrarHorasDictadas(50);
        
        ArrayList<Profesor> profesores = new ArrayList<>();
        profesores.add(prof1);
        profesores.add(prof2);
        
        profesores.sort(Comparator.comparingDouble(Profesor::calcularSalarioMensual));
        
        assertEquals("Profesor B", profesores.get(0).getNombre()); 
        assertEquals("Profesor A", profesores.get(1).getNombre());
    }
}