/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.domain;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Arce
 */



public class PrestamoDTO {
    private double montoPrestado;
    private String tipoPrestamo;
    private int plazo;
    private String descripcion;
    private Timestamp fechaSolicitud;
    private double tasaInteres;
    private double pagoActual;
    private int numMontos;

    // Getters y Setters
    public double getMontoPrestado() {
        return montoPrestado;
    }

    public void setMontoPrestado(double montoPrestado) {
        this.montoPrestado = montoPrestado;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getPagoActual() {
        return pagoActual;
    }

    public void setPagoActual(double pagoActual) {
        this.pagoActual = pagoActual;
    }

    public int getNumMontos() {
        return numMontos;
    }

    public void setNumMontos(int numMontos) {
        this.numMontos = numMontos;
    }
}
