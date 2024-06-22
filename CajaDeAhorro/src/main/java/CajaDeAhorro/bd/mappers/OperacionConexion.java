package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Operacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz OperacionInterface para realizar operaciones
 * CRUD en la tabla de operaciones de la base de datos.
 *
 * @author Ramses
 */
public class OperacionConexion implements OperacionInterface {

    @Override
    public void crearOperacion(Operacion operacion) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO operacion (numero_cuenta, nombre) VALUES (?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, operacion.getNumeroCuenta());
            lineaParametros.setString(2, operacion.getNombre());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Operación insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la operación.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
    }

    @Override
    public void actualizarOperacion(int id, Operacion operacion) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "UPDATE operacion SET numero_cuenta = ?, nombre = ? WHERE id_operacion = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, operacion.getNumeroCuenta());
            lineaParametros.setString(2, operacion.getNombre());
            lineaParametros.setInt(3, id);

            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Operación actualizada correctamente.");
            } else {
                System.out.println("No se pudo actualizar la Operación.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminarOperacion(int id) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();

            String deleteSql = "DELETE FROM operacion WHERE id_operacion = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(deleteSql);
            lineaParametros.setInt(1, id);
            int flag = lineaParametros.executeUpdate();

            if (flag > 0) {
                System.out.println("Operación eliminada correctamente.");
            } else {
                System.out.println("No se pudo eliminar la Operación.");
            }

            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
    }

    @Override
    public Operacion obtenerOperacionPorId(int id) {
        Operacion consultarOperacion = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM operacion WHERE id_operacion = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);
            lineaParametros.setInt(1, id);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarOperacion = new Operacion();
                consultarOperacion.setIdOperacion(resultado.getInt("id_operacion"));
                consultarOperacion.setNumeroCuenta(resultado.getInt("numero_cuenta"));
                consultarOperacion.setNombre(resultado.getString("nombre"));
            }
            System.out.println("Se obtuvo correctamente la Operación");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQL Exception:: " + e);
        }
        return consultarOperacion;
    }

    @Override
    public List<Operacion> obtenerTodasLasOperaciones() {

        List<Operacion> listaOperaciones = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM operacion";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            while (resultado.next()) {
                Operacion operacion = new Operacion();
                operacion.setIdOperacion(resultado.getInt("id_operacion"));
                operacion.setNumeroCuenta(resultado.getInt("numero_cuenta"));
                operacion.setNombre(resultado.getString("nombre"));
                listaOperaciones.add(operacion);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se obtuvo la lista de Operaciones");
            System.out.println(e);
        }
        return listaOperaciones;
    }

    @Override
    public Operacion obtenerUltimaOperacion() {
        Operacion consultarOperacion = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM operacion ORDER BY id_operacion DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();

            if (resultado.next()) {
                consultarOperacion = new Operacion();
                consultarOperacion.setIdOperacion(resultado.getInt("id_operacion"));
                consultarOperacion.setNumeroCuenta(resultado.getInt("numero_cuenta"));
                consultarOperacion.setNombre(resultado.getString("nombre"));
            }
            System.out.println("Se obtuvo correctamente la Operación");
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener la Operación");
            System.out.println(e);
        }
        return consultarOperacion;
    }

    @Override
    public void realizarDeposito(int numeroCuenta, double cantidad) {
        try {
            CuentaConexion cuentaConexion = new CuentaConexion();
            double saldoAntes = cuentaConexion.obtenerSaldo(numeroCuenta);

            if (saldoAntes == 0.0) {
                System.out.println("No se encontró la cuenta con número de cuenta: " + numeroCuenta);
                return;
            }

            // Continuar con el depósito
            ConexionBd enlace = new ConexionBd();
            Connection conexion = enlace.Conectar();

            double nuevoSaldo = saldoAntes + cantidad;

            String sqlActualizarSaldo = "UPDATE cuenta SET saldo = ? WHERE numero_cuenta = ?";
            PreparedStatement psActualizarSaldo = conexion.prepareStatement(sqlActualizarSaldo);
            psActualizarSaldo.setDouble(1, nuevoSaldo);
            psActualizarSaldo.setInt(2, numeroCuenta);
            psActualizarSaldo.executeUpdate();

            // Registrar la operación de depósito
            String sqlInsertarOperacion = "INSERT INTO operacion (numero_cuenta, nombre) VALUES (?, ?)";
            PreparedStatement psInsertarOperacion = conexion.prepareStatement(sqlInsertarOperacion);
            psInsertarOperacion.setInt(1, numeroCuenta);
            psInsertarOperacion.setString(2, "Deposito");
            psInsertarOperacion.executeUpdate();

            System.out.println("Depósito realizado correctamente.");

            // Desconectar la conexión
            enlace.Desconectar();

            // Obtener el saldo después del depósito
            double saldoDespues = cuentaConexion.obtenerSaldo(numeroCuenta);
            System.out.println("Saldo antes del depósito: " + saldoAntes);
            System.out.println("Saldo después del depósito: " + saldoDespues);

        } catch (SQLException e) {
            System.out.println("Error al realizar el depósito: " + e);
        }
    }

    @Override
    public boolean realizarRetiro(int numeroCuenta, double cantidad) {
        try {
            CuentaConexion cuentaConexion = new CuentaConexion();
            double saldoAntes = cuentaConexion.obtenerSaldo(numeroCuenta);

            if (saldoAntes == 0.0) {
                System.out.println("No se encontró la cuenta con número de cuenta: " + numeroCuenta);
                return false;
            }

            if (saldoAntes < cantidad) {
                System.out.println("Saldo insuficiente para realizar el retiro.");
                return false;
            }

            // Continuar con el retiro
            ConexionBd enlace = new ConexionBd();
            Connection conexion = enlace.Conectar();

            double nuevoSaldo = saldoAntes - cantidad;

            String sqlActualizarSaldo = "UPDATE cuenta SET saldo = ? WHERE numero_cuenta = ?";
            PreparedStatement psActualizarSaldo = conexion.prepareStatement(sqlActualizarSaldo);
            psActualizarSaldo.setDouble(1, nuevoSaldo);
            psActualizarSaldo.setInt(2, numeroCuenta);
            psActualizarSaldo.executeUpdate();

            // Registrar la operación de retiro
            String sqlInsertarOperacion = "INSERT INTO operacion (numero_cuenta, nombre) VALUES (?, ?)";
            PreparedStatement psInsertarOperacion = conexion.prepareStatement(sqlInsertarOperacion);
            psInsertarOperacion.setInt(1, numeroCuenta);
            psInsertarOperacion.setString(2, "Retiro");
            psInsertarOperacion.executeUpdate();

            System.out.println("Retiro realizado correctamente.");

            // Desconectar la conexión
            enlace.Desconectar();

            // Obtener el saldo después del retiro
            double saldoDespues = cuentaConexion.obtenerSaldo(numeroCuenta);
            System.out.println("Saldo antes del retiro: " + saldoAntes);
            System.out.println("Saldo después del retiro: " + saldoDespues);

            return true; // Retiro exitoso
        } catch (SQLException e) {
            System.out.println("Error al realizar el retiro: " + e);
            return false; // Error al realizar el retiro
        }
    }
}
