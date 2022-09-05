package visual;

import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.ConnectionException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utiles.keyboradUtil;

/**
 *
 * @author Edgar Moya
 */
public class JD_Cambiar_contrasena extends javax.swing.JDialog {

    private Usuario u = new Usuario();

    public JD_Cambiar_contrasena(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());

        siguienteCampo();
        focusButtons();
    }

    public Image getIconImage() {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/popup_contrasena.png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();
        jtfPass_Nueva = new custom_swing.PasswordField();
        jtfPass_Confirmada = new custom_swing.PasswordField();
        jtfPass_Actual = new custom_swing.PasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar contraseña");

        bg.setBackground(new java.awt.Color(255, 255, 255));

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Cambiar contraseña");
        btnAceptar.setEnabled(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

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

        jtfPass_Nueva.setToolTipText("Inserte su nueva contraseña");
        jtfPass_Nueva.setLabelText("NUEVA CONTRASEÑA *");
        jtfPass_Nueva.setOpaque(false);
        jtfPass_Nueva.setShowAndHide(true);
        jtfPass_Nueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPass_NuevaKeyReleased(evt);
            }
        });

        jtfPass_Confirmada.setToolTipText("Inserte nuevamente la nueva contraseña");
        jtfPass_Confirmada.setLabelText("CONFIRME CONTRASEÑA *");
        jtfPass_Confirmada.setOpaque(false);
        jtfPass_Confirmada.setShowAndHide(true);
        jtfPass_Confirmada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPass_ConfirmadaKeyReleased(evt);
            }
        });

        jtfPass_Actual.setToolTipText("Inserte su contraseña actual");
        jtfPass_Actual.setLabelText("CONTRASEÑA ACTUAL  *");
        jtfPass_Actual.setOpaque(false);
        jtfPass_Actual.setShowAndHide(true);
        jtfPass_Actual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPass_ActualKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfPass_Nueva, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addComponent(jtfPass_Confirmada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfPass_Actual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jtfPass_Actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfPass_Nueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfPass_Confirmada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nueva = String.valueOf(jtfPass_Nueva.getPassword());
        String actual = String.valueOf(jtfPass_Actual.getPassword());
        try {
            if (igualContrasena()) {
                UsuarioDAO uDAO = new UsuarioDAO();
                boolean update = uDAO.updatePassword(u.getUsuario(), actual, nueva);
                if (update){                   
                    dispose();
                    JOptionPane.showMessageDialog(this, "Contraseña cambiada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta, vuelva a intentarlo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Compruebe la nueva contraseña, no coinciden las contraseñas escritas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfPass_NuevaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPass_NuevaKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfPass_NuevaKeyReleased

    private void jtfPass_ConfirmadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPass_ConfirmadaKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfPass_ConfirmadaKeyReleased

    private void jtfPass_ActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPass_ActualKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfPass_ActualKeyReleased

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
            java.util.logging.Logger.getLogger(JD_Cambiar_contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Cambiar_contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Cambiar_contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Cambiar_contrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Cambiar_contrasena dialog = new JD_Cambiar_contrasena(new javax.swing.JFrame(), true);
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

    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (String.valueOf(jtfPass_Actual.getPassword()).isEmpty()
                || String.valueOf(jtfPass_Nueva.getPassword()).isEmpty()
                || String.valueOf(jtfPass_Confirmada.getPassword()).isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }

    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfPass_Actual, jtfPass_Nueva);
        keyboradUtil.siguienteCampo(jtfPass_Nueva, jtfPass_Confirmada);
        keyboradUtil.siguienteCampo(jtfPass_Confirmada, btnAceptar, btnCancelar);
    }

    // Método para cambiar el focus al siguiente botón 
    private void focusButtons() {
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
    }

    // Comprobar que la nueva contraseña es igual a la confirmada
    private boolean igualContrasena() {
        String nueva = String.valueOf(jtfPass_Nueva.getPassword());
        String confirmada = String.valueOf(jtfPass_Confirmada.getPassword());
        if (nueva.equals(confirmada)) {
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private custom_swing.PasswordField jtfPass_Actual;
    private custom_swing.PasswordField jtfPass_Confirmada;
    private custom_swing.PasswordField jtfPass_Nueva;
    // End of variables declaration//GEN-END:variables

    // Obtener usuario registrado
    public void setUsuario(Usuario u) {
        this.u = u;
    }

}
