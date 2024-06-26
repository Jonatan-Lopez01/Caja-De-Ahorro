/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Intereses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Arce
 */
public class InteresesConexion implements InteresesInterface {

    @Override
    public void crearInteres(Intereses interes) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO intereses (tasa_interes, fecha_inicio, fecha_fin) VALUES (?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            lineaParametros.setDouble(1, interes.getTasaInteres());
            lineaParametros.setDate(2, new java.sql.Date(interes.getFechaInicio().getTime()));
            lineaParametros.setDate(3, new java.sql.Date(interes.getFechaFin().getTime()));

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Interés insertado correctamente.");

                // Obtener el ID generado automáticamente
                try (ResultSet generatedKeys = lineaParametros.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        interes.setIdInteres(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Error al obtener el ID del interés insertado.");
                    }
                }
            } else {
                System.out.println("Interés no insertado.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    @Override
    public void actualizarInteres(int id, Intereses interes) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE intereses SET tasa_interes = ?, fecha_inicio = ?, fecha_fin = ? WHERE id_interes = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setDouble(1, interes.getTasaInteres());
            lineaParametros.setDate(2, new java.sql.Date(interes.getFechaInicio().getTime()));
            lineaParametros.setDate(3, new java.sql.Date(interes.getFechaFin().getTime()));
            lineaParametros.setInt(4, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Interes actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el Interes.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Intereses eliminarInteres(int id) {
        Intereses interesEliminado = null;

        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            // Primero, obtenemos los datos del interes antes de eliminarlo
            interesEliminado = this.obtenerInteresPorId(id);

            // Si el interes existe, procede a eliminarlo
            if (interesEliminado != null) {
                String deleteSql = "DELETE FROM intereses WHERE id_interes = ?";
                PreparedStatement lineaParametros = enlaceActivo.prepareStatement(deleteSql);
                lineaParametros.setInt(1, id);
                int flag = lineaParametros.executeUpdate();

                if (flag > 0) {
                    System.out.println("Interes eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el Interes.");
                    interesEliminado = null; // Si no se pudo eliminar, no devolvemos el interes
                }
            } else {
                System.out.println("No se encontró el Interes con el ID proporcionado.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
            interesEliminado = null; // Si ocurre una excepción, no devolvemos el interes
        }

        return interesEliminado;
    }

    @Override
    public Intereses obtenerInteresPorId(int id) {
        Intereses consultarInteres = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM intereses WHERE id_interes = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarInteres = new Intereses();
                consultarInteres.setIdInteres(resultado.getInt("id_interes"));
                consultarInteres.setTasaInteres(resultado.getDouble("tasa_interes"));
                consultarInteres.setFechaInicio(resultado.getDate("fecha_inicio"));
                consultarInteres.setFechaFin(resultado.getDate("fecha_fin"));
                System.out.println("Se obtuvo correctamente el interes");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
        return consultarInteres;
    }

    @Override
    public List<Intereses> obtenerTodosLosIntereses() {
        List<Intereses> listaIntereses = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM intereses";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                Intereses interes = new Intereses();
                interes.setIdInteres(resultado.getInt("id_interes"));
                interes.setTasaInteres(resultado.getDouble("tasa_interes"));
                interes.setFechaInicio(resultado.getDate("fecha_inicio"));
                interes.setFechaFin(resultado.getDate("fecha_fin"));
                listaIntereses.add(interes);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de intereses");
            System.out.println(e);
        }
        return listaIntereses;
    }

    @Override
    public Intereses obtenerUltimoInteres() {
        Intereses consultarInteres = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM intereses ORDER BY id_interes DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarInteres = new Intereses();
                consultarInteres.setIdInteres(resultado.getInt("id_interes"));
                consultarInteres.setTasaInteres(resultado.getDouble("tasa_interes"));
                consultarInteres.setFechaInicio(resultado.getDate("fecha_inicio"));
                consultarInteres.setFechaFin(resultado.getDate("fecha_fin"));
            }
            System.out.println("Se obtuvo correctamente el interes");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el interes");
            System.out.println(e);
        }
        return consultarInteres;
    }

    @Override
    public double calcularIntereses(double saldo, double intereses) {
        return saldo * (intereses / 100);
    }

    @Override
    public double tasaIntereses(double cantidadIntereses, double saldoInicial) {
        if (saldoInicial == 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser cero");
        }
        return (cantidadIntereses / saldoInicial) * 100;
    }
}
