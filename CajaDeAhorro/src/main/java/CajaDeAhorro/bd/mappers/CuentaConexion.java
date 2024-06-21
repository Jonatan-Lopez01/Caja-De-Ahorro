package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @autor Gizelle RM
 */
public class CuentaConexion {
    // Métodos para realizar operaciones relacionadas con la entidad Cuenta

    public void crearCuenta(Cuenta cuenta) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO cuenta (tasa_interes, estatus_cuenta, saldo,tipo) VALUES (?, ?, ?,?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setFloat(1, cuenta.getTasaInteres());
            lineaParametros.setInt(2, cuenta.getEstatusCuenta());
            lineaParametros.setFloat(3, cuenta.getSaldo());
            lineaParametros.setString(4, cuenta.getTipo());
            

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Cuenta creada correctamente.");
            } else {
                System.out.println("No se pudo crear la cuenta.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public void actualizarCuenta(int numeroCuenta, Cuenta cuenta) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE cuenta SET tasa_interes = ?, estatus_cuenta = ?, saldo = ?, tipo =? WHERE numero_cuenta = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setFloat(1, cuenta.getTasaInteres());
            lineaParametros.setInt(2, cuenta.getEstatusCuenta());
            lineaParametros.setFloat(3, cuenta.getSaldo());
            lineaParametros.setString(4,cuenta.getTipo());
            lineaParametros.setInt(5, numeroCuenta);

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Cuenta actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la cuenta.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

   public Cuenta eliminarCuenta(int numeroCuenta) {
        Cuenta cuentaEliminada = obtenerCuentaPorNumero(numeroCuenta); // Obtener los datos antes de eliminar
        if (cuentaEliminada == null) {
            return null; // La cuenta no existe
        }
        
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "DELETE FROM cuenta WHERE numero_cuenta = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, numeroCuenta);

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Cuenta eliminada correctamente.");
            } else {
                System.out.println("No se pudo eliminar la cuenta.");
                cuentaEliminada = null; // Si no se pudo eliminar, no devolvemos la cuenta
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
            cuentaEliminada = null; // Si ocurre una excepción, no devolvemos la cuenta
        }
        return cuentaEliminada;
    }

    public Cuenta obtenerCuentaPorNumero(int numeroCuenta) {
        Cuenta cuenta = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM cuenta WHERE numero_cuenta = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, numeroCuenta);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) {
                cuenta = new Cuenta();
                cuenta.setNumeroCuenta(resultado.getInt("numero_cuenta"));
                cuenta.setTasaInteres(resultado.getFloat("tasa_interes"));
                cuenta.setEstatusCuenta(resultado.getInt("estatus_cuenta"));
                cuenta.setSaldo(resultado.getFloat("saldo"));
                cuenta.setTipo(resultado.getString("tipo"));
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return cuenta;
    }

    public List<Cuenta> obtenerTodasLasCuentas() {
        List<Cuenta> listaCuentas = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM cuenta";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();
            while (resultado.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setNumeroCuenta(resultado.getInt("numero_cuenta"));
                cuenta.setTasaInteres(resultado.getFloat("tasa_interes"));
                cuenta.setEstatusCuenta(resultado.getInt("estatus_cuenta"));
                cuenta.setSaldo(resultado.getFloat("saldo"));
                cuenta.setTipo(resultado.getString("tipo"));

                listaCuentas.add(cuenta);
                }
                enlace.Desconectar();
                } catch (SQLException e) {
                System.out.println("SQLException: " + e);
                }
                return listaCuentas;
                }
    
    public Cuenta obtenerUltimaCuenta() {
        Cuenta ultimaCuenta = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM cuenta ORDER BY numero_cuenta DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) { // Se mueve a la fila 0 y devuelve true si hay una fila, sino devuelve false
                ultimaCuenta = new Cuenta();
                ultimaCuenta.setNumeroCuenta(resultado.getInt("numero_cuenta"));
                ultimaCuenta.setTasaInteres(resultado.getFloat("tasa_interes"));
                ultimaCuenta.setEstatusCuenta(resultado.getInt("estatus_cuenta"));
                ultimaCuenta.setSaldo(resultado.getFloat("saldo"));
                ultimaCuenta.setTipo(resultado.getString("tipo"));

            }
            System.out.println("Se obtuvo correctamente la última cuenta");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener la última cuenta");
            System.out.println(e);
        }
        return ultimaCuenta;
    }
}
