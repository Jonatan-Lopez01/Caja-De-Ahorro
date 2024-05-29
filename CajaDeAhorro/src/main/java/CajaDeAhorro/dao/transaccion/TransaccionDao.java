/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.dao.transaccion;

import CajaDeAhorro.bd.domain.Transaccion;
import java.util.List;

/**
 *
 * @author Gizelle RM
 */
public interface TransaccionDao {
    
    // Método para crear una nueva transacción
    void crearTransaccion(Transaccion transaccion);
    
    // Método para actualizar una transacción existente
    void actualizarTransaccion(int idTransaccion, Transaccion transaccion);

    // Método para eliminar una transacción por su id
    Transaccion eliminarTransaccion(int idTransaccion);

    // Método para obtener una transacción por su id
    Transaccion obtenerTransaccionPorId(int idTransaccion);

    // Método para obtener todas las transacciones
    List<Transaccion> obtenerTodasLasTransacciones();
    
    // Método para obtener la última transacción
    Transaccion obtenerUltimaTransaccion();
}
