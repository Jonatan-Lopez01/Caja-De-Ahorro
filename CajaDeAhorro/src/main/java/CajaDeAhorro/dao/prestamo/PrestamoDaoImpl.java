/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.dao.prestamo;

import CajaDeAhorro.bd.domain.Prestamo;
import CajaDeAhorro.bd.mappers.PrestamoConexion;
import java.util.List;

/**
 * Implementación del DAO (Data Access Object) para la entidad Prestamo.
 * Esta clase utiliza PrestamoConexion para interactuar con la base de datos.
 * 
 * @autor Arce
 */
public class PrestamoDaoImpl implements PrestamoDao {

    @Override
    public void crearPrestamo(Prestamo prestamo) {
        PrestamoConexion conexion = new PrestamoConexion();
        conexion.crearPrestamo(prestamo);
    }

    @Override
    public void actualizarPrestamo(int id, Prestamo prestamo) {
        PrestamoConexion conexion = new PrestamoConexion();
        conexion.actualizarPrestamo(id, prestamo);
    }

    @Override
    public Prestamo eliminarPrestamo(int id) {
        PrestamoConexion conexion = new PrestamoConexion();
        return conexion.eliminarPrestamo(id);
    }

    @Override
    public Prestamo obtenerPrestamoPorId(int id) {
        PrestamoConexion conexion = new PrestamoConexion();
        return conexion.obtenerPrestamoPorId(id);
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        PrestamoConexion conexion = new PrestamoConexion();
        return conexion.obtenerTodosLosPrestamos();
    }

    @Override
    public Prestamo obtenerUltimoPrestamo() {
        PrestamoConexion conexion = new PrestamoConexion();
        return conexion.obtenerUltimoPrestamo();
    }
}
