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
public class Prestamo {
    // Atributos
    private long id_prestamo = -1;
    private long id_solicitud_prestamo = -1;  // Clave foránea a la tabla solicitud_prestamo
    private long id_intereses = -1;
    private double monto_prestado = 0.0;
    private double pago_actual = 0.0;
    private Timestamp fecha_solicitud;
    private Date plazo;
    private int num_montos = 0;

    // Constructor
    public Prestamo() {
    }

    // Métodos, únicamente Getters y Setters.
    public long getIdPrestamo() {
        return this.id_prestamo;
    }

    public void setIdPrestamo(long nuevoIdPrestamo) {
        this.id_prestamo = nuevoIdPrestamo;
    }

    public long getIdSolicitudPrestamo() {
        return this.id_solicitud_prestamo;
    }

    public void setIdSolicitudPrestamo(long nuevoIdSolicitudPrestamo) {
        this.id_solicitud_prestamo = nuevoIdSolicitudPrestamo;
    }

    public long getIdIntereses() {
        return this.id_intereses;
    }

    public void setIdIntereses(long nuevoIdIntereses) {
        this.id_intereses = nuevoIdIntereses;
    }

    public double getMontoPrestado() {
        return this.monto_prestado;
    }

    public void setMontoPrestado(double nuevoMontoPrestado) {
        this.monto_prestado = nuevoMontoPrestado;
    }

    public double getPagoActual() {
        return this.pago_actual;
    }

    public void setPagoActual(double nuevoPagoActual) {
        this.pago_actual = nuevoPagoActual;
    }

    public Timestamp getFechaSolicitud() {
        return this.fecha_solicitud;
    }

    public void setFechaSolicitud(Timestamp nuevaFechaSolicitud) {
        this.fecha_solicitud = nuevaFechaSolicitud;
    }

    public Date getPlazo() {
        return this.plazo;
    }

    public void setPlazo(Date nuevoPlazo) {
        this.plazo = nuevoPlazo;
    }

    public int getNumMontos() {
        return this.num_montos;
    }

    public void setNumMontos(int nuevoNumMontos) {
        this.num_montos = nuevoNumMontos;
    }
}
