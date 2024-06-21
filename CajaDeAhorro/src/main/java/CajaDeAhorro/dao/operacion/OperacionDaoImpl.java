/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.operacion;
import CajaDeAhorro.bd.domain.Operacion;
import CajaDeAhorro.bd.mappers.OperacionConexion;
import java.util.List;
/**
 *
 * @author Ramses
 */
public class OperacionDaoImpl implements OperacionDao{

    @Override
    public void crearOperacion(Operacion operacion) {
        OperacionConexion conexion = new OperacionConexion();
        conexion.crearOperacion(operacion);
    }

    @Override
    public void actualizarOperacion(int id, Operacion operacion) {
        OperacionConexion conexion = new OperacionConexion();
        conexion.actualizarOperacion(id, operacion);
    }

    @Override
    public void eliminarOperacion(int id) {
        OperacionConexion conexion = new OperacionConexion();
        conexion.eliminarOperacion(id);
    }

    @Override
    public Operacion obtenerOperacionPorId(int id) {
        OperacionConexion conexion = new OperacionConexion();
        return conexion.obtenerOperacionPorId(id);
    }

    @Override
    public List<Operacion> obtenerTodasLasOperaciones() {
        OperacionConexion conexion = new OperacionConexion();
        return conexion.obtenerTodasLasOperaciones();
    }

    @Override
    public Operacion obtenerUltimaOperacion() {
        OperacionConexion conexion = new OperacionConexion();
        return conexion.obtenerUltimaOperacion();
    }
    @Override
    public void realizarDeposito(int numeroCuenta, double cantidad) {
        OperacionConexion conexion = new OperacionConexion();
        conexion.realizarDeposito(numeroCuenta, cantidad);
    }
     @Override
    public void realizarRetiro(int numeroCuenta, double cantidad) {
        OperacionConexion conexion = new OperacionConexion();
        conexion.realizarRetiro(numeroCuenta, cantidad);
    }
}
