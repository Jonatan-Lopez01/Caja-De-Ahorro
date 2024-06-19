/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.cuentas_Liquidadas;

import CajaDeAhorro.bd.domain.CuentasLiquidadas;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonatan Eduardo
 */
public class CuentasLiquidadasDaoImplTest {
    
    public CuentasLiquidadasDaoImplTest() {
    }

    @Test
    public void testCrearCuentaLiquidada() {
        System.out.println("crearCuentaLiquidada");
        CuentasLiquidadas cuentaLiquidada = new CuentasLiquidadas();
        CuentasLiquidadasDaoImpl instance = new CuentasLiquidadasDaoImpl();
        cuentaLiquidada.setFolio_pago_liquidez("fdsfdsfsd45434534");
        cuentaLiquidada.setTipo_liquidez("DFDFDFDSFDSFD");
        cuentaLiquidada.setNumero_cuenta(5645656);
        instance.crearCuentaLiquidada(cuentaLiquidada);
    }

    @Test
    public void testActualizarCuentaLiquidada() {
        System.out.println("testActualizarCuentaLiquidada");
        int idCuentaLiquidada = 1; // ID de la cuenta liquidadas que quieres actualizar
        CuentasLiquidadas cuentaLiquidada = new CuentasLiquidadas();
        cuentaLiquidada.setId_cuenta_liquidada(idCuentaLiquidada);
        cuentaLiquidada.setFolio_pago_liquidez("NuevoFolio123");
        cuentaLiquidada.setTipo_liquidez("NuevoTipo");

        CuentasLiquidadasDaoImpl instance = new CuentasLiquidadasDaoImpl();
        instance.actualizarCuentaLiquidada(idCuentaLiquidada, cuentaLiquidada);
    }

    @Test
    public void testEliminarCuentaLiquidada() {
        System.out.println("eliminarCuentaLiquidada");
        int idCuentaLiquidada = 4;
        CuentasLiquidadasDaoImpl instance = new CuentasLiquidadasDaoImpl();
        CuentasLiquidadas expResult = null;
        CuentasLiquidadas result = instance.eliminarCuentaLiquidada(idCuentaLiquidada);
    }

    @Test
    public void testObtenerCuentaLiquidadaPorId() {
        System.out.println("obtenerCuentaLiquidadaPorId");
        int idCuentaLiquidada = 1;
        CuentasLiquidadasDaoImpl instance = new CuentasLiquidadasDaoImpl();
        CuentasLiquidadas expResult = new CuentasLiquidadas();
        CuentasLiquidadas result = instance.obtenerCuentaLiquidadaPorId(idCuentaLiquidada);
    }

    @Test
    public void testObtenerTodasLasCuentasLiquidadas() {
        System.out.println("obtenerTodasLasCuentasLiquidadas");
        CuentasLiquidadasDaoImpl instance = new CuentasLiquidadasDaoImpl();
        List<CuentasLiquidadas> expResult = null;
        List<CuentasLiquidadas> result = instance.obtenerTodasLasCuentasLiquidadas();
    }

    @Test
    public void testObtenerUltimaCuentaLiquidada() {
        System.out.println("obtenerUltimaCuentaLiquidada");
        CuentasLiquidadasDaoImpl instance = new CuentasLiquidadasDaoImpl();
        CuentasLiquidadas expResult = null;
        CuentasLiquidadas result = instance.obtenerUltimaCuentaLiquidada();
    }
    
}
