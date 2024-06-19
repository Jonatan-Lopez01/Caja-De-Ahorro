/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Socio;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public interface SocioInterface {
       // Método para crear un nuevo socio
    void crearSocio(Socio socio);
    // Método para actualizar un socio existente

    void actualizarSocio(int id, Socio socio);

    // Método para eliminar un socio por su id
    Socio eliminarSocio(int id);

    // Método para obtener un socio por su id
    Socio obtenerSocioPorId(int id);

    // Método para obtener todos los socios, 
    List<Socio> obtenerTodosLosSocios();
    
    Socio obtenerUltimoSocio();
    
}
