/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.rol;

import CajaDeAhorro.bd.domain.Rol;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Jonatan Eduardo
 */
public class RolDaoImplTest {

    public RolDaoImplTest() {
    }

    private Rol crearRol(String nombre, String descripcion) {
        // Crear un nuevo rol localmente
        Rol nuevoRol = new Rol();
        nuevoRol.setNombre(nombre);
        nuevoRol.setDescripcion(descripcion);

        // Instanciar la clase RolDaoImpl
        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // Subir el rol local a la base de datos
        rolBaseDatos.crearRol(nuevoRol);

        // Obtener el último rol creado en la base de datos
        Rol rolCreado = rolBaseDatos.obtenerUltimoRol();

        // Verificar que el rol se haya creado correctamente
        assertNotNull("Fallo: El rol creado es nulo, porque no se pudo obtener de la base de datos", rolCreado);
        assertEquals("El nombre del rol no coincide", nuevoRol.getNombre(), rolCreado.getNombre());
        assertEquals("La descripción del rol no coincide", nuevoRol.getDescripcion(), rolCreado.getDescripcion());

        return rolCreado;
    }

    @Test
    public void testCrearRol() {
        Rol rolCreado = crearRol("Administrador2", "El encargado de suministrar las redes2");

        System.out.println("\n El rol insertado a la base de datos es : \n");
        System.out.println("id_rol: " + rolCreado.getIdRol());
        System.out.println("nombre: " + rolCreado.getNombre());
        System.out.println("descripcion: " + rolCreado.getDescripcion());
    }

    @Test
    public void testEliminarRol() {
        // Crear un nuevo rol local para insertarlo a la base de datos y depseus para eliminarlo
        Rol rolCreado = crearRol("Temporal", "Rol temporal para pruebas");

        // Ahora procedemos a eliminar el rol recién creado
        int id = rolCreado.getIdRol(); // obtenemos el id del rol creado

        // Instanciar la clase RolDaoImpl
        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // Guardamos localmente el rol que se va a eliminar de la base de datos
        Rol rolRespaldo = rolBaseDatos.obtenerRolPorId(id); // usamos el rol creado como respaldo
        assertNotNull("El rol obtenido para respaldo es nulo", rolRespaldo);

        // Procedemos a eliminar el rol
        Rol rolEliminado = rolBaseDatos.eliminarRol(id);

        // Definimos las condiciones de fallo para la eliminación
        assertNotNull("El rol eliminado es nulo", rolEliminado);
        assertEquals("El id_rol no coincide", rolRespaldo.getIdRol(), rolEliminado.getIdRol());
        assertEquals("El nombre no coincide", rolRespaldo.getNombre(), rolEliminado.getNombre());
        assertEquals("La descripción del rol no coincide", rolRespaldo.getDescripcion(), rolEliminado.getDescripcion());

        // Mandamos a imprimir los detalles del rol eliminado a consola
        System.out.println("\n La tupla eliminada fue: \n");
        System.out.println("id_rol: " + rolEliminado.getIdRol());
        System.out.println("nombre: " + rolEliminado.getNombre());
        System.out.println("descripción: " + rolEliminado.getDescripcion());
    }

    @Test
    public void testObtenerRolPorId() {
        int id = 1; // id del rol a buiscar
        System.out.println("Buscando el rol con id= " + id + "\n");

        // Instanciar la clase RolDaoImpl
        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // El rolObtenido puede tener una tupla o puede tener null
        Rol rolObtenido = rolBaseDatos.obtenerRolPorId(id);

        // Definimos las condiciones de fallo:
        assertNotNull("El rol obtenido es null", rolObtenido);

        // Mandamos a imprimir los detalles del rol obtenido a consola
        System.out.println("\n La tupla obtenida es: \n");
        System.out.println("id_rol: " + rolObtenido.getIdRol());
        System.out.println("nombre: " + rolObtenido.getNombre());
        System.out.println("descripción: " + rolObtenido.getDescripcion());
    }

