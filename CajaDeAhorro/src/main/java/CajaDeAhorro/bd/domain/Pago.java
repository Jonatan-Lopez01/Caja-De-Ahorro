/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.domain;
import java.sql.Date;
import java.time.LocalDateTime;
/**
 *
 * @author Jonatan Eduardo
 */
public class Pago {
    //Atributos

    private int id_pago;
    private int id_prestamo;
    private double cantidad;
    private LocalDateTime  fecha;

    //Constructor
    public Pago() {
        
    }

    //Getters y Setters
    public int getIdPago() {
        return this.id_pago;
    }

    public void setIdPago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getIdPrestamo() {
        return this.id_prestamo;
    }

    public void setIdPrestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

     public LocalDateTime getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
