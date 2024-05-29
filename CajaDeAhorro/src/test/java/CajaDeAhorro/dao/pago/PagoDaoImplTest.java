/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.pago;

import CajaDeAhorro.bd.domain.Pago;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonatan Eduardo
 */
public class PagoDaoImplTest {

    private Pago realizarPago(int idPrestamo, int cantidad, LocalDateTime fecha) {
        // Crear un nuevo pago localmente
        Pago nuevoPago = new Pago();
        nuevoPago.setIdPrestamo(idPrestamo);
        nuevoPago.setCantidad(cantidad);
        nuevoPago.setFecha(fecha);

        // Instanciar la clase PagoDaoImpl
        PagoDaoImpl pagoBaseDatos = new PagoDaoImpl();

        // Realizar el pago en la base de datos
        pagoBaseDatos.RealizarPago(nuevoPago);

        // Obtener el último pago creado en la base de datos
        Pago pagoCreado = pagoBaseDatos.obtenerUltimoPago();

        // Verificar que el pago se haya realizado correctamente
        assertNotNull("Fallo: El pago creado es nulo, porque no se pudo obtener de la base de datos", pagoCreado);
        assertEquals("El id_prestamo del pago no coincide", nuevoPago.getIdPrestamo(), pagoCreado.getIdPrestamo());
        double tolerancia = 0.000000001;
        assertEquals("La cantidad del pago no coincide", nuevoPago.getCantidad(), pagoCreado.getCantidad(), tolerancia);
        long toleranciaEnMilisegundos = 1000; // Tolerancia de 100 milisegundos

        long diferenciaEnMilisegundos = Math.abs(ChronoUnit.MILLIS.between(nuevoPago.getFecha(), pagoCreado.getFecha()));

        assertTrue("La diferencia en la fecha del pago es mayor que la tolerancia",
                diferenciaEnMilisegundos <= toleranciaEnMilisegundos);

        return pagoCreado;
    }

    @Test
    public void testRealizarPago() {
        LocalDateTime fecha = LocalDateTime.now(); // Obtener la fecha y hora actual
        Pago rolCreado = realizarPago(19, 300, fecha);

        System.out.println("\n El pago insertado a la base de datos es : \n");
        System.out.println("id_pago: " + rolCreado.getIdPago());
        System.out.println("id_prestamo: " + rolCreado.getIdPrestamo());
        System.out.println("cantidad: " + rolCreado.getCantidad());
        System.out.println("fecha: " + rolCreado.getFecha());
    }

    @Test
    public void testEliminarPago() {
        LocalDateTime fecha = LocalDateTime.now(); // Obtener la fecha y hora actual
        Pago pagoCreado = realizarPago(19, 100, fecha); //Pago insertado en la base de datos

        //Instanciamos la clase PagoDaoImpl
        PagoDaoImpl pagoBaseDatos = new PagoDaoImpl();

        // Obtener el ID del pago recién creado
        int idPago = pagoCreado.getIdPago();

        // Guardamos localmente el rol que se va a eliminar de la base de datos
        Pago pagoRespaldo = pagoBaseDatos.obtenerPagoPorId(idPago);
        assertNotNull("El pago obtenido para respaldo es nulo", pagoRespaldo);

        // Proceder a eliminar el pago
        Pago pagoEliminado = pagoBaseDatos.eliminarPago(idPago);

        // Verificar que el pago se haya eliminado correctamente
        assertNotNull("El pago eliminado es nulo", pagoEliminado);
        assertEquals("El ID del pago no coincide", pagoRespaldo.getIdPago(), pagoEliminado.getIdPago());
        double tolerancia = 0.000000001;
        assertEquals("La cantidad del pago no coincide", pagoRespaldo.getCantidad(), pagoEliminado.getCantidad(), tolerancia);
        long toleranciaEnMilisegundos = 1000; // Tolerancia de 1000 milisegundos

        long diferenciaEnMilisegundos = Math.abs(ChronoUnit.MILLIS.between(pagoRespaldo.getFecha(), pagoEliminado.getFecha()));

        assertTrue("La diferencia en la fecha del pago es mayor que la tolerancia",
                diferenciaEnMilisegundos <= toleranciaEnMilisegundos);

        // Imprimir los detalles del pago eliminado en la consola
        System.out.println("\n La tupla eliminada fue: \n");
        System.out.println("id_pago: " + pagoEliminado.getIdPago());
        System.out.println("cantidad: " + pagoEliminado.getCantidad());
        System.out.println("fecha: " + pagoEliminado.getFecha());
    }

