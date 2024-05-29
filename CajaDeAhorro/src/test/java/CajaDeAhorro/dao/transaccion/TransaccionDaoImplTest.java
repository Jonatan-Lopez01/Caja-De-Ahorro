/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.transaccion;

import CajaDeAhorro.bd.domain.Transaccion;
import CajaDeAhorro.bd.mappers.TransaccionConexion;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Gizelle RM
 */
public class TransaccionDaoImplTest {
    
 @Test
    public void testCrearTransaccion() {
        // Crear una nueva transacción localmente
        Transaccion nuevaTransaccion = new Transaccion();
        nuevaTransaccion.setIdOperacion(1);
        nuevaTransaccion.setMonto(100.0);
        nuevaTransaccion.setFecha("2024-05-28");

        // Instanciar la clase TransaccionConexion
        TransaccionConexion transaccionConexion = new TransaccionConexion();

        // Subir la transacción local a la base de datos
        transaccionConexion.crearTransaccion(nuevaTransaccion);

        // Obtener la transacción recién creada de la base de datos
        Transaccion transaccionCreada = transaccionConexion.obtenerUltimaTransaccion();

        // Mostrar los detalles de la transacción creada
        System.out.println("\nLa transacción insertada en la base de datos es:\n");
        System.out.println("ID de transacción: " + transaccionCreada.getIdTransaccion());
        System.out.println("ID de operación: " + transaccionCreada.getIdOperacion());
        System.out.println("Monto: " + transaccionCreada.getMonto());
        System.out.println("Fecha: " + transaccionCreada.getFecha());
    }

    @Test
    public void testObtenerTransaccionPorId() {
        int idTransaccion = 1; // ID de la transacción a buscar
        System.out.println("Buscando la transacción con ID = " + idTransaccion + "\n");

        // Instanciar la clase TransaccionConexion
        TransaccionConexion transaccionConexion = new TransaccionConexion();

        // Obtener la transacción por su ID
        Transaccion transaccionObtenida = transaccionConexion.obtenerTransaccionPorId(idTransaccion);

        // Definir las condiciones de fallo
        assertNotNull("La transacción obtenida es null", transaccionObtenida);

        // Mostrar los detalles de la transacción obtenida
        System.out.println("\nLa transacción obtenida es:\n");
        System.out.println("ID de transacción: " + transaccionObtenida.getIdTransaccion());
        System.out.println("ID de operación: " + transaccionObtenida.getIdOperacion());
        System.out.println("Monto: " + transaccionObtenida.getMonto());
        System.out.println("Fecha: " + transaccionObtenida.getFecha());
    }

    @Test
    public void testEliminarTransaccion() {
        testCrearTransaccion();

        // Instanciar la clase TransaccionConexion
        TransaccionConexion transaccionConexion = new TransaccionConexion();

        // Obtener la transacción recién creada de la base de datos
        Transaccion transaccionCreada = transaccionConexion.obtenerUltimaTransaccion();
        int idTransaccion = transaccionCreada.getIdTransaccion();

        // Obtener la transacción a eliminar de la base de datos
        Transaccion transaccionEliminada = transaccionConexion.eliminarTransaccion(idTransaccion);

        // Verificar que la transacción fue eliminada correctamente
        assertNotNull("La transacción eliminada es null", transaccionEliminada);

        // Intentar obtener la transacción eliminada
        Transaccion transaccionObtenida = transaccionConexion.obtenerTransaccionPorId(idTransaccion);

        // Verificar que la transacción ya no existe en la base de datos
        assertNull("La transacción aún existe en la base de datos", transaccionObtenida);

        // Mostrar los detalles de la transacción eliminada
        System.out.println("\nLa transacción eliminada fue:\n");
        System.out.println("ID de transacción: " + transaccionEliminada.getIdTransaccion());
        System.out.println("ID de operación: " + transaccionEliminada.getIdOperacion());
        System.out.println("Monto: " + transaccionEliminada.getMonto());
        System.out.println("Fecha: " + transaccionEliminada.getFecha());
    }

