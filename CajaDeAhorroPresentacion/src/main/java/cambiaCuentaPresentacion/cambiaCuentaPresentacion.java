/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cambiaCuentaPresentacion;

import CajaDeAhorro.bd.domain.Cuenta;
import CajaDeAhorro.dao.cuenta.CuentaDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loginPresentacion.VentanaAdministradorPresentacion;

/**
 *
 * @author Gamem
 */
public class cambiaCuentaPresentacion extends javax.swing.JFrame {

    /**
     * Creates new form cambiaCuenta
     */
    public cambiaCuentaPresentacion() {
        setTitle("Panel de Cambio de Cuenta"); // Añade un título a la ventana        setResizable(false); // Hace que el tamaño de la ventana sea fijo
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); // Hace que el tamaño de la ventana sea fijo
        cargarCuentas();
    }

    public void limpiar() {

    }

    public void cargarCuentas() {
        CuentaDaoImpl enlace = new CuentaDaoImpl();
        java.util.List<Cuenta> listaDeCuentas = enlace.obtenerTodasLasCuentas();

        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Numero Cuenta");
        modeloTabla.addColumn("Tasa de interes");
        modeloTabla.addColumn("Estatus de la cuenta");
        modeloTabla.addColumn("Saldo");
        modeloTabla.addColumn("Tipo");

        for (Cuenta usuario : listaDeCuentas) {
            modeloTabla.addRow(new Object[]{usuario.getNumeroCuenta(), usuario.getTasaInteres(), usuario.getEstatusCuenta(), usuario.getSaldo(), usuario.getTipo()});
        }
        tablaCuenta.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuenta = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        inNumCuenta = new javax.swing.JTextField();
        inTasaInteres = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        inEstatus = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        inSaldo = new javax.swing.JTextField();
        botonActualizarSocio = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        inTipo = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        btnRegresar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PANEL DE CONTROL DE SOCIOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PANEL DE CAMBIO DE CUENTA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 440, 40));

        tablaCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero Cuenta", "Tasa de  interes", "Estatus de la cuenta", "Saldo", "Tipo"
            }
        ));
        tablaCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCuentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCuenta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 570, 350));

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextPane1.setText("Lista de todos los socios");
        jTextPane1.setToolTipText("");
        jTextPane1.setCaretColor(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 570, 40));

        inNumCuenta.setEditable(false);
        inNumCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inNumCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(inNumCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 200, 30));

        inTasaInteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTasaInteresActionPerformed(evt);
            }
        });
        jPanel1.add(inTasaInteres, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 200, 30));

        jTextPane3.setEditable(false);
        jTextPane3.setText("Tasa de interes");
        jTextPane3.setToolTipText("");
        jScrollPane3.setViewportView(jTextPane3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, -1, -1));

        inEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inEstatusActionPerformed(evt);
            }
        });
        jPanel1.add(inEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 200, 30));

        jTextPane4.setEditable(false);
        jTextPane4.setText("Estatus de la cuenta");
        jTextPane4.setToolTipText("");
        jScrollPane5.setViewportView(jTextPane4);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        jTextPane5.setEditable(false);
        jTextPane5.setText("Saldo");
        jScrollPane6.setViewportView(jTextPane5);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, -1, -1));

        inSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(inSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 200, 30));

        botonActualizarSocio.setBackground(new java.awt.Color(131, 46, 5));
        botonActualizarSocio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonActualizarSocio.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizarSocio.setText("ACTUALIZAR");
        botonActualizarSocio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActualizarSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonActualizarSocioMouseClicked(evt);
            }
        });
        botonActualizarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarSocioActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizarSocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, 120, 40));

        jTextPane6.setEditable(false);
        jTextPane6.setText("Numero Cuenta");
        jScrollPane7.setViewportView(jTextPane6);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));

        inTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTipoActionPerformed(evt);
            }
        });
        jPanel1.add(inTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 200, 30));

        jTextPane7.setEditable(false);
        jTextPane7.setText("Tipo");
        jScrollPane8.setViewportView(jTextPane7);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, -1, -1));

        btnRegresar1.setBackground(new java.awt.Color(131, 46, 5));
        btnRegresar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar1.setText("REGRESAR");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jonatan Eduardo\\Documents\\GitHub\\Caja-De-Ahorro\\CajaDeAhorroPresentacion\\src\\main\\java\\Img\\fondo2.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1090, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inNumCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inNumCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inNumCuentaActionPerformed

    private void inTasaInteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTasaInteresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTasaInteresActionPerformed

    private void inEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inEstatusActionPerformed

    private void inSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inSaldoActionPerformed

    private void botonActualizarSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarSocioMouseClicked
        // TODO add your handling code here:
        if (inNumCuenta.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un elemento de la tabla", "Error al actualizar", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de querer actualizar este usuario?", "Actualizar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmacion == JOptionPane.YES_OPTION) {
                Cuenta nuevaCuenta = new Cuenta();

                nuevaCuenta.setNumeroCuenta(Integer.parseInt(inNumCuenta.getText()));
                nuevaCuenta.setTasaInteres(Float.parseFloat(inTasaInteres.getText()));
                nuevaCuenta.setEstatusCuenta(Integer.parseInt(inEstatus.getText()));
                nuevaCuenta.setSaldo(Float.parseFloat(inSaldo.getText()));
                nuevaCuenta.setTipo(inTipo.getText());

                CuentaDaoImpl enlace = new CuentaDaoImpl();
                enlace.actualizarCuenta(Integer.parseInt(inNumCuenta.getText()), nuevaCuenta);
                JOptionPane.showMessageDialog(this, "Socio actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                cargarCuentas();
            } else {
                // Socio ha seleccionado "No" (Cancelar)
                System.out.println("El usuario ha cancelado la actualizacion del rol.");
            }

        }
    }//GEN-LAST:event_botonActualizarSocioMouseClicked

    private void botonActualizarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarSocioActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_botonActualizarSocioActionPerformed

    private void inTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inTipoActionPerformed

    private void tablaCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCuentaMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = tablaCuenta.getSelectedRow();

        // Verificar que la fila seleccionada sea válida
        if (filaSeleccionada != -1) {
            // Obtener los valores de las celdas de la fila seleccionada
            Object numCuenta = tablaCuenta.getValueAt(filaSeleccionada, 0);
            Object tasaInteres = tablaCuenta.getValueAt(filaSeleccionada, 1);
            Object Estatus = tablaCuenta.getValueAt(filaSeleccionada, 2);
            Object Saldo = tablaCuenta.getValueAt(filaSeleccionada, 3);
            Object Tipo = tablaCuenta.getValueAt(filaSeleccionada, 4);

            // Mostrar los valores en los JTextField correspondientes
            inNumCuenta.setText(numCuenta.toString());
            inSaldo.setText(Saldo.toString());
            inEstatus.setText(Estatus.toString());
            inTasaInteres.setText(tasaInteres.toString());
            inTipo.setText(Tipo.toString());
        }
    }//GEN-LAST:event_tablaCuentaMouseClicked

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        // TODO add your handling code here:
        VentanaAdministradorPresentacion abrir = new VentanaAdministradorPresentacion();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

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
            java.util.logging.Logger.getLogger(cambiaCuentaPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cambiaCuentaPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cambiaCuentaPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cambiaCuentaPresentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cambiaCuentaPresentacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarSocio;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JTextField inEstatus;
    private javax.swing.JTextField inNumCuenta;
    private javax.swing.JTextField inSaldo;
    private javax.swing.JTextField inTasaInteres;
    private javax.swing.JTextField inTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTable tablaCuenta;
    // End of variables declaration//GEN-END:variables
}