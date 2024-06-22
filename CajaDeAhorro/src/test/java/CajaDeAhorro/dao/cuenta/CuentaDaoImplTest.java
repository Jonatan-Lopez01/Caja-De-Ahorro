package CajaDeAhorro.dao.cuenta;

import CajaDeAhorro.bd.domain.Cuenta;
import CajaDeAhorro.bd.mappers.CuentaConexion;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para la clase CuentaDaoImpl.
 *
 * @autor Gizelle RM
 */
public class CuentaDaoImplTest {

    public CuentaDaoImplTest() {
    }

    @Test
    public void testCrearCuenta() {
        // Crear una nueva cuenta localmente
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setTasaInteres(0.00f);
        nuevaCuenta.setEstatusCuenta(1);
        nuevaCuenta.setSaldo(20000.0f);

        // Instanciar la clase CuentaConexion
        CuentaConexion cuentaConexion = new CuentaConexion();

        // Subir la cuenta local a la base de datos
        cuentaConexion.crearCuenta(nuevaCuenta);

        // Obtener la cuenta recién creada de la base de datos
        Cuenta cuentaCreada = cuentaConexion.obtenerUltimaCuenta();


        System.out.println("\nLa cuenta insertada en la base de datos es:\n");
        System.out.println("Número de cuenta: " + cuentaCreada.getNumeroCuenta());
        System.out.println("Tasa de interés: " + cuentaCreada.getTasaInteres());
        System.out.println("Estatus de cuenta: " + cuentaCreada.getEstatusCuenta());
        System.out.println("Saldo: " + cuentaCreada.getSaldo());
    }

    @Test
    public void testObtenerCuentaPorNumero() {
        int numeroCuenta = 2; // Número de cuenta a buscar
        System.out.println("Buscando la cuenta con número de cuenta = " + numeroCuenta + "\n");

        // Instanciar la clase CuentaConexion
        CuentaConexion cuentaConexion = new CuentaConexion();

        // Obtener la cuenta por su número de cuenta
        Cuenta cuentaObtenida = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);

        // Definir las condiciones de fallo:
        assertNotNull("La cuenta obtenida es null", cuentaObtenida);

