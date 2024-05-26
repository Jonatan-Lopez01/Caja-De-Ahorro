/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.usuario;


import CajaDeAhorro.bd.domain.Usuario;
import CajaDeAhorro.dao.usuario.UsuarioDaoImpl;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


/**
 *
 * @author Jonatan Eduardo
 */
public class UsuarioDaoImplTest {
    
    
    /*public void InsertarUsuario() {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo("Millan@gmail.com");
        nuevoUsuario.setIdRol(200);
        nuevoUsuario.setNombre("Millan Lopez");
        nuevoUsuario.setContraseña("Millan983");
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        usuarioBaseDatos.crearUsuario(nuevoUsuario);
    }

    public void ObtenerUsuario() {
        Usuario user = new Usuario();
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        user = usuarioBaseDatos.obtenerUsuarioPorId(2);
        System.out.println(user.getNombre());
        System.out.println(user.getContraseña());
    }

    public void ActualizarUsuario() {
        Usuario user = new Usuario();
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        user = usuarioBaseDatos.obtenerUsuarioPorId(2);

        user.setNombre("Natanael Cano");
        user.setContraseña("Nata&Belico%123");
        user.setCorreo("nata@gmail.com");
        usuarioBaseDatos.actualizarUsuario(user);
    }

    public void ObterListaUsuarios() {
        List<Usuario> listaUsuarios = null;
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        listaUsuarios = usuarioBaseDatos.obtenerTodosLosUsuarios();

        for (Usuario OneUser : listaUsuarios) {
            System.out.println("\n");
            System.out.println("Id del User: " + OneUser.getIdUsuario());
            System.out.println("Correo: " + OneUser.getCorreo());
            System.out.println("Id Rol: " + OneUser.getIdRol());
            System.out.println("Nombre: " + OneUser.getNombre());
            System.out.println("Contraseña: " + OneUser.getContraseña());
            System.out.println("\n");
        }
    }*/

    @Test
    public void testCrearUsuario() {
        System.out.println("crearUsuario");
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo("Millan@gmail.com");
        nuevoUsuario.setIdRol(200);
        nuevoUsuario.setNombre("Millan Lopez");
        nuevoUsuario.setContraseña("Millan983");
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        usuarioBaseDatos.crearUsuario(nuevoUsuario);
        fail("");
    }

    @Test
    public void testActualizarUsuario() {
        System.out.println("actualizarUsuario");
        Usuario usuario = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.actualizarUsuario(usuario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        int id = 0;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.eliminarUsuario(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerUsuarioPorId() {
        System.out.println("obtenerUsuarioPorId");
        int id = 0;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        Usuario expResult = null;
        Usuario result = instance.obtenerUsuarioPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerTodosLosUsuarios() {
        System.out.println("obtenerTodosLosUsuarios");
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.obtenerTodosLosUsuarios();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
