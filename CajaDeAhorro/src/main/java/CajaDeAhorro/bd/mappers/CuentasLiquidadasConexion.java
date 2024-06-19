/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.CuentasLiquidadas;
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
public class CuentasLiquidadasConexion {

    public void crearCuentaLiquidada(CuentasLiquidadas cuentaLiquidada) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO cuentas_liquidadas (numero_cuenta, tipo_liquidez, folio_pago_liquidez) VALUES (?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, cuentaLiquidada.getNumero_cuenta());
            lineaParametros.setString(2, cuentaLiquidada.getTipo_liquidez());
            lineaParametros.setString(3, cuentaLiquidada.getFolio_pago_liquidez());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Cuenta liquidada creada correctamente.");
            } else {
                System.out.println("No se pudo crear la cuenta liquidada.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    // Método para actualizar una cuenta liquidada
    public void actualizarCuentaLiquidada(int idCuentaLiquidada, CuentasLiquidadas cuentaLiquidada) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE cuentas_liquidadas SET numero_cuenta = ?, tipo_liquidez = ?, folio_pago_liquidez = ? WHERE id_cuenta_liquidada = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, cuentaLiquidada.getNumero_cuenta());
            lineaParametros.setString(2, cuentaLiquidada.getTipo_liquidez());
            lineaParametros.setString(3, cuentaLiquidada.getFolio_pago_liquidez());
            lineaParametros.setInt(4, idCuentaLiquidada);

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Cuenta liquidada actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la cuenta liquidada.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    // Método para eliminar una cuenta liquidada
    public CuentasLiquidadas eliminarCuentaLiquidada(int idCuentaLiquidada) {
        CuentasLiquidadas cuentaLiquidadaEliminada = obtenerCuentaLiquidadaPorId(idCuentaLiquidada); // Obtener los datos antes de eliminar
        if (cuentaLiquidadaEliminada == null) {
            return null; // La cuenta no existe
        }

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "DELETE FROM cuentas_liquidadas WHERE id_cuenta_liquidada = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, idCuentaLiquidada);

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Cuenta liquidada eliminada correctamente.");
            } else {
                System.out.println("No se pudo eliminar la cuenta liquidada.");
                cuentaLiquidadaEliminada = null; // Si no se pudo eliminar, no devolvemos la cuenta
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
            cuentaLiquidadaEliminada = null; // Si ocurre una excepción, no devolvemos la cuenta
        }
        return cuentaLiquidadaEliminada;
    }

    // Método para obtener una cuenta liquidada por ID
    public CuentasLiquidadas obtenerCuentaLiquidadaPorId(int idCuentaLiquidada) {
        CuentasLiquidadas cuentaLiquidada = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM cuentas_liquidadas WHERE id_cuenta_liquidada = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, idCuentaLiquidada);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) {
                cuentaLiquidada = new CuentasLiquidadas();
                cuentaLiquidada.setId_cuenta_liquidada(resultado.getInt("id_cuenta_liquidada"));
                cuentaLiquidada.setNumero_cuenta(resultado.getInt("numero_cuenta"));
                cuentaLiquidada.setTipo_liquidez(resultado.getString("tipo_liquidez"));
                cuentaLiquidada.setFolio_pago_liquidez(resultado.getString("folio_pago_liquidez"));
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return cuentaLiquidada;
    }
    // Método para obtener todas las cuentas liquidadas

    public List<CuentasLiquidadas> obtenerTodasLasCuentasLiquidadas() {
        List<CuentasLiquidadas> listaCuentasLiquidadas = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM cuentas_liquidadas";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();
            while (resultado.next()) {
                CuentasLiquidadas cuentaLiquidada = new CuentasLiquidadas();
                cuentaLiquidada.setId_cuenta_liquidada(resultado.getInt("id_cuenta_liquidada"));
                cuentaLiquidada.setNumero_cuenta(resultado.getInt("numero_cuenta"));
                cuentaLiquidada.setTipo_liquidez(resultado.getString("tipo_liquidez"));
                cuentaLiquidada.setFolio_pago_liquidez(resultado.getString("folio_pago_liquidez"));
                listaCuentasLiquidadas.add(cuentaLiquidada);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return listaCuentasLiquidadas;
    }
// Método para obtener la última cuenta liquidada

    public CuentasLiquidadas obtenerUltimaCuentaLiquidada() {
        CuentasLiquidadas ultimaCuentaLiquidada = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM cuentas_liquidadas ORDER BY id_cuenta_liquidada DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) {
                ultimaCuentaLiquidada = new CuentasLiquidadas();
                ultimaCuentaLiquidada.setId_cuenta_liquidada(resultado.getInt("id_cuenta_liquidada"));
                ultimaCuentaLiquidada.setNumero_cuenta(resultado.getInt("numero_cuenta"));
                ultimaCuentaLiquidada.setTipo_liquidez(resultado.getString("tipo_liquidez"));
                ultimaCuentaLiquidada.setFolio_pago_liquidez(resultado.getString("folio_pago_liquidez"));
            }
            System.out.println("Se obtuvo correctamente la última cuenta liquidada");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener la última cuenta liquidada");
            System.out.println(e);
        }
        return ultimaCuentaLiquidada;
    }
}
