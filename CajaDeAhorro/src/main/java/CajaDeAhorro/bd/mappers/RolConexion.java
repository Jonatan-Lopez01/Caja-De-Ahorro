/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class RolConexion implements RolInterface {
    

    @Override
    public void crearRol(Rol rol) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO rol (nombre, descripcion) VALUES (?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setString(1, rol.getNombre());
            lineaParametros.setString(2, rol.getDescripcion());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Rol insertado correctamente.");
            } else {
                System.out.println("Rol no insertado,");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
    }

    @Override
    public void actualizarRol(int id, Rol rol) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE rol SET nombre = ?, descripcion = ? WHERE id_rol = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setString(1, rol.getNombre());
            lineaParametros.setString(2, rol.getDescripcion());
            lineaParametros.setInt(3, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Rol actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el Rol.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Rol eliminarRol(int id) {
        Rol rolEliminado = null;

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            // Primero, obtenemos los datos del rol antes de eliminarlo
            rolEliminado = this.obtenerRolPorId(id);

            // Si el rol existe, procede a eliminarlo
            if (rolEliminado != null) {
                String deleteSql = "DELETE FROM rol WHERE id_rol = ?";
                PreparedStatement lineaParametros = enlaceActivo.prepareStatement(deleteSql);
                lineaParametros.setInt(1, id);
                int flag = lineaParametros.executeUpdate();

                if (flag > 0) {
                    System.out.println("Rol eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el Rol.");
                    rolEliminado = null; // Si no se pudo eliminar, no devolvemos el rol
                }
            } else {
                System.out.println("No se encontró el Rol con el ID proporcionado.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            
            System.out.println("SQL Exception:: " + e);
            rolEliminado = null; // Si ocurre una excepción, no devolvemos el rol
        }

      return rolEliminado;
    }

    @Override
    public Rol obtenerRolPorId(int id) {
        Rol consultarRol = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM rol WHERE id_rol = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery(); //Resultado apunta al inicio de el conjunto de tuplas, tipo como en la posicion -1
          

            if (resultado.next()) { //Se mueve a la fila 0 y devuelve true si hay una fila, pero sino devuelve false
                consultarRol = new Rol();
                consultarRol.setIdRol(resultado.getInt("id_rol"));
                consultarRol.setNombre(resultado.getString("nombre"));
                consultarRol.setDescripcion(resultado.getString("descripcion"));
                System.out.println("Se obtuvo correctamente el rol");
                enlace.Desconectar();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
        return consultarRol;
    }

    @Override
    public List<Rol> obtenerTodosLosRoles() {

        List<Rol> listaUsuarios = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM rol";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                Rol rol = new Rol();
                rol.setIdRol(resultado.getInt("id_rol"));
                rol.setNombre(resultado.getString("nombre"));
                rol.setDescripcion(resultado.getString("descripcion"));
                listaUsuarios.add(rol);
                
            } 
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de roles");
            System.out.println(e);
        }
        return listaUsuarios;
    }

    @Override
    public Rol obtenerUltimoRol() {
        Rol consultarRol = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM rol ORDER BY id_rol DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) { //Se mueve a la fila 0 y devuelve true si hay una fila, pero sino devuelve false
                consultarRol = new Rol();
                consultarRol.setIdRol(resultado.getInt("id_rol"));
                consultarRol.setNombre(resultado.getString("nombre"));
                consultarRol.setDescripcion(resultado.getString("descripcion"));
            }
            System.out.println("Se obtuvo correctamente el rol");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el rol");
            System.out.println(e);
        }
        return consultarRol;

    }
}
