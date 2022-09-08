package visual;

import javax.swing.JOptionPane;
import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.BDException;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import excepciones.IdentificadorException;
import excepciones.LongitudException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import utiles.keyboradUtil;

public class JD_Adicionar_usuario extends javax.swing.JDialog {

    private boolean cambios;

    public JD_Adicionar_usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());

        maxLength();
        siguienteCampo();
        focusButtons();
        keyboradUtil.sinEspacio(jtfIdentificador);
    }

    public Image getIconImage() {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/add.png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jpNuevoUsuario = new javax.swing.JPanel();
        jtfIdentificador = new custom_swing.TextField();
        jtfApellidos = new custom_swing.TextField();
        jtfNombre = new custom_swing.TextField();
        jtfContrasenna = new custom_swing.PasswordField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();
        jrbAdmin = new javax.swing.JRadioButton();
        jrbConsultor = new javax.swing.JRadioButton();
        jrbTesorero = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Usuario");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jpNuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jtfIdentificador.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfIdentificador.setToolTipText("Inserte el identificador del usuario");
        jtfIdentificador.setLabelText("IDENTIFICADOR*");
        jtfIdentificador.setOpaque(false);
        jtfIdentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfIdentificadorKeyReleased(evt);
            }
        });

        jtfApellidos.setToolTipText("Inserte los apellidos del usuario");
        jtfApellidos.setLabelText("APELLIDOS*");
        jtfApellidos.setOpaque(false);
        jtfApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfApellidosKeyReleased(evt);
            }
        });

        jtfNombre.setToolTipText("Inserte el nombre del usuario");
        jtfNombre.setLabelText("NOMBRE*");
        jtfNombre.setOpaque(false);
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombreKeyReleased(evt);
            }
        });

        jtfContrasenna.setToolTipText("Inserte la contraseña del usuario");
        jtfContrasenna.setLabelText("CONTRASEÑA*");
        jtfContrasenna.setOpaque(false);
        jtfContrasenna.setShowAndHide(true);
        jtfContrasenna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfContrasennaKeyReleased(evt);
            }
        });

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar nuevo usuario");
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
        btnCancelar.setToolTipText("Cerrar diálogo de captación");
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jrbAdmin.setBackground(new java.awt.Color(255, 255, 255));
        jrbAdmin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jrbAdmin.setText("Administrador");
        jrbAdmin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbAdminItemStateChanged(evt);
            }
        });

        jrbConsultor.setBackground(new java.awt.Color(255, 255, 255));
        jrbConsultor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jrbConsultor.setText("Consultor");
        jrbConsultor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbConsultorItemStateChanged(evt);
            }
        });

        jrbTesorero.setBackground(new java.awt.Color(255, 255, 255));
        jrbTesorero.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jrbTesorero.setText("Tesorero");
        jrbTesorero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbTesoreroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpNuevoUsuarioLayout = new javax.swing.GroupLayout(jpNuevoUsuario);
        jpNuevoUsuario.setLayout(jpNuevoUsuarioLayout);
        jpNuevoUsuarioLayout.setHorizontalGroup(
            jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfIdentificador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addComponent(jtfContrasenna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                        .addComponent(jrbAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbTesorero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbConsultor)))
                .addGap(15, 15, 15))
            .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jpNuevoUsuarioLayout.setVerticalGroup(
            jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevoUsuarioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbTesorero)
                    .addComponent(jrbAdmin)
                    .addComponent(jrbConsultor))
                .addGap(30, 30, 30)
                .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        boolean admin = jrbAdmin.isSelected();
        boolean tesorero = jrbTesorero.isSelected();
        boolean consultor = jrbConsultor.isSelected();
        Usuario u = new Usuario();      
        try {
            u.setIdentificador(jtfIdentificador.getText());
            u.setNombre(jtfNombre.getText());
            u.setApellidos(jtfApellidos.getText());
            u.setContrasenna(String.valueOf(jtfContrasenna.getPassword()));
            u.setInicio((byte) (0));
            u.setActivo((byte) (1));
            UsuarioDAO uDAO = new UsuarioDAO();
            // Validar 
            if (u.isValido()) {
                uDAO.agregarUsuario(u, admin, tesorero, consultor);
                JOptionPane.showMessageDialog(this, "Usuario agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                cambios = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (FaltanDatosException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (LongitudException lon) {
            JOptionPane.showMessageDialog(this, lon.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (IdentificadorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfIdentificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdentificadorKeyReleased
        camposRequeridos();    
    }//GEN-LAST:event_jtfIdentificadorKeyReleased

    private void jtfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfNombreKeyReleased

    private void jtfApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidosKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfApellidosKeyReleased

    private void jtfContrasennaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContrasennaKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfContrasennaKeyReleased

    private void jrbTesoreroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbTesoreroItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jrbTesoreroItemStateChanged

    private void jrbConsultorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbConsultorItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jrbConsultorItemStateChanged

    private void jrbAdminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbAdminItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jrbAdminItemStateChanged

    // Limpiar todos los campos
    private void limpiar() {
        jtfIdentificador.setText("");
        jtfNombre.setText("");
        jtfApellidos.setText("");
        jtfContrasenna.setText("");
        jtfIdentificador.requestFocus();
    }

    // Permitir determinada longitud de caracteres
    private void maxLength() {
        keyboradUtil.maxLength(jtfIdentificador, 20);
        keyboradUtil.maxLength(jtfNombre, 40);
        keyboradUtil.maxLength(jtfApellidos, 40);
        //No importa el número de caracteres de la contraseña, siempre se guarda en un hash de 34
    }

    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfIdentificador, jtfNombre);
        keyboradUtil.siguienteCampo(jtfNombre, jtfApellidos);
        keyboradUtil.siguienteCampo(jtfApellidos, jtfContrasenna);
        keyboradUtil.siguienteCampo(jtfContrasenna, btnAceptar, btnCancelar);
    }

    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfIdentificador.getText().isEmpty() || jtfNombre.getText().isEmpty() || 
                jtfApellidos.getText().isEmpty() || String.valueOf(jtfContrasenna.getPassword()).isEmpty() ||
                (!jrbTesorero.isSelected() && !jrbConsultor.isSelected() && !jrbAdmin.isSelected())) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }

    // Método para cambiar el focus al siguiente botón 
    private void focusButtons() {
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
    }
    
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
            java.util.logging.Logger.getLogger(JD_Adicionar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Adicionar_usuario dialog = new JD_Adicionar_usuario(new javax.swing.JFrame(), true);
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
    
    
    // Retorna si se efectuaron cambios para actualizar la tabla
    public boolean cambios() {
        return cambios;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private javax.swing.JPanel jpNuevoUsuario;
    private javax.swing.JRadioButton jrbAdmin;
    private javax.swing.JRadioButton jrbConsultor;
    private javax.swing.JRadioButton jrbTesorero;
    private custom_swing.TextField jtfApellidos;
    private custom_swing.PasswordField jtfContrasenna;
    private custom_swing.TextField jtfIdentificador;
    private custom_swing.TextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
