package CajaDeAhorro.bd.domain;

import java.sql.Timestamp;

public class SolicitudPrestamo {

    private int id_solicitud_prestamo;
    private int id_socio;
    private int numCuenta;
    private double monto_prestado;
    private String tipo_prestamo;
    private Timestamp fecha_solicitud;
    private int plazo;
    private int num_montos;
    private String descripcion;
    private String estado;

    public SolicitudPrestamo() {
    }

    public int getnumCuenta() {
        return numCuenta;
    }

    public void setnumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getIdSolicitudPrestamo() {
        return id_solicitud_prestamo;
    }

    public void setIdSolicitudPrestamo(int id_solicitud_prestamo) {
        this.id_solicitud_prestamo = id_solicitud_prestamo;
    }

    public int getIdSocio() {
        return id_socio;
    }

    public void setIdSocio(int id_socio) {
        this.id_socio = id_socio;
    }

    public double getMontoPrestado() {
        return monto_prestado;
    }

    public void setMontoPrestado(double monto_prestado) {
        this.monto_prestado = monto_prestado;
    }

    public String getTipoPrestamo() {
        return tipo_prestamo;
    }

    public void setTipoPrestamo(String tipo_prestamo) {
        this.tipo_prestamo = tipo_prestamo;
    }

    public Timestamp getFechaSolicitud() {
        return fecha_solicitud;
    }

    public void setFechaSolicitud(Timestamp fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getNumMontos() {
        return num_montos;
    }

    public void setNumMontos(int num_montos) {
        this.num_montos = num_montos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
