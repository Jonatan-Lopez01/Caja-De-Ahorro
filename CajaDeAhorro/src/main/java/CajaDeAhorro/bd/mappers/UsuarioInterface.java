/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Usuario;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public interface UsuarioInterface {
     // Método para crear un nuevo usuario
    void crearUsuario(Usuario usuario);
    // Método para actualizar un usuario existente

    void actualizarUsuario(Usuario usuario);

    // Método para eliminar un usuario por su id
    void eliminarUsuario(int id);

    // Método para obtener un usuario por su id
    Usuario obtenerUsuarioPorId(int id);

    // Método para obtener todos los usuarios, 
    List<Usuario> obtenerTodosLosUsuarios();
    
}
