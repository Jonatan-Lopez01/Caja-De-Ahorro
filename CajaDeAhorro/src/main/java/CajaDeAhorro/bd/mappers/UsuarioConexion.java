/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.events.EntityDeclaration;

/**
 *
 * @author Jonatan Eduardo
 */
public class UsuarioConexion implements UsuarioInterface {

    @Override
    public void crearUsuario(Usuario usuario) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO usuario (id_usuario, id_rol, nombre, correo, password) VALUES (?,?,?,?,?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, usuario.getIdUsuario());
            lineaParametros.setInt(2, usuario.getIdRol());
            lineaParametros.setString(3, usuario.getNombre());
            lineaParametros.setString(4, usuario.getCorreo());
            lineaParametros.setString(5, usuario.getContraseña());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Usuario insertado correctamente.");
            } else {
                System.out.println("Usuario no insertado,");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception" + e);
        }

    }

    @Override
    public void actualizarUsuario(int id, Usuario usuario) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE usuario SET id_rol = ?, nombre = ?, correo = ?, password = ? WHERE id_usuario = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, usuario.getIdRol());
            lineaParametros.setString(2, usuario.getNombre());
            lineaParametros.setString(3, usuario.getCorreo());
            lineaParametros.setString(4, usuario.getContraseña());
            lineaParametros.setInt(5, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el Usuario.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }

    }

    @Override
    public Usuario eliminarUsuario(int id) {
        Usuario usuarioEliminado = null;

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            // Primero, obtenemos los datos del usuario antes de eliminarlo
            usuarioEliminado = this.obtenerUsuarioPorId(id);

            // Si el usuario existe, procede a eliminarlo
            if (usuarioEliminado != null) {
                String sql = "DELETE FROM usuario WHERE id_usuario = ?";
                PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
                lineaParametros.setInt(1, id);

                int flag = lineaParametros.executeUpdate();
                if (flag > 0) {
                    System.out.println("Usuario eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el Rol.");
                    usuarioEliminado = null; // Si no se pudo eliminar, no devolvemos el usuario
                }
            } else {
                System.out.println("No se encontró el usuario con el ID proporcionado.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
        return usuarioEliminado;
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
                consultarUsuario.setIdRol(resultado.getInt("id_rol"));
                consultarUsuario.setNombre(resultado.getString("nombre"));
                consultarUsuario.setCorreo(resultado.getString("correo"));
                consultarUsuario.setContraseña(resultado.getString("password"));
                System.out.println("Se obtuvo correctamente el rol");
                enlace.Desconectar();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
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
                usuario.setIdRol(resultado.getInt("id_rol"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setCorreo(resultado.getString("correo"));
                usuario.setContraseña(resultado.getString("password"));

                listaUsuarios.add(usuario);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de roles");
            System.out.println(e);
        }
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUltimoUsuario() {
        Usuario consultarUsuario = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM usuario ORDER BY id_usuario DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) { //Se mueve a la fila 0 y devuelve true si hay una fila, pero sino devuelve false
                consultarUsuario = new Usuario();
                consultarUsuario.setIdUsuario(resultado.getInt("id_usuario"));
                consultarUsuario.setIdRol(resultado.getInt("id_rol"));
                consultarUsuario.setNombre(resultado.getString("nombre"));
                consultarUsuario.setCorreo(resultado.getString("correo"));
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
    public int login(String correo, String password) {
        int id = -1;

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT id_usuario FROM usuario WHERE correo = ? AND password = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setString(1, correo);
            lineaParametros.setString(2, password);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) { // El usuario existe y la contraseña es correcta
                id = resultado.getInt("id_usuario"); // Obtener el ID del usuario
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo iniciar sesion");
            System.out.println(e);
        }
        return id;
    }

}
