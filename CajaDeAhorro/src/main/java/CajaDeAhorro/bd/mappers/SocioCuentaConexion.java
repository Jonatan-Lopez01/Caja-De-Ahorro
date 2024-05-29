/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.SocioCuenta;
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
public class SocioCuentaConexion implements SocioCuentaInterface{
     //Metodos implementados con las consultas a la base de datos.
    @Override
    public void crearSocioCuenta(SocioCuenta socioCuenta) {

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO socio_Cuenta (id_socio,id_cuenta) VALUES (?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, socioCuenta.getId_socio());
            lineaParametros.setInt(2, socioCuenta.getId_cuenta());
        
            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("SocioCuenta insertado Correctamente... ");
            } else {
                System.out.println("SocioCuenta no insertado...");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
public void actualizarSocioCuenta(SocioCuenta socioCuenta) {
    try {
        ConexionBd enlace = new ConexionBd();
        Connection enlaceActivo = enlace.Conectar();
        String sql = "UPDATE socio_Cuenta SET id_socio = ?, id_cuenta = ? WHERE id_socio_cuenta = ?";
        PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
        lineaParametros.setInt(1, socioCuenta.getId_socio());
        lineaParametros.setInt(2, socioCuenta.getId_cuenta());
        lineaParametros.setInt(3, socioCuenta.getId_socio_cuenta());
        


        int flag = lineaParametros.executeUpdate();

        if (flag > 0) {
            System.out.println("SocioCuenta actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el socioCuenta.");
        }
        enlace.Desconectar();
    } catch (SQLException e) {
        System.out.println(e);
    }
}


    @Override
    public void eliminarSocioCuenta(int id) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "DELETE FROM socio_Cuenta WHERE id_socioCuenta = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("SocioCuenta eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el socioCuenta.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public SocioCuenta obtenerSocioCuentaPorId(int id) {
        SocioCuenta consultarSocioCuenta = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM socio_Cuenta WHERE id_socioCuenta = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery(); //Resultado apunta al inicio de el conjunto de tuplas, tipo como en la posicion -1

            if (resultado.next()) { //Se mueve a la fila 0 y devuelve true si hay una fila, pero sino devuelve false
                consultarSocioCuenta = new SocioCuenta();
                consultarSocioCuenta.setId_socio_cuenta(resultado.getInt("id_socio_cuenta"));
                consultarSocioCuenta.setId_socio(resultado.getInt("id_socio"));
                consultarSocioCuenta.setId_cuenta(resultado.getInt("id_cuenta"));
            }
            System.out.println("Se obtuvo correctamente el socioCuenta");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el socioCuenta");
            System.out.println(e);
        }
        return consultarSocioCuenta;
    }

    @Override
    public List<SocioCuenta> obtenerTodosLosSocioCuentas() {
        List<SocioCuenta> listaSocioCuentas = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM socio_Cuenta";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                SocioCuenta socioCuenta = new SocioCuenta();
                socioCuenta.setId_socio_cuenta(resultado.getInt("id_socio_cuenta"));
                socioCuenta.setId_socio(resultado.getInt("id_socio"));
                socioCuenta.setId_cuenta(resultado.getInt("id_cuenta"));
                listaSocioCuentas.add(socioCuenta);
            }
            System.out.println("Se obtuvo correctamente la lista de socioCuentas");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de socioCuentas");
            System.out.println(e);
        }
        return listaSocioCuentas;
    }
    
}
