/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rolPresentacion;

import CajaDeAhorro.bd.domain.Rol;
import CajaDeAhorro.dao.rol.RolDaoImpl;
import usuarioPresentacion.*;
import loginPresentacion.LoginPresentacion;
import java.awt.Image;
import java.awt.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import loginPresentacion.VentanaAdministradorPresentacion;

/**
 *
 * @author Jonatan Eduardo
 */
public class ConfiguracionRol extends javax.swing.JFrame {

    String tipoBusqueda = "ID Rol";

    /**
     * Creates new form ConfiguracionUsuario
     */
    public ConfiguracionRol() {
        initComponents();
        setTitle("Panel de control de Usuarios"); // Añade un título a la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); // Hace que el tamaño de la ventana sea fijo
        SetImageLabel(imgbuscar, "src/main/java/Img/lupa.png");//para autopajustar laimagen al labael
        cargarlistaRoles();
        txtIdRol.setEditable(false);
    }

    public void cargarlistaRoles() {
        RolDaoImpl enlace = new RolDaoImpl();
        java.util.List<Rol> listaDeRoles = enlace.obtenerTodosLosRoles();
        System.out.println(listaDeRoles);

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Rol");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripción");
        for (Rol rol : listaDeRoles) {
            modeloTabla.addRow(new Object[]{rol.getIdRol(), rol.getNombre(), rol.getDescripcion()});
        }
        tablaRoles.setModel(modeloTabla);
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
        txtBuscar = new javax.swing.JTextField();
        imgbuscar = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRoles = new javax.swing.JTable();
        txtIdRol = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        filtro = new javax.swing.JComboBox<>();
        btnEliminar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(991, 564));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 430, 30));
        jPanel1.add(imgbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 30, 30));

        btnRegresar.setBackground(new java.awt.Color(131, 46, 5));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        tablaRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Rol", "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaRoles.setSelectionBackground(new java.awt.Color(153, 51, 0));
        tablaRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRolesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tablaRolesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaRolesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRoles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 430, 250));

        txtIdRol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txtIdRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 270, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 270, -1));

        btnNuevo.setBackground(new java.awt.Color(131, 46, 5));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("AGREGAR NUEVO");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 180, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripcion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(131, 46, 5));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 100, 40));

        btnEliminar.setBackground(new java.awt.Color(7, 58, 33));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("LIstar todos los roles");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 430, 30));

        btnActualizar.setBackground(new java.awt.Color(131, 46, 5));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 120, 40));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PANEL DE CONTROL DE ROLES");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 520, 40));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 370, 140));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Rol:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        filtro.setBackground(new java.awt.Color(153, 51, 0));
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Rol", "Nombre" }));
        filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filtro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtroMouseClicked(evt);
            }
        });
        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });
        jPanel1.add(filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, 30));

        btnEliminar1.setBackground(new java.awt.Color(131, 46, 5));
        btnEliminar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setText("ELIMINAR");
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 120, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jonatan Eduardo\\Documents\\GitHub\\Caja-De-Ahorro\\CajaDeAhorroPresentacion\\src\\main\\java\\Img\\fondo2.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaAdministradorPresentacion abrir = new VentanaAdministradorPresentacion();
        abrir.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        InsertarRol abrir = new InsertarRol();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tablaRoles.removeAll();
        cargarlistaRoles();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (txtIdRol.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento de la tabla", "Error al actualizar", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de querer actualizar este rol?", "Actualizar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmacion == JOptionPane.YES_OPTION) {
                Rol nuevoRol = new Rol();
                int IdRol = (Integer.parseInt(txtIdRol.getText()));
                nuevoRol.setNombre(txtNombre.getText());
                nuevoRol.setDescripcion(txtDescripcion.getText());

                RolDaoImpl enlace = new RolDaoImpl();
                enlace.actualizarRol(IdRol, nuevoRol);
                JOptionPane.showMessageDialog(this, "Rol actualiazdo correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarlistaRoles();
                limpiar();
            } else {
                // Usuario ha seleccionado "No" (Cancelar)
                System.out.println("El usuario ha cancelado la actualizacion del rol.");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tablaRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolesMouseClicked

        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tablaRoles.getSelectedRow();

        // Verificar que la fila seleccionada sea válida
        if (filaSeleccionada != -1) {
            // Obtener los valores de las celdas de la fila seleccionada
            Object idRol = tablaRoles.getValueAt(filaSeleccionada, 0);
            Object nombre = tablaRoles.getValueAt(filaSeleccionada, 1);
            Object descripcion = tablaRoles.getValueAt(filaSeleccionada, 2);

            // Mostrar los valores en los JTextField correspondientes
            txtIdRol.setText(idRol.toString());
            txtNombre.setText(nombre.toString());
            txtDescripcion.setText(descripcion.toString());
        }
    }//GEN-LAST:event_tablaRolesMouseClicked

    private void tablaRolesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaRolesMouseExited

    private void tablaRolesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRolesMousePressed
        // TODO add your handling code here:


    }//GEN-LAST:event_tablaRolesMousePressed

    private void filtroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtroMouseClicked

    }//GEN-LAST:event_filtroMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        RolDaoImpl enlace = new RolDaoImpl();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Rol");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripción");
        if (tipoBusqueda.equalsIgnoreCase("Nombre")) {
            java.util.List<Rol> listaDeRoles = enlace.obtenerRolesByNombre(txtBuscar.getText());
            for (Rol rol : listaDeRoles) {
                modeloTabla.addRow(new Object[]{rol.getIdRol(), rol.getNombre(), rol.getDescripcion()});
            }
            tablaRoles.setModel(modeloTabla);
        }
        if (tipoBusqueda.equalsIgnoreCase("ID Rol")) {
            if (txtBuscar.getText().isEmpty() || !txtBuscar.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "El campo de búsqueda no puede estar vacío y no puede ser letra si busca por ID Rol", "Error al buscar", JOptionPane.ERROR_MESSAGE);
            } else {
                Rol rolEncontrado = enlace.obtenerRolPorId(Integer.parseInt(txtBuscar.getText()));
                if (rolEncontrado != null) {
                    modeloTabla.addRow(new Object[]{rolEncontrado.getIdRol(), rolEncontrado.getNombre(), rolEncontrado.getDescripcion()});
                    tablaRoles.setModel(modeloTabla);
                }else
                {
                    System.out.println("Hay que limpiar la tabla");
                    modeloTabla.addRow(new Object[]{"", "", ""});
                    tablaRoles.setModel(modeloTabla);
                }

            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        // TODO add your handling code here:
        tipoBusqueda = (String) filtro.getSelectedItem();
        System.out.println(tipoBusqueda);
    }//GEN-LAST:event_filtroActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConfiguracionRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiguracionRol().setVisible(true);
            }
        });
    }

    private void SetImageLabel(JLabel Nombrelabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(Nombrelabel.getWidth(), Nombrelabel.getHeight(), Image.SCALE_DEFAULT));
        Nombrelabel.setIcon(icon);
        this.repaint();
    }

    public void limpiar() {
        txtIdRol.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JLabel imgbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaRoles;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
