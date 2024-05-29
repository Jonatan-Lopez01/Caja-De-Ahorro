package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Operacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz OperacionInterface para realizar operaciones CRUD en la tabla de operaciones de la base de datos.
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
}
