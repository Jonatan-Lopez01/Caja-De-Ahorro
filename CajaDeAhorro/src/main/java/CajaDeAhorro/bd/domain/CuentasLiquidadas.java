/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.domain;

/**
 *
 * @author Jonatan Eduardo
 */
public class CuentasLiquidadas {

    private int id_cuenta_liquidada;
    private int numero_cuenta;
    private String tipo_liquidez;
    private String folio_pago_liquidez;
    private int id_socio;

    // Getter and Setter for id_cuenta_liquidada
    public int getId_cuenta_liquidada() {
        return id_cuenta_liquidada;
    }

    public void setId_cuenta_liquidada(int id_cuenta_liquidada) {
        this.id_cuenta_liquidada = id_cuenta_liquidada;
    }

    // Getter and Setter for numero_cuenta
    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    // Getter and Setter for tipo_liquidez
    public String getTipo_liquidez() {
        return tipo_liquidez;
    }

    public void setTipo_liquidez(String tipo_liquidez) {
        this.tipo_liquidez = tipo_liquidez;
    }

    // Getter and Setter for folio_pago_liquidez
    public String getFolio_pago_liquidez() {
        return folio_pago_liquidez;
    }

    public void setFolio_pago_liquidez(String folio_pago_liquidez) {
        this.folio_pago_liquidez = folio_pago_liquidez;
    }
    public int getIdSocio() {
        return id_socio;
    }

    public void setIdSocio(int idSocio) {
        this.id_socio=idSocio ;
    }

}