    @Test
    public void testObtenerTodasLasTransacciones() {
        // Instanciar la clase TransaccionConexion
        TransaccionConexion transaccionConexion = new TransaccionConexion();

        // Obtener todas las transacciones de la base de datos
        List<Transaccion> listaDeTransacciones = transaccionConexion.obtenerTodasLasTransacciones();

        // Definir las condiciones de fallo
        assertFalse("La lista de transacciones está vacía", listaDeTransacciones.isEmpty());

        // Mostrar los detalles de cada transacción en la lista
        System.out.println("\nListado de las transacciones:\n");
        for (Transaccion transaccionIndividual : listaDeTransacciones) {
            System.out.println("ID de transacción: " + transaccionIndividual.getIdTransaccion());
            System.out.println("ID de operación: " + transaccionIndividual.getIdOperacion());
            System.out.println("Monto: " + transaccionIndividual.getMonto());
            System.out.println("Fecha: " + transaccionIndividual.getFecha());
            System.out.println("\n");
        }
    }

    @Test
    public void testActualizarTransaccion() {
        int idTransaccion = 2; // ID de la transacción a actualizar

        // Crear una nueva transacción localmente con cambios simulados
        Transaccion transaccionLocal = new Transaccion();
        transaccionLocal.setIdOperacion(3);
        transaccionLocal.setMonto(500.0);
        transaccionLocal.setFecha("2024-05-29");

        // Instanciar la clase TransaccionConexion
        TransaccionConexion transaccionConexion = new TransaccionConexion();

        // Obtener la transacción actual de la base de datos
        Transaccion transaccionDeLaBaseDeDatos = transaccionConexion.obtenerTransaccionPorId(idTransaccion);

        // Verificar que la transacción existe antes de actualizarla
        assertNotNull("Fallo: No se encontró una transacción con el ID proporcionado", transaccionDeLaBaseDeDatos);

        // Mostrar los detalles de la transacción actual
        System.out.println("\nDetalles de la transacción actual\n");
        System.out.println("ID de transacción: " + transaccionDeLaBaseDeDatos.getIdTransaccion());
        System.out.println("ID de operación: " + transaccionDeLaBaseDeDatos.getIdOperacion());
        System.out.println("Monto: " + transaccionDeLaBaseDeDatos.getMonto());
        System.out.println("Fecha: " + transaccionDeLaBaseDeDatos.getFecha());

        // Mostrar los cambios en los detalles de la transacción (localmente)
        System.out.println("\nCambios en los detalles para la transacción (localmente)\n");
        System.out.println("ID de operación: " + transaccionLocal.getIdOperacion());
        System.out.println("Monto: " + transaccionLocal.getMonto());
        System.out.println("Fecha: " + transaccionLocal.getFecha() + "\n");

        // Actualizar la transacción en la base de datos
        transaccionConexion.actualizarTransaccion(idTransaccion, transaccionLocal);

        // Obtener la transacción actualizada de la base de datos
        transaccionDeLaBaseDeDatos = transaccionConexion.obtenerTransaccionPorId(idTransaccion);

        // Definir las condiciones de fallo
        //assertEquals("El ID de operación de la transacción no coincide", transaccionLocal.getIdOperacion(), transaccionDeLaBaseDeDatos.getIdOperacion());
        //assertEquals("El monto de la transacción no coincide", transaccionLocal.getMonto(), transaccionDeLaBaseDeDatos.getMonto(), 0.001); // Acepta una diferencia mínima
        //assertEquals("La fecha de la transacción no coincide", transaccionLocal.getFecha(), transaccionDeLaBaseDeDatos.getFecha());

        // Mostrar en consola los detalles de la transacción actualizada en la base de datos
        System.out.println("\nDetalles de la transacción actualizada en la base de datos\n");
        System.out.println("ID de transacción: " + transaccionDeLaBaseDeDatos.getIdTransaccion());
        System.out.println("ID de operación: " + transaccionDeLaBaseDeDatos.getIdOperacion());
        System.out.println("Monto: " + transaccionDeLaBaseDeDatos.getMonto());
        System.out.println("Fecha: " + transaccionDeLaBaseDeDatos.getFecha());
    }
}


