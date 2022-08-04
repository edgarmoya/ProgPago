package visual;

import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.awt.Color;
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
        jpIdentificacion = new javax.swing.JPanel();
        jlUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfPassword = new custom_swing.PasswordField();
        jtfUsuario = new custom_swing.TextField();
        btnAceptar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        labelCancelar = new javax.swing.JLabel();
        jlFondoHex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Configurar conexión de datos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpParametros.setBackground(new java.awt.Color(255, 255, 255));
        jpParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)), "PARÁMETROS DE ACCESO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Calibri", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        jpParametros.setForeground(new java.awt.Color(0, 0, 0));
        jpParametros.setOpaque(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/earth.png"))); // NOI18N

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

        javax.swing.GroupLayout jpParametrosLayout = new javax.swing.GroupLayout(jpParametros);
        jpParametros.setLayout(jpParametrosLayout);
        jpParametrosLayout.setHorizontalGroup(
            jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParametrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpParametrosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbBD, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpBackground.add(jpParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 330, 170));

        jpIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        jpIdentificacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)), "IDENTIFICACIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Calibri", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        jpIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        jpIdentificacion.setOpaque(false);

        jlUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pass.png"))); // NOI18N

        jtfPassword.setToolTipText("Inserte su contraseña");
        jtfPassword.setLabelText("CONTRASEÑA");
        jtfPassword.setOpaque(false);
        jtfPassword.setShowAndHide(true);
        jtfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPasswordKeyReleased(evt);
            }
        });

        jtfUsuario.setToolTipText("Inserte su nombre de usuario");
        jtfUsuario.setLabelText("USUARIO");
        jtfUsuario.setOpaque(false);

        javax.swing.GroupLayout jpIdentificacionLayout = new javax.swing.GroupLayout(jpIdentificacion);
        jpIdentificacion.setLayout(jpIdentificacionLayout);
        jpIdentificacionLayout.setHorizontalGroup(
            jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIdentificacionLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jpIdentificacionLayout.setVerticalGroup(
            jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIdentificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIdentificacionLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpBackground.add(jpIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 140));

        btnAceptar.setBackground(new java.awt.Color(45, 125, 246));
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAceptarMouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aceptar");

        javax.swing.GroupLayout btnAceptarLayout = new javax.swing.GroupLayout(btnAceptar);
        btnAceptar.setLayout(btnAceptarLayout);
        btnAceptarLayout.setHorizontalGroup(
            btnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
            .addGroup(btnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAceptarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnAceptarLayout.setVerticalGroup(
            btnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(btnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnAceptarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jpBackground.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 110, 30));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(45, 125, 246), new java.awt.Color(45, 125, 246), new java.awt.Color(45, 125, 246), new java.awt.Color(45, 125, 246)));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });

        labelCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCancelar.setForeground(new java.awt.Color(45, 125, 246));
        labelCancelar.setText("Cancelar");

        javax.swing.GroupLayout btnCancelarLayout = new javax.swing.GroupLayout(btnCancelar);
        btnCancelar.setLayout(btnCancelarLayout);
        btnCancelarLayout.setHorizontalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCancelarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelCancelar)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnCancelarLayout.setVerticalGroup(
            btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
            .addGroup(btnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCancelarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelCancelar)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jpBackground.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 110, 30));

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
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbServidorMouseClicked
        buscarBD();
    }//GEN-LAST:event_jcbServidorMouseClicked

    private void jcbServidorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbServidorItemStateChanged
        buscarBD();
    }//GEN-LAST:event_jcbServidorItemStateChanged

    private void jtfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPasswordKeyReleased
        buscarBD();
    }//GEN-LAST:event_jtfPasswordKeyReleased

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        //Color del botón cuando el mouse está encima
        btnAceptar.setBackground(new Color(32,112,233));
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        //Color del botón cuando el mouse no está encima
        btnAceptar.setBackground(new Color(45,125,246));
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        //Color del botón cuando es presionado
        btnAceptar.setBackground(new Color(20,100,221));
    }//GEN-LAST:event_btnAceptarMousePressed

    private void btnAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseReleased
        //Color del botón luego de ser presionado
        btnAceptar.setBackground(new Color(45,125,246));
    }//GEN-LAST:event_btnAceptarMouseReleased

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        //Color del botón cuando el mouse está encima
        btnCancelar.setBackground(new Color(242,242,242));
        labelCancelar.setForeground(new Color(32,112,233));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        //Color del botón cuando el mouse no está encima
        btnCancelar.setBackground(new Color(255,255,255));
        labelCancelar.setForeground(new Color(45,125,246));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        //Color del botón cuando es presionado
        btnCancelar.setBackground(new Color(230,230,230));
        labelCancelar.setForeground(new Color(20,100,221));      
    }//GEN-LAST:event_btnCancelarMousePressed

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        //Color del botón luego de ser presionado
        btnCancelar.setBackground(new Color(255,255,255));
        labelCancelar.setForeground(new Color(45,125,246));
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
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
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        JD_Login JDLogin = new JD_Login(null, true);                
        goTo.dialog(this, JDLogin);
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JD_Login JDLogin = new JD_Login(null, true);                
        goTo.dialog(this, JDLogin);
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JPanel btnAceptar;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private custom_swing.Combobox jcbBD;
    private custom_swing.Combobox jcbServidor;
    private javax.swing.JLabel jlFondoHex;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpIdentificacion;
    private javax.swing.JPanel jpParametros;
    private custom_swing.PasswordField jtfPassword;
    private custom_swing.TextField jtfUsuario;
    private javax.swing.JLabel labelCancelar;
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
