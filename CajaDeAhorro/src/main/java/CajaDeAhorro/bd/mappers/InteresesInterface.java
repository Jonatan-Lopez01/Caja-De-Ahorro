/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.bd.mappers;
import java.util.List;
import CajaDeAhorro.bd.domain.Intereses;

/**
 *
 * @author Arce
 */


public interface InteresesInterface {
    void crearInteres(Intereses interes);
    void actualizarInteres(int id, Intereses interes);
    Intereses eliminarInteres(int id);
    Intereses obtenerInteresPorId(int id);
    List<Intereses> obtenerTodosLosIntereses();
    Intereses obtenerUltimoInteres();
    double calcularIntereses(double saldo, double intereses);
    double tasaIntereses(double cantidadIntereses, double saldoInicial); 
}

