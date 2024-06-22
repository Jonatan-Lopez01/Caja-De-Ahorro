/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change esta license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package CajaDeAhorro.bd.domain;

/**
 *
 * @autor Gizelle RM
 */
public class Cuenta {
    // Atributos
    private int numero_cuenta = -1;
    private float tasa_interes = 0.0f;
    private int estatus_cuenta = -1;
    private float saldo = 0;
    private String tipo ="";

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Constructor
    public Cuenta() {

    }

    // Métodos, únicamente Getters y Setters
    public int getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setNumeroCuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public float getTasaInteres() {
        return tasa_interes;
    }

    public void setTasaInteres(float tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public int getEstatusCuenta() {
        return estatus_cuenta;
    }

    public void setEstatusCuenta(int estatus_cuenta) {
        this.estatus_cuenta = estatus_cuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
