 package CajaDeAhorro.dao.cuenta;

import CajaDeAhorro.bd.domain.Cuenta;
import CajaDeAhorro.bd.mappers.CuentaConexion;
import java.util.List;

/**
 *
 * @autor Gizelle RM
 */
public class CuentaDaoImpl implements CuentaDao {

    @Override
    public void crearCuenta(Cuenta cuenta) {
        CuentaConexion conexion = new CuentaConexion();
        conexion.crearCuenta(cuenta);
    }

    @Override
    public void actualizarCuenta(int numeroCuenta, Cuenta cuenta) {
        CuentaConexion conexion = new CuentaConexion();
        conexion.actualizarCuenta(numeroCuenta, cuenta);
    }

    @Override
    public Cuenta eliminarCuenta(int numeroCuenta) {
        Cuenta cuentaEliminada = new Cuenta();
        CuentaConexion conexion = new CuentaConexion();
        cuentaEliminada = conexion.eliminarCuenta(numeroCuenta);
        return cuentaEliminada;
    }

    @Override
    public Cuenta obtenerCuentaPorNumero(int numeroCuenta) {
        Cuenta cuentaByNumero;
        CuentaConexion conexion = new CuentaConexion();
        cuentaByNumero = conexion.obtenerCuentaPorNumero(numeroCuenta);
        return cuentaByNumero;
    }

    @Override
    public List<Cuenta> obtenerTodasLasCuentas() {
        List<Cuenta> listaDeCuentas = null;
        CuentaConexion conexion = new CuentaConexion();
        listaDeCuentas = conexion.obtenerTodasLasCuentas();
        return listaDeCuentas;
    }

    @Override
    public Cuenta obtenerUltimaCuenta() {
        Cuenta ultimaCuenta;
        CuentaConexion conexion = new CuentaConexion();
        ultimaCuenta = conexion.obtenerUltimaCuenta();
        return ultimaCuenta;
    }
    
    @Override
    public List<Object[]> obtenerTransaccionesPorNumeroCuenta(int numeroCuenta) {
        CuentaConexion conexion = new CuentaConexion();
        return conexion.obtenerTransaccionesPorNumeroCuenta(numeroCuenta);
    }

}