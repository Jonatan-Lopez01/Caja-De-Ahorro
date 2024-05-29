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
    void crearPrestamo(Prestamo prestamo);
    void actualizarPrestamo(int id, Prestamo prestamo);
    Prestamo eliminarPrestamo(int id);
    Prestamo obtenerPrestamoPorId(int id);
    List<Prestamo> obtenerTodosLosPrestamos();
    Prestamo obtenerUltimoPrestamo();
}
