package visual;

import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ppago.Login;
import utiles.autoComplete;
import utiles.goTo;
import utiles.keyboradUtil;

/**
 *
 * @author Edgar Moya
 */
public class JD_LoginBD extends javax.swing.JDialog {
  
    public JD_LoginBD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage()); 
        
        buscarServidor();  
        siguienteCampo();
    }
    
    
    public Image getIconImage (){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ic_config.png"));
        return res;
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        jpParametros = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcbServidor = new custom_swing.Combobox();
        jtfPuerto = new custom_swing.TextField();
        jLabel9 = new javax.swing.JLabel();
        jcbBD = new custom_swing.Combobox();
        jLabel8 = new javax.swing.JLabel();
        jpIdentificacion = new javax.swing.JPanel();
        jlUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfPassword = new custom_swing.PasswordField();
        jtfUsuario = new custom_swing.TextField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();
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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_server.png"))); // NOI18N

        jcbServidor.setToolTipText("Seleccione el servidor");
        jcbServidor.setLabeText("SERVIDOR*");
        jcbServidor.setOpaque(false);
        jcbServidor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbServidorItemStateChanged(evt);
            }
        });
        jcbServidor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbServidorFocusGained(evt);
            }
        });
        jcbServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbServidorMouseClicked(evt);
            }
        });

        jtfPuerto.setText("5432");
        jtfPuerto.setToolTipText("Inserte el puerto");
        jtfPuerto.setLabelText("PUERTO*");
        jtfPuerto.setOpaque(false);
        jtfPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPuertoKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_port.png"))); // NOI18N

        jcbBD.setToolTipText("Seleccione la base de datos");
        jcbBD.setLabeText("BASE DE DATOS*");
        jcbBD.setOpaque(false);
        jcbBD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcbBDFocusGained(evt);
            }
        });
        jcbBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbBDKeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_bd.png"))); // NOI18N

        javax.swing.GroupLayout jpParametrosLayout = new javax.swing.GroupLayout(jpParametros);
        jpParametros.setLayout(jpParametrosLayout);
        jpParametrosLayout.setHorizontalGroup(
            jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpParametrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbBD, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jtfPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jpParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbBD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jpBackground.add(jpParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 330, 240));

        jpIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        jpIdentificacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204)), "IDENTIFICACIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Calibri", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        jpIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        jpIdentificacion.setOpaque(false);

        jlUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_user.png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_pass.png"))); // NOI18N

        jtfPassword.setToolTipText("Inserte su contraseña");
        jtfPassword.setLabelText("CONTRASEÑA*");
        jtfPassword.setOpaque(false);
        jtfPassword.setShowAndHide(true);
        jtfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPasswordKeyReleased(evt);
            }
        });

        jtfUsuario.setToolTipText("Inserte su nombre de usuario");
        jtfUsuario.setLabelText("USUARIO*");
        jtfUsuario.setOpaque(false);
        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyReleased(evt);
            }
        });

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
                .addGroup(jpIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Loguerse en el servidor");
        btnAceptar.setEnabled(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jpBackground.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 110, 30));

        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(45, 125, 246)));
        btnCancelar.setForeground(new java.awt.Color(45, 125, 246));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cerrar diálogo");
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jpBackground.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 110, 30));

        jlFondoHex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        jpBackground.add(jlFondoHex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 360));

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

    private void jcbServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbServidorMouseClicked
        buscarBD();
        camposRequeridos();
    }//GEN-LAST:event_jcbServidorMouseClicked

    private void jcbServidorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbServidorItemStateChanged
        buscarBD();
    }//GEN-LAST:event_jcbServidorItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JD_Login JDLogin = new JD_Login(null, true);                
        goTo.dialog(this, JDLogin);
    }//GEN-LAST:event_formWindowClosing

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Obtener los datos ingresados de los campos correspondientes
        String username = jtfUsuario.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        String host = (String) jcbServidor.getSelectedItem();
        String port = jtfPuerto.getText();
        String bd = (String) jcbBD.getSelectedItem();

        try {
            if (Login.validarBD(username, password, host, port, bd)) {
                JOptionPane.showMessageDialog(this, "Conexión establecida exitosamente.", "Conectado", JOptionPane.INFORMATION_MESSAGE);                
                //Ir nuevamente al login
                JD_Login JDLogin = new JD_Login(null, true);                
                goTo.dialog(this, JDLogin);

            } else {
                JOptionPane.showMessageDialog(this, "La base de datos elegida no es válida, vuelva a intentarlo.", "Error", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JD_Login JDLogin = new JD_Login(null, true);                
        goTo.dialog(this, JDLogin);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfPuertoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPuertoKeyReleased
        camposRequeridos();
        if (jtfPuerto.getText().length() == 4){
             buscarBD();
        }       
    }//GEN-LAST:event_jtfPuertoKeyReleased

    private void jtfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfUsuarioKeyReleased

    private void jtfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPasswordKeyReleased
        buscarBD();
        camposRequeridos();    
    }//GEN-LAST:event_jtfPasswordKeyReleased

    private void jcbBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbBDKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jcbBDKeyReleased

    private void jcbBDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbBDFocusGained
        buscarBD();
        camposRequeridos();
    }//GEN-LAST:event_jcbBDFocusGained

    private void jcbServidorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcbServidorFocusGained
        camposRequeridos();
    }//GEN-LAST:event_jcbServidorFocusGained

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
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private custom_swing.Combobox jcbBD;
    private custom_swing.Combobox jcbServidor;
    private javax.swing.JLabel jlFondoHex;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpIdentificacion;
    private javax.swing.JPanel jpParametros;
    private custom_swing.PasswordField jtfPassword;
    private custom_swing.TextField jtfPuerto;
    private custom_swing.TextField jtfUsuario;
    // End of variables declaration//GEN-END:variables

    // Buscar servidores disponibles
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

            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbServidor, veDatos);
        } catch (UnknownHostException ex) {
            //no mostrar nada, no le saldrá al usuario ningun servidor a elegir
        } catch (SocketException ex) {
            //no mostrar nada, no le saldrá al usuario ningun servidor a elegir
        }
    }

    // Buscar BDs disponibles
    private void buscarBD() {
        //Obtener el usuario, contraseña, servidor y puerto de los campos correspondientes
        String username = jtfUsuario.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        String host = (String) jcbServidor.getSelectedItem();
        String port = jtfPuerto.getText();

        //Limpiar ComboBox
        jcbBD.removeAllItems();

        try {
            //Obtener las base de datos en una lista
            ArrayList<String> lista = Login.getListaBD(username, password, host, port);

            //Copiar la lista a un arreglo
            String[] veDatos = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                veDatos[i] = lista.get(i).toString();
            }

            autoComplete.setAutoComplete(jcbBD, veDatos);
        } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Error al conectar con el postgresql.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            //no mostrar nada, no le saldrá al usuario ninguna BD a elegir
        }
    }
    
    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfUsuario, jtfPassword);
        keyboradUtil.siguienteCampo(jtfPassword, jcbServidor);
        keyboradUtil.siguienteCampo(jcbServidor, jtfPuerto);
        keyboradUtil.siguienteCampo(jtfPuerto, jcbBD);
        keyboradUtil.siguienteCampo(jcbBD, btnAceptar, btnCancelar);
    }
    
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        String servidor = (jcbServidor.getSelectedIndex()!=-1) ? jcbServidor.getSelectedItem().toString() : "";
        String bd = (jcbBD.getSelectedIndex()!=-1) ? jcbBD.getSelectedItem().toString() : "";
        if (jtfUsuario.getText().isEmpty() || String.valueOf(jtfPassword.getPassword()).isEmpty() ||
                servidor.isEmpty() || jtfPuerto.getText().isEmpty() || bd.isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }  
}
