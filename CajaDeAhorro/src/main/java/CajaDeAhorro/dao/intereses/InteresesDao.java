/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.dao.intereses;

import CajaDeAhorro.bd.domain.Intereses;
import java.util.List;

/**
 *
 * @author Arce
 */


public interface InteresesDao {
    void crearInteres(Intereses interes);
    void actualizarInteres(int id, Intereses interes);
    Intereses eliminarInteres(int id);
    Intereses obtenerInteresPorId(int id);
    List<Intereses> obtenerTodosLosIntereses();
    Intereses obtenerUltimoInteres();
}