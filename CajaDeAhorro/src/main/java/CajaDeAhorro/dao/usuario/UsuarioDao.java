package CajaDeAhorro.dao.usuario;

import CajaDeAhorro.bd.domain.Usuario;

import java.util.List;

/**
 * Interfaz para las operaciones CRUD de la entidad Usuario. Autor: Jonatan
 * Eduardo
 */
public interface UsuarioDao {

    // Método para crear un nuevo usuario
    void crearUsuario(Usuario usuario);
    // Método para actualizar un usuario existente

    void actualizarUsuario(int id, Usuario usuario);

    // Método para eliminar un usuario por su id
    Usuario eliminarUsuario(int id);

    // Método para obtener un usuario por su id
    Usuario obtenerUsuarioPorId(int id);

    // Método para obtener todos los usuarios, 
    List<Usuario> obtenerTodosLosUsuarios();
    
    //Metodo para obtener el ultimo usuario
    Usuario obtenerUltimoUsuario();

}
