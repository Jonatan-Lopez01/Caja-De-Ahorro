package CajaDeAhorro.dao.solicitudprestamo;

import CajaDeAhorro.bd.domain.SolicitudPrestamo;
import java.util.List;

/**
 * Interfaz para definir operaciones relacionadas con la entidad SolicitudPrestamo en la base de datos.
 * Permite la creación, actualización, eliminación y consulta de solicitudes de préstamo.
 * También proporciona un método para obtener la última solicitud de préstamo creada en la base de datos.
 * 
 * @author Ramses
 */
public interface SolicitudPrestamoDao {
    
    // Método para crear una nueva solicitud de préstamo
    void crearSolicitudPrestamo(SolicitudPrestamo solicitudPrestamo);
    
    // Método para actualizar una solicitud de préstamo existente
    void actualizarSolicitudPrestamo(int id, SolicitudPrestamo solicitudPrestamo);

    // Método para eliminar una solicitud de préstamo por su id
    void eliminarSolicitudPrestamo(int id);

    // Método para obtener una solicitud de préstamo por su id
    SolicitudPrestamo obtenerSolicitudPrestamoPorId(int id);

    // Método para obtener todas las solicitudes de préstamo 
    List<SolicitudPrestamo> obtenerTodasLasSolicitudesPrestamo();
    
    // Método para obtener la última solicitud de préstamo creada en la base de datos
    // Este método ordena las solicitudes de préstamo de forma ascendente y toma el id_solicitud_prestamo mayor del ordenamiento
    // Esto se debe a que en la base de datos el id_solicitud_prestamo es autoincrementable
    SolicitudPrestamo obtenerUltimaSolicitudPrestamo();
    
    String verificarTerminosCondicionesAprobadas(long idSocio);
}
