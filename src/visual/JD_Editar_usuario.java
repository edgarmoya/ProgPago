package visual;

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
import javax.swing.JOptionPane;
import utiles.keyboradUtil;

/**
 *
 * @author Edgar Moya
 */
public class JD_Editar_usuario extends javax.swing.JDialog {

    private UsuarioDAO uDAO = new UsuarioDAO();
    private boolean cambios;
    
    public JD_Editar_usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("edit_button"));

        maxLength();
        siguienteCampo();
        focusButtons();
        keyboradUtil.sinEspacio(jtfIdentificador);
        camposRequeridos();
    }

    public Image getIconImage(String nombre_icono) {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/"+nombre_icono+".png"));
        return res;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jpEditarUsuario = new javax.swing.JPanel();
        jtfApellidos = new custom_swing.TextField();
        jtfNombre = new custom_swing.TextField();
        jtfContrasenna = new custom_swing.PasswordField();
        btnCancelar = new custom_swing.Button();
        jcbAdmin = new javax.swing.JCheckBox();
        jcbTesorero = new javax.swing.JCheckBox();
        jcbConsultor = new javax.swing.JCheckBox();
        btnAceptar = new custom_swing.Button();
        jtfConfirmarContrasenna = new custom_swing.PasswordField();
        jtfIdentificador = new custom_swing.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Usuario");

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jpEditarUsuario.setBackground(new java.awt.Color(255, 255, 255));

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
        jtfContrasenna.setLabelText("CONTRASEÑA");
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
        btnAceptar.setToolTipText("Editar usuario");
        btnAceptar.setEnabled(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jtfConfirmarContrasenna.setToolTipText("Inserte nuevamente la nueva contraseña");
        jtfConfirmarContrasenna.setLabelText("CONFIRMAR CONTRASEÑA");
        jtfConfirmarContrasenna.setOpaque(false);
        jtfConfirmarContrasenna.setShowAndHide(true);
        jtfConfirmarContrasenna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfConfirmarContrasennaKeyReleased(evt);
            }
        });

        jtfIdentificador.setToolTipText("Inserte el nombre del usuario");
        jtfIdentificador.setEnabled(false);
        jtfIdentificador.setLabelText("IDENTIFICADOR*");
        jtfIdentificador.setOpaque(false);

        javax.swing.GroupLayout jpEditarUsuarioLayout = new javax.swing.GroupLayout(jpEditarUsuario);
        jpEditarUsuario.setLayout(jpEditarUsuarioLayout);
        jpEditarUsuarioLayout.setHorizontalGroup(
            jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEditarUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEditarUsuarioLayout.createSequentialGroup()
                        .addComponent(jcbAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbTesorero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbConsultor)))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEditarUsuarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfConfirmarContrasenna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfContrasenna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpEditarUsuarioLayout.createSequentialGroup()
                        .addGroup(jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpEditarUsuarioLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfIdentificador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jpEditarUsuarioLayout.setVerticalGroup(
            jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEditarUsuarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jtfIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jtfConfirmarContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbConsultor)
                    .addComponent(jcbTesorero)
                    .addComponent(jcbAdmin))
                .addGap(30, 30, 30)
                .addGroup(jpEditarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jtfIdentificador.getAccessibleContext().setAccessibleDescription("No puede ser modificado el identificador");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jpEditarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidosKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfApellidosKeyReleased

    private void jtfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfNombreKeyReleased

    private void jtfContrasennaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContrasennaKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfContrasennaKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jcbAdminItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAdminItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jcbAdminItemStateChanged

    private void jcbTesoreroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTesoreroItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jcbTesoreroItemStateChanged

    private void jcbConsultorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbConsultorItemStateChanged
        camposRequeridos();
    }//GEN-LAST:event_jcbConsultorItemStateChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Editar usuario
        accionEditar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jtfConfirmarContrasennaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConfirmarContrasennaKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfConfirmarContrasennaKeyReleased

    
    // Editar usuario a bd
    private void accionEditar(){
        boolean admin = jcbAdmin.isSelected();
        boolean tesorero = jcbTesorero.isSelected();
        boolean consultor = jcbConsultor.isSelected();
        Usuario u = new Usuario();      
        try {
            u.setIdentificador(jtfIdentificador.getText());
            u.setNombre(jtfNombre.getText());
            u.setApellidos(jtfApellidos.getText());
            u.setContrasenna(String.valueOf(jtfContrasenna.getPassword()));           
            if (u.isEditValido()) {  // Validar campos completos
                if (validarPassword()){  // Validar que las contraseñas sean iguales
                    if (uDAO.editarUsuario(u, admin, tesorero, consultor)){
                        JOptionPane.showMessageDialog(this, "Usuario editado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        cambios = true;
                        dispose();
                    } 
                } else{
                    JOptionPane.showMessageDialog(this, "Compruebe la nueva contraseña, no coinciden las contraseñas insertadas.", "Error", JOptionPane.ERROR_MESSAGE);
                    jtfConfirmarContrasenna.requestFocus();
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
                jtfApellidos.getText().isEmpty() || (!jcbTesorero.isSelected() 
                && !jcbConsultor.isSelected() && !jcbAdmin.isSelected())) {
            btnAceptar.setEnabled(false);
        } else {
            if (!String.valueOf(jtfContrasenna.getPassword()).isEmpty()){
                if (!String.valueOf(jtfConfirmarContrasenna.getPassword()).isEmpty()){
                    btnAceptar.setEnabled(true);
                } else{
                    btnAceptar.setEnabled(false);
                }                
            }else{
                btnAceptar.setEnabled(true);
            }          
        }
    }

    // Método para cambiar el focus al siguiente botón 
    private void focusButtons() {
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
    }
    
    // Método para validar que ambas contraseñas sean correctas
    private boolean validarPassword(){
        String contrasena = String.valueOf(jtfContrasenna.getPassword());
        String contrasena_confirmada = String.valueOf(jtfConfirmarContrasenna.getPassword());
        if (contrasena.equals(contrasena_confirmada)){
            return true;
        }
        return false;
    }
    
    // Retorna si se efectuaron cambios para actualizar la tabla
    public boolean cambios() {
        return cambios;
    }
    
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
            java.util.logging.Logger.getLogger(JD_Editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Editar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Editar_usuario dialog = new JD_Editar_usuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel bg;
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private javax.swing.JCheckBox jcbAdmin;
    private javax.swing.JCheckBox jcbConsultor;
    private javax.swing.JCheckBox jcbTesorero;
    private javax.swing.JPanel jpEditarUsuario;
    private custom_swing.TextField jtfApellidos;
    private custom_swing.PasswordField jtfConfirmarContrasenna;
    private custom_swing.PasswordField jtfContrasenna;
    private custom_swing.TextField jtfIdentificador;
    private custom_swing.TextField jtfNombre;
    // End of variables declaration//GEN-END:variables

    
    // Setters
    public void setJtfIdentificador(String jtfIdentificador) {
        this.jtfIdentificador.setText(jtfIdentificador);
    }

    public void setJtfNombre(String jtfNombre) {
        this.jtfNombre.setText(jtfNombre);
    }
    
    public void setJtfApellidos(String jtfApellidos) {
        this.jtfApellidos.setText(jtfApellidos);
    }
    
    // Seleccionar checkboxs correspondiente 
    public void setRoles(String roles){
        if (roles.contains("administrador")){
            jcbAdmin.setSelected(true);
        }
        if (roles.contains("tesorero")){
            jcbTesorero.setSelected(true);
        }
        if (roles.contains("consultor")){
            jcbConsultor.setSelected(true);
        }
    }
}
