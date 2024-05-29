/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.Socio;

import CajaDeAhorro.bd.domain.Socio;
import CajaDeAhorro.bd.mappers.SocioConexion;
import java.util.List;

/**
 *
 * @author Jonatan Eduardo
 */
public class SocioDaoImpl implements SocioDao {

    @Override
    public void crearSocio(Socio socio) {
        SocioConexion conexion = new SocioConexion();
        conexion.crearSocio(socio);
    }

    @Override
    public void actualizarSocio(int id, Socio socio) {
        SocioConexion conexion = new SocioConexion();
        conexion.actualizarSocio(id,socio);
    }

    @Override
    public Socio eliminarSocio(int id) {
        SocioConexion conexion = new SocioConexion();
        return conexion.eliminarSocio(id);
    }

    @Override
    public Socio obtenerSocioPorId(int id) {
        SocioConexion conexion = new SocioConexion();
        return conexion.obtenerSocioPorId(id);
    }

    @Override
    public List<Socio> obtenerTodosLosSocios() {
        SocioConexion conexion = new SocioConexion();
        return conexion.obtenerTodosLosSocios();
    }

    @Override
    public Socio obtenerUltimoSocio() {
        SocioConexion conexion = new SocioConexion();
        return conexion.obtenerUltimoSocio();
    }
    

}