    @Test
    public void testObtenerTodosLosRoles() {

        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // El metodo obtenerTodosLosRoles devuelve una lista vacia sino encuentra nada en la base de datos
        List<Rol> listaDeRoles = rolBaseDatos.obtenerTodosLosRoles();

        // Definimos las condiciones de fallo
        assertFalse("La lista de roles está vacía", listaDeRoles.isEmpty());

        // Mandamos a imprimir los detalles de cada rol a consola
        System.out.println("\nListado de los roles: \n");
        for (Rol rolIndividual : listaDeRoles) {
            System.out.println("ID: " + rolIndividual.getIdRol());
            System.out.println("Nombre: " + rolIndividual.getNombre());
            System.out.println("Descripción: " + rolIndividual.getDescripcion());
            System.out.println("\n");
        }
    }
    
    @Test
    public void testObtenerRolesByNombre() {

        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // El metodo obtenerTodosLosRoles devuelve una lista vacia sino encuentra nada en la base de datos
        List<Rol> listaDeRoles = rolBaseDatos.obtenerRolesByNombre("Admin");

        // Definimos las condiciones de fallo
        assertFalse("La lista de roles está vacía", listaDeRoles.isEmpty());

        // Mandamos a imprimir los detalles de cada rol a consola
        System.out.println("\nListado de los roles: \n");
        for (Rol rolIndividual : listaDeRoles) {
            System.out.println("ID: " + rolIndividual.getIdRol());
            System.out.println("Nombre: " + rolIndividual.getNombre());
            System.out.println("Descripción: " + rolIndividual.getDescripcion());
            System.out.println("\n");
        }
    }

    @Test
    public void testActualizarRol() {
        int id = 1; // id del rol a actualizar

        // Crear un nuevo rol localmente, simulando la obtención de datos desde un formulario
        Rol rolLocal = new Rol();
        rolLocal.setNombre("Patrón");
        rolLocal.setDescripcion("El mero mero de todos");

        // Obtener el rol actual de la base de datos
        RolDaoImpl rolBaseDatos = new RolDaoImpl();
        Rol rolDeLaBaseDeDatos = rolBaseDatos.obtenerRolPorId(id);

        // Verificar que el rol existe antes de actualizarlo
        assertNotNull("Fallo: No se encontró un rol con el ID proporcionado", rolDeLaBaseDeDatos);

        // Mostrar los detalles del rol actual
        System.out.println("\nDetalles del rol actual\n");
        System.out.println("Nombre: " + rolDeLaBaseDeDatos.getNombre());
        System.out.println("Descripción: " + rolDeLaBaseDeDatos.getDescripcion());

        // Mostrar los cambios en los detalles del rol (localmente)
        System.out.println("\nCambios en los detalles para el rol (localmente)\n");
        System.out.println("Nombre: " + rolLocal.getNombre());
        System.out.println("Descripción: " + rolLocal.getDescripcion() + "\n");

        // Actualizar el rol en la base de datos
        rolBaseDatos.actualizarRol(id, rolLocal);

        // Obtener el rol actualizado de la base de datos
        rolDeLaBaseDeDatos = rolBaseDatos.obtenerRolPorId(id);

        // Definir las condiciones de fallo
        assertEquals("El nombre del rol no coincide", rolLocal.getNombre(), rolDeLaBaseDeDatos.getNombre());
        assertEquals("La descripción del rol no coincide", rolLocal.getDescripcion(), rolDeLaBaseDeDatos.getDescripcion());

        // Mostrar en consola los cambios en los detalles del rol en la base de datos
        System.out.println("\nDetalles del rol actualizado en la base de datos\n");
        System.out.println("Nombre: " + rolDeLaBaseDeDatos.getNombre());
        System.out.println("Descripción: " + rolDeLaBaseDeDatos.getDescripcion());

    }

}
