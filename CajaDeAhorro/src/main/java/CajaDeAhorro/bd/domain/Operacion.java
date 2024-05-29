package CajaDeAhorro.bd.domain;

public class Operacion {
    private int id_operacion;
    private int numero_cuenta; // Clave externa
    private String nombre = "";

    public Operacion() {
    }

    public int getIdOperacion() {
        return id_operacion;
    }

    public void setIdOperacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public int getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setNumeroCuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String NombreOp) {
        this.nombre = NombreOp;
    }
    
}
