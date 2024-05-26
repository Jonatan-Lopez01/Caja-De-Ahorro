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
