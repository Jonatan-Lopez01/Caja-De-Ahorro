package CajaDeAhorro.dao.solicitudprestamo;

import CajaDeAhorro.bd.domain.SolicitudPrestamo;
import CajaDeAhorro.bd.mappers.SolicitudPrestamoConexion;
import java.util.List;

/**
 * Implementación de la interfaz SolicitudPrestamoDao.
 * Permite la creación, actualización, eliminación y consulta de solicitudes de préstamo.
 * También proporciona un método para obtener la última solicitud de préstamo creada en la base de datos.
 * 
 * @author Ramses
 */
public class SolicitudPrestamoDaoImpl implements SolicitudPrestamoDao {

    @Override
    public void crearSolicitudPrestamo(SolicitudPrestamo solicitudPrestamo) {
        SolicitudPrestamoConexion conexion = new SolicitudPrestamoConexion();
        conexion.crearSolicitudPrestamo(solicitudPrestamo);
    }

    @Override
    public void actualizarSolicitudPrestamo(int id, SolicitudPrestamo solicitudPrestamo) {
        SolicitudPrestamoConexion conexion = new SolicitudPrestamoConexion();
        conexion.actualizarSolicitudPrestamo(id, solicitudPrestamo);
    }

    @Override
    public void eliminarSolicitudPrestamo(int id) {
        SolicitudPrestamoConexion conexion = new SolicitudPrestamoConexion();
        conexion.eliminarSolicitudPrestamo(id);
    }

    @Override
    public SolicitudPrestamo obtenerSolicitudPrestamoPorId(int id) {
        SolicitudPrestamoConexion conexion = new SolicitudPrestamoConexion();
        return conexion.obtenerSolicitudPrestamoPorId(id);
    }

    @Override
    public List<SolicitudPrestamo> obtenerTodasLasSolicitudesPrestamo() {
        SolicitudPrestamoConexion conexion = new SolicitudPrestamoConexion();
        return conexion.obtenerTodasLasSolicitudesPrestamo();
    }

    @Override
    public SolicitudPrestamo obtenerUltimaSolicitudPrestamo() {
        SolicitudPrestamoConexion conexion = new SolicitudPrestamoConexion();
        return conexion.obtenerUltimaSolicitudPrestamo();
    }
}
