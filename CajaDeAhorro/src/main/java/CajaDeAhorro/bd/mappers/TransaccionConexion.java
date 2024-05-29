package CajaDeAhorro.bd.mappers;

import CajaDeAhorro.bd.domain.Transaccion;
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
public class TransaccionConexion {

    // Método para crear una nueva transacción
    public void crearTransaccion(Transaccion transaccion) {
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "INSERT INTO transaccion (id_operacion, monto, fecha) VALUES (?, ?, ?)";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, transaccion.getIdOperacion());
            lineaParametros.setDouble(2, transaccion.getMonto());
            lineaParametros.setString(3, transaccion.getFecha());

            int flag = lineaParametros.executeUpdate();
            if (flag > 0) {
                System.out.println("Transacción creada correctamente.");
            } else {
                System.out.println("No se pudo crear la transacción.");
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    // Método para actualizar una transacción
 public void actualizarTransaccion(int idTransaccion, Transaccion transaccion) {
    try {
        ConexionBd enlace = new ConexionBd();
        Connection enlaceActivo = enlace.Conectar();
        String sql = "UPDATE transaccion SET monto = ?, fecha = ? WHERE id_transaccion = ?";
        PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

        lineaParametros.setDouble(1, transaccion.getMonto());
        lineaParametros.setString(2, transaccion.getFecha());
        lineaParametros.setInt(3, idTransaccion);

        int flag = lineaParametros.executeUpdate();
        if (flag > 0) {
            System.out.println("Transacción actualizada correctamente.");
        } else {
            System.out.println("No se pudo actualizar la transacción.");
        }
        enlace.Desconectar();
    } catch (SQLException e) {
        System.out.println("SQLException: " + e);
    }
}


    // Método para eliminar una transacción por su id
public Transaccion eliminarTransaccion(int idTransaccion) {
    Transaccion transaccionEliminada = obtenerTransaccionPorId(idTransaccion); // Obtener los datos antes de eliminar
    if (transaccionEliminada == null) {
        return null; // La transacción no existe
    }
    
    try {
        ConexionBd enlace = new ConexionBd();
        Connection enlaceActivo = enlace.Conectar();
        String sql = "DELETE FROM transaccion WHERE id_transaccion = ?";
        PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

        lineaParametros.setInt(1, idTransaccion);

        int flag = lineaParametros.executeUpdate();
        if (flag > 0) {
            System.out.println("Transacción eliminada correctamente.");
        } else {
            System.out.println("No se pudo eliminar la transacción.");
            transaccionEliminada = null; // Si no se pudo eliminar, no devolvemos la transacción
        }
        enlace.Desconectar();
    } catch (SQLException e) {
        System.out.println("SQLException: " + e);
        transaccionEliminada = null; // Si ocurre una excepción, no devolvemos la transacción
    }
    return transaccionEliminada;
}



    // Método para obtener una transacción por su id
    public Transaccion obtenerTransaccionPorId(int idTransaccion) {
        Transaccion transaccion = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM transaccion WHERE id_transaccion = ?";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            lineaParametros.setInt(1, idTransaccion);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) {
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultado.getInt("id_transaccion"));
                transaccion.setIdOperacion(resultado.getInt("id_operacion"));
                transaccion.setMonto(resultado.getDouble("monto"));
                transaccion.setFecha(resultado.getString("fecha"));
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return transaccion;
    }

    // Método para obtener todas las transacciones
    public List<Transaccion> obtenerTodasLasTransacciones() {
        List<Transaccion> listaTransacciones = new ArrayList<>();
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM transaccion";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();
            while (resultado.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultado.getInt("id_transaccion"));
                transaccion.setIdOperacion(resultado.getInt("id_operacion"));
                transaccion.setMonto(resultado.getDouble("monto"));
                transaccion.setFecha(resultado.getString("fecha"));
                listaTransacciones.add(transaccion);
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return listaTransacciones;
    }
    // Método para obtener la última transacción
    public Transaccion obtenerUltimaTransaccion() {
        Transaccion transaccion = null;
        try {
            ConexionBd enlace = new ConexionBd();
            Connection enlaceActivo = enlace.Conectar();
            String sql = "SELECT * FROM transaccion ORDER BY id_transaccion DESC LIMIT 1";
            PreparedStatement lineaParametros = enlaceActivo.prepareStatement(sql);

            ResultSet resultado = lineaParametros.executeQuery();
            if (resultado.next()) {
                transaccion = new Transaccion();
                transaccion.setIdTransaccion(resultado.getInt("id_transaccion"));
                transaccion.setIdOperacion(resultado.getInt("id_operacion"));
                transaccion.setMonto(resultado.getDouble("monto"));
                transaccion.setFecha(resultado.getString("fecha"));
            }
            enlace.Desconectar();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
        return transaccion;
    }
}