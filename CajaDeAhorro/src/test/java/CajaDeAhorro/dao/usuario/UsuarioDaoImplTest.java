/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.usuario;

import CajaDeAhorro.bd.domain.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonatan Eduardo
 */
public class UsuarioDaoImplTest {

    public UsuarioDaoImplTest() {
    }

    private Usuario crearUsuario(int id_rol, String nombre, String correo, String password) {
        // Crear un nuevo rol localmente
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setIdRol(id_rol);
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setContraseña(password);

        // Instanciar la clase UsuarioDaoImpl
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();

        // Subir el usuario local a la base de datos
        usuarioBaseDatos.crearUsuario(nuevoUsuario);

        // Obtener el último usuario creado en la base de datos
        Usuario usuarioCreado = usuarioBaseDatos.obtenerUltimoUsuario();

        // Definimos las condiciones de fallo:
        assertNotNull("Fallo: El usuario creado es nulo, porque no se pudo obtener de la base de datos", usuarioCreado);
        assertEquals("El id_rol del usuario no coincide", nuevoUsuario.getIdRol(), usuarioCreado.getIdRol());
        assertEquals("El nombre del usuario no coincide", nuevoUsuario.getNombre(), usuarioCreado.getNombre());
        assertEquals("El correo del usuario no coincide", nuevoUsuario.getCorreo(), usuarioCreado.getCorreo());
        assertEquals("La contraseña del usuario no coincide", nuevoUsuario.getContraseña(), usuarioCreado.getContraseña());

        return usuarioCreado;
    }

    @Test
    public void testCrearUsuario() {

        Usuario nuevoUsuario = crearUsuario(25, "Kevin Ivan Jimenez", "kevin@gmail.com", "kevin23");
        System.out.println("\n El usuario insertado a la base de datos es : \n");
        System.out.println("id_usuario: " + nuevoUsuario.getIdUsuario());
        System.out.println("id_rol: " + nuevoUsuario.getIdRol());
        System.out.println("nombre: " + nuevoUsuario.getNombre());
        System.out.println("correo: " + nuevoUsuario.getCorreo());
        System.out.println("password: " + nuevoUsuario.getContraseña());
    }

    @Test
    public void testActualizarUsuario() {
        int id = 4; // id del usuario a actualizar

        // Obtener el rol actual de la base de datos
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        Usuario usuarioDeLaBaseDeDatos = usuarioBaseDatos.obtenerUsuarioPorId(id);

        // Verificar que el usuario existe antes de actualizarlo
        assertNotNull("Fallo: No se encontró un usuario con el ID proporcionado", usuarioDeLaBaseDeDatos);

        // Mostrar los detalles del usuario actual
        System.out.println("\nDetalles del usuario actual\n");
        System.out.println("id_usuario: " + usuarioDeLaBaseDeDatos.getIdUsuario());
        System.out.println("id_rol: " + usuarioDeLaBaseDeDatos.getIdRol());
        System.out.println("nombre: " + usuarioDeLaBaseDeDatos.getNombre());
        System.out.println("correo: " + usuarioDeLaBaseDeDatos.getCorreo());
        System.out.println("contraseña: " + usuarioDeLaBaseDeDatos.getContraseña());

        // Definir los cambios para actualizar
        Usuario usuarioLocal = new Usuario();
        usuarioLocal.setIdUsuario(id);
        usuarioLocal.setIdRol(24);
        usuarioLocal.setNombre("Mario Alberto Perez Cortes");
        usuarioLocal.setCorreo("Alberto@gmail.com");
        usuarioLocal.setContraseña("chanchitofeliz12345678");

        //Mostrar los cambios en los detalles del usuario (localmente)
        System.out.println("\nCambios en los detalles para el usuario (localmente)\n");
        System.out.println("id_rol: " + usuarioLocal.getIdRol());
        System.out.println("nombre: " + usuarioLocal.getNombre());
        System.out.println("correo: " + usuarioLocal.getCorreo());
        System.out.println("contraseña: " + usuarioLocal.getContraseña() + "\n");

        // Actualizar el usuario en la base de datos
        usuarioBaseDatos.actualizarUsuario(id, usuarioLocal);

        // Obtener el usuario actualizado de la base de datos
        usuarioDeLaBaseDeDatos = usuarioBaseDatos.obtenerUsuarioPorId(id);

        // Definir las condiciones de fallo
        assertEquals("El id_usuario del usuario no coincide", usuarioLocal.getIdUsuario(), usuarioDeLaBaseDeDatos.getIdUsuario());
        assertEquals("El id_rol del usuario no coincide", usuarioLocal.getIdRol(), usuarioDeLaBaseDeDatos.getIdRol());
        assertEquals("El nombre del usuario no coincide", usuarioLocal.getNombre(), usuarioDeLaBaseDeDatos.getNombre());
        assertEquals("El correo del usuario no coincide", usuarioLocal.getCorreo(), usuarioDeLaBaseDeDatos.getCorreo());
        assertEquals("El contraseña del usuario no coincide", usuarioLocal.getContraseña(), usuarioDeLaBaseDeDatos.getContraseña());

        // Mostrar en consola los cambios en los detalles del rol en la base de datos
        System.out.println("\nDetalles del usuario actualizado en la base de datos\n");
        System.out.println("id_rol: " + usuarioDeLaBaseDeDatos.getIdRol());
        System.out.println("nombre: " + usuarioDeLaBaseDeDatos.getNombre());
        System.out.println("correo: " + usuarioDeLaBaseDeDatos.getCorreo());
        System.out.println("contraseña: " + usuarioDeLaBaseDeDatos.getContraseña() + "\n");
    }

    @Test
    public void testEliminarUsuario() {
        // Crear un nuevo rol antes de eliminarlo
        Usuario usuarioCreado = crearUsuario(27, "Jonatan Eduardo Ramirez", "jony@gmail.com", "jon1qwe%1");

        // Ahora procedemos a eliminar el usuario recién creado
        int id = usuarioCreado.getIdUsuario(); // obtenemos el id del rol creado

        // Instanciar la clase  UsuarioDaoImpl
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();

        // Guardamos localmente el usuario que se va a eliminar de la base de datos
        Usuario usuarioRespaldo = usuarioBaseDatos.obtenerUsuarioPorId(id); // usamos el usuario creado como respaldo
        assertNotNull("El usuario eliminado es nulo", usuarioRespaldo);

        // Procedemos a eliminar el usuario
        Usuario usuarioEliminado = usuarioBaseDatos.eliminarUsuario(id);

        // Definimos las condiciones de fallo para la eliminación:
        assertNotNull("El usuario eliminado es nulo", usuarioEliminado);
        
        assertEquals("El id_rol no coincide", usuarioRespaldo.getIdRol(), usuarioEliminado.getIdRol());
        assertEquals("El nombre no coincide", usuarioRespaldo.getNombre(), usuarioEliminado.getNombre());
        assertEquals("La correo del usuario no coincide", usuarioRespaldo.getCorreo(), usuarioEliminado.getCorreo());
        assertEquals("La contraseña del usuario no coincide", usuarioRespaldo.getContraseña(), usuarioEliminado.getContraseña());

        // Mandamos a imprimir los detalles del usuario eliminado a consola
        System.out.println("\nLa tupla eliminada fue: \n");
        System.out.println("id_usuario: " + usuarioEliminado.getIdUsuario());
        System.out.println("id_rol: " + usuarioEliminado.getIdRol());
        System.out.println("nombre: " + usuarioEliminado.getNombre());
        System.out.println("correo: " + usuarioEliminado.getCorreo());
        System.out.println("contraseña: " + usuarioEliminado.getContraseña());
    }

    @Test
    public void testObtenerUsuarioPorId() {
        int id = 4; // id del usuario a buscar
        System.out.println("Buscando el usuario con id_usuario= " + id + "\n");

        // Instanciar la clase UsuarioDaoImpl
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();

        // El usuario Obtenido puede tener una tupla o puede tener null
        Usuario UsuarioObtenido = usuarioBaseDatos.obtenerUsuarioPorId(id);

        // Definimos las condiciones de fallo:
        assertNotNull("El usuario obtenido es null", UsuarioObtenido);

        // Mandamos a imprimir los detalles del usuario obtenido a consola
        System.out.println("\n La tupla obtenida es: \n");
        System.out.println("id_usuario: " + UsuarioObtenido.getIdUsuario());
        System.out.println("id_rol: " + UsuarioObtenido.getIdRol());
        System.out.println("nombre: " + UsuarioObtenido.getNombre());
        System.out.println("correo: " + UsuarioObtenido.getCorreo());
        System.out.println("contraseña: " + UsuarioObtenido.getContraseña());
    }

    @Test
    public void testObtenerTodosLosUsuarios() {
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();

        // El metodo obtenerTodosLosUsuarios devuelve una lista vacia sino encuentra nada en la base de datos
        List<Usuario> listaDeUsuario = usuarioBaseDatos.obtenerTodosLosUsuarios();

        // Definimos las condiciones de fallo
        assertFalse("La lista de usuario está vacía", listaDeUsuario.isEmpty());

        // Mandamos a imprimir los detalles de cada usuario a consola
        System.out.println("\nListado de los usuarios: \n");
        for (Usuario usuarioIndividual : listaDeUsuario) {
            System.out.println("Id Usuario: " + usuarioIndividual.getIdUsuario());
            System.out.println("Id Rol: " + usuarioIndividual.getIdRol());
            System.out.println("Nombre: " + usuarioIndividual.getNombre());
            System.out.println("Correo: " + usuarioIndividual.getCorreo());
            System.out.println("Contraseña: " + usuarioIndividual.getContraseña());
            System.out.println("\n");
        }
    }
    
    @Test
    public void testLogin() {
        String correo = "Alberto@gmail.com";
        String password = "chanchitofeliz12345678";
        boolean flag = false;
        UsuarioDaoImpl usuarioBaseDatos = new UsuarioDaoImpl();
        flag = usuarioBaseDatos.login(correo, password);
        assertTrue("El login debería ser exitoso", flag);
        System.out.println("Logueo exitoso");
    }
}
