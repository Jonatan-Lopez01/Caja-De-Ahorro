/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.intereses;
import CajaDeAhorro.bd.domain.Intereses;
import CajaDeAhorro.bd.mappers.InteresesConexion;
import java.util.List;

/**
 *
 * @author Arce
 */

public class InteresesDaoImpl implements InteresesDao {

    @Override
    public void crearInteres(Intereses interes) {
        InteresesConexion conexion = new InteresesConexion();
        conexion.crearInteres(interes);
    }

    @Override
    public void actualizarInteres(int id, Intereses interes) {
        InteresesConexion conexion = new InteresesConexion();
        conexion.actualizarInteres(id, interes);
    }

    @Override
    public Intereses eliminarInteres(int id) {
        Intereses interesEliminado;
        InteresesConexion conexion = new InteresesConexion();
        interesEliminado = conexion.eliminarInteres(id);
        return interesEliminado;
    }

    @Override
    public Intereses obtenerInteresPorId(int id) {
        Intereses interesById;
        InteresesConexion conexion = new InteresesConexion();
        interesById = conexion.obtenerInteresPorId(id);
        return interesById;
    }

    @Override
    public List<Intereses> obtenerTodosLosIntereses() {
        List<Intereses> listaDeIntereses;
        InteresesConexion conexion = new InteresesConexion();
        listaDeIntereses = conexion.obtenerTodosLosIntereses();
        return listaDeIntereses;
    }

    @Override
    public Intereses obtenerUltimoInteres() {
        Intereses ultimoInteres;
        InteresesConexion conexion = new InteresesConexion();
        ultimoInteres = conexion.obtenerUltimoInteres();
        return ultimoInteres;
    }

    @Override
    public double calcularIntereses(double saldo, double intereses) {
        InteresesConexion conexion = new InteresesConexion();
        return conexion.calcularIntereses(saldo, intereses);
    }

    @Override
    public double tasaIntereses(double cantidadIntereses, double saldoInicial) {
       InteresesConexion conexion = new InteresesConexion();
       return conexion.tasaIntereses(cantidadIntereses, saldoInicial);
    }
}
