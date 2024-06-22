/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CajaDeAhorro.dao.cuentas_Liquidadas;

import CajaDeAhorro.bd.domain.CuentasLiquidadas;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public interface CuentasLiquidadasDao {
    
    // Método para crear una cuenta liquidada
    void crearCuentaLiquidada(CuentasLiquidadas cuentaLiquidada);

    // Método para actualizar una cuenta liquidada
    void actualizarCuentaLiquidada(int idCuentaLiquidada, CuentasLiquidadas cuentaLiquidada);

    // Método para eliminar una cuenta liquidada
    CuentasLiquidadas eliminarCuentaLiquidada(int idCuentaLiquidada);

    // Método para obtener una cuenta liquidada por ID
    CuentasLiquidadas obtenerCuentaLiquidadaPorId(int idCuentaLiquidada);

    // Método para obtener todas las cuentas liquidadas
    List<CuentasLiquidadas> obtenerTodasLasCuentasLiquidadas();

    // Método para obtener la última cuenta liquidada
    CuentasLiquidadas obtenerUltimaCuentaLiquidada();
    
    List<CuentasLiquidadas> obteneCuentasLiquidadasByIdSocio(int idSocio);
    
}
