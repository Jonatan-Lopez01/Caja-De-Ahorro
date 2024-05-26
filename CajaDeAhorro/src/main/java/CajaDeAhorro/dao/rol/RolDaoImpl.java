/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.rol;

import CajaDeAhorro.bd.domain.Rol;
import CajaDeAhorro.bd.mappers.RolConexion;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class RolDaoImpl implements RolDao {

    @Override
    public void crearRol(Rol rol) {
        RolConexion conexion = new RolConexion();
        conexion.crearRol(rol);
    }

    @Override
    public void actualizarRol(int id, Rol rol) {
        RolConexion conexion = new RolConexion();
        conexion.actualizarRol( id, rol);
    }

    @Override
    public Rol eliminarRol(int id) {
        Rol rolEliminado = new Rol();
        RolConexion conexion = new RolConexion();
        rolEliminado = conexion.eliminarRol(id);
        return rolEliminado;
    }

    @Override
    public Rol obtenerRolPorId(int id) {
        Rol rolById;
        RolConexion conexion = new RolConexion();
        rolById = conexion.obtenerRolPorId(id);
        return rolById;
    }

    @Override
    public List<Rol> obtenerTodosLosRoles() {
        List listaDeRoles = null;
        RolConexion conexion = new RolConexion();
        listaDeRoles = conexion.obtenerTodosLosRoles();
        return listaDeRoles;
    }

    @Override
    public Rol obtenerUltimoRol() {
        Rol ultimoRol= new Rol();
        RolConexion conexion = new RolConexion();
        ultimoRol= conexion.obtenerUltimoRol();
        return ultimoRol;   
    }
}
