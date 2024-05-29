/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Socio;
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
public class SocioConexion implements SocioInterface{
    //Metodos implementados con las consultas a la base de datos.
    @Override
    public void crearSocio(Socio socio) {

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO socio (nombre, apellidos, direccion, telefono,correo) VALUES (?, ?, ?, ?,?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setString(1, socio.getNombre());
            lineaParametros.setString(2, socio.getApellidos());
            lineaParametros.setString(3, socio.getDireccion());
            lineaParametros.setString(4, socio.getTelefono());
            lineaParametros.setString(5, socio.getCorreo());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Socio insertado Correctamente... ");
            } else {
                System.out.println("Socio no insertado...");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void actualizarSocio(Socio socio) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE socio SET nombre = ?, apellidos = ?, direccion= ?, telefono = ?, correo = ? WHERE id_socio = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setString(1, socio.getNombre());
            lineaParametros.setString(2, socio.getApellidos());
            lineaParametros.setString(3, socio.getDireccion());
            lineaParametros.setString(4, socio.getTelefono());
            lineaParametros.setString(5, socio.getCorreo());
            lineaParametros.setInt(6, socio.getId_socio());

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Socio actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el socio.");
        }
        enlace.Desconectar();
    } catch (SQLException e) {
        System.out.println(e);
    }
}


    @Override
    public void eliminarSocio(int id) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "DELETE FROM socio WHERE id_socio = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Socio eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el socio.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Socio obtenerSocioPorId(int id) {
        Socio consultarSocio = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM socio WHERE id_socio = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery(); //Resultado apunta al inicio de el conjunto de tuplas, tipo como en la posicion -1

            if (resultado.next()) { //Se mueve a la fila 0 y devuelve true si hay una fila, pero sino devuelve false
                consultarSocio = new Socio();
                consultarSocio.setId_socio(resultado.getInt("id_socio"));
                consultarSocio.setNombre(resultado.getString("nombre"));
                consultarSocio.setApellidos(resultado.getString("apellidos"));
                consultarSocio.setDireccion(resultado.getString("direccion"));
                consultarSocio.setTelefono(resultado.getString("telefono"));
                consultarSocio.setCorreo(resultado.getString("correo"));
            }
            System.out.println("Se obtuvo correctamente el socio");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el socio");
            System.out.println(e);
        }
        return consultarSocio;
    }

    @Override
    public List<Socio> obtenerTodosLosSocios() {
        List<Socio> listaSocios = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM socio";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                Socio socio = new Socio();
                socio.setId_socio(resultado.getInt("id_socio"));
                socio.setNombre(resultado.getString("nombre"));
                socio.setApellidos(resultado.getString("apellidos"));
                socio.setDireccion(resultado.getString("direccion"));
                socio.setTelefono(resultado.getString("telefono"));
                socio.setCorreo(resultado.getString("correo"));
                listaSocios.add(socio);
            }
            System.out.println("Se obtuvo correctamente la lista de socios");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de socios");
            System.out.println(e);
        }
        return listaSocios;
    }
    
}