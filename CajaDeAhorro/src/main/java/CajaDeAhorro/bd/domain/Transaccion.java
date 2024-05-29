package CajaDeAhorro.bd.domain;

/**
 *
 * @autor Gizelle RM
 */
public class Transaccion {
    // Atributos
    private int id_transaccion;
    private int id_operacion;
    private double monto;
    private String fecha;   
    // Constructor
    public Transaccion() {
        // Constructor vacío
    }

    // Getters
    public int getIdTransaccion() {
        return id_transaccion;
    }

    public int getIdOperacion() {
        return id_operacion;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    // Setters
    public void setIdTransaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public void setIdOperacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
