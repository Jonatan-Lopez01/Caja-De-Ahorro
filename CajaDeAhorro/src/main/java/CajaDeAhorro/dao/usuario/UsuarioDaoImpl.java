/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.usuario;

import CajaDeAhorro.bd.domain.Usuario;

import java.util.List;

import CajaDeAhorro.bd.mappers.UsuarioConexion;

public class UsuarioDaoImpl implements UsuarioDao {

    //solo llamar a los metodos de la clase UsuarioConexion
    @Override
    public void crearUsuario(Usuario usuario) {
        UsuarioConexion conexion = new UsuarioConexion();
        conexion.crearUsuario(usuario);

    }

    @Override
    public void actualizarUsuario(int id, Usuario usuario) {
        UsuarioConexion conexion = new UsuarioConexion();
        conexion.actualizarUsuario(id, usuario);

    }

    @Override
    public Usuario eliminarUsuario(int id) {
        Usuario usuarioEliminado = null;
        UsuarioConexion conexion = new UsuarioConexion();
        usuarioEliminado = conexion.eliminarUsuario(id);
        return usuarioEliminado;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuarioById;
        UsuarioConexion conexion = new UsuarioConexion();
        usuarioById = conexion.obtenerUsuarioPorId(id);

        return usuarioById;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List listaDeUsuarios = null;
        UsuarioConexion conexion = new UsuarioConexion();
        listaDeUsuarios = conexion.obtenerTodosLosUsuarios();
        return listaDeUsuarios;
    }

    @Override
    public Usuario obtenerUltimoUsuario() {
        Usuario ultimoUsuario = new Usuario();
        UsuarioConexion conexion = new UsuarioConexion();
        ultimoUsuario = conexion.obtenerUltimoUsuario();
        return ultimoUsuario;
    }
    
    @Override
    public boolean login (String correo,String password )
    {
        UsuarioConexion conexion = new UsuarioConexion();
        return conexion.login(correo, password);//devuelve true o false
    }
}
