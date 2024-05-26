/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.rol;

import CajaDeAhorro.bd.domain.Rol;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonatan Eduardo
 */
public class RolDaoImplTest {

    public RolDaoImplTest() {
    }

    @Test
    public void testCrearRol() {
        System.out.println("**crearRol**");

        // Crear un nuevo rol
        Rol nuevoRol = new Rol();
        nuevoRol.setNombre("Es un gerente pequeño");
        nuevoRol.setDescripcion("Gerente que no tiene nada que hacer jojo");

        // Instanciar la clase RolDaoImpl
        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // Crear el rol en la base de datos
        rolBaseDatos.crearRol(nuevoRol);

        // Obtener el último rol creado desde la base de datos
        Rol rolCreado = rolBaseDatos.obtenerUltimoRol();

        // Comprobar que el rol no es nulo
        assertNotNull("El rol creado es nulo", rolCreado);

        // Verificar que los valores son correctos
        assertEquals("El nombre del rol no coincide", nuevoRol.getNombre(), rolCreado.getNombre());
        assertEquals("La descripción del rol no coincide", nuevoRol.getDescripcion(), rolCreado.getDescripcion());

        System.out.println("TEST TERMINADO EXITOSAMENTE! C:");
    }

    @Test
    public void testActualizarRol() {
        System.out.println("**actualizarRol**");

        // Crear un nuevo rol
        Rol nuevoRol = new Rol();
        nuevoRol.setNombre("Rol de Prueba para actualizarlo");
        nuevoRol.setDescripcion("Descripcion de prueba para actualizarlo");

        // Instanciar la clase RolDaoImpl
        RolDaoImpl rolBaseDatos = new RolDaoImpl();

        // Crear el rol en la base de datos
        rolBaseDatos.crearRol(nuevoRol);  // Aquí ya se creó un rol

        // Obtener el último rol creado (el que acabamos de crear)
        Rol rolCreado = rolBaseDatos.obtenerUltimoRol();

        System.out.println("Los datos del nuevo rol para modificar son:");
        System.out.println("ID: " + rolCreado.getIdRol());
        System.out.println("Nombre: " + rolCreado.getNombre());
        System.out.println("Descripción: " + rolCreado.getDescripcion());

        // Modificar los datos del rol
        rolCreado.setNombre("Rol de prueba ya modificado");
        rolCreado.setDescripcion("Descripcion de prueba ya modificada");
        rolBaseDatos.actualizarRol(rolCreado);

        System.out.println("Los datos modificados del rol son:");
        System.out.println("ID: " + rolCreado.getIdRol());
        System.out.println("Nombre: " + rolCreado.getNombre());
        System.out.println("Descripción: " + rolCreado.getDescripcion());

        // Verificar que los cambios se han guardado correctamente
        Rol rolActualizado = rolBaseDatos.obtenerRolPorId(rolCreado.getIdRol());

        // Comprobar que el rol actualizado no es nulo
        assertNotNull("El rol actualizado es nulo", rolActualizado);

        // Verificar que los valores son correctos
        assertEquals("El nombre del rol no coincide", rolCreado.getNombre(), rolActualizado.getNombre());
        assertEquals("La descripción del rol no coincide", rolCreado.getDescripcion(), rolActualizado.getDescripcion());

        System.out.println("TEST TERMINADO EXITOSAMENTE! C:");
    }

    @Test
    public void testEliminarRol() {
        System.out.println("**eliminarRol**");
        int id = 5;
        System.out.println("Se eliminara el rol con el id: " + id);
        RolDaoImpl rolBaseDatos = new RolDaoImpl();
        rolBaseDatos.eliminarRol(id);
        System.out.println("Rol eliminado correctamente");

        System.out.println("TEST TERMINADO EXITOSAMENTE! C:");
    }

    @Test
    public void testObtenerRolPorId() {
        System.out.println("**obtenerRolPorId**");
        Rol rolObtenido = new Rol();
        int id = 1;
        System.out.println("El rol con id= " + id + "es: ");
        RolDaoImpl RolBaseDatos = new RolDaoImpl();
        rolObtenido = RolBaseDatos.obtenerRolPorId(id);
        System.out.println(rolObtenido.getIdRol());
        System.out.println(rolObtenido.getNombre());
        System.out.println(rolObtenido.getDescripcion());

        System.out.println("TEST TERMINADO EXITOSAMENTE! C:");
    }

    @Test
    public void testObtenerTodosLosRoles() {
        System.out.println("**obtenerTodosLosRoles**");
        RolDaoImpl RolBaseDatos = new RolDaoImpl();
        List<Rol> listaDeRoles = null;
        listaDeRoles = RolBaseDatos.obtenerTodosLosRoles();

        for (Rol rolIndividual : listaDeRoles) {
            System.out.println(rolIndividual.getIdRol());
            System.out.println(rolIndividual.getNombre());
            System.out.println(rolIndividual.getDescripcion());
        }

        System.out.println("TEST TERMINADO EXITOSAMENTE! C:");
    }

}
