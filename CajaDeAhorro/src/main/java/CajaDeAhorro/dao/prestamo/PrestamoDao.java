/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.prestamo;
import CajaDeAhorro.bd.domain.Prestamo;
import java.util.List;

/**
 *
 * @author Arce
 */

public interface PrestamoDao {
    // Método para crear un nuevo prestamo
    void crearPrestamo(Prestamo prestamo);

    // Método para actualizar un prestamo existente
    void actualizarPrestamo(int id, Prestamo prestamo);

    // Método para eliminar un prestamo por el id
    Prestamo eliminarPrestamo(int id);

    // Método para obtener un prestamo por su id
    Prestamo obtenerPrestamoPorId(int id);

    // Método para obtener todos los prestamos 
    List<Prestamo> obtenerTodosLosPrestamos();

    // Metodo para obtener el ultimo prestamo creado de la base de datos
    // Ordena de forma ascendente y toma el id_prestamo mayor del ordenamiento
    // esto lo hacemos asi debido a que en la DATABASE el id_prestamo es autoincrementable :)
    Prestamo obtenerUltimoPrestamo();
}
