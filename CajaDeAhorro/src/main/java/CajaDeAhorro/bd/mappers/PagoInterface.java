/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Pago;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public interface PagoInterface {
    
    // Método para hacer un pago
    void RealizarPago(Pago pago);
    
    // Método para actualizar un pago
    void actualizarPago(int id, Pago pago);

    // Método para eliminar un pago por el id
    Pago eliminarPago(int id);

    // Método para obtener un pago por su id
    Pago obtenerPagoPorId(int id);

    // Método para obtener todos los pagos
    List<Pago> obtenerTodosLosPagos();
    
    //Metodo para obtener el ultimo pago realizado
    Pago obtenerUltimoPago();   
}
