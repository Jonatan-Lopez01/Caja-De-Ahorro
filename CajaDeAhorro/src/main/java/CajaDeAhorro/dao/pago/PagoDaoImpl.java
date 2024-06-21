/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.pago;

import CajaDeAhorro.bd.domain.Pago;
import CajaDeAhorro.bd.mappers.PagoConexion;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class PagoDaoImpl implements PagoDao {

    @Override
    public void RealizarPago(Pago pago) {
        PagoConexion conexion = new PagoConexion();
        conexion.RealizarPago(pago);
    }

    @Override
    public void actualizarPago(int id, Pago pago) {
        PagoConexion conexion = new PagoConexion();
        conexion.actualizarPago(id, pago);
    }

    @Override
    public Pago eliminarPago(int id) {
        PagoConexion conexion = new PagoConexion();
        return conexion.eliminarPago(id);
    }

    @Override
    public Pago obtenerPagoPorId(int id) {
        PagoConexion conexion = new PagoConexion();
        return conexion.obtenerPagoPorId(id);

    }

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        PagoConexion conexion = new PagoConexion();
        return conexion.obtenerTodosLosPagos();

    }

    @Override
    public Pago obtenerUltimoPago() {
        PagoConexion conexion = new PagoConexion();
        return conexion.obtenerUltimoPago();
    }
    public List<Pago>  pagosRealizadosPorSocio(int idPrestamo,LocalDateTime fecha){
        PagoConexion conexion = new PagoConexion();
        return conexion.pagosRealizadosPorSocio(idPrestamo, fecha);
    }
}
