/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.cuentas_Liquidadas;

import CajaDeAhorro.bd.domain.CuentasLiquidadas;
import CajaDeAhorro.bd.mappers.CuentasLiquidadasConexion;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class CuentasLiquidadasDaoImpl implements CuentasLiquidadasDao {

    @Override
    public void crearCuentaLiquidada(CuentasLiquidadas cuentaLiquidada) {
        CuentasLiquidadasConexion conexion = new CuentasLiquidadasConexion();
        conexion.crearCuentaLiquidada(cuentaLiquidada);
    }

    @Override
    public void actualizarCuentaLiquidada(int idCuentaLiquidada, CuentasLiquidadas cuentaLiquidada) {
        CuentasLiquidadasConexion conexion = new CuentasLiquidadasConexion();
        conexion.actualizarCuentaLiquidada(idCuentaLiquidada, cuentaLiquidada);
    }

    @Override
    public CuentasLiquidadas eliminarCuentaLiquidada(int idCuentaLiquidada) {
        CuentasLiquidadas cuentaLiquidadaEliminada;
        CuentasLiquidadasConexion conexion = new CuentasLiquidadasConexion();
        cuentaLiquidadaEliminada = conexion.eliminarCuentaLiquidada(idCuentaLiquidada);
        return cuentaLiquidadaEliminada;
    }

    @Override
    public CuentasLiquidadas obtenerCuentaLiquidadaPorId(int idCuentaLiquidada) {
        CuentasLiquidadas cuentaLiquidadaById;
        CuentasLiquidadasConexion conexion = new CuentasLiquidadasConexion();
        cuentaLiquidadaById = conexion.obtenerCuentaLiquidadaPorId(idCuentaLiquidada);
        return cuentaLiquidadaById;
    }

    @Override
    public List<CuentasLiquidadas> obtenerTodasLasCuentasLiquidadas() {
        List<CuentasLiquidadas> listaCuentasLiquidadas;
        CuentasLiquidadasConexion conexion = new CuentasLiquidadasConexion();
        listaCuentasLiquidadas = conexion.obtenerTodasLasCuentasLiquidadas();
        return listaCuentasLiquidadas;
    }

    @Override
    public CuentasLiquidadas obtenerUltimaCuentaLiquidada() {
        CuentasLiquidadas ultimaCuentaLiquidada;
        CuentasLiquidadasConexion conexion = new CuentasLiquidadasConexion();
        ultimaCuentaLiquidada = conexion.obtenerUltimaCuentaLiquidada();
        return ultimaCuentaLiquidada;
    }

}
