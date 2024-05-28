/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.prestamo;

import CajaDeAhorro.bd.domain.Prestamo;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arce
 */
public class PrestamoDaoImplTest {

    public PrestamoDaoImplTest() {
    }

    @Test
    public void testCrearPrestamo() {
        System.out.println("crearPrestamo");
        
        // Crear un nuevo prestamo localmente
        Prestamo prestamo = new Prestamo();
        prestamo.setIdSolicitudPrestamo(1);
        prestamo.setIdIntereses(1);
        prestamo.setMontoPrestado(10000.0);
        prestamo.setPagoActual(1000.0);
        prestamo.setFechaSolicitud(new Timestamp(System.currentTimeMillis()));
        prestamo.setPlazo(Date.valueOf("2024-12-31")); // Fecha específica para el plazo
        prestamo.setNumMontos(10);

        // Instanciar la clase PrestamoDaoImpl
        PrestamoDaoImpl instance = new PrestamoDaoImpl();
        
        // Crear el prestamo en la base de datos
        instance.crearPrestamo(prestamo);

        // Obtener el último prestamo creado
        Prestamo result = instance.obtenerUltimoPrestamo();
        
        // Verificar los resultados
        assertNotNull(result);
        assertEquals(prestamo.getIdSolicitudPrestamo(), result.getIdSolicitudPrestamo());
        assertEquals(prestamo.getIdIntereses(), result.getIdIntereses());
        assertEquals(prestamo.getMontoPrestado(), result.getMontoPrestado(), 0.01);
        assertEquals(prestamo.getPagoActual(), result.getPagoActual(), 0.01);
        assertEquals(prestamo.getFechaSolicitud(), result.getFechaSolicitud());
        assertEquals(prestamo.getPlazo(), result.getPlazo());
        assertEquals(prestamo.getNumMontos(), result.getNumMontos());
    }

    @Test
    public void testObtenerPrestamoPorId() {
        System.out.println("obtenerPrestamoPorId");
        
        // ID del prestamo a obtener
        int id = 1;

        // Instanciar la clase PrestamoDaoImpl
        PrestamoDaoImpl instance = new PrestamoDaoImpl();
        
        // Obtener el prestamo por ID
        Prestamo result = instance.obtenerPrestamoPorId(id);

        // Verificar los resultados
        assertNotNull(result);
        System.out.println("id_prestamo: " + result.getIdPrestamo());
        System.out.println("id_solicitud_prestamo: " + result.getIdSolicitudPrestamo());
        System.out.println("id_intereses: " + result.getIdIntereses());
        System.out.println("monto_prestado: " + result.getMontoPrestado());
        System.out.println("pago_actual: " + result.getPagoActual());
        System.out.println("fecha_solicitud: " + result.getFechaSolicitud());
        System.out.println("plazo: " + result.getPlazo());
        System.out.println("num_montos: " + result.getNumMontos());
    }

    @Test
    public void testEliminarPrestamo() {
        System.out.println("eliminarPrestamo");
        
        // ID del prestamo a eliminar
        int id = 1;

        // Instanciar la clase PrestamoDaoImpl
        PrestamoDaoImpl instance = new PrestamoDaoImpl();
        
        // Eliminar el prestamo
        Prestamo prestamoEliminado = instance.eliminarPrestamo(id);

        // Verificar los resultados
        assertNotNull(prestamoEliminado);
        System.out.println("id_prestamo: " + prestamoEliminado.getIdPrestamo());
        System.out.println("id_solicitud_prestamo: " + prestamoEliminado.getIdSolicitudPrestamo());
        System.out.println("id_intereses: " + prestamoEliminado.getIdIntereses());
        System.out.println("monto_prestado: " + prestamoEliminado.getMontoPrestado());
        System.out.println("pago_actual: " + prestamoEliminado.getPagoActual());
        System.out.println("fecha_solicitud: " + prestamoEliminado.getFechaSolicitud());
        System.out.println("plazo: " + prestamoEliminado.getPlazo());
        System.out.println("num_montos: " + prestamoEliminado.getNumMontos());
    }

    @Test
    public void testObtenerTodosLosPrestamos() {
        System.out.println("obtenerTodosLosPrestamos");
        
        // Instanciar la clase PrestamoDaoImpl
        PrestamoDaoImpl instance = new PrestamoDaoImpl();
        
        // Obtener todos los prestamos
        List<Prestamo> result = instance.obtenerTodosLosPrestamos();

        // Verificar los resultados
        assertFalse(result.isEmpty());
        for (Prestamo prestamo : result) {
            System.out.println("id_prestamo: " + prestamo.getIdPrestamo());
            System.out.println("id_solicitud_prestamo: " + prestamo.getIdSolicitudPrestamo());
            System.out.println("id_intereses: " + prestamo.getIdIntereses());
            System.out.println("monto_prestado: " + prestamo.getMontoPrestado());
            System.out.println("pago_actual: " + prestamo.getPagoActual());
            System.out.println("fecha_solicitud: " + prestamo.getFechaSolicitud());
            System.out.println("plazo: " + prestamo.getPlazo());
            System.out.println("num_montos: " + prestamo.getNumMontos());
        }
    }

    @Test
    public void testActualizarPrestamo() {
        System.out.println("actualizarPrestamo");
        
        // ID del prestamo a actualizar
        int id = 1;

        // Crear un nuevo prestamo localmente con los datos actualizados
        Prestamo prestamo = new Prestamo();
        prestamo.setIdSolicitudPrestamo(2);
        prestamo.setIdIntereses(2);
        prestamo.setMontoPrestado(20000.0);
        prestamo.setPagoActual(2000.0);
        prestamo.setFechaSolicitud(new Timestamp(System.currentTimeMillis()));
        prestamo.setPlazo(Date.valueOf("2025-12-31")); // Fecha específica para el plazo
        prestamo.setNumMontos(20);

        // Instanciar la clase PrestamoDaoImpl
        PrestamoDaoImpl instance = new PrestamoDaoImpl();
        
        // Actualizar el prestamo
        instance.actualizarPrestamo(id, prestamo);

        // Obtener el prestamo actualizado
        Prestamo result = instance.obtenerPrestamoPorId(id);

        // Verificar los resultados
        assertNotNull(result);
        assertEquals(prestamo.getIdSolicitudPrestamo(), result.getIdSolicitudPrestamo());
        assertEquals(prestamo.getIdIntereses(), result.getIdIntereses());
        assertEquals(prestamo.getMontoPrestado(), result.getMontoPrestado(), 0.01);
        assertEquals(prestamo.getPagoActual(), result.getPagoActual(), 0.01);
        assertEquals(prestamo.getFechaSolicitud(), result.getFechaSolicitud());
        assertEquals(prestamo.getPlazo(), result.getPlazo());
        assertEquals(prestamo.getNumMontos(), result.getNumMontos());

        System.out.println("id_prestamo: " + result.getIdPrestamo());
        System.out.println("id_solicitud_prestamo: " + result.getIdSolicitudPrestamo());
        System.out.println("id_intereses: " + result.getIdIntereses());
        System.out.println("monto_prestado: " + result.getMontoPrestado());
        System.out.println("pago_actual: " + result.getPagoActual());
        System.out.println("fecha_solicitud: " + result.getFechaSolicitud());
        System.out.println("plazo: " + result.getPlazo());
        System.out.println("num_montos: " + result.getNumMontos());
    }
}
