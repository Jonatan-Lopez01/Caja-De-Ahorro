package CajaDeAhorro.dao.cuenta;

import CajaDeAhorro.bd.domain.Cuenta;
import java.util.List;

/**
 *
 * @autor Gizelle RM
 */
public interface CuentaDao {
    // Método para crear una nueva cuenta
    void crearCuenta(Cuenta cuenta);

    // Método para actualizar una cuenta existente
    void actualizarCuenta(int numeroCuenta, Cuenta cuenta);

    // Método para eliminar una cuenta por el número de cuenta
    Cuenta eliminarCuenta(int numeroCuenta);

    // Método para obtener una cuenta por su número de cuenta
    Cuenta obtenerCuentaPorNumero(int numeroCuenta);

    // Método para obtener todas las cuentas
    List<Cuenta> obtenerTodasLasCuentas();
    
     // Método para obtener la última cuenta creada
    Cuenta obtenerUltimaCuenta();
    
    List<Object[]> obtenerTransaccionesPorNumeroCuenta(int numeroCuenta);
}