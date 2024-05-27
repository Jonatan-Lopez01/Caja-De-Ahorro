/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.bd.domain;

/**
 *
 * @author Jonatan Eduardo
 */
public class Rol {
    //Atributos

    private int id_rol = -1;
    private String nombre = "";
    private String descripcion = "";

    //Constructor
    public Rol() {

    }

    //Metodos, unicamente Getters y Setters.
    public int getIdRol() {
        return this.id_rol;
    }

    public void setIdRol(int nuevoIdRol) {
        this.id_rol = nuevoIdRol;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String nuevaDescrip) {
        this.descripcion = nuevaDescrip;
    }

}
