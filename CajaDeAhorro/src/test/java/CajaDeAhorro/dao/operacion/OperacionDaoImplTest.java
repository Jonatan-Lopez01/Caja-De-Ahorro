package CajaDeAhorro.dao.operacion;

import CajaDeAhorro.bd.domain.Cuenta;
import CajaDeAhorro.bd.domain.Operacion;
import CajaDeAhorro.bd.mappers.CuentaConexion;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class OperacionDaoImplTest {

    private OperacionDaoImpl operacionDao;  // Variable operacionDao declarada aquí
    private CuentaConexion cuentaConexion;

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
        
    }

    @Test
    public void testObtenerOperacionPorId() {
        int id = 7; // id de la operación a buscar
        System.out.println("Buscando la operación con id= " + id + "\n");

        // Instanciar la clase OperacionDaoImpl
        OperacionDaoImpl operacionBaseDatos = new OperacionDaoImpl();

        // La operacionObtenida puede tener una tupla o puede tener null
        Operacion operacionObtenida = operacionBaseDatos.obtenerOperacionPorId(id);

        

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
        int id = 7; // id de la operación a actualizar

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


        // Mostrar en consola los cambios en los detalles de la operación en la base de datos
        System.out.println("\nDetalles de la operación actualizada en la base de datos\n");
        System.out.println("Número de Cuenta: " + operacionDeLaBaseDeDatos.getNumeroCuenta());
        System.out.println("Nombre: " + operacionDeLaBaseDeDatos.getNombre());
    }

    @Before
    public void setUp() {
        operacionDao = new OperacionDaoImpl();
        cuentaConexion = new CuentaConexion();
    }

    @After
    public void tearDown() {
        operacionDao = null;
        cuentaConexion = null;
    }

    @Test
    public void testRealizarDeposito() {
        int numeroCuenta = 7; // Número de cuenta en la que se realizará el depósito
        double cantidad = 100.0; // Cantidad a depositar

        // Obtener la cuenta antes del depósito
        Cuenta cuentaAntes = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);
        double saldoAntes = cuentaAntes.getSaldo();

        // Realizar el depósito
        operacionDao.realizarDeposito(numeroCuenta, cantidad);

        // Obtener la cuenta después del depósito
        Cuenta cuentaDespues = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);
        double saldoDespues = cuentaDespues.getSaldo();

        // Verificar que el saldo se haya actualizado correctamente
        assertEquals("El saldo después del depósito no coincide", saldoAntes + cantidad, saldoDespues, 0.001);

        // Obtener la última operación de depósito realizada en la cuenta
        Operacion ultimaOperacionDeposito = operacionDao.obtenerUltimaOperacion();

        // Verificar que la operación de depósito se haya registrado correctamente

        // Mostrar los detalles de la última operación de depósito en consola
        System.out.println("\nDetalles de la última operación de depósito:\n");
        System.out.println("ID de la operación: " + ultimaOperacionDeposito.getIdOperacion());
        System.out.println("Número de cuenta: " + ultimaOperacionDeposito.getNumeroCuenta());
        System.out.println("Nombre de la operación: " + ultimaOperacionDeposito.getNombre());
    }

    @Test
    public void testRealizarRetiro() {
        int numeroCuenta = 7;
        double cantidad = 50.0;

        Cuenta cuentaAntes = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);
        double saldoAntes = cuentaAntes.getSaldo();

        if (saldoAntes >= cantidad) {
            operacionDao.realizarRetiro(numeroCuenta, cantidad);

            Cuenta cuentaDespues = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);
            double saldoDespues = cuentaDespues.getSaldo();

            assertEquals("El saldo después del retiro no coincide", saldoAntes - cantidad, saldoDespues, 0.001);

            Operacion ultimaOperacionRetiro = operacionDao.obtenerUltimaOperacion();


            System.out.println("\nDetalles de la última operación de retiro:\n");
            System.out.println("ID de la operación: " + ultimaOperacionRetiro.getIdOperacion());
            System.out.println("Número de cuenta: " + ultimaOperacionRetiro.getNumeroCuenta());
            System.out.println("Nombre de la operación: " + ultimaOperacionRetiro.getNombre());
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

}
