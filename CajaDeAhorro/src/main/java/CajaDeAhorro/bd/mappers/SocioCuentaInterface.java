/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.bd.mappers;
import CajaDeAhorro.bd.domain.SocioCuenta;
import java.util.List;

/**
 *
 * @author Kevin Caballero
 */
public interface SocioCuentaInterface {
    // Método para crear un nuevo socioCuenta
    void crearSocioCuenta(SocioCuenta socioCuenta);
    // Método para actualizar un socioCuenta existente

    void actualizarSocioCuenta(SocioCuenta socioCuenta);

    // Método para eliminar un socioCuenta por su id
    void eliminarSocioCuenta(int id);

    // Método para obtener un socioCuenta por su id
    SocioCuenta obtenerSocioCuentaPorId(int id);

    // Método para obtener todos los socioCuentas, 
    List<SocioCuenta> obtenerTodosLosSocioCuentas();
}
