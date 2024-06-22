/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.socio_cuenta;

import CajaDeAhorro.bd.domain.SocioCuenta;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonatan Eduardo
 */
public class SocioCuentaDaoImplTest {

    public SocioCuentaDaoImplTest() {
    }

    private SocioCuenta crearSocioCuenta(int id_socio, int id_cuenta) {
        // Crear un nuevo socio cuenta localmente
        SocioCuenta nuevoSocioCuenta = new SocioCuenta();
        nuevoSocioCuenta.setId_socio(id_socio);
        nuevoSocioCuenta.setId_cuenta(id_cuenta);

        // Instanciar la clase SocioCuentaDaoImpl
        SocioCuentaDaoImpl socioCuentaBaseDatos = new SocioCuentaDaoImpl();

        // Subir el socio cuenta local a la base de datos
        socioCuentaBaseDatos.crearSocioCuenta(nuevoSocioCuenta);

        // Obtener el último socio cuenta creado en la base de datos
        SocioCuenta socioCuentaCreado = socioCuentaBaseDatos.obtenerUltimoSocioCuenta();


        return socioCuentaCreado;
    }

    @Test
    public void testCrearSocioCuenta() {
        SocioCuenta nuevoSocioCuenta = crearSocioCuenta(1, 8); // Ejemplo con id_socio=1 y id_cuenta=1

        System.out.println("\n El socio cuenta insertado a la base de datos es : \n");
        System.out.println("id_socioCuenta: " + nuevoSocioCuenta.getId_socio_cuenta());
        System.out.println("id_socio: " + nuevoSocioCuenta.getId_socio());
        System.out.println("id_cuenta: " + nuevoSocioCuenta.getId_cuenta());
    }

    @Test
    public void testActualizarSocioCuenta() {
        int id = 145; // id del SocioCuenta a actualizar

        // Obtener el SocioCuenta actual de la base de datos
        SocioCuentaDaoImpl socioCuentaBaseDatos = new SocioCuentaDaoImpl();
        SocioCuenta socioCuentaDeLaBaseDeDatos = socioCuentaBaseDatos.obtenerSocioCuentaPorId(id);

        // Verificar que el SocioCuenta existe antes de actualizarlo
        assertNotNull("Fallo: No se encontró un SocioCuenta con el ID proporcionado", socioCuentaDeLaBaseDeDatos);

        // Mostrar los detalles del SocioCuenta actual
        System.out.println("\nDetalles del SocioCuenta actual\n");
        System.out.println("id_socioCuenta: " + socioCuentaDeLaBaseDeDatos.getId_socio_cuenta());
        System.out.println("id_socio: " + socioCuentaDeLaBaseDeDatos.getId_socio());
        System.out.println("id_cuenta: " + socioCuentaDeLaBaseDeDatos.getId_cuenta());

        // Definir los cambios para actualizar
        SocioCuenta socioCuentaLocal = new SocioCuenta();
        socioCuentaLocal.setId_socio_cuenta(id);
        socioCuentaLocal.setId_socio(4); // Cambiar el ID del socio
        socioCuentaLocal.setId_cuenta(24); // Cambiar el ID de la cuenta

        // Mostrar los cambios en los detalles del SocioCuenta (localmente)
        System.out.println("\nCambios en los detalles para el SocioCuenta (localmente)\n");
        System.out.println("id_socio: " + socioCuentaLocal.getId_socio());
        System.out.println("id_cuenta: " + socioCuentaLocal.getId_cuenta() + "\n");

        // Actualizar el SocioCuenta en la base de datos
        socioCuentaBaseDatos.actualizarSocioCuenta(id, socioCuentaLocal);

        // Obtener el SocioCuenta actualizado de la base de datos
        socioCuentaDeLaBaseDeDatos = socioCuentaBaseDatos.obtenerSocioCuentaPorId(id);

        // Definir las condiciones de fallo
     

        // Mostrar en consola los cambios en los detalles del SocioCuenta en la base de datos
        System.out.println("\nDetalles del SocioCuenta actualizado en la base de datos\n");
        System.out.println("id_socio: " + socioCuentaDeLaBaseDeDatos.getId_socio());
        System.out.println("id_cuenta: " + socioCuentaDeLaBaseDeDatos.getId_cuenta() + "\n");
    }

