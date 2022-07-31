package visual;

import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ppago.Login;
import utiles.autoComplete;
import utiles.goTo;

public class JD_LoginBD extends javax.swing.JDialog {

    //Arreglar todas las excepciones
    public JD_LoginBD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        buscarServidor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        jpParametros = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbServidor = new custom_swing.Combobox();
        jcbBD = new custom_swing.Combobox();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jpIdentificacion = new javax.swing.JPanel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfPassword = new custom_swing.PasswordField();
        jlFondoHex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar conexión de datos");
        setResizable(false);

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpParametros.setBackground(new java.awt.Color(255, 255, 255));
        jpParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(102, 102, 102)), "PARÁMETROS DE ACCESO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Calibri", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        jpParametros.setForeground(new java.awt.Color(0, 0, 0));
        jpParametros.setOpaque(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/globe.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file.png"))); // NOI18N

        jcbServidor.setLabeText("SERVIDOR");
        jcbServidor.setOpaque(false);
        jcbServidor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbServidorItemStateChanged(evt);
            }
        });
        jcbServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbServidorMouseClicked(evt);
            }
        });

        jcbBD.setLabeText("BASE DE DATOS");
        jcbBD.setOpaque(false);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpParametrosLayout = new javax.swing.GroupLayout(jpParametros);
        jpParametros.setLayout(jpParametrosLayout);
        jpParametrosLayout.setHorizontalGroup(
            jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParametrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpParametrosLayout.createSequentialGroup()
                                .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbBD, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jpParametrosLayout.setVerticalGroup(
            jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParametrosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbBD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jpBackground.add(jpParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 330, 210));

        jpIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        jpIdentificacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(102, 102, 102)), "IDENTIFICACIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Calibri", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        jpIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        jpIdentificacion.setOpaque(false);

        jtfUsuario.setToolTipText("Inserte su nombre de usuario");
        jtfUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(45, 125, 246)));
        jtfUsuario.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("USUARIO");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/username.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lock.png"))); // NOI18N

        jtfPassword.setToolTipText("Inserte su contraseña");
        jtfPassword.setLabelText("CONTRASEÑA");
        jtfPassword.setOpaque(false);
        jtfPassword.setShowAndHide(true);
        jtfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jpIdentificacionLayout = new javax.swing.GroupLayout(jpIdentificacion);
        jpIdentificacion.setLayout(jpIdentificacionLayout);
        jpIdentificacionLayout.setHorizontalGroup(
            jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIdentificacionLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpIdentificacionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jpIdentificacionLayout.setVerticalGroup(
            jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIdentificacionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpIdentificacionLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5))
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpBackground.add(jpIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 140));

        jlFondoHex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        jpBackground.add(jlFondoHex, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 0, -1, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        //Obtener los datos ingresados de los campos correspondientes
        String username = jtfUsuario.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        String host = (String) jcbServidor.getSelectedItem();
        String bd = (String) jcbBD.getSelectedItem();

        try {
            if (Login.validarBD(username, password, host, bd)) {
                JOptionPane.showMessageDialog(this, "Conexión establecida exitosamente.", "Conectado", JOptionPane.INFORMATION_MESSAGE);                
                //Ir nuevamente al login
                JD_Login JDLogin = new JD_Login(null, true);                
                goTo.dialog(this, JDLogin);

            } else {
                JOptionPane.showMessageDialog(this, "Compruebe los datos ingresados y vuelva a intentarlo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FaltanDatosException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException cex) {
            JOptionPane.showMessageDialog(this, cex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos \"" + bd + "\".", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "Error al guardar la conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        JD_Login JDLogin = new JD_Login(null, true);                
        goTo.dialog(this, JDLogin);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jcbServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbServidorMouseClicked
        buscarBD();
    }//GEN-LAST:event_jcbServidorMouseClicked

    private void jcbServidorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbServidorItemStateChanged
        buscarBD();
    }//GEN-LAST:event_jcbServidorItemStateChanged

    private void jtfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPasswordKeyReleased
        buscarBD();
    }//GEN-LAST:event_jtfPasswordKeyReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_LoginBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_LoginBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_LoginBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_LoginBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_LoginBD dialog = new JD_LoginBD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private custom_swing.Combobox jcbBD;
    private custom_swing.Combobox jcbServidor;
    private javax.swing.JLabel jlFondoHex;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpIdentificacion;
    private javax.swing.JPanel jpParametros;
    private custom_swing.PasswordField jtfPassword;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables

    private void buscarServidor() {
        //Limpiar ComboBox
        jcbServidor.removeAllItems();

        try {
            ArrayList<String> lista = Login.getServidores();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                veDatos[i] = lista.get(i).toString();
            }

            //Agregar datos al comoBox
            autoComplete.setAutoComplete(jcbServidor, veDatos);
        } catch (UnknownHostException ex) {
            //joptionpane
        } catch (SocketException ex) {
            //joptionpane
        }
    }

    private void buscarBD() {
        //Obtener el usuario, contraseña y servidor de los campos correspondientes
        String username = jtfUsuario.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        String host = (String) jcbServidor.getSelectedItem();

        //Limpiar ComboBox
        jcbBD.removeAllItems();

        try {
            //Obtener las base de datos en una lista
            ArrayList<String> lista = Login.getListaBD(username, password, host);

            //Copiar la lista a un arreglo
            String[] veDatos = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                veDatos[i] = lista.get(i).toString();
            }

            autoComplete.setAutoComplete(jcbBD, veDatos);
        } catch (ClassNotFoundException ex) {
            //joptionpane
        } catch (SQLException ex) {
            //joptionpane
        }
    }
}
