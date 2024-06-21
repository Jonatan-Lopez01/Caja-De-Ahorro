package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Operacion;
import java.util.List;

/**
 * Interfaz para definir operaciones relacionadas con la entidad Operacion en la base de datos.
 * Permite la creación, actualización, eliminación y consulta de operaciones.
 * También proporciona un método para obtener la última operación creada en la base de datos.
 * 
 * @author Ramses
 */
public interface OperacionInterface {
    
    // Método para crear una nueva operación
    void crearOperacion(Operacion operacion);
    
    // Método para actualizar una operación existente
    void actualizarOperacion(int id, Operacion operacion);

    // Método para eliminar una operación por su id
    void eliminarOperacion(int id);

    // Método para obtener una operación por su id
    Operacion obtenerOperacionPorId(int id);

    // Método para obtener todas las operaciones 
    List<Operacion> obtenerTodasLasOperaciones();
    
    // Método para obtener la última operación creada en la base de datos
    // Este método ordena las operaciones de forma ascendente y toma el id_operacion mayor del ordenamiento
    // Esto se debe a que en la base de datos el id_operacion es autoincrementable
    Operacion obtenerUltimaOperacion();
    
    void realizarDeposito(int numeroCuenta, double cantidad);
    
    void realizarRetiro(int numeroCuenta, double cantidad);
}
