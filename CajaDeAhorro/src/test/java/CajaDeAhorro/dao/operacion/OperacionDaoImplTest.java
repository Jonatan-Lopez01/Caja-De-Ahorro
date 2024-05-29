package CajaDeAhorro.dao.operacion;

import CajaDeAhorro.bd.domain.Operacion;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OperacionDaoImplTest {

    public OperacionDaoImplTest() {
    }

    private Operacion crearOperacion(int numeroCuenta, String nombre) {
        // Crear una nueva operación localmente
        Operacion nuevaOperacion = new Operacion();
        nuevaOperacion.setNumeroCuenta(numeroCuenta);
        nuevaOperacion.setNombre(nombre);

        // Instanciar la clase OperacionDaoImpl
        OperacionDaoImpl operacionBaseDatos = new OperacionDaoImpl();

        // Subir la operación local a la base de datos
        operacionBaseDatos.crearOperacion(nuevaOperacion);

        // Obtener la última operación creada en la base de datos
        Operacion operacionCreada = operacionBaseDatos.obtenerUltimaOperacion();

        // Verificar que la operación se haya creado correctamente
        assertNotNull("Fallo: La operación creada es nula, porque no se pudo obtener de la base de datos", operacionCreada);
        assertEquals("El número de cuenta no coincide", nuevaOperacion.getNumeroCuenta(), operacionCreada.getNumeroCuenta());
        assertEquals("El nombre de la operación no coincide", nuevaOperacion.getNombre(), operacionCreada.getNombre());

        return operacionCreada;
    }

    @Test
    public void testCrearOperacion() {
        Operacion operacionCreada = crearOperacion(1, "Deposito");

        System.out.println("\n La operación insertada a la base de datos es : \n");
        System.out.println("id_operacion: " + operacionCreada.getIdOperacion());
        System.out.println("numero_cuenta: " + operacionCreada.getNumeroCuenta());
        System.out.println("nombre: \n" + operacionCreada.getNombre());
    }

    @Test
    public void testEliminarOperacion() {
        // Crear una nueva operación antes de eliminarla
        Operacion operacionCreada = crearOperacion(1, "Temporal");
        System.out.println("\n La operación insertada a la base de datos es : \n");
        System.out.println("id_operacion: " + operacionCreada.getIdOperacion());
        System.out.println("numero_cuenta: " + operacionCreada.getNumeroCuenta());
        System.out.println("nombre: " + operacionCreada.getNombre());
        // Ahora procedemos a eliminar la operación recién creada
        int id = operacionCreada.getIdOperacion(); // obtenemos el id de la operación creada

        // Instanciar la clase OperacionDaoImpl
        OperacionDaoImpl operacionBaseDatos = new OperacionDaoImpl();

        // Procedemos a eliminar la operación
        operacionBaseDatos.eliminarOperacion(id);

        // Verificar que la operación ha sido eliminada
        Operacion operacionEliminada = operacionBaseDatos.obtenerOperacionPorId(id);
        assertNull("La operación no se eliminó correctamente", operacionEliminada);
    }

    @Test
    public void testObtenerOperacionPorId() {
        int id = 6; // id de la operación a buscar
        System.out.println("Buscando la operación con id= " + id + "\n");

        // Instanciar la clase OperacionDaoImpl
        OperacionDaoImpl operacionBaseDatos = new OperacionDaoImpl();

        // La operacionObtenida puede tener una tupla o puede tener null
        Operacion operacionObtenida = operacionBaseDatos.obtenerOperacionPorId(id);

        // Definimos las condiciones de fallo:
        assertNotNull("La operación obtenida es null", operacionObtenida);

        // Mandamos a imprimir los detalles de la operación obtenida a consola
        System.out.println("\n La tupla obtenida es: \n");
        System.out.println("id_operacion: " + operacionObtenida.getIdOperacion());
        System.out.println("numero_cuenta: " + operacionObtenida.getNumeroCuenta());
        System.out.println("nombre: " + operacionObtenida.getNombre());
    }

    @Test
    public void testObtenerTodasLasOperaciones() {
        OperacionDaoImpl operacionBaseDatos = new OperacionDaoImpl();

        // El metodo obtenerTodasLasOperaciones devuelve una lista vacía si no encuentra nada en la base de datos
        List<Operacion> listaDeOperaciones = operacionBaseDatos.obtenerTodasLasOperaciones();

        // Definimos las condiciones de fallo
        assertFalse("La lista de operaciones está vacía", listaDeOperaciones.isEmpty());

        // Mandamos a imprimir los detalles de cada operación a consola
        System.out.println("\nListado de las operaciones: \n");
        for (Operacion operacionIndividual : listaDeOperaciones) {
            System.out.println("ID: " + operacionIndividual.getIdOperacion());
            System.out.println("Número de Cuenta: " + operacionIndividual.getNumeroCuenta());
            System.out.println("Nombre: " + operacionIndividual.getNombre());
            System.out.println("\n");
        }
    }

    @Test
    public void testActualizarOperacion() {
        int id = 6; // id de la operación a actualizar

        // Crear una nueva operación localmente, simulando la obtención de datos desde un formulario
        Operacion operacionLocal = new Operacion();
        operacionLocal.setNumeroCuenta(1);
        operacionLocal.setNombre("Retiro");

        // Obtener la operación actual de la base de datos
        OperacionDaoImpl operacionBaseDatos = new OperacionDaoImpl();
        Operacion operacionDeLaBaseDeDatos = operacionBaseDatos.obtenerOperacionPorId(id);

        // Verificar que la operación existe antes de actualizarla
        assertNotNull("Fallo: No se encontró una operación con el ID proporcionado", operacionDeLaBaseDeDatos);

        // Mostrar los detalles de la operación actual
        System.out.println("\nDetalles de la operación actual\n");
        System.out.println("Número de Cuenta: " + operacionDeLaBaseDeDatos.getNumeroCuenta());
        System.out.println("Nombre: " + operacionDeLaBaseDeDatos.getNombre());

        // Mostrar los cambios en los detalles de la operación (localmente)
        System.out.println("\nCambios en los detalles para la operación (localmente)\n");
        System.out.println("Número de Cuenta: " + operacionLocal.getNumeroCuenta());
        System.out.println("Nombre: " + operacionLocal.getNombre() + "\n");

        // Actualizar la operación en la base de datos
        operacionBaseDatos.actualizarOperacion(id, operacionLocal);

        // Obtener la operación actualizada de la base de datos
        operacionDeLaBaseDeDatos = operacionBaseDatos.obtenerOperacionPorId(id);

        // Definir las condiciones de fallo
        assertEquals("El número de cuenta no coincide", operacionLocal.getNumeroCuenta(), operacionDeLaBaseDeDatos.getNumeroCuenta());
        assertEquals("El nombre de la operación no coincide", operacionLocal.getNombre(), operacionDeLaBaseDeDatos.getNombre());

        // Mostrar en consola los cambios en los detalles de la operación en la base de datos
        System.out.println("\nDetalles de la operación actualizada en la base de datos\n");
        System.out.println("Número de Cuenta: " + operacionDeLaBaseDeDatos.getNumeroCuenta());
        System.out.println("Nombre: " + operacionDeLaBaseDeDatos.getNombre());
    }
}
