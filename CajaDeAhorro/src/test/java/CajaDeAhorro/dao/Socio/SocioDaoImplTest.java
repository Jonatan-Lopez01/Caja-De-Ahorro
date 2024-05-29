/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package CajaDeAhorro.dao.Socio;

import CajaDeAhorro.bd.domain.Socio;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonatan Eduardo
 */
public class SocioDaoImplTest {

    public SocioDaoImplTest() {
    }

    private Socio crearSocio(String nombre, String apellidos, String direccion, String telefono, String correo) {
        // Crear un nuevo socio localmente
        Socio nuevoSocio = new Socio();
        nuevoSocio.setNombre(nombre);
        nuevoSocio.setApellidos(apellidos);
        nuevoSocio.setDireccion(direccion);
        nuevoSocio.setTelefono(telefono);
        nuevoSocio.setCorreo(correo);

        // Instanciar la clase SocioDaoImpl
        SocioDaoImpl socioBaseDatos = new SocioDaoImpl();

        // Subir el socio local a la base de datos
        socioBaseDatos.crearSocio(nuevoSocio);

        // Obtener el último socio creado en la base de datos
        Socio socioCreado = socioBaseDatos.obtenerUltimoSocio();

        // Verificar que el socio se haya creado correctamente
        assertNotNull("Fallo: El socio creado es nulo, porque no se pudo obtener de la base de datos", socioCreado);
        assertEquals("El nombre del socio no coincide", nuevoSocio.getNombre(), socioCreado.getNombre());
        assertEquals("Los apellidos del socio no coinciden", nuevoSocio.getApellidos(), socioCreado.getApellidos());
        assertEquals("La dirección del socio no coincide", nuevoSocio.getDireccion(), socioCreado.getDireccion());
        assertEquals("El teléfono del socio no coincide", nuevoSocio.getTelefono(), socioCreado.getTelefono());
        assertEquals("El correo del socio no coincide", nuevoSocio.getCorreo(), socioCreado.getCorreo());

        return socioCreado;
    }

    @Test
    public void testCrearSocio() {
        Socio socioCreado = crearSocio("Juan", "Perez", "Calle Falsa 123", "1234567890", "juan.perez@example.com");

        System.out.println("\n El socio insertado a la base de datos es : \n");
        System.out.println("id_socio: " + socioCreado.getId_socio());
        System.out.println("nombre: " + socioCreado.getNombre());
        System.out.println("apellidos: " + socioCreado.getApellidos());
        System.out.println("direccion: " + socioCreado.getDireccion());
        System.out.println("telefono: " + socioCreado.getTelefono());
        System.out.println("correo: " + socioCreado.getCorreo());
    }

    @Test
    public void testActualizarSocio() {
        int id = 2; // id del socio a actualizar

        // Crear un nuevo socio localmente, simulando la obtención de datos desde un formulario
        Socio socioLocal = new Socio();
        socioLocal.setNombre("Juan");
        socioLocal.setApellidos("Perez");
        socioLocal.setDireccion("Calle Falsa 123");
        socioLocal.setTelefono("1234567890");
        socioLocal.setCorreo("juan.perez@example.com");

        // Obtener el socio actual de la base de datos
        SocioDaoImpl socioBaseDatos = new SocioDaoImpl();
        Socio socioDeLaBaseDeDatos = socioBaseDatos.obtenerSocioPorId(id);

        // Verificar que el socio existe antes de actualizarlo
        assertNotNull("Fallo: No se encontró un socio con el ID proporcionado", socioDeLaBaseDeDatos);

        // Mostrar los detalles del socio actual
        System.out.println("\nDetalles del socio actual\n");
        System.out.println("Nombre: " + socioDeLaBaseDeDatos.getNombre());
        System.out.println("Apellidos: " + socioDeLaBaseDeDatos.getApellidos());
        System.out.println("Dirección: " + socioDeLaBaseDeDatos.getDireccion());
        System.out.println("Teléfono: " + socioDeLaBaseDeDatos.getTelefono());
        System.out.println("Correo: " + socioDeLaBaseDeDatos.getCorreo());

        // Mostrar los cambios en los detalles del socio (localmente)
        System.out.println("\nCambios en los detalles para el socio (localmente)\n");
        System.out.println("Nombre: " + socioLocal.getNombre());
        System.out.println("Apellidos: " + socioLocal.getApellidos());
        System.out.println("Dirección: " + socioLocal.getDireccion());
        System.out.println("Teléfono: " + socioLocal.getTelefono());
        System.out.println("Correo: " + socioLocal.getCorreo() + "\n");

        // Actualizar el socio en la base de datos
        socioBaseDatos.actualizarSocio(id, socioLocal);

        // Obtener el socio actualizado de la base de datos
        socioDeLaBaseDeDatos = socioBaseDatos.obtenerSocioPorId(id);

        // Definir las condiciones de fallo
        assertEquals("El nombre del socio no coincide", socioLocal.getNombre(), socioDeLaBaseDeDatos.getNombre());
        assertEquals("Los apellidos del socio no coinciden", socioLocal.getApellidos(), socioDeLaBaseDeDatos.getApellidos());
        assertEquals("La dirección del socio no coincide", socioLocal.getDireccion(), socioDeLaBaseDeDatos.getDireccion());
        assertEquals("El teléfono del socio no coincide", socioLocal.getTelefono(), socioDeLaBaseDeDatos.getTelefono());
        assertEquals("El correo del socio no coincide", socioLocal.getCorreo(), socioDeLaBaseDeDatos.getCorreo());

        // Mostrar en consola los cambios en los detalles del socio en la base de datos
        System.out.println("\nDetalles del socio actualizado en la base de datos\n");
        System.out.println("Nombre: " + socioDeLaBaseDeDatos.getNombre());
        System.out.println("Apellidos: " + socioDeLaBaseDeDatos.getApellidos());
        System.out.println("Dirección: " + socioDeLaBaseDeDatos.getDireccion());
        System.out.println("Teléfono: " + socioDeLaBaseDeDatos.getTelefono());
        System.out.println("Correo: " + socioDeLaBaseDeDatos.getCorreo());
    }

