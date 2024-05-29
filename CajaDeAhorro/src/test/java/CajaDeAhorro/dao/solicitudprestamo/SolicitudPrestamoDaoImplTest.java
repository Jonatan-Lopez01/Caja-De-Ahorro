/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CajaDeAhorro.dao.solicitudprestamo;

/**
 *
 * @author Ramses
 */

import CajaDeAhorro.bd.domain.SolicitudPrestamo;
import java.sql.Timestamp;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
public class SolicitudPrestamoDaoImplTest {
      public SolicitudPrestamoDaoImplTest() {
    }

    private SolicitudPrestamo crearSolicitudPrestamo(int id_socio, double monto_prestado, String tipo_prestamo, Timestamp fecha_solicitud, int plazo, int num_montos, String descripcion, String estado) {
        // Crear una nueva solicitud de préstamo localmente
        SolicitudPrestamo nuevaSolicitud = new SolicitudPrestamo();
        nuevaSolicitud.setIdSocio(id_socio);
        nuevaSolicitud.setMontoPrestado(monto_prestado);
        nuevaSolicitud.setTipoPrestamo(tipo_prestamo);
        nuevaSolicitud.setFechaSolicitud(fecha_solicitud);
        nuevaSolicitud.setPlazo(plazo);
        nuevaSolicitud.setNumMontos(num_montos);
        nuevaSolicitud.setDescripcion(descripcion);
        nuevaSolicitud.setEstado(estado);

        // Instanciar la clase SolicitudPrestamoDaoImpl
        SolicitudPrestamoDaoImpl solicitudBaseDatos = new SolicitudPrestamoDaoImpl();

        // Subir la solicitud local a la base de datos
        solicitudBaseDatos.crearSolicitudPrestamo(nuevaSolicitud);
        

        // Obtener la última solicitud creada en la base de datos
        SolicitudPrestamo solicitudCreada = solicitudBaseDatos.obtenerUltimaSolicitudPrestamo();

        // Verificar que la solicitud se haya creado correctamente
        assertNotNull("Fallo: La solicitud creada es nula, porque no se pudo obtener de la base de datos", solicitudCreada);
        assertEquals("El id de socio no coincide", nuevaSolicitud.getIdSocio(), solicitudCreada.getIdSocio());
        assertEquals("El monto prestado no coincide", nuevaSolicitud.getMontoPrestado(), solicitudCreada.getMontoPrestado(), 0.001);
        assertEquals("El tipo de préstamo no coincide", nuevaSolicitud.getTipoPrestamo(), solicitudCreada.getTipoPrestamo());
        assertEquals("La fecha de solicitud no coincide", nuevaSolicitud.getFechaSolicitud(), solicitudCreada.getFechaSolicitud());
        assertEquals("El plazo no coincide", nuevaSolicitud.getPlazo(), solicitudCreada.getPlazo());
        assertEquals("El número de montos no coincide", nuevaSolicitud.getNumMontos(), solicitudCreada.getNumMontos());
        assertEquals("La descripción no coincide", nuevaSolicitud.getDescripcion(), solicitudCreada.getDescripcion());
        assertEquals("El estado no coincide", nuevaSolicitud.getEstado(), solicitudCreada.getEstado());

        return solicitudCreada;
    }

    @Test
    public void testCrearSolicitudPrestamo() {
        SolicitudPrestamo solicitudCreada = crearSolicitudPrestamo(1, 5000.0, "Personal", Timestamp.valueOf("2024-05-29 00:00:00"), 24, 12, "Préstamo para vacaciones", "En revisión");

        System.out.println("\n La solicitud de préstamo insertada a la base de datos es : \n");
        System.out.println("id_solicitud_prestamo: " + solicitudCreada.getIdSolicitudPrestamo());
        System.out.println("id_socio: " + solicitudCreada.getIdSocio());
        System.out.println("monto_prestado: " + solicitudCreada.getMontoPrestado());
        System.out.println("tipo_prestamo: " + solicitudCreada.getTipoPrestamo());
        System.out.println("fecha_solicitud: " + solicitudCreada.getFechaSolicitud());
        System.out.println("plazo: " + solicitudCreada.getPlazo());
        System.out.println("num_montos: " + solicitudCreada.getNumMontos());
        System.out.println("descripcion: " + solicitudCreada.getDescripcion());
        System.out.println("estado: " + solicitudCreada.getEstado());
    }

