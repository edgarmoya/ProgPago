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
        btnCancelar = new custom_swing.Button();
        jcbAdmin = new javax.swing.JCheckBox();
        jcbTesorero = new javax.swing.JCheckBox();
        jcbConsultor = new javax.swing.JCheckBox();
        btnAceptar = new custom_swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Usuario");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jpNuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jtfIdentificador.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfIdentificador.setToolTipText("Inserte el identificador del usuario");
        jtfIdentificador.setLabelText("IDENTIFICADOR*");
        jtfIdentificador.setOpaque(false);
        jtfIdentificador.setPreferredSize(new java.awt.Dimension(64, 48));
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

        jcbAdmin.setBackground(new java.awt.Color(255, 255, 255));
        jcbAdmin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jcbAdmin.setText("Administrador");
        jcbAdmin.setOpaque(true);
        jcbAdmin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAdminItemStateChanged(evt);
            }
        });

        jcbTesorero.setBackground(new java.awt.Color(255, 255, 255));
        jcbTesorero.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jcbTesorero.setText("Tesorero");
        jcbTesorero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTesoreroItemStateChanged(evt);
            }
        });

        jcbConsultor.setBackground(new java.awt.Color(255, 255, 255));
        jcbConsultor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jcbConsultor.setText("Consultor");
        jcbConsultor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbConsultorItemStateChanged(evt);
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

        javax.swing.GroupLayout jpNuevoUsuarioLayout = new javax.swing.GroupLayout(jpNuevoUsuario);
        jpNuevoUsuario.setLayout(jpNuevoUsuarioLayout);
        jpNuevoUsuarioLayout.setHorizontalGroup(
            jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevoUsuarioLayout.createSequentialGroup()
                        .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIdentificador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfContrasenna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                        .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNuevoUsuarioLayout.createSequentialGroup()
                                .addComponent(jcbAdmin)
                                .addGap(12, 12, 12)
                                .addComponent(jcbTesorero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbConsultor))
                            .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))))
        );
        jpNuevoUsuarioLayout.setVerticalGroup(
            jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevoUsuarioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAdmin)
                    .addComponent(jcbTesorero)
                    .addComponent(jcbConsultor))
                .addGap(30, 30, 30)
                .addGroup(jpNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jpNuevoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
        boolean admin = jcbAdmin.isSelected();
        boolean tesorero = jcbTesorero.isSelected();
        boolean consultor = jcbConsultor.isSelected();
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
                if (uDAO.agregarUsuario(u, admin, tesorero, consultor)){
                    JOptionPane.showMessageDialog(this, "Usuario agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cambios = true;
                }else{
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar.", "Error", JOptionPane.ERROR_MESSAGE);
                }             
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

    private void jcbAdminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAdminItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jcbAdminItemStateChanged

    private void jcbTesoreroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTesoreroItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jcbTesoreroItemStateChanged

    private void jcbConsultorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbConsultorItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jcbConsultorItemStateChanged

    // Limpiar todos los campos
    private void limpiar() {
        jtfIdentificador.setText("");
        jtfNombre.setText("");
        jtfApellidos.setText("");
        jtfContrasenna.setText("");
        jtfIdentificador.requestFocus();
        camposRequeridos();
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
                (!jcbTesorero.isSelected() && !jcbConsultor.isSelected() && !jcbAdmin.isSelected())) {
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
    private javax.swing.JCheckBox jcbAdmin;
    private javax.swing.JCheckBox jcbConsultor;
    private javax.swing.JCheckBox jcbTesorero;
    private javax.swing.JPanel jpNuevoUsuario;
    private custom_swing.TextField jtfApellidos;
    private custom_swing.PasswordField jtfContrasenna;
    private custom_swing.TextField jtfIdentificador;
    private custom_swing.TextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
