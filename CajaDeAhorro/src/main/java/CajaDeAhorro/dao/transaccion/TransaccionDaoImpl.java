/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.transaccion;

import CajaDeAhorro.bd.domain.Transaccion;
import CajaDeAhorro.bd.mappers.TransaccionConexion;
import java.util.List;

/**
 *
 * @autor Gizelle RM
 */
public class TransaccionDaoImpl implements TransaccionDao {

    @Override
    public void crearTransaccion(Transaccion transaccion) {
        TransaccionConexion conexion = new TransaccionConexion();
        conexion.crearTransaccion(transaccion);
    }

    @Override
    public void actualizarTransaccion(int id, Transaccion transaccion) {
        TransaccionConexion conexion = new TransaccionConexion();
        conexion.actualizarTransaccion(id, transaccion);
    }

    @Override
    public Transaccion eliminarTransaccion(int id) {
        Transaccion transaccionEliminada = new Transaccion();
        TransaccionConexion conexion = new TransaccionConexion();
        transaccionEliminada = conexion.eliminarTransaccion(id);
        return transaccionEliminada;
    }

    @Override
    public Transaccion obtenerTransaccionPorId(int id) {
        Transaccion transaccionById;
        TransaccionConexion conexion = new TransaccionConexion();
        transaccionById = conexion.obtenerTransaccionPorId(id);
        return transaccionById;
    }

    @Override
    public List<Transaccion> obtenerTodasLasTransacciones() {
        List<Transaccion> listaDeTransacciones;
        TransaccionConexion conexion = new TransaccionConexion();
        listaDeTransacciones = conexion.obtenerTodasLasTransacciones();
        return listaDeTransacciones;
    }
    
    @Override
    public Transaccion obtenerUltimaTransaccion() {
        Transaccion ultimaTransaccion;
        TransaccionConexion conexion = new TransaccionConexion();
        ultimaTransaccion = conexion.obtenerUltimaTransaccion();
        return ultimaTransaccion;
    }
}
