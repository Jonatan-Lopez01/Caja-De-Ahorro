/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.socio_cuenta;

import CajaDeAhorro.bd.domain.SocioCuenta;
import CajaDeAhorro.bd.mappers.SocioCuentaConexion;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class SocioCuentaDaoImpl implements SocioCuentaDao {

    @Override
    public void crearSocioCuenta(SocioCuenta socioCuenta) {
        SocioCuentaConexion conexion = new SocioCuentaConexion();
        conexion.crearSocioCuenta(socioCuenta);
    }

    @Override
    public void actualizarSocioCuenta(int id, SocioCuenta socioCuenta) {
        SocioCuentaConexion conexion = new SocioCuentaConexion();
        conexion.actualizarSocioCuenta(id, socioCuenta);
    }

    @Override
    public SocioCuenta eliminarSocioCuenta(int id) {
        SocioCuentaConexion conexion = new SocioCuentaConexion();
        return conexion.eliminarSocioCuenta(id);

    }

    @Override
    public SocioCuenta obtenerSocioCuentaPorId(int id) {
        SocioCuentaConexion conexion = new SocioCuentaConexion();
        return conexion.obtenerSocioCuentaPorId(id);
    }

    @Override
    public List<SocioCuenta> obtenerTodosLosSocioCuentas() {
        SocioCuentaConexion conexion = new SocioCuentaConexion();
        return conexion.obtenerTodosLosSocioCuentas();
    }

    @Override
    public SocioCuenta obtenerUltimoSocioCuenta() {
         SocioCuentaConexion conexion = new SocioCuentaConexion();
         return conexion.obtenerUltimoSocioCuenta();
    }
    public void actualizarSocioCuentaPorNumeroCuenta(int numeroCuenta, int idSocioOriginal, int nuevoIdSocio)
    {
        SocioCuentaConexion conexion = new SocioCuentaConexion();
        conexion.actualizarSocioCuentaPorNumeroCuenta(numeroCuenta, idSocioOriginal,nuevoIdSocio);       
    }

}
