package visual;

import entidades.Tesorero;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ppago.ConexionPg;
import ppago.Login;
import utiles.goTo;

public class JD_Login extends javax.swing.JDialog {

    private ConexionPg connPg;
    private String CAMBIAR = "<html><u>CAMBIAR</u></html>";
    private String CONECTAR = "<html><u>CONECTAR</u></html>";

    public JD_Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        conectarBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        jlUsuario = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        ic_username = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        ic_password = new javax.swing.JLabel();
        jlPassword = new javax.swing.JLabel();
        jlServidor = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();
        jlHiperv = new javax.swing.JLabel();
        jlFondoHex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setResizable(false);

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlUsuario.setBackground(new java.awt.Color(102, 102, 102));
        jlUsuario.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jlUsuario.setForeground(new java.awt.Color(102, 102, 102));
        jlUsuario.setText("USUARIO");
        jpBackground.add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jtfUsuario.setToolTipText("Inserte su nombre de usuario");
        jtfUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(45, 125, 246)));
        jtfUsuario.setOpaque(false);
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        jpBackground.add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 250, 26));

        ic_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/username.png"))); // NOI18N
        jpBackground.add(ic_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 25));

        jtfPassword.setToolTipText("Inserte su contraseña");
        jtfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(45, 125, 246)));
        jtfPassword.setOpaque(false);
        jtfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPasswordActionPerformed(evt);
            }
        });
        jpBackground.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 250, 27));

        ic_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lock.png"))); // NOI18N
        jpBackground.add(ic_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jlPassword.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        jlPassword.setForeground(new java.awt.Color(102, 102, 102));
        jlPassword.setText("CONTRASEÑA");
        jpBackground.add(jlPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jlServidor.setForeground(new java.awt.Color(102, 102, 102));
        jlServidor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlServidor.setText("Establecer conexion con el servidor");
        jlServidor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlServidorMouseClicked(evt);
            }
        });
        jpBackground.add(jlServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 210, 130, -1));

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jpBackground.add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 115, 30));

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jpBackground.add(jbAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 115, 30));

        jlHiperv.setForeground(new java.awt.Color(102, 102, 102));
        jlHiperv.setText("CONECTAR");
        jlHiperv.setToolTipText("Configurar otro servidor");
        jlHiperv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlHipervMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlHipervMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlHipervMouseExited(evt);
            }
        });
        jpBackground.add(jlHiperv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 90, -1));

        jlFondoHex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        jpBackground.add(jlFondoHex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPasswordActionPerformed

    private void jlServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlServidorMouseClicked

    }//GEN-LAST:event_jlServidorMouseClicked

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        String username = jtfUsuario.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        Tesorero t = new Tesorero(username, password);
        try {
            if (Login.validarUser(connPg, t)) {
                VentanaPrincipal vp = new VentanaPrincipal();
                goTo.frame(this, vp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FaltanDatosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jlHipervMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHipervMouseEntered
        jlHiperv.setForeground(new Color(45, 125, 246));
    }//GEN-LAST:event_jlHipervMouseEntered

    private void jlHipervMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHipervMouseExited
        jlHiperv.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_jlHipervMouseExited

    private void jlHipervMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHipervMouseClicked
        JD_LoginBD JDLoginBD = new JD_LoginBD(null, true);
        goTo.dialog(this, JDLoginBD);
    }//GEN-LAST:event_jlHipervMouseClicked

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
            java.util.logging.Logger.getLogger(JD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Login dialog = new JD_Login(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel ic_password;
    private javax.swing.JLabel ic_username;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlFondoHex;
    private javax.swing.JLabel jlHiperv;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlServidor;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables

    private void conectarBD() {
        try {
            connPg = new ConexionPg();
            connPg = connPg.cargar();
            Connection conn = connPg.conectar();
            if (conn != null) {
                jlServidor.setText("Servidor conectado.");
                jlHiperv.setText(CAMBIAR);
                jlHiperv.setToolTipText("Configurar otro servidor");
            } else {
                jlServidor.setText("Sin conexión establecida.");
                jlHiperv.setText(CONECTAR);
                jlHiperv.setToolTipText("Establecer conexión con el servidor");
            }
        } catch (ClassNotFoundException e) {
            jlServidor.setText("Sin conexión establecida.");
            jlHiperv.setText(CONECTAR);
            jlHiperv.setToolTipText("Establecer conexión con el servidor");
        } catch (IOException e) {
            jlServidor.setText("Sin conexión establecida.");
            jlHiperv.setText(CONECTAR);
            jlHiperv.setToolTipText("Establecer conexión con el servidor");
        } catch (SQLException e) {
            jlServidor.setText("Sin conexión establecida.");
            jlHiperv.setText(CONECTAR);
            jlHiperv.setToolTipText("Establecer conexión con el servidor");
        }
    }
}
