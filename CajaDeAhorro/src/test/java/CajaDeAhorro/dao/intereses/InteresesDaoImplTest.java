/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.intereses;

import CajaDeAhorro.bd.domain.Intereses;
import java.util.List;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @autor Arce 
 */

public class InteresesDaoImplTest {

    public InteresesDaoImplTest() {
    }

    @Test
    public void testCrearInteres() {
        // Crear un nuevo interes localmente, esto simula que desde un formulario se obtienen los datos :)
        Intereses nuevoInteres = new Intereses();
        nuevoInteres.setTasaInteres(10.0);

        // Establecer fechas específicas
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = dateFormat.parse("2024-05-01");
            Date fechaFin = dateFormat.parse("2028-12-31");
            nuevoInteres.setFechaInicio(fechaInicio);
            nuevoInteres.setFechaFin(fechaFin);
        } catch (ParseException e) {
            fail("Error al parsear las fechas: " + e.getMessage());
        }

        // Instanciar la clase InteresesDaoImpl
        InteresesDaoImpl interesesBaseDatos = new InteresesDaoImpl();

        // Subir el interes local a la base de datos
        interesesBaseDatos.crearInteres(nuevoInteres);

        // Obtener el último interes creado en la base de datos
        Intereses interesCreado = interesesBaseDatos.obtenerUltimoInteres();

        // Definimos las condiciones de fallo:
        assertNotNull("Fallo: El interes creado es nulo, porque no se pudo obtener de la base de datos", interesCreado);
        assertEquals("La tasa de interes no coincide", nuevoInteres.getTasaInteres(), interesCreado.getTasaInteres(), 0.01);
        assertEquals("La fecha de inicio no coincide", nuevoInteres.getFechaInicio(), interesCreado.getFechaInicio());
        assertEquals("La fecha de fin no coincide", nuevoInteres.getFechaFin(), interesCreado.getFechaFin());

