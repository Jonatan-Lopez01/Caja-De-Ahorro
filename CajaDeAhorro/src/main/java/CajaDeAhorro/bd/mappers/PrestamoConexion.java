/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arce
 */
public class PrestamoConexion implements PrestamoInterface {

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO prestamo (id_solicitud_prestamo, id_intereses, monto_prestado, pago_actual, fecha_solicitud, plazo, num_montos) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setLong(1, prestamo.getIdSolicitudPrestamo());
            lineaParametros.setLong(2, prestamo.getIdIntereses());
            lineaParametros.setDouble(3, prestamo.getMontoPrestado());
            lineaParametros.setDouble(4, prestamo.getPagoActual());
            lineaParametros.setTimestamp(5, prestamo.getFechaSolicitud());
            lineaParametros.setDate(6, prestamo.getPlazo());
            lineaParametros.setInt(7, prestamo.getNumMontos());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Prestamo insertado correctamente.");
            } else {
                System.out.println("Prestamo no insertado.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
    }

    @Override
    public void actualizarPrestamo(int id, Prestamo prestamo) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE prestamo SET id_solicitud_prestamo = ?, id_intereses = ?, monto_prestado = ?, pago_actual = ?, fecha_solicitud = ?, plazo = ?, num_montos = ? WHERE id_prestamo = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setLong(1, prestamo.getIdSolicitudPrestamo());
            lineaParametros.setLong(2, prestamo.getIdIntereses());
            lineaParametros.setDouble(3, prestamo.getMontoPrestado());
            lineaParametros.setDouble(4, prestamo.getPagoActual());
            lineaParametros.setTimestamp(5, prestamo.getFechaSolicitud());
            lineaParametros.setDate(6, prestamo.getPlazo());
            lineaParametros.setInt(7, prestamo.getNumMontos());
            lineaParametros.setInt(8, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Prestamo actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el Prestamo.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Prestamo eliminarPrestamo(int id) {
        Prestamo prestamoEliminado = null;

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            // Primero, obtenemos los datos del prestamo antes de eliminarlo
            prestamoEliminado = this.obtenerPrestamoPorId(id);

            // Si el prestamo existe, procede a eliminarlo
            if (prestamoEliminado != null) {
                String deleteSql = "DELETE FROM prestamo WHERE id_prestamo = ?";
                PreparedStatement lineaParametros = enlaceActivo.prepareStatement(deleteSql);
                lineaParametros.setInt(1, id);
                int flag = lineaParametros.executeUpdate();

                if (flag > 0) {
                    System.out.println("Prestamo eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el Prestamo.");
                    prestamoEliminado = null; // Si no se pudo eliminar, no devolvemos el prestamo
                }
            } else {
                System.out.println("No se encontró el Prestamo con el ID proporcionado.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
            prestamoEliminado = null; // Si ocurre una excepción, no devolvemos el prestamo
        }

        return prestamoEliminado;
    }

    @Override
    public Prestamo obtenerPrestamoPorId(int id) {
        Prestamo consultarPrestamo = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM prestamo WHERE id_prestamo = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarPrestamo = new Prestamo();
                consultarPrestamo.setIdPrestamo(resultado.getLong("id_prestamo"));
                consultarPrestamo.setIdSolicitudPrestamo(resultado.getLong("id_solicitud_prestamo"));
                consultarPrestamo.setIdIntereses(resultado.getLong("id_intereses"));
                consultarPrestamo.setMontoPrestado(resultado.getDouble("monto_prestado"));
                consultarPrestamo.setPagoActual(resultado.getDouble("pago_actual"));
                consultarPrestamo.setFechaSolicitud(resultado.getTimestamp("fecha_solicitud"));
                consultarPrestamo.setPlazo(resultado.getDate("plazo"));
                consultarPrestamo.setNumMontos(resultado.getInt("num_montos"));
                System.out.println("Se obtuvo correctamente el prestamo");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
        return consultarPrestamo;
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        List<Prestamo> listaPrestamos = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM prestamo";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(resultado.getLong("id_prestamo"));
                prestamo.setIdSolicitudPrestamo(resultado.getLong("id_solicitud_prestamo"));
                prestamo.setIdIntereses(resultado.getLong("id_intereses"));
                prestamo.setMontoPrestado(resultado.getDouble("monto_prestado"));
                prestamo.setPagoActual(resultado.getDouble("pago_actual"));
                prestamo.setFechaSolicitud(resultado.getTimestamp("fecha_solicitud"));
                prestamo.setPlazo(resultado.getDate("plazo"));
                prestamo.setNumMontos(resultado.getInt("num_montos"));
                listaPrestamos.add(prestamo);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de prestamos");
            System.out.println(e);
        }
        return listaPrestamos;
    }

    @Override
    public Prestamo obtenerUltimoPrestamo() {
        Prestamo consultarPrestamo = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM prestamo ORDER BY id_prestamo DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarPrestamo = new Prestamo();
                consultarPrestamo.setIdPrestamo(resultado.getLong("id_prestamo"));
                consultarPrestamo.setIdSolicitudPrestamo(resultado.getLong("id_solicitud_prestamo"));
                consultarPrestamo.setIdIntereses(resultado.getLong("id_intereses"));
                consultarPrestamo.setMontoPrestado(resultado.getDouble("monto_prestado"));
                consultarPrestamo.setPagoActual(resultado.getDouble("pago_actual"));
                consultarPrestamo.setFechaSolicitud(resultado.getTimestamp("fecha_solicitud"));
                consultarPrestamo.setPlazo(resultado.getDate("plazo"));
                consultarPrestamo.setNumMontos(resultado.getInt("num_montos"));
            }
            System.out.println("Se obtuvo correctamente el prestamo");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el prestamo");
            System.out.println(e);
        }
        return consultarPrestamo;
    }
}
