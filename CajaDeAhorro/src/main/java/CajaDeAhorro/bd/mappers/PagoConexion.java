/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class PagoConexion {

    // Método para hacer un pago
    public void RealizarPago(Pago pago) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO pago (id_prestamo, cantidad, fecha) VALUES (?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, pago.getIdPrestamo());
            lineaParametros.setDouble(2, pago.getCantidad());
            lineaParametros.setTimestamp(3, Timestamp.valueOf(pago.getFecha()));

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Pago realizado correctamente.");
            } else {
                System.out.println("Pago no insertado,");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
    }

    // Método para actualizar un pago
    public void actualizarPago(int id, Pago pago) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE pago SET id_prestamo = ?, cantidad = ?, fecha = ? WHERE id_pago = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, pago.getIdPrestamo());
            lineaParametros.setDouble(2, pago.getCantidad());
            lineaParametros.setTimestamp(3, Timestamp.valueOf(pago.getFecha()));
            lineaParametros.setInt(4, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Pago actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el pago.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Método para eliminar un pago por el id
    public Pago eliminarPago(int id) {
        Pago pagoEliminado = null;

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            // Primero, obtenemos los datos del pago antes de eliminarlo
            pagoEliminado = this.obtenerPagoPorId(id);

            // Si el pago existe, procede a eliminarlo
            if (pagoEliminado != null) {
                String deleteSql = "DELETE FROM pago WHERE id_pago = ?";
                PreparedStatement lineaParametros = enlaceActivo.prepareStatement(deleteSql);
                lineaParametros.setInt(1, id);
                int flag = lineaParametros.executeUpdate();

                if (flag > 0) {
                    System.out.println("Pago eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el pago.");
                    pagoEliminado = null; // Si no se pudo eliminar, no devolvemos el pago
                }
            } else {
                System.out.println("No se encontró el pago con el ID proporcionado.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }

        return pagoEliminado;
    }

    // Método para obtener un pago por su id_pago
    public Pago obtenerPagoPorId(int idPago) {
        Pago pago = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM pago WHERE id_pago = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, idPago);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) {
                pago = new  Pago();
                pago.setIdPago(resultado.getInt("id_pago"));
                pago.setIdPrestamo(resultado.getInt("id_prestamo"));
                pago.setCantidad(resultado.getDouble("cantidad"));

                Timestamp timestamp = resultado.getTimestamp("fecha");
                pago.setFecha(timestamp.toLocalDateTime());
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return pago;
    }

    // Método para obtener todos los pagos
    public List<Pago> obtenerTodosLosPagos() {
        List<Pago> pagos = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM pago";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            ResultSet resultado = lineaParametros.executeQuery(sql);

            while (resultado.next()) {
                Pago pago = new Pago();

                pago.setIdPago(resultado.getInt("id_pago"));
                pago.setIdPrestamo(resultado.getInt("id_prestamo"));
                pago.setCantidad(resultado.getDouble("cantidad"));
                Timestamp timestamp = resultado.getTimestamp("fecha");
                pago.setFecha(timestamp.toLocalDateTime());

                pagos.add(pago);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return pagos;
    }

    // Método para obtener el último pago realizado
    public Pago obtenerUltimoPago() {
        Pago ultimoPago = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM pago ORDER BY id_pago DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery(sql);
            
            if (resultado.next()) {
                ultimoPago = new Pago();
                ultimoPago.setIdPago(resultado.getInt("id_pago"));
                ultimoPago.setIdPrestamo(resultado.getInt("id_prestamo"));
                ultimoPago.setCantidad(resultado.getInt("cantidad"));
                Timestamp timestamp = resultado.getTimestamp("fecha");
                ultimoPago.setFecha(timestamp.toLocalDateTime());
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return ultimoPago;
    }
}