        // Mostrar los detalles de la cuenta obtenida
        System.out.println("\nLa cuenta obtenida es:\n");
        System.out.println("Número de cuenta: " + cuentaObtenida.getNumeroCuenta());
        System.out.println("Tasa de interés: " + cuentaObtenida.getTasaInteres());
        System.out.println("Estatus de cuenta: " + cuentaObtenida.getEstatusCuenta());
        System.out.println("Saldo: " + cuentaObtenida.getSaldo());
    }

    @Test
    public void testEliminarCuenta() {
         testCrearCuenta();

        // Instanciar la clase CuentaConexion
        CuentaConexion cuentaConexion = new CuentaConexion();

        // Obtener la cuenta recién creada de la base de datos
        Cuenta cuentaCreada = cuentaConexion.obtenerUltimaCuenta();
         int numeroCuenta = cuentaCreada.getNumeroCuenta();
        
        // Obtener la cuenta a eliminar de la base de datos
        Cuenta cuentaEliminada = cuentaConexion.eliminarCuenta(numeroCuenta);

        // Verificar que la cuenta fue eliminada correctamente
        assertNotNull("La cuenta eliminada es null", cuentaEliminada);

        // Intentar obtener la cuenta eliminada
        Cuenta cuentaObtenida = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);

        // Verificar que la cuenta ya no existe en la base de datos
        assertNull("La cuenta aún existe en la base de datos", cuentaObtenida);

        // Mostrar los detalles de la cuenta eliminada
        System.out.println("\nLa cuenta eliminada fue:\n");
        System.out.println("Número de cuenta: " + cuentaEliminada.getNumeroCuenta());
        System.out.println("Tasa de interés: " + cuentaEliminada.getTasaInteres());
        System.out.println("Estatus de cuenta: " + cuentaEliminada.getEstatusCuenta());
        System.out.println("Saldo: " + cuentaEliminada.getSaldo());
    }

    @Test
    public void testObtenerTodasLasCuentas() {
        // Instanciar la clase CuentaConexion
        CuentaConexion cuentaConexion = new CuentaConexion();

        // Obtener todas las cuentas de la base de datos
        List<Cuenta> listaDeCuentas = cuentaConexion.obtenerTodasLasCuentas();

        // Definir las condiciones de fallo
        assertFalse("La lista de cuentas está vacía", listaDeCuentas.isEmpty());

        // Mostrar los detalles de cada cuenta en la lista
        System.out.println("\nListado de las cuentas:\n");
        for (Cuenta cuentaIndividual : listaDeCuentas) {
            System.out.println("Número de cuenta: " + cuentaIndividual.getNumeroCuenta());
            System.out.println("Tasa de interés: " + cuentaIndividual.getTasaInteres());
            System.out.println("Estatus de cuenta: " + cuentaIndividual.getEstatusCuenta());
            System.out.println("Saldo: " + cuentaIndividual.getSaldo());
            System.out.println("\n");
        }
    }

    @Test
    public void testActualizarCuenta() {
        int numeroCuenta = 2; // Número de cuenta a actualizar

        // Crear una nueva cuenta localmente con cambios simulados
        Cuenta cuentaLocal = new Cuenta();
        cuentaLocal.setTasaInteres(0.700f);
        cuentaLocal.setEstatusCuenta(2);
        cuentaLocal.setSaldo(15000000.0f);

        // Instanciar la clase CuentaConexion
        CuentaConexion cuentaConexion = new CuentaConexion();

        // Obtener la cuenta actual de la base de datos
        Cuenta cuentaDeLaBaseDeDatos = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);

        // Verificar que la cuenta existe antes de actualizarla
        assertNotNull("Fallo: No se encontró una cuenta con el número proporcionado", cuentaDeLaBaseDeDatos);

        // Mostrar los detalles de la cuenta actual
        System.out.println("\nDetalles de la cuenta actual\n");
        System.out.println("Número de cuenta: " + cuentaDeLaBaseDeDatos.getNumeroCuenta());
        System.out.println("Tasa de interés: " + cuentaDeLaBaseDeDatos.getTasaInteres());
        System.out.println("Estatus de cuenta: " + cuentaDeLaBaseDeDatos.getEstatusCuenta());
        System.out.println("Saldo: " + cuentaDeLaBaseDeDatos.getSaldo());

        // Mostrar los cambios en los detalles de la cuenta (localmente)
        System.out.println("\nCambios en los detalles para la cuenta (localmente)\n");
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Tasa de interés: " + cuentaLocal.getTasaInteres());
        System.out.println("Estatus de cuenta: " + cuentaLocal.getEstatusCuenta());
        System.out.println("Saldo: " + cuentaLocal.getSaldo() + "\n");

        // Actualizar la cuenta en la base de datos
        cuentaConexion.actualizarCuenta(numeroCuenta, cuentaLocal);

        // Obtener la cuenta actualizada de la base de datos
        cuentaDeLaBaseDeDatos = cuentaConexion.obtenerCuentaPorNumero(numeroCuenta);

        // Definir las condiciones de fallo
        assertEquals("El número de cuenta no coincide", numeroCuenta, cuentaDeLaBaseDeDatos.getNumeroCuenta());
        assertEquals("La tasa de interés no coincide", cuentaLocal.getTasaInteres(), cuentaDeLaBaseDeDatos.getTasaInteres(), 0.0);
        assertEquals("El estatus de la cuenta no coincide", cuentaLocal.getEstatusCuenta(), cuentaDeLaBaseDeDatos.getEstatusCuenta());
        assertEquals("El saldo de la cuenta no coincide", cuentaLocal.getSaldo(), cuentaDeLaBaseDeDatos.getSaldo(), 0.0);

        // Mostrar en consola los detalles de la cuenta actualizada en la base de datos
        System.out.println("\nDetalles de la cuenta actualizada en la base de datos\n");
        System.out.println("Número de cuenta: " + cuentaDeLaBaseDeDatos.getNumeroCuenta());
        System.out.println("Tasa de interés: " + cuentaDeLaBaseDeDatos.getTasaInteres());
        System.out.println("Estatus de cuenta: " + cuentaDeLaBaseDeDatos.getEstatusCuenta());
        System.out.println("Saldo: " + cuentaDeLaBaseDeDatos.getSaldo());
    }
}