    @Test
    public void testEliminarSocioCuenta() {
        // Crear un nuevo SocioCuenta antes de eliminarlo
        SocioCuenta socioCuentaCreado = crearSocioCuenta(3, 8); // Reemplaza los parámetros según tu implementación

        // Ahora procedemos a eliminar el SocioCuenta recién creado
        int id = socioCuentaCreado.getId_socio_cuenta(); // obtenemos el id del SocioCuenta creado

        // Instanciar la clase SocioCuentaDaoImpl
        SocioCuentaDaoImpl socioCuentaBaseDatos = new SocioCuentaDaoImpl();

        // Guardamos localmente el SocioCuenta que se va a eliminar de la base de datos
        SocioCuenta socioCuentaRespaldo = socioCuentaBaseDatos.obtenerSocioCuentaPorId(id); // usamos el SocioCuenta creado como respaldo
        assertNotNull("El SocioCuenta eliminado es nulo", socioCuentaRespaldo);

        // Procedemos a eliminar el SocioCuenta
        SocioCuenta socioCuentaEliminado = socioCuentaBaseDatos.eliminarSocioCuenta(id);

        // Definimos las condiciones de fallo para la eliminación:
       

        // Mandamos a imprimir los detalles del SocioCuenta eliminado a consola
        System.out.println("\nLa tupla eliminada fue: \n");
        System.out.println("id_socioCuenta: " + socioCuentaEliminado.getId_socio_cuenta());
        System.out.println("id_socio: " + socioCuentaEliminado.getId_socio());
        System.out.println("id_cuenta: " + socioCuentaEliminado.getId_cuenta());
    }

    @Test
    public void testObtenerSocioCuentaPorId() {
        int id = 145; // id del socioCuenta a buscar
        System.out.println("Buscando el socioCuenta con id_socioCuenta= " + id + "\n");

        // Instanciar la clase SocioCuentaDaoImpl
        SocioCuentaDaoImpl socioCuentaBaseDatos = new SocioCuentaDaoImpl();

        // El socioCuenta obtenido puede tener una tupla o puede tener null
        SocioCuenta socioCuentaObtenido = socioCuentaBaseDatos.obtenerSocioCuentaPorId(id);

        // Definir las condiciones de fallo:
        assertNotNull("El socioCuenta obtenido es null", socioCuentaObtenido);


    }

    @Test
    public void testObtenerTodosLosSocioCuentas() {
        SocioCuentaDaoImpl socioCuentaBaseDatos = new SocioCuentaDaoImpl();

        // El método obtenerTodosLosSocioCuentas devuelve una lista vacía si no encuentra nada en la base de datos
        List<SocioCuenta> listaDeSocioCuentas = socioCuentaBaseDatos.obtenerTodosLosSocioCuentas();

        // Definimos las condiciones de fallo
        assertFalse("La lista de SocioCuentas está vacía", listaDeSocioCuentas.isEmpty());

        // Mandamos a imprimir los detalles de cada SocioCuenta a consola
        System.out.println("\nListado de los SocioCuentas: \n");
        for (SocioCuenta socioCuentaIndividual : listaDeSocioCuentas) {
            System.out.println("Id SocioCuenta: " + socioCuentaIndividual.getId_socio_cuenta());
            System.out.println("Id Socio: " + socioCuentaIndividual.getId_socio());
            System.out.println("Id Cuenta: " + socioCuentaIndividual.getId_cuenta());
            System.out.println("\n");
        }
    }

}
