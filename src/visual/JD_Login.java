package visual;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ppago.ConexionPg;
import ppago.Login;
import utiles.goTo;
import utiles.keyboradUtil;

/**
 *
 * @author Edgar Moya
 */
public class JD_Login extends javax.swing.JDialog {

    private ConexionPg connPg;
    private Usuario u = new Usuario();
    private boolean estadoConn = false;
    private String CAMBIAR = "<html>Servidor conectado. <font color=\"#999999\"><b><u>CAMBIAR</u></b></font></html>";
    private String CONECTAR = "<html>Sin conexión establecida. <font color=\"#999999\"><b><u>CONECTAR</u></b></font></html>";

    public JD_Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());        
        
        conectarBD();       
        siguienteCampo();
        focusButtons();
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
        jtfIdentificador = new custom_swing.TextField();
        jtfPassword = new custom_swing.PasswordField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();
        jlFondoHex = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticación");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ic_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_user.png"))); // NOI18N
        jpBackground.add(ic_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, 25));

        ic_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login_pass.png"))); // NOI18N
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

        jtfIdentificador.setToolTipText("Inserte su identificador de usuario");
        jtfIdentificador.setLabelText("IDENTIFICADOR*");
        jtfIdentificador.setOpaque(false);
        jtfIdentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfIdentificadorKeyReleased(evt);
            }
        });
        jpBackground.add(jtfIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 275, -1));

        jtfPassword.setToolTipText("Inserte su contraseña");
        jtfPassword.setLabelText("CONTRASEÑA*");
        jtfPassword.setOpaque(false);
        jtfPassword.setShowAndHide(true);
        jtfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPasswordKeyReleased(evt);
            }
        });
        jpBackground.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 275, -1));

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Iniciar sesión en la aplicación");
        btnAceptar.setEnabled(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jpBackground.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, 30));

        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(45, 125, 246)));
        btnCancelar.setForeground(new java.awt.Color(45, 125, 246));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cerrar aplicación");
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String username = jtfIdentificador.getText();
        String password = String.valueOf(jtfPassword.getPassword());
        u.setIdentificador(username);
        u.setContrasenna(password);
        try {
            int result = Login.validarUser(connPg, u);
            switch(result){
                case 0:
                    // Usuario incorrecto
                    JOptionPane.showMessageDialog(this, "Usuario incorrecto, compruebe los datos y vuelva a intentarlo.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case 1:
                    // Loguear usuario
                    UsuarioDAO uDAO = new UsuarioDAO(); 
                    VentanaPrincipal vp = new VentanaPrincipal(uDAO.getNomb_Apell_Roles(u.getIdentificador()));
                    goTo.frame(this, vp);
                    break;
                case 2:
                    // Cambiar contraseña
                    JD_Cambiar_contrasena JDContrasena = new JD_Cambiar_contrasena(null, true);
                    JDContrasena.setUsuario(u);
                    JDContrasena.setVisible(true);
                    break;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FaltanDatosException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfIdentificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdentificadorKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfIdentificadorKeyReleased

    private void jtfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPasswordKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfPasswordKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing
  
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
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private javax.swing.JLabel ic_password;
    private javax.swing.JLabel ic_username;
    private javax.swing.JLabel jlFondoHex;
    private javax.swing.JLabel jlHiperv;
    private javax.swing.JPanel jpBackground;
    private custom_swing.TextField jtfIdentificador;
    private custom_swing.PasswordField jtfPassword;
    // End of variables declaration//GEN-END:variables

    // Conectar a la base de datos
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
    
    // Si el mouse se posiciona encima del texto 
    private void mouseEntered(String color){              
        CAMBIAR = "<html>Servidor conectado. <font color=\""+ color + "\"><b><u>CAMBIAR</u></b></font></html>";;
        CONECTAR = "<html>Sin conexión establecida. <font color=\""+ color +"\"><b><u>CONECTAR</u></b></font></html>";
        if(estadoConn){
            jlHiperv.setText(CAMBIAR);
        }else{
            jlHiperv.setText(CONECTAR);
        }     
    }
        
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfIdentificador.getText().isEmpty() || String.valueOf(jtfPassword.getPassword()).isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }  
    
    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfIdentificador, jtfPassword);              
        keyboradUtil.siguienteCampo(jtfPassword, btnAceptar, btnCancelar);
    }
    
    // Método para cambiar el focus al siguiente botón 
    private void focusButtons(){
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
    }
}
