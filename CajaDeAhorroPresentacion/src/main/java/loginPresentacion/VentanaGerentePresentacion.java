/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginPresentacion;

import CajaDeAhorro.bd.domain.Cuenta;
import CajaDeAhorro.bd.domain.Rol;
import CajaDeAhorro.bd.domain.Socio;
import CajaDeAhorro.bd.domain.SolicitudPrestamo;
import CajaDeAhorro.bd.domain.Usuario;
import CajaDeAhorro.dao.Socio.SocioDaoImpl;
import CajaDeAhorro.dao.cuenta.CuentaDaoImpl;
import CajaDeAhorro.dao.rol.RolDaoImpl;
import CajaDeAhorro.dao.solicitudprestamo.SolicitudPrestamoDaoImpl;
import CajaDeAhorro.dao.usuario.UsuarioDaoImpl;
import com.itextpdf.text.BaseColor;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatan Eduardo
 */
public class VentanaGerentePresentacion extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaGerentePresentacion() {
        initComponents();
        setTitle("Bienvenido-Ventana-Gerente"); // Añade un título a la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); // Hace que el tamaño de la ventana sea fijo
        SetImageLabel(labelgerente, "src/main/java/Img/gerente.png");//para autopajustar laimagen al labael

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelgerente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1250, 680));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(131, 46, 5));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGRESAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        jLabel3.setFont(new java.awt.Font("Eras Demi ITC", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("INTERFAZ DE GERENTES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 460, 50));
        jPanel1.add(labelgerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 610, 390));

        jLabel4.setFont(new java.awt.Font("Eras Demi ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LISTA DE SERVICIOS DISPONIBLES PARA LOS GERENTES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 560, 50));

        jButton9.setBackground(new java.awt.Color(131, 46, 5));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("COLOCAR PERSONAS EN BURÓ DE CRÉDITO  (CU 30)");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 450, 50));

        jButton10.setBackground(new java.awt.Color(131, 46, 5));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("LISTADO DE EMPLEADOS DE LA CAJA DE AHORRO");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 450, 50));

        jButton8.setBackground(new java.awt.Color(131, 46, 5));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("PANEL DE CONTROL DE PRÉSTAMOS  (CU 16,17,18,22,23) RAM");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 450, 50));

        jButton11.setBackground(new java.awt.Color(131, 46, 5));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("ESTABLECER PARÁMETROS PARA LOS PRESTAMOS   (CU 20)  JOJA");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 450, 50));

        jButton12.setBackground(new java.awt.Color(131, 46, 5));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("CANCELACIÓN DE MOVIMIENTO FINANCIERO     (CU 7) GIZ");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 450, 50));

        jButton13.setBackground(new java.awt.Color(131, 46, 5));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("CREAR INFORME GENERAL DE LA BANCA");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 450, 50));

        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jonatan Eduardo\\Documents\\GitHub\\Caja-De-Ahorro\\CajaDeAhorroPresentacion\\src\\main\\java\\Img\\fondo2.jpg")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginPresentacion abrir = new LoginPresentacion();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Realmente deseas generar un reporte de la caja de ahorro?", "Ventana de confirmación", JOptionPane.YES_NO_OPTION);
        // Procesar la respuesta de la pregunta
        if (respuesta == JOptionPane.YES_OPTION) {
            Document reporteGeneral = new Document();
            Font fuenteAzul = new Font(Font.FontFamily.HELVETICA, 19, Font.NORMAL, BaseColor.BLUE);
            try {
                String rutaDeExportacion = System.getProperty("user.home");
                PdfWriter.getInstance(reporteGeneral, new FileOutputStream(rutaDeExportacion + "/Desktop/Reporte_General.pdf"));
                reporteGeneral.setMargins(28.35f, 28.35f, 28.35f, 28.35f);
                reporteGeneral.open();

                //INICIO DE LA TABLA DE USUARIOS----------------------------------------------------------------
                // Crear el título y agregarlo al documento
                Paragraph titulo = new Paragraph("Lista de Usuarios de la Caja de Ahorro",fuenteAzul);
                titulo.setAlignment(Paragraph.ALIGN_CENTER);
                reporteGeneral.add(titulo);

                // Espacio después del título
                reporteGeneral.add(new Paragraph(" "));

                // Crear la tabla y agregarla al documento
                PdfPTable tablaUsuarios = new PdfPTable(5);
                tablaUsuarios.setWidthPercentage(100);
                tablaUsuarios.addCell("ID USUARIO");
                tablaUsuarios.addCell("ID ROL");
                tablaUsuarios.addCell("NOMBRE DE USUARIO");
                tablaUsuarios.addCell("CORREO");
                tablaUsuarios.addCell("CONTRASEÑA");

                UsuarioDaoImpl enlace = new UsuarioDaoImpl();
                java.util.List<Usuario> listaUsuarios = enlace.obtenerTodosLosUsuarios();

                for (Usuario usuario : listaUsuarios) {
                    tablaUsuarios.addCell("" + usuario.getIdUsuario());
                    tablaUsuarios.addCell("" + usuario.getIdRol());
                    tablaUsuarios.addCell("" + usuario.getNombre());
                    tablaUsuarios.addCell("" + usuario.getCorreo());
                    tablaUsuarios.addCell("" + usuario.getContraseña());
                }
                reporteGeneral.add(tablaUsuarios);
                 //FIN DE LA TABLA DE USUARIOS----------------------------------------------------------------
                
                 //INICIO DE LA TABLA DE SOCIOS---------------------------------------------------------------
                reporteGeneral.add(new Paragraph(" "));
                Paragraph titulo2 = new Paragraph("Lista de Socios de la Caja de Ahorro",fuenteAzul);
                titulo2.setAlignment(Paragraph.ALIGN_CENTER);
                reporteGeneral.add(titulo2);

                // Espacio después del título
                reporteGeneral.add(new Paragraph(" "));

                // Crear la tabla y agregarla al documento
                PdfPTable tablaSocios = new PdfPTable(6);
                tablaSocios.setWidthPercentage(100);
                tablaSocios.addCell("ID SOCIO");
                tablaSocios.addCell("NOMBRE");
                tablaSocios.addCell("APELLIDOS");
                tablaSocios.addCell("DIRECCION");
                tablaSocios.addCell("TELEFONO");
                tablaSocios.addCell("CORREO");

                SocioDaoImpl enlace2 = new SocioDaoImpl();
                java.util.List<Socio> listaSocios = enlace2.obtenerTodosLosSocios();

                for (Socio socio : listaSocios) {
                    tablaSocios.addCell("" + socio.getId_socio());
                    tablaSocios.addCell("" + socio.getNombre());
                    tablaSocios.addCell("" + socio.getApellidos());
                    tablaSocios.addCell("" + socio.getDireccion());
                    tablaSocios.addCell("" + socio.getTelefono());
                    tablaSocios.addCell("" + socio.getCorreo());
                }
                reporteGeneral.add(tablaSocios);               
                 //FIN DE LA TABLA DE SOCIOS------------------------------------------------------------------
                 
                 
                //INICIO DE LA TABLA DE SOLICITUDES DE PRESTAMO---------------------------------------------------------------
                reporteGeneral.add(new Paragraph(" "));
                Paragraph titulo3 = new Paragraph("Lista de Solicitudes de Préstamo",fuenteAzul);
                titulo3.setAlignment(Paragraph.ALIGN_CENTER);
                reporteGeneral.add(titulo3);

                // Espacio después del título
                reporteGeneral.add(new Paragraph(" "));

                // Crear la tabla y agregarla al documento
                PdfPTable tablaSoliPrestamo = new PdfPTable(9);
                tablaSoliPrestamo.setWidthPercentage(100);
                tablaSoliPrestamo.addCell("ID SOLICITUD PRESTAMO");
                tablaSoliPrestamo.addCell("ID SOCIO");
                tablaSoliPrestamo.addCell("MONTO PRESTADO");
                tablaSoliPrestamo.addCell("TIPO DE PRESTAMO");
                tablaSoliPrestamo.addCell("FECHA DE SOLICITUD");
                tablaSoliPrestamo.addCell("PLAZO");
                tablaSoliPrestamo.addCell("# DE MONTOS");
                tablaSoliPrestamo.addCell("DESCRIPCION");
                tablaSoliPrestamo.addCell("ESTADO");

                SolicitudPrestamoDaoImpl enlace3 = new SolicitudPrestamoDaoImpl();
                java.util.List<SolicitudPrestamo> listaSolicitudes = enlace3.obtenerTodasLasSolicitudesPrestamo();

                for (SolicitudPrestamo soli : listaSolicitudes) {
                    tablaSoliPrestamo.addCell("" + soli.getIdSolicitudPrestamo());
                    tablaSoliPrestamo.addCell("" + soli.getIdSocio());
                    tablaSoliPrestamo.addCell("" + soli.getMontoPrestado());
                    tablaSoliPrestamo.addCell("" + soli.getTipoPrestamo());
                    tablaSoliPrestamo.addCell("" + soli.getFechaSolicitud());
                    tablaSoliPrestamo.addCell("" + soli.getPlazo());
                    tablaSoliPrestamo.addCell("" + soli.getNumMontos());
                    tablaSoliPrestamo.addCell("" + soli.getDescripcion());
                    tablaSoliPrestamo.addCell("" + soli.getEstado());
                }
                reporteGeneral.add(tablaSoliPrestamo);               
                 //FIN DE LA TABLA DE SOLICITUDES DE PRESTAMO------------------------------------------------------------------
                 
                 
                 //INICIO DE LA TABLA DE ROLES DE LA CAJA DE AHORRO---------------------------------------------------------------
                reporteGeneral.add(new Paragraph(" "));
                Paragraph titulo4 = new Paragraph("Lista de Roles en la caja de Ahorro",fuenteAzul);
                titulo4.setAlignment(Paragraph.ALIGN_CENTER);
                reporteGeneral.add(titulo4);

                // Espacio después del título
                reporteGeneral.add(new Paragraph(" "));

                // Crear la tabla y agregarla al documento
                PdfPTable tablaRoles = new PdfPTable(3);
                tablaRoles.setWidthPercentage(100);
                tablaRoles.addCell("ID DEL ROL");
                tablaRoles.addCell("NOMBRE");
                tablaRoles.addCell("DESCRIPCION");

                RolDaoImpl enlace4 = new RolDaoImpl();
                java.util.List<Rol> listaRoles = enlace4.obtenerTodosLosRoles();

                for (Rol rol : listaRoles) {
                    tablaRoles.addCell("" + rol.getIdRol());
                    tablaRoles.addCell("" + rol.getNombre());
                    tablaRoles.addCell("" + rol.getDescripcion());
                }
                reporteGeneral.add(tablaRoles);               
                 //FIN DE LA TABLA DE ROLES DE LA CAJA DE AHORRO------------------------------------------------------------------
                 
                 //INICIO DE LA TABLA DE ROLES DE LA CAJA DE AHORRO---------------------------------------------------------------
                reporteGeneral.add(new Paragraph(" "));
                Paragraph titulo5 = new Paragraph("Lista de Cuentas Activas en la Caja de Ahorro",fuenteAzul);
                titulo5.setAlignment(Paragraph.ALIGN_CENTER);
                reporteGeneral.add(titulo5);

                // Espacio después del título
                reporteGeneral.add(new Paragraph(" "));

                // Crear la tabla y agregarla al documento
                PdfPTable tablaCuentas = new PdfPTable(4);
                tablaCuentas.setWidthPercentage(100);
                tablaCuentas.addCell("# DE CUENTA");
                tablaCuentas.addCell("TAZA DE INTERES APLICADO");
                tablaCuentas.addCell("ESTATUS DE LA CUENTA");
                tablaCuentas.addCell("SALDO ACTUAL");

                CuentaDaoImpl enlace5 = new CuentaDaoImpl();
                java.util.List<Cuenta> listaCuentas = enlace5.obtenerTodasLasCuentas();

                for (Cuenta cuenta : listaCuentas) {
                    tablaCuentas.addCell("" + cuenta.getNumeroCuenta());
                    tablaCuentas.addCell("" + cuenta.getTasaInteres());
                    tablaCuentas.addCell("" + cuenta.getEstatusCuenta());
                    tablaCuentas.addCell("" + cuenta.getSaldo());
                }
                reporteGeneral.add(tablaCuentas);               
                 //FIN DE LA TABLA DE ROLES DE LA CAJA DE AHORRO------------------------------------------------------------------
                reporteGeneral.close();

            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Reporte Generado Exitosamente", "Ventana de Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaGerentePresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGerentePresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGerentePresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGerentePresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGerentePresentacion().setVisible(true);
            }
        });
    }

    private void SetImageLabel(JLabel Nombrelabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(Nombrelabel.getWidth(), Nombrelabel.getHeight(), Image.SCALE_DEFAULT));
        Nombrelabel.setIcon(icon);
        this.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelgerente;
    // End of variables declaration//GEN-END:variables
}
