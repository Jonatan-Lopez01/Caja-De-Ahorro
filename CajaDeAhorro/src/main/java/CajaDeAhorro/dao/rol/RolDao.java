/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.dao.rol;

import CajaDeAhorro.bd.domain.Rol;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public interface RolDao {
    // Método para crear un nuevo rol

    void crearRol(Rol rol);
    // Método para actualizar un usuario existente

    void actualizarRol(Rol rol);

    // Método para eliminar un rol por el id
    void eliminarRol(int id);

    // Método para obtener un rol por su id
    Rol obtenerRolPorId(int id);

    // Método para obtener todos los roles 
    List<Rol> obtenerTodosLosRoles();
    
    //Metodo para obtener el ultimo rol creado de la base de datos
    //Ordena de forma ascendente y toma el id_rol mayor del ordenamiento
    //esto lo hacemos asi debido a que en la DATABASE el id_rol es autoincrementable :)
    
    Rol obtenerUltimoRol();

}
