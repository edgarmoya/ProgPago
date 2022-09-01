package visual;

import entidades.Usuario;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ppago.ConexionPg;
import ppago.Login;
import utiles.goTo;

public class JD_Login extends javax.swing.JDialog {

    private ConexionPg connPg;
    private boolean estadoConn = false;
    private String CAMBIAR = "<html>Servidor conectado. <font color=\"#999999\"><b><u>CAMBIAR</u></b></font></html>";
    private String CONECTAR = "<html>Sin conexión establecida. <font color=\"#999999\"><b><u>CONECTAR</u></b></font></html>";

    public JD_Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());        
        conectarBD();
    }
    
    
    public Image getIconImage (){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ic_iniciarsesion.png"));
        return res;
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        ic_username = new javax.swing.JLabel();
        ic_password = new javax.swing.JLabel();
        jlHiperv = new javax.swing.JLabel();
        jtfUsuario = new custom_swing.TextField();
        jtfPassword = new custom_swing.PasswordField();
        btnAceptar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JPanel();
        labelCancelar = new javax.swing.JLabel();
        jlFondoHex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setResizable(false);

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ic_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        jpBackground.add(ic_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, 25));

        ic_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pass.png"))); // NOI18N
        jpBackground.add(ic_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, -1, -1));

        jlHiperv.setForeground(new java.awt.Color(102, 102, 102));
        jlHiperv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        jpBackground.add(jlHiperv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 310, 30));

        jtfUsuario.setToolTipText("Inserte su nombre de usuario");
        jtfUsuario.setLabelText("USUARIO");
        jtfUsuario.setOpaque(false);
        jpBackground.add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 270, -1));

        jtfPassword.setToolTipText("Inserte su contraseña");
        jtfPassword.setLabelText("CONTRASEÑA");
        jtfPassword.setOpaque(false);
        jtfPassword.setShowAndHide(true);
        jpBackground.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 270, -1));

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

        jpBackground.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 30));

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

        jpBackground.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 110, 30));

        jlFondoHex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        jpBackground.add(jlFondoHex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlHipervMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHipervMouseEntered
        mouseEntered("#2d7df6");
    }//GEN-LAST:event_jlHipervMouseEntered

    private void jlHipervMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHipervMouseExited
       mouseEntered("#999999");
    }//GEN-LAST:event_jlHipervMouseExited

    private void jlHipervMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlHipervMouseClicked
        JD_LoginBD JDLoginBD = new JD_LoginBD(null, true);
        goTo.dialog(this, JDLoginBD);
    }//GEN-LAST:event_jlHipervMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        String username = jtfUsuario.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        byte activate = 1;
        Usuario u = new Usuario(username, password, activate);
        try {
            if (Login.validarUser(connPg, u)) {
                VentanaPrincipal vp = new VentanaPrincipal();
                goTo.frame(this, vp);
            }else{
                JOptionPane.showMessageDialog(this, "Usuario incorrecto, compruebe los datos y vuelva a intentarlo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FaltanDatosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarMouseClicked

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

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCancelarMouseClicked

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
    private javax.swing.JPanel btnAceptar;
    private javax.swing.JPanel btnCancelar;
    private javax.swing.JLabel ic_password;
    private javax.swing.JLabel ic_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlFondoHex;
    private javax.swing.JLabel jlHiperv;
    private javax.swing.JPanel jpBackground;
    private custom_swing.PasswordField jtfPassword;
    private custom_swing.TextField jtfUsuario;
    private javax.swing.JLabel labelCancelar;
    // End of variables declaration//GEN-END:variables

    private void conectarBD() {
        try {
            connPg = new ConexionPg();
            connPg = connPg.cargar();
            Connection conn = connPg.conectar();
            if (conn != null) {
                conectado();
                estadoConn = true;
            } else {
                no_conectado();
                estadoConn = false;
            }
        } catch (ClassNotFoundException e) {
            no_conectado();
        } catch (IOException e) {
            no_conectado();
        } catch (SQLException e) {
            no_conectado();
        }
    }
    
    private void no_conectado(){
        jlHiperv.setText(CONECTAR);
        jlHiperv.setToolTipText("Establecer conexión con el servidor");
    }
    
    private void conectado(){
        jlHiperv.setText(CAMBIAR);
        jlHiperv.setToolTipText("Configurar otro servidor");
    }
    
    private void mouseEntered(String color){              
        CAMBIAR = "<html>Servidor conectado. <font color=\""+ color + "\"><b><u>CAMBIAR</u></b></font></html>";;
        CONECTAR = "<html>Sin conexión establecida. <font color=\""+ color +"\"><b><u>CONECTAR</u></b></font></html>";
        if(estadoConn){
            jlHiperv.setText(CAMBIAR);
        }else{
            jlHiperv.setText(CONECTAR);
        }     
    }
}
