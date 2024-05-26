/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class UsuarioConexion implements UsuarioInterface {

    //Metodos implementados con las consultas a la base de datos.
    @Override
    public void crearUsuario(Usuario usuario) {

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO usuario (correo, id_rol, nombre, password) VALUES (?, ?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setString(1, usuario.getCorreo());
            lineaParametros.setInt(2, usuario.getIdRol());
            lineaParametros.setString(3, usuario.getNombre());
            lineaParametros.setString(4, usuario.getContraseña());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Usuario insertado Correctamente... ");
            } else {
                System.out.println("Usuario no insertado...");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
public void actualizarUsuario(Usuario usuario) {
    try {
        ConexionBd enlace = new ConexionBd();
        Connection enlaceActivo = enlace.Conectar();
        String sql = "UPDATE usuario SET id_usuario = ?, correo = ?, nombre = ?, password = ?, id_rol = ? WHERE id_usuario = ?";
        PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

        lineaParametros.setInt(1, usuario.getIdUsuario());
        lineaParametros.setString(2, usuario.getCorreo());
        lineaParametros.setString(3, usuario.getNombre());
        lineaParametros.setString(4, usuario.getContraseña());
        lineaParametros.setInt(5, usuario.getIdRol());
        lineaParametros.setInt(6, usuario.getIdUsuario());

        int flag = lineaParametros.executeUpdate();

        if (flag > 0) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el usuario.");
        }
        enlace.Desconectar();
    } catch (SQLException e) {
        System.out.println(e);
    }
}


    @Override
    public void eliminarUsuario(int id) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "DELETE FROM usuario WHERE id_usuario = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el usuario.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        Usuario consultarUsuario = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery(); //Resultado apunta al inicio de el conjunto de tuplas, tipo como en la posicion -1

            if (resultado.next()) { //Se mueve a la fila 0 y devuelve true si hay una fila, pero sino devuelve false
                consultarUsuario = new Usuario();
                consultarUsuario.setIdUsuario(resultado.getInt("id_usuario"));
                consultarUsuario.setCorreo(resultado.getString("correo"));
                consultarUsuario.setIdRol(resultado.getInt("id_rol"));
                consultarUsuario.setNombre(resultado.getString("nombre"));
                consultarUsuario.setContraseña(resultado.getString("password"));
            }
            System.out.println("Se obtuvo correctamente el usuario");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el usuario");
            System.out.println(e);
        }
        return consultarUsuario;
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM usuario";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("id_usuario"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setIdRol(resultado.getInt("id_rol"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setContraseña(resultado.getString("password"));
                listaUsuarios.add(usuario);
            }
            System.out.println("Se obtuvo correctamente la lista de usuarios");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de usuarios");
            System.out.println(e);
        }
        return listaUsuarios;
    }

}