    @Test
    public void testEliminarSocio() {
        // Crear un nuevo socio local para insertarlo a la base de datos y después para eliminarlo
        Socio socioCreado = crearSocio("Juan", "Pérez", "Calle Falsa 123", "1234567890", "juan.perez@example.com");

        // Ahora procedemos a eliminar el socio recién creado
        int id = socioCreado.getId_socio(); // obtenemos el id del socio creado

        // Instanciar la clase SocioDaoImpl
        SocioDaoImpl socioBaseDatos = new SocioDaoImpl();

        // Guardamos localmente el socio que se va a eliminar de la base de datos
        Socio socioRespaldo = socioBaseDatos.obtenerSocioPorId(id); // usamos el socio creado como respaldo
        assertNotNull("El socio obtenido para respaldo es nulo", socioRespaldo);

        // Procedemos a eliminar el socio
        Socio socioEliminado = socioBaseDatos.eliminarSocio(id);

        // Definimos las condiciones de fallo para la eliminación
        assertNotNull("El socio eliminado es nulo", socioEliminado);
        assertEquals("El id_socio no coincide", socioRespaldo.getId_socio(), socioEliminado.getId_socio());
        assertEquals("El nombre no coincide", socioRespaldo.getNombre(), socioEliminado.getNombre());
        assertEquals("Los apellidos no coinciden", socioRespaldo.getApellidos(), socioEliminado.getApellidos());
        assertEquals("La dirección no coincide", socioRespaldo.getDireccion(), socioEliminado.getDireccion());
        assertEquals("El teléfono no coincide", socioRespaldo.getTelefono(), socioEliminado.getTelefono());
        assertEquals("El correo no coincide", socioRespaldo.getCorreo(), socioEliminado.getCorreo());

        // Mandamos a imprimir los detalles del socio eliminado a consola
        System.out.println("\n La tupla eliminada fue: \n");
        System.out.println("id_socio: " + socioEliminado.getId_socio());
        System.out.println("nombre: " + socioEliminado.getNombre());
        System.out.println("apellidos: " + socioEliminado.getApellidos());
        System.out.println("direccion: " + socioEliminado.getDireccion());
        System.out.println("telefono: " + socioEliminado.getTelefono());
        System.out.println("correo: " + socioEliminado.getCorreo());
    }

    @Test
    public void testObtenerSocioPorId() {
        int id = 1; // id del socio a buscar
        System.out.println("Buscando el socio con id= " + id + "\n");

        // Instanciar la clase SocioDaoImpl
        SocioDaoImpl socioBaseDatos = new SocioDaoImpl();

        // El socioObtenido puede tener una tupla o puede tener null
        Socio socioObtenido = socioBaseDatos.obtenerSocioPorId(id);

        // Definimos las condiciones de fallo:
        assertNotNull("El socio obtenido es null", socioObtenido);

        // Mandamos a imprimir los detalles del socio obtenido a consola
        System.out.println("\n La tupla obtenida es: \n");
        System.out.println("id_socio: " + socioObtenido.getId_socio());
        System.out.println("nombre: " + socioObtenido.getNombre());
        System.out.println("apellidos: " + socioObtenido.getApellidos());
        System.out.println("dirección: " + socioObtenido.getDireccion());
        System.out.println("teléfono: " + socioObtenido.getTelefono());
        System.out.println("correo: " + socioObtenido.getCorreo());
    }

    @Test
    public void testObtenerTodosLosSocios() {

        SocioDaoImpl socioBaseDatos = new SocioDaoImpl();

        // El método obtenerTodosLosSocios devuelve una lista vacía si no encuentra nada en la base de datos
        List<Socio> listaDeSocios = socioBaseDatos.obtenerTodosLosSocios();

        // Definimos las condiciones de fallo
        assertFalse("La lista de socios está vacía", listaDeSocios.isEmpty());

        // Mandamos a imprimir los detalles de cada socio a consola
        System.out.println("\nListado de los socios: \n");
        for (Socio socioIndividual : listaDeSocios) {
            System.out.println("ID: " + socioIndividual.getId_socio());
            System.out.println("Nombre: " + socioIndividual.getNombre());
            System.out.println("Apellidos: " + socioIndividual.getApellidos());
            System.out.println("Dirección: " + socioIndividual.getDireccion());
            System.out.println("Teléfono: " + socioIndividual.getTelefono());
            System.out.println("Correo: " + socioIndividual.getCorreo());
            System.out.println("\n");
        }
    }

}
