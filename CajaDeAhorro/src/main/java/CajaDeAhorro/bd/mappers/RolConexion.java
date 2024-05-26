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
                System.out.println("Rol insertado Correctamente... ");
            } else {
                System.out.println("Rol no insertado...");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualizarRol(Rol rol) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE rol SET id_rol = ?, nombre = ?, descripcion = ? ";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, rol.getIdRol());
            lineaParametros.setString(2, rol.getNombre());
            lineaParametros.setString(3, rol.getDescripcion());

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
    public void eliminarRol(int id) {

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "DELETE FROM rol WHERE rol = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Rol eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el Rol.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
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

            }
            System.out.println("Se obtuvo correctamente el rol");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el rol");
            System.out.println(e);
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
            System.out.println("Se obtuvo correctamente la lista de roles");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de roles");
            System.out.println(e);
        }
        return listaUsuarios;
    }
    
    @Override
     public Rol obtenerUltimoRol(){
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
