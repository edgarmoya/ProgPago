package visual;

import dao.OrganizacionDAO;
import entidades.Organizacion;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utiles.ImageFilter;
import utiles.keyboradUtil;

/**
 *
 * @author Edgar Moya
 */
public class JD_Organizacion extends javax.swing.JDialog {
   
    private OrganizacionDAO oDAO = new OrganizacionDAO();
    private Organizacion org = new Organizacion();
    private InputStream fis;
    private int longBytes;
    private boolean newLogo;

    
    public JD_Organizacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();      
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        
        siguienteCampo();
        focusButtons();
        maxLength();
        soloNumeros();
        
        keyboradUtil.isCorreo(jtfCorreo);  
        mostrarDatos();
        camposRequeridos();
    }

    public Image getIconImage() {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/popup_organizacion.png"));
        return res;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jtfCodigo = new custom_swing.TextField();
        jtfDireccion = new custom_swing.TextField();
        jtfTelefono = new custom_swing.TextField();
        jtfCorreo = new custom_swing.TextField();
        jtfNombre = new custom_swing.TextField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();
        jpVistaPrevia = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        btnAddLogo = new custom_swing.Button();
        btnDeleteLogo = new custom_swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos de la Organización");

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jtfCodigo.setToolTipText("Inserte código de la organización");
        jtfCodigo.setLabelText("CÓDIGO*");
        jtfCodigo.setOpaque(false);
        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
        });

        jtfDireccion.setToolTipText("Inserte la dirección de la organización");
        jtfDireccion.setLabelText("DIRECCIÓN");
        jtfDireccion.setOpaque(false);

        jtfTelefono.setToolTipText("Inserte el teléfono de la organización");
        jtfTelefono.setLabelText("TELÉFONO");
        jtfTelefono.setOpaque(false);

        jtfCorreo.setToolTipText("Inserte el correo de la organización");
        jtfCorreo.setLabelText("CORREO ELECTRÓNICO");
        jtfCorreo.setOpaque(false);

        jtfNombre.setToolTipText("Inserte nombre de la organización");
        jtfNombre.setLabelText("NOMBRE*");
        jtfNombre.setOpaque(false);
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombreKeyReleased(evt);
            }
        });

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Modificar datos de la organización");
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

        jpVistaPrevia.setBackground(new java.awt.Color(255, 255, 255));
        jpVistaPrevia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(153, 153, 153)), "VISTA PREVIA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 10), new java.awt.Color(102, 102, 102))); // NOI18N
        jpVistaPrevia.setForeground(new java.awt.Color(102, 102, 102));
        jpVistaPrevia.setToolTipText("Vista previa del logo");

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/no_logo.png"))); // NOI18N

        javax.swing.GroupLayout jpVistaPreviaLayout = new javax.swing.GroupLayout(jpVistaPrevia);
        jpVistaPrevia.setLayout(jpVistaPreviaLayout);
        jpVistaPreviaLayout.setHorizontalGroup(
            jpVistaPreviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVistaPreviaLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jpVistaPreviaLayout.setVerticalGroup(
            jpVistaPreviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVistaPreviaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnAddLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAddLogo.setToolTipText("Agregar logo");
        btnAddLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLogoActionPerformed(evt);
            }
        });

        btnDeleteLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDeleteLogo.setToolTipText("Eliminar logo");
        btnDeleteLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jpVistaPrevia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpVistaPrevia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String codigo = jtfCodigo.getText();
        String nombre = jtfNombre.getText();
        String direccion = jtfDireccion.getText();
        String telefono = jtfTelefono.getText();
        String correo = jtfCorreo.getText();
        
        Organizacion o = null;  
        if (newLogo){
            o = new Organizacion(codigo, nombre, direccion, telefono, correo, fis);
        }else {
            o = new Organizacion(codigo, nombre, direccion, telefono, correo, org.getLogo());
        }
        
        try {
            // comprobar si es valido
            if (oDAO.agregarOrganizacion(o, longBytes)){
                JOptionPane.showMessageDialog(this, "Organización actualizada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jtfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfNombreKeyReleased

    private void btnAddLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLogoActionPerformed
        elegirImagen();
    }//GEN-LAST:event_btnAddLogoActionPerformed

    private void btnDeleteLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLogoActionPerformed
        lbLogo.setIcon(new ImageIcon(getClass().getResource("/imagenes/no_logo.png")));
        fis = null;
    }//GEN-LAST:event_btnDeleteLogoActionPerformed

    // Elegir imagen 
    private void elegirImagen() {
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);  //solo archivos y no carpetas
        j.addChoosableFileFilter(new ImageFilter());
        j.setAcceptAllFileFilterUsed(false);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                longBytes = (int) j.getSelectedFile().length();
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), Image.SCALE_SMOOTH);
                lbLogo.setIcon(new ImageIcon(icono));
                lbLogo.updateUI();  
                newLogo = true;
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al obtener imagen seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al obtener imagen seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Mostrar datos guardados en bd
    private void mostrarDatos() {        
        try {
            org = oDAO.obtenerOrganizacion();
            if (org.getCodigo() != null && org.getNombre() != null){
                jtfCodigo.setText(org.getCodigo());
                jtfNombre.setText(org.getNombre());
                jtfDireccion.setText(org.getDireccion());
                jtfTelefono.setText(org.getTelefono());
                jtfCorreo.setText(org.getCorreo());               
                
                if (org.getLogo() != null){
                    // mostrar imagen correspondiente
                    BufferedImage bi = ImageIO.read(org.getLogo());
                    ImageIcon foto = new ImageIcon(bi);
                    Image img = foto.getImage();
                    Image imgScale = img.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH);           
                    lbLogo.setIcon(new ImageIcon(imgScale));
                } else{
                    // mostrar imagen "sin logo"
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
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener imagen seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfCodigo.getText().isEmpty() || jtfNombre.getText().isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }
    
    // Permitir determinada longitud de caracteres
    private void maxLength() {
        keyboradUtil.maxLength(jtfCodigo, 4);
        keyboradUtil.maxLength(jtfNombre, 50);
        keyboradUtil.maxLength(jtfDireccion, 100);
        keyboradUtil.maxLength(jtfTelefono, 15);
        keyboradUtil.maxLength(jtfCorreo, 50);
    }
    
    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfCodigo, jtfNombre);
        keyboradUtil.siguienteCampo(jtfNombre, jtfDireccion);
        keyboradUtil.siguienteCampo(jtfDireccion, jtfTelefono);
        keyboradUtil.siguienteCampo(jtfTelefono, jtfCorreo);
        keyboradUtil.siguienteCampo(jtfCorreo, btnAceptar, btnCancelar);
    }
    
    // Permitir solo números
    private void soloNumeros() {
        keyboradUtil.soloNumeros(jtfTelefono);
        keyboradUtil.soloNumeros(jtfCodigo);
    }
    
    // Método para cambiar el focus al siguiente botón 
    private void focusButtons(){
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
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
            java.util.logging.Logger.getLogger(JD_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Organizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Organizacion dialog = new JD_Organizacion(new javax.swing.JFrame(), true);
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
    private custom_swing.Button btnAddLogo;
    private custom_swing.Button btnCancelar;
    private custom_swing.Button btnDeleteLogo;
    private javax.swing.JPanel jpVistaPrevia;
    private custom_swing.TextField jtfCodigo;
    private custom_swing.TextField jtfCorreo;
    private custom_swing.TextField jtfDireccion;
    private custom_swing.TextField jtfNombre;
    private custom_swing.TextField jtfTelefono;
    private javax.swing.JLabel lbLogo;
    // End of variables declaration//GEN-END:variables
}
