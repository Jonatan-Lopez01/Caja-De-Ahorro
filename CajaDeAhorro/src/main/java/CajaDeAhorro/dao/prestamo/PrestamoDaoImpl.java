/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.dao.prestamo;
import CajaDeAhorro.bd.domain.Prestamo;
import CajaDeAhorro.bd.mappers.PrestamoConexion;
import java.util.List;
/**
 *
 * @author Arce
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
        Prestamo prestamoEliminado;
        PrestamoConexion conexion = new PrestamoConexion();
        prestamoEliminado = conexion.eliminarPrestamo(id);
        return prestamoEliminado;
    }

    @Override
    public Prestamo obtenerPrestamoPorId(int id) {
        Prestamo prestamoById;
        PrestamoConexion conexion = new PrestamoConexion();
        prestamoById = conexion.obtenerPrestamoPorId(id);
        return prestamoById;
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        List<Prestamo> listaDePrestamos;
        PrestamoConexion conexion = new PrestamoConexion();
        listaDePrestamos = conexion.obtenerTodosLosPrestamos();
        return listaDePrestamos;
    }

    @Override
    public Prestamo obtenerUltimoPrestamo() {
        Prestamo ultimoPrestamo;
        PrestamoConexion conexion = new PrestamoConexion();
        ultimoPrestamo = conexion.obtenerUltimoPrestamo();
        return ultimoPrestamo;
    }
}
