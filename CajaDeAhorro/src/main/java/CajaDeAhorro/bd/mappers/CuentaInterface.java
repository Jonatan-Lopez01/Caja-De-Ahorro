package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Cuenta;
import java.util.List;

/**
 *
 * @author Gizelle RM
 */
public interface CuentaInterface {
    
    // Método para crear una nueva cuenta
    void crearCuenta(Cuenta cuenta);
    
    // Método para actualizar una cuenta existente
    void actualizarCuenta(int numeroCuenta, Cuenta cuenta);

    // Método para eliminar una cuenta por su número de cuenta
    void eliminarCuenta(int numeroCuenta);

    // Método para obtener una cuenta por su número de cuenta
    Cuenta obtenerCuentaPorNumero(int numeroCuenta);

    // Método para obtener todas las cuentas
    List<Cuenta> obtenerTodasLasCuentas();
    
     Cuenta obtenerUltimaCuenta();
}