        System.out.println("\n El interes insertado a la base de datos es : \n");
        System.out.println("id_interes: " + interesCreado.getIdInteres());
        System.out.println("tasa_interes: " + interesCreado.getTasaInteres());
        System.out.println("fecha_inicio: " + interesCreado.getFechaInicio());
        System.out.println("fecha_fin: " + interesCreado.getFechaFin());
    }

    @Test
    public void testObtenerInteresPorId() {
        int id = 1; // id del interes a buscar
        System.out.println("Buscando el interes con id= " + id + "\n");

        // Instanciar la clase InteresesDaoImpl
        InteresesDaoImpl interesesBaseDatos = new InteresesDaoImpl();

        // El interesObtenido puede tener una tupla o puede tener null
        Intereses interesObtenido = interesesBaseDatos.obtenerInteresPorId(id);

        // Definimos las condiciones de fallo:
        assertNotNull("El interes obtenido es null", interesObtenido);

        // Mandamos a imprimir los detalles del interes obtenido a consola
        System.out.println("\n La tupla obtenida es: \n");
        System.out.println("id_interes: " + interesObtenido.getIdInteres());
        System.out.println("tasa_interes: " + interesObtenido.getTasaInteres());
        System.out.println("fecha_inicio: " + interesObtenido.getFechaInicio());
        System.out.println("fecha_fin: " + interesObtenido.getFechaFin());
    }

    @Test
    public void testEliminarInteres() {
        int id = 4; //id del interes a eliminar

        // Guardamos localmente el interes que se va a eliminar de la base de datos
        Intereses interesRespaldo = new Intereses();
        InteresesDaoImpl interesesBaseDatos = new InteresesDaoImpl();
        interesRespaldo = interesesBaseDatos.obtenerInteresPorId(id);

        // Procedemos a eliminar el interes
        Intereses interesEliminado = interesesBaseDatos.eliminarInteres(id);

        // Definimos las condiciones de fallo:
        assertNotNull("El interes obtenido para respaldo es nulo", interesRespaldo);
        assertNotNull("El interes eliminado es nulo", interesEliminado);
        assertEquals("El id_interes no coincide", interesRespaldo.getIdInteres(), interesEliminado.getIdInteres());
        assertEquals("La tasa de interes no coincide", interesRespaldo.getTasaInteres(), interesEliminado.getTasaInteres(), 0.01);
        assertEquals("La fecha de inicio no coincide", interesRespaldo.getFechaInicio(), interesEliminado.getFechaInicio());
        assertEquals("La fecha de fin no coincide", interesRespaldo.getFechaFin(), interesEliminado.getFechaFin());

        // Mandamos a imprimir los detalles del interes eliminado a consola
        System.out.println("\n La tupla eliminada fue: \n");
        System.out.println("id_interes: " + interesEliminado.getIdInteres());
        System.out.println("tasa_interes: " + interesEliminado.getTasaInteres());
        System.out.println("fecha_inicio: " + interesEliminado.getFechaInicio());
        System.out.println("fecha_fin: " + interesEliminado.getFechaFin());
    }

    @Test
    public void testObtenerTodosLosIntereses() {

        InteresesDaoImpl interesesBaseDatos = new InteresesDaoImpl();
        
        // El metodo obtenerTodosLosIntereses devuelve una lista vacia sino encuentra nada en la base de datos
        List<Intereses> listaDeIntereses = interesesBaseDatos.obtenerTodosLosIntereses();

        // Definimos las condiciones de fallo
        assertFalse("La lista de intereses está vacía", listaDeIntereses.isEmpty());

        // Mandamos a imprimir los detalles de cada interes a consola
        System.out.println("\nListado de los intereses: \n");
        for (Intereses interesIndividual : listaDeIntereses) {
            System.out.println("ID: " + interesIndividual.getIdInteres());
            System.out.println("Tasa de Interes: " + interesIndividual.getTasaInteres());
            System.out.println("Fecha de Inicio: " + interesIndividual.getFechaInicio());
            System.out.println("Fecha de Fin: " + interesIndividual.getFechaFin());
            System.out.println("\n");
        }
    }

     @Test
    public void testActualizarInteres() {
        int id = 1; // id del interes a actualizar
        
        // Crear un nuevo interes localmente, simulando la obtención de datos desde un formulario
        Intereses interesLocal = new Intereses();
        interesLocal.setTasaInteres(6.0);
        
        // Establecer fechas específicas
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = dateFormat.parse("2024-01-01");
            Date fechaFin = dateFormat.parse("2024-12-31");
            interesLocal.setFechaInicio(fechaInicio);
            interesLocal.setFechaFin(fechaFin);
        } catch (ParseException e) {
            fail("Error al parsear las fechas: " + e.getMessage());
        }
        
        // Obtener el interes actual de la base de datos
        InteresesDaoImpl interesesBaseDatos = new InteresesDaoImpl();
        Intereses interesDeLaBaseDeDatos = interesesBaseDatos.obtenerInteresPorId(id);

        // Verificar que el interes existe antes de actualizarlo
        assertNotNull("Fallo: No se encontró un interes con el ID proporcionado", interesDeLaBaseDeDatos);

        // Mostrar los detalles del interes actual
        System.out.println("\nDetalles del interes actual\n");
        System.out.println("Tasa de Interes: " + interesDeLaBaseDeDatos.getTasaInteres());
        System.out.println("Fecha de Inicio: " + interesDeLaBaseDeDatos.getFechaInicio());
        System.out.println("Fecha de Fin: " + interesDeLaBaseDeDatos.getFechaFin());

        // Mostrar los cambios en los detalles del interes (localmente)
        System.out.println("\nCambios en los detalles para el interes (localmente)\n");
        System.out.println("Tasa de Interes: " + interesLocal.getTasaInteres());
        System.out.println("Fecha de Inicio: " + interesLocal.getFechaInicio());
        System.out.println("Fecha de Fin: " + interesLocal.getFechaFin() + "\n");

        // Actualizar el interes en la base de datos
        interesesBaseDatos.actualizarInteres(id, interesLocal);

        // Obtener el interes actualizado de la base de datos
        interesDeLaBaseDeDatos = interesesBaseDatos.obtenerInteresPorId(id);

        // Definir las condiciones de fallo
        assertEquals("La tasa de interes no coincide", interesLocal.getTasaInteres(), interesDeLaBaseDeDatos.getTasaInteres(), 0.01);
        assertEquals("La fecha de inicio no coincide", interesLocal.getFechaInicio(), interesDeLaBaseDeDatos.getFechaInicio());
        assertEquals("La fecha de fin no coincide", interesLocal.getFechaFin(), interesDeLaBaseDeDatos.getFechaFin());
        
        // Mostrar en consola los cambios en los detalles del interes en la base de datos
        System.out.println("\nDetalles del interes actualizado en la base de datos\n");
        System.out.println("Tasa de Interes: " + interesDeLaBaseDeDatos.getTasaInteres());
        System.out.println("Fecha de Inicio: " + interesDeLaBaseDeDatos.getFechaInicio());
        System.out.println("Fecha de Fin: " + interesDeLaBaseDeDatos.getFechaFin());
    }

}
