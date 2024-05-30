/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Prestamo;
import CajaDeAhorro.bd.domain.PrestamoDTO;
import java.util.List;

/**
 * Interface para definir las operaciones CRUD sobre los objetos Prestamo.
 * 
 * @autor Arce
 */
public interface PrestamoInterface {
    void crearPrestamo(Prestamo prestamo);
    void actualizarPrestamo(int id, Prestamo prestamo);
    Prestamo eliminarPrestamo(int id);
    Prestamo obtenerPrestamoPorId(int id);
    List<Prestamo> obtenerTodosLosPrestamos();
    Prestamo obtenerUltimoPrestamo();
    List<PrestamoDTO> obtenerTodosLosDatosPrestamoPorSocio(long idSocio);
}