    @Test
    public void testObtenerPagoPorId() {
        int idPago = 1; // ID del pago a buscar
        System.out.println("Buscando el pago con ID = " + idPago + "\n");

        // Instanciar la clase PagoDaoImpl
        PagoDaoImpl pagoBaseDatos = new PagoDaoImpl();

        // El pagoObtenido puede ser una instancia de Pago o puede ser null
        Pago pagoObtenido = pagoBaseDatos.obtenerPagoPorId(idPago);

        // Definimos las condiciones de fallo:
        assertNotNull("El pago obtenido es null", pagoObtenido);

        // Mandamos a imprimir los detalles del pago obtenido a consola
        System.out.println("\n La tupla obtenida es: \n");
        System.out.println("id_pago: " + pagoObtenido.getIdPago());
        System.out.println("id_prestamo: " + pagoObtenido.getIdPrestamo());
        System.out.println("cantidad: " + pagoObtenido.getCantidad());
        System.out.println("fecha: " + pagoObtenido.getFecha());
    }

    @Test
    public void testObtenerTodosLosPagos() {
        PagoDaoImpl pagoBaseDatos = new PagoDaoImpl();

        // El método obtenerTodosLosPagos devuelve una lista vacía si no encuentra nada en la base de datos
        List<Pago> listaDePagos = pagoBaseDatos.obtenerTodosLosPagos();

        // Definimos las condiciones de fallo
        assertFalse("La lista de pagos está vacía", listaDePagos.isEmpty());

        // Mandamos a imprimir los detalles de cada pago a consola
        System.out.println("\nListado de los pagos: \n");
        for (Pago pagoIndividual : listaDePagos) {
            System.out.println("ID Pago: " + pagoIndividual.getIdPago());
            System.out.println("ID Préstamo: " + pagoIndividual.getIdPrestamo());
            System.out.println("Cantidad: " + pagoIndividual.getCantidad());
            System.out.println("Fecha: " + pagoIndividual.getFecha());
            System.out.println("\n");
        }
    }

    @Test
    public void testActualizarPago() {
        int idPago = 1; // ID del pago a actualizar

        // Crear un nuevo pago localmente, simulando la obtención de datos desde un formulario
        Pago pagoLocal = new Pago();
        pagoLocal.setIdPrestamo(21);
        pagoLocal.setCantidad(152.25);
        pagoLocal.setFecha(LocalDateTime.now());

        // Obtener el pago actual de la base de datos
        PagoDaoImpl pagoBaseDatos = new PagoDaoImpl();
        Pago pagoDeLaBaseDeDatos = pagoBaseDatos.obtenerPagoPorId(idPago);

        // Verificar que el pago existe antes de actualizarlo
        assertNotNull("Fallo: No se encontró un pago con el ID proporcionado", pagoDeLaBaseDeDatos);

        // Mostrar los detalles del pago actual
        System.out.println("\nDetalles del pago actual\n");
        System.out.println("ID Préstamo: " + pagoDeLaBaseDeDatos.getIdPrestamo());
        System.out.println("Cantidad: " + pagoDeLaBaseDeDatos.getCantidad());
        System.out.println("Fecha: " + pagoDeLaBaseDeDatos.getFecha());

        // Mostrar los cambios en los detalles del pago (localmente)
        System.out.println("\nCambios en los detalles para el pago (localmente)\n");
        System.out.println("ID Préstamo: " + pagoLocal.getIdPrestamo());
        System.out.println("Cantidad: " + pagoLocal.getCantidad());
        System.out.println("Fecha de actualización: " + pagoLocal.getFecha() + "\n");

        // Actualizar el pago en la base de datos
        pagoBaseDatos.actualizarPago(idPago, pagoLocal);

        // Obtener el pago actualizado de la base de datos
        pagoDeLaBaseDeDatos = pagoBaseDatos.obtenerPagoPorId(idPago);

        // Definir las condiciones de fallo
        assertEquals("El ID del préstamo no coincide", pagoLocal.getIdPrestamo(), pagoDeLaBaseDeDatos.getIdPrestamo());
        double tolerancia = 0.000000001;
        assertEquals("La cantidad del pago no coincide", pagoLocal.getCantidad(), pagoDeLaBaseDeDatos.getCantidad(), tolerancia);
        long toleranciaEnMilisegundos = 1000; // Tolerancia de 1000 milisegundos

        long diferenciaEnMilisegundos = Math.abs(ChronoUnit.MILLIS.between(pagoLocal.getFecha(), pagoDeLaBaseDeDatos.getFecha()));

        assertTrue("La diferencia en la fecha del pago es mayor que la tolerancia",
                diferenciaEnMilisegundos <= toleranciaEnMilisegundos);

        // Mostrar en consola los cambios en los detalles del pago en la base de datos
        System.out.println("\nDetalles del pago actualizado en la base de datos\n");
        System.out.println("ID Préstamo: " + pagoDeLaBaseDeDatos.getIdPrestamo());
        System.out.println("Cantidad: " + pagoDeLaBaseDeDatos.getCantidad());
        System.out.println("Fecha: " + pagoDeLaBaseDeDatos.getFecha());
    }

}
