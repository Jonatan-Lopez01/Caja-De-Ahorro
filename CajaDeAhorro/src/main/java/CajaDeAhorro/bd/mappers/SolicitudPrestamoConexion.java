package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.SolicitudPrestamo;
import CajaDeAhorro.bd.domain.SolicitudPrestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitudPrestamoConexion implements SolicitudPrestamoInterface {

    @Override
    public void crearSolicitudPrestamo(SolicitudPrestamo solicitudPrestamo) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO solicitud_prestamo (id_socio, monto_prestado, tipo_prestamo, fecha_solicitud, plazo, num_montos, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, solicitudPrestamo.getIdSocio());
            lineaParametros.setDouble(2, solicitudPrestamo.getMontoPrestado());
            lineaParametros.setString(3, solicitudPrestamo.getTipoPrestamo());
            lineaParametros.setTimestamp(4, solicitudPrestamo.getFechaSolicitud());
            lineaParametros.setInt(5, solicitudPrestamo.getPlazo());
            lineaParametros.setInt(6, solicitudPrestamo.getNumMontos());
            lineaParametros.setString(7, solicitudPrestamo.getDescripcion());
            lineaParametros.setString(8, solicitudPrestamo.getEstado());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Solicitud de préstamo insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la solicitud de préstamo.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
    }

    @Override
    public void actualizarSolicitudPrestamo(int id, SolicitudPrestamo solicitudPrestamo) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE solicitud_prestamo SET id_socio = ?, monto_prestado = ?, tipo_prestamo = ?, fecha_solicitud = ?, plazo = ?, num_montos = ?, descripcion = ?, estado = ? WHERE id_solicitud_prestamo = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, solicitudPrestamo.getIdSocio());
            lineaParametros.setDouble(2, solicitudPrestamo.getMontoPrestado());
            lineaParametros.setString(3, solicitudPrestamo.getTipoPrestamo());
            lineaParametros.setTimestamp(4, solicitudPrestamo.getFechaSolicitud());
            lineaParametros.setInt(5, solicitudPrestamo.getPlazo());
            lineaParametros.setInt(6, solicitudPrestamo.getNumMontos());
            lineaParametros.setString(7, solicitudPrestamo.getDescripcion());
            lineaParametros.setString(8, solicitudPrestamo.getEstado());
            lineaParametros.setInt(9, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Solicitud de préstamo actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la solicitud de préstamo.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminarSolicitudPrestamo(int id) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            String deleteSql = "DELETE FROM solicitud_prestamo WHERE id_solicitud_prestamo = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(deleteSql);
            lineaParametros.setLong(1, id);
            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Solicitud de préstamo eliminada correctamente.");
            } else {
                System.out.println("No se pudo eliminar la solicitud de préstamo.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
    }

    @Override
    public SolicitudPrestamo obtenerSolicitudPrestamoPorId(int id) {
        SolicitudPrestamo consultarSolicitudPrestamo = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM solicitud_prestamo WHERE id_solicitud_prestamo = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setLong(1, id);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarSolicitudPrestamo = new SolicitudPrestamo();
                consultarSolicitudPrestamo.setIdSolicitudPrestamo(resultado.getInt("id_solicitud_prestamo"));
                consultarSolicitudPrestamo.setIdSocio(resultado.getInt("id_socio"));
                consultarSolicitudPrestamo.setMontoPrestado(resultado.getDouble("monto_prestado"));
                consultarSolicitudPrestamo.setTipoPrestamo(resultado.getString("tipo_prestamo"));
                consultarSolicitudPrestamo.setFechaSolicitud(resultado.getTimestamp("fecha_solicitud"));
                consultarSolicitudPrestamo.setPlazo(resultado.getInt("plazo"));
                consultarSolicitudPrestamo.setNumMontos(resultado.getInt("num_montos"));
                consultarSolicitudPrestamo.setDescripcion(resultado.getString("descripcion"));
                consultarSolicitudPrestamo.setEstado(resultado.getString("estado"));
            }
            System.out.println("Consulta completada con éxito.");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return consultarSolicitudPrestamo;
    }

    @Override
    public List<SolicitudPrestamo> obtenerTodasLasSolicitudesPrestamo() {
        List<SolicitudPrestamo> listaSolicitudesPrestamo = new ArrayList<>();

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM solicitud_prestamo";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                SolicitudPrestamo solicitudPrestamo = new SolicitudPrestamo();
                solicitudPrestamo.setIdSolicitudPrestamo(resultado.getInt("id_solicitud_prestamo"));
                solicitudPrestamo.setIdSocio(resultado.getInt("id_socio"));
                solicitudPrestamo.setMontoPrestado(resultado.getDouble("monto_prestado"));
                solicitudPrestamo.setTipoPrestamo(resultado.getString("tipo_prestamo"));
                solicitudPrestamo.setFechaSolicitud(resultado.getTimestamp("fecha_solicitud"));
                solicitudPrestamo.setPlazo(resultado.getInt("plazo"));
                solicitudPrestamo.setNumMontos(resultado.getInt("num_montos"));
                solicitudPrestamo.setDescripcion(resultado.getString("descripcion"));
                solicitudPrestamo.setEstado(resultado.getString("estado"));
                listaSolicitudesPrestamo.add(solicitudPrestamo);
            }
            System.out.println("Consulta completada con éxito.");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return listaSolicitudesPrestamo;
    }

    @Override
    public SolicitudPrestamo obtenerUltimaSolicitudPrestamo() {
        SolicitudPrestamo ultimaSolicitudPrestamo = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM solicitud_prestamo ORDER BY id_solicitud_prestamo DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                ultimaSolicitudPrestamo = new SolicitudPrestamo();
                ultimaSolicitudPrestamo.setIdSolicitudPrestamo(resultado.getInt("id_solicitud_prestamo"));
                ultimaSolicitudPrestamo.setIdSocio(resultado.getInt("id_socio"));
                ultimaSolicitudPrestamo.setMontoPrestado(resultado.getDouble("monto_prestado"));
                ultimaSolicitudPrestamo.setTipoPrestamo(resultado.getString("tipo_prestamo"));
                ultimaSolicitudPrestamo.setFechaSolicitud(resultado.getTimestamp("fecha_solicitud"));
                ultimaSolicitudPrestamo.setPlazo(resultado.getInt("plazo"));
                ultimaSolicitudPrestamo.setNumMontos(resultado.getInt("num_montos"));
                ultimaSolicitudPrestamo.setDescripcion(resultado.getString("descripcion"));
                ultimaSolicitudPrestamo.setEstado(resultado.getString("estado"));
            }
            System.out.println("Consulta completada con éxito.");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return ultimaSolicitudPrestamo;
    }
}
