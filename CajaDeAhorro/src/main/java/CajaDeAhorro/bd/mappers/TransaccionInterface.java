package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Transaccion;
import java.util.List;

/**
 *
 * @autor Gizelle RM
 */
public interface TransaccionInterface {
    
    // Método para crear una nueva transacción
    void crearTransaccion(Transaccion transaccion);
    
    // Método para actualizar una transacción existente
    void actualizarTransaccion(int idTransaccion, Transaccion transaccion);

    // Método para eliminar una transacción por su id
    void eliminarTransaccion(int idTransaccion);

    // Método para obtener una transacción por su id
    Transaccion obtenerTransaccionPorId(int idTransaccion);

    // Método para obtener todas las transacciones
    List<Transaccion> obtenerTodasLasTransacciones();
    
    // Método para obtener la última transacción
    Transaccion obtenerUltimaTransaccion();
}