    @Test
public void testEliminarSolicitudPrestamo() {
    // Crear una nueva solicitud antes de eliminarla
    SolicitudPrestamo solicitudCreada = crearSolicitudPrestamo(1, 5000.0, "Personal", Timestamp.valueOf("2024-05-29 00:00:00"), 24, 12, "Préstamo para vacaciones", "En revisión");
    System.out.println("\n La solicitud insertada a la base de datos es : \n");
    System.out.println("id_solicitud_prestamo: " + solicitudCreada.getIdSolicitudPrestamo());
    System.out.println("id_socio: " + solicitudCreada.getIdSocio());
    System.out.println("monto_prestado: " + solicitudCreada.getMontoPrestado());
    System.out.println("tipo_prestamo: " + solicitudCreada.getTipoPrestamo());
    System.out.println("fecha_solicitud: " + solicitudCreada.getFechaSolicitud());
    System.out.println("plazo: " + solicitudCreada.getPlazo());
    System.out.println("num_montos: " + solicitudCreada.getNumMontos());
    System.out.println("descripcion: " + solicitudCreada.getDescripcion());
    System.out.println("estado: " + solicitudCreada.getEstado());
    // Ahora procedemos a eliminar la solicitud recién creada
    int id = solicitudCreada.getIdSolicitudPrestamo(); // obtenemos el id de la solicitud creada

    // Instanciar la clase SolicitudPrestamoDaoImpl
    SolicitudPrestamoDaoImpl solicitudBaseDatos = new SolicitudPrestamoDaoImpl();

    // Procedemos a eliminar la solicitud
    solicitudBaseDatos.eliminarSolicitudPrestamo(id);

    // Verificar que la solicitud ha sido eliminada
    SolicitudPrestamo solicitudEliminada = solicitudBaseDatos.obtenerSolicitudPrestamoPorId(id);
    assertNull("La solicitud no se eliminó correctamente", solicitudEliminada);
}
@Test
public void testObtenerSolicitudPrestamoPorId() {
    int id = 12; // id de la solicitud a buscar
    System.out.println("Buscando la solicitud con id= " + id + "\n");

    // Instanciar la clase SolicitudPrestamoDaoImpl
    SolicitudPrestamoDaoImpl solicitudBaseDatos = new SolicitudPrestamoDaoImpl();

    // La solicitudObtenida puede tener una tupla o puede tener null
    SolicitudPrestamo solicitudObtenida = solicitudBaseDatos.obtenerSolicitudPrestamoPorId(id);

    // Definimos las condiciones de fallo:
    assertNotNull("La solicitud obtenida es null", solicitudObtenida);

    // Mandamos a imprimir los detalles de la solicitud obtenida a consola
    System.out.println("\n La tupla obtenida es: \n");
    System.out.println("id_solicitud_prestamo: " + solicitudObtenida.getIdSolicitudPrestamo());
    System.out.println("id_socio: " + solicitudObtenida.getIdSocio());
    System.out.println("monto_prestado: " + solicitudObtenida.getMontoPrestado());
    System.out.println("tipo_prestamo: " + solicitudObtenida.getTipoPrestamo());
    System.out.println("fecha_solicitud: " + solicitudObtenida.getFechaSolicitud());
    System.out.println("plazo: " + solicitudObtenida.getPlazo());
    System.out.println("num_montos: " + solicitudObtenida.getNumMontos());
    System.out.println("descripcion: " + solicitudObtenida.getDescripcion());
    System.out.println("estado: " + solicitudObtenida.getEstado());
}
@Test
public void testObtenerTodasLasSolicitudesPrestamo() {
    SolicitudPrestamoDaoImpl solicitudBaseDatos = new SolicitudPrestamoDaoImpl();

    // El metodo obtenerTodasLasSolicitudesPrestamo devuelve una lista vacía si no encuentra nada en la base de datos
    List<SolicitudPrestamo> listaDeSolicitudes = solicitudBaseDatos.obtenerTodasLasSolicitudesPrestamo();

    // Definimos las condiciones de fallo
    assertFalse("La lista de solicitudes está vacía", listaDeSolicitudes.isEmpty());

    // Mandamos a imprimir los detalles de cada solicitud a consola
    System.out.println("\nListado de las solicitudes: \n");
    for (SolicitudPrestamo solicitudIndividual : listaDeSolicitudes) {
        System.out.println("ID: " + solicitudIndividual.getIdSolicitudPrestamo());
        System.out.println("ID Socio: " + solicitudIndividual.getIdSocio());
        System.out.println("Monto Prestado: " + solicitudIndividual.getMontoPrestado());
        System.out.println("Tipo de Préstamo: " + solicitudIndividual.getTipoPrestamo());
        System.out.println("Fecha de Solicitud: " + solicitudIndividual.getFechaSolicitud());
        System.out.println("Plazo: " + solicitudIndividual.getPlazo());
        System.out.println("Número de Montos: " + solicitudIndividual.getNumMontos());
        System.out.println("Descripción: " + solicitudIndividual.getDescripcion());
        System.out.println("Estado: " + solicitudIndividual.getEstado());
        System.out.println("\n");
    }
}
@Test
public void testActualizarSolicitudPrestamo() {
    int id = 12; // id de la solicitud a actualizar

    // Crear una nueva solicitud localmente, simulando la obtención de datos desde un formulario
    SolicitudPrestamo solicitudLocal = new SolicitudPrestamo();
    solicitudLocal.setIdSocio(1);
    solicitudLocal.setMontoPrestado(5000.0);
    solicitudLocal.setTipoPrestamo("Personal");
    solicitudLocal.setFechaSolicitud(Timestamp.valueOf("2024-05-29 00:00:00"));
    solicitudLocal.setPlazo(12);
    solicitudLocal.setDescripcion("Préstamo para vacaciones");
    solicitudLocal.setEstado("Aceptado");

    // Obtener la solicitud actual de la base de datos
    SolicitudPrestamoDaoImpl solicitudBaseDatos = new SolicitudPrestamoDaoImpl();
    SolicitudPrestamo solicitudDeLaBaseDeDatos = solicitudBaseDatos.obtenerSolicitudPrestamoPorId(id);

    // Verificar que la solicitud existe antes de actualizarla
    assertNotNull("Fallo: No se encontró una solicitud con el ID proporcionado", solicitudDeLaBaseDeDatos);

    // Mostrar los detalles de la solicitud actual
    System.out.println("\nDetalles de la solicitud actual\n");
    System.out.println("ID Socio: " + solicitudDeLaBaseDeDatos.getIdSocio());
    System.out.println("Monto Prestado: " + solicitudDeLaBaseDeDatos.getMontoPrestado());
    System.out.println("Tipo de Préstamo: " + solicitudDeLaBaseDeDatos.getTipoPrestamo());
    System.out.println("Fecha de Solicitud: " + solicitudDeLaBaseDeDatos.getFechaSolicitud());
    System.out.println("Plazo: " + solicitudDeLaBaseDeDatos.getPlazo());
    System.out.println("Descripción: " + solicitudDeLaBaseDeDatos.getDescripcion());
    System.out.println("Estado: " + solicitudDeLaBaseDeDatos.getEstado());

    // Mostrar los cambios en los detalles de la solicitud (localmente)
    System.out.println("\nCambios en los detalles para la solicitud (localmente)\n");
    System.out.println("ID Socio: " + solicitudLocal.getIdSocio());
    System.out.println("Monto Prestado: " + solicitudLocal.getMontoPrestado());
    System.out.println("Tipo de Préstamo: " + solicitudLocal.getTipoPrestamo());
    System.out.println("Fecha de Solicitud: " + solicitudLocal.getFechaSolicitud());
    System.out.println("Plazo: " + solicitudLocal.getPlazo());
    System.out.println("Descripción: " + solicitudLocal.getDescripcion());
    System.out.println("Estado: " + solicitudLocal.getEstado() + "\n");

    // Actualizar la solicitud en la base de datos
    solicitudBaseDatos.actualizarSolicitudPrestamo(id, solicitudLocal);

    // Obtener la solicitud actualizada de la base de datos
    solicitudDeLaBaseDeDatos = solicitudBaseDatos.obtenerSolicitudPrestamoPorId(id);

    // Definir las condiciones de fallo
    assertEquals("El ID de socio no coincide", solicitudLocal.getIdSocio(), solicitudDeLaBaseDeDatos.getIdSocio());
    assertEquals("El monto prestado no coincide", solicitudLocal.getMontoPrestado(), solicitudDeLaBaseDeDatos.getMontoPrestado(), 0.01);
    assertEquals("El tipo de préstamo no coincide", solicitudLocal.getTipoPrestamo(), solicitudDeLaBaseDeDatos.getTipoPrestamo());
    assertEquals("La fecha de solicitud no coincide", solicitudLocal.getFechaSolicitud(), solicitudDeLaBaseDeDatos.getFechaSolicitud());
    assertEquals("El plazo no coincide", solicitudLocal.getPlazo(), solicitudDeLaBaseDeDatos.getPlazo());
    assertEquals("La descripción no coincide", solicitudLocal.getDescripcion(), solicitudDeLaBaseDeDatos.getDescripcion());
    assertEquals("El estado no coincide", solicitudLocal.getEstado(), solicitudDeLaBaseDeDatos.getEstado());

    // Mostrar en consola los cambios en los detalles de la solicitud en la base de datos
    System.out.println("\nDetalles de la solicitud actualizada en la base de datos\n");
    System.out.println("ID Socio: " + solicitudDeLaBaseDeDatos.getIdSocio());
    System.out.println("Monto Prestado: " + solicitudDeLaBaseDeDatos.getMontoPrestado());
    System.out.println("Tipo de Préstamo: " + solicitudDeLaBaseDeDatos.getTipoPrestamo());
    System.out.println("Fecha de Solicitud: " + solicitudDeLaBaseDeDatos.getFechaSolicitud());
    System.out.println("Plazo: " + solicitudDeLaBaseDeDatos.getPlazo());
    System.out.println("Descripción: " + solicitudDeLaBaseDeDatos.getDescripcion());
    System.out.println("Estado: " + solicitudDeLaBaseDeDatos.getEstado());
}

}
