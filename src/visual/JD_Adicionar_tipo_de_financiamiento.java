package visual;

import javax.swing.JOptionPane;
import entidades.TipoFinan;
import dao.TipoFinanDAO;
import excepciones.BDException;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import excepciones.LongitudException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import utiles.keyboradUtil;

/**
 *
 * @author Lester
 */
public class JD_Adicionar_tipo_de_financiamiento extends javax.swing.JDialog {
    
   private TipoFinanDAO tfDAO = new TipoFinanDAO();
    private String codTipoFinan;
    private boolean cambios;
    private boolean editar;
   
    public JD_Adicionar_tipo_de_financiamiento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("add_button"));
        
        siguienteCampo();
        focusButtons();
        maxLength();
        soloNumeros();
    }
    
    public Image getIconImage (String nombe_icono){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/"+nombe_icono+".png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNuevo_Tipo_de_Financiamiento = new javax.swing.JPanel();
        jtfcod_tipo = new custom_swing.TextField();
        jtfdescripcion = new custom_swing.TextField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Tipo de Financiamiento");
        setResizable(false);

        jpNuevo_Tipo_de_Financiamiento.setBackground(new java.awt.Color(255, 255, 255));

        jtfcod_tipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfcod_tipo.setToolTipText("Inserte el código del tipo de financiamiento");
        jtfcod_tipo.setLabelText("CÓDIGO*");
        jtfcod_tipo.setOpaque(false);
        jtfcod_tipo.setPreferredSize(new java.awt.Dimension(64, 48));
        jtfcod_tipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfcod_tipoFocusLost(evt);
            }
        });
        jtfcod_tipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfcod_tipoKeyReleased(evt);
            }
        });

        jtfdescripcion.setToolTipText("Inserte la descripción del tipo de financiamiento");
        jtfdescripcion.setLabelText("DESCRIPCIÓN*");
        jtfdescripcion.setOpaque(false);
        jtfdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfdescripcionKeyReleased(evt);
            }
        });

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar nuevo tipo de financiamiento");
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

        javax.swing.GroupLayout jpNuevo_Tipo_de_FinanciamientoLayout = new javax.swing.GroupLayout(jpNuevo_Tipo_de_Financiamiento);
        jpNuevo_Tipo_de_Financiamiento.setLayout(jpNuevo_Tipo_de_FinanciamientoLayout);
        jpNuevo_Tipo_de_FinanciamientoLayout.setHorizontalGroup(
            jpNuevo_Tipo_de_FinanciamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNuevo_Tipo_de_FinanciamientoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpNuevo_Tipo_de_FinanciamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfcod_tipo, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jtfdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(jpNuevo_Tipo_de_FinanciamientoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jpNuevo_Tipo_de_FinanciamientoLayout.setVerticalGroup(
            jpNuevo_Tipo_de_FinanciamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevo_Tipo_de_FinanciamientoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtfcod_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jpNuevo_Tipo_de_FinanciamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevo_Tipo_de_Financiamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevo_Tipo_de_Financiamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         if (!editar){
            // Agregar tipo de financiamiento
            accionAgregar();
        }else{
            // Editar tipo de financiamiento
            accionEditar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfcod_tipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfcod_tipoKeyReleased
        camposRequeridos();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            completarCodigo(jtfcod_tipo.getText());
        } 
    }//GEN-LAST:event_jtfcod_tipoKeyReleased

    private void jtfdescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfdescripcionKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfdescripcionKeyReleased

    private void jtfcod_tipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfcod_tipoFocusLost
        completarCodigo(jtfcod_tipo.getText());    
    }//GEN-LAST:event_jtfcod_tipoFocusLost

    // Limpiar todos los campos y hacer focus el primero
    private void limpiar() {
        jtfcod_tipo.setText("");
        jtfdescripcion.setText("");
        jtfcod_tipo.requestFocus();
        camposRequeridos();
    }
    
    // Permitir determinada longitud de caracteres
    private void maxLength() {
        keyboradUtil.maxLength(jtfcod_tipo, 4);
        keyboradUtil.maxLength(jtfdescripcion, 100);
    }
    
    // Permitir solo números
    private void soloNumeros() {
        keyboradUtil.soloNumeros(jtfcod_tipo);
    }
    
    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfcod_tipo, jtfdescripcion);
        keyboradUtil.siguienteCampo(jtfdescripcion, btnAceptar, btnCancelar);
    }
    
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfcod_tipo.getText().isEmpty() || jtfdescripcion.getText().isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }
    
    // Método para cambiar el focus al siguiente botón 
    private void focusButtons(){
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
    }
    
    // Método para completar con ceros a la izquierda si el código no tiene 4 dígitos
    private void completarCodigo(String codigo){
        if (codigo.length() != 4 && codigo.length() != 0){
            while(codigo.length() != 4){
                codigo = "0"+codigo;    
            }
            jtfcod_tipo.setText(codigo);
        }       
    }
    
    // Agregar tipo de financiamiento a bd
    private void accionAgregar(){
        TipoFinan tf = new TipoFinan();
        tf.setCod_tipo(jtfcod_tipo.getText());
        tf.setDescripcion(jtfdescripcion.getText());
        
         try {
            if (tf.isValido()) {   // Validar
                if (tfDAO.agregarTipoFinan(tf)) {
                    JOptionPane.showMessageDialog(this, "Tipo de financiamiento agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cambios = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException | LongitudException | ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Editar tipo de financiamiento en bd
    private void accionEditar(){
        TipoFinan tf = new TipoFinan();
        tf.setCod_tipo(jtfcod_tipo.getText());
        tf.setDescripcion(jtfdescripcion.getText());
        
        try {
            // Validar campos
            if (tf.isValido()) {
                if (tfDAO.editarTipoFinan(codTipoFinan, tf)) {
                    JOptionPane.showMessageDialog(this, "Tipo de financiamiento editado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    cambios = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al editar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException | LongitudException | ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(JD_Adicionar_tipo_de_financiamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_tipo_de_financiamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_tipo_de_financiamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_tipo_de_financiamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Adicionar_tipo_de_financiamiento dialog = new JD_Adicionar_tipo_de_financiamiento(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jpNuevo_Tipo_de_Financiamiento;
    private custom_swing.TextField jtfcod_tipo;
    private custom_swing.TextField jtfdescripcion;
    // End of variables declaration//GEN-END:variables

     //Cambios que se producirán si se va a editar el tipo de financiamiento
    public void dialogo_editar(TipoFinan tf){  
        editar = true;
        codTipoFinan = tf.getCod_tipo();
        // Editar título e icono
        setTitle("Editar Tipo de Financiamiento");
        setIconImage(getIconImage("edit_button"));
        // Cambiar toolTip del btnAceptar
        btnAceptar.setToolTipText("Editar tipo de financiamiento");
        // Mostrar datos en campo correspondiente
        setJtfcod_tipo(tf.getCod_tipo());
        setJtfdescripcion(tf.getDescripcion());
        // Comprobar campos para que se active el btnAceptar
        camposRequeridos();
    }
    
    // retorna si se realizó algún cambio o no
    public boolean cambios() {
        return cambios;
    }
     
    // Setters
    public void setJtfcod_tipo(String jtfcod_tipo) {
        this.jtfcod_tipo.setText(jtfcod_tipo);
    }

    public void setJtfdescripcion(String jtfdescripcion) {
        this.jtfdescripcion.setText(jtfdescripcion);
    }
}
