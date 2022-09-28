package visual;

import javax.swing.JOptionPane;
import entidades.Destino;
import dao.DestinoDAO;
import excepciones.BDException;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import excepciones.LongitudException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import utiles.keyboradUtil;

public class JD_Adicionar_destino extends javax.swing.JDialog {
    
    private DestinoDAO dDAO = new DestinoDAO();
    private String codDestino;
    private boolean cambios;
    private boolean editar;
    
    public JD_Adicionar_destino(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("add_button"));
             
        siguienteCampo();
        focusButtons();
        maxLength();
        soloNumeros();               
    }
    
    public Image getIconImage(String nombe_icono) {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/"+nombe_icono+".png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDestino = new javax.swing.JPanel();
        jtfid_destino = new custom_swing.TextField();
        jtfnombre = new custom_swing.TextField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Destino");
        setResizable(false);

        jpDestino.setBackground(new java.awt.Color(255, 255, 255));

        jtfid_destino.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfid_destino.setToolTipText("Inserte código del destino");
        jtfid_destino.setLabelText("CÓDIGO*");
        jtfid_destino.setOpaque(false);
        jtfid_destino.setPreferredSize(new java.awt.Dimension(64, 48));
        jtfid_destino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfid_destinoFocusLost(evt);
            }
        });
        jtfid_destino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfid_destinoKeyReleased(evt);
            }
        });

        jtfnombre.setToolTipText("Inserte nombre del destino");
        jtfnombre.setLabelText("NOMBRE*");
        jtfnombre.setOpaque(false);
        jtfnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfnombreKeyReleased(evt);
            }
        });

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar nuevo destino");
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

        javax.swing.GroupLayout jpDestinoLayout = new javax.swing.GroupLayout(jpDestino);
        jpDestino.setLayout(jpDestinoLayout);
        jpDestinoLayout.setHorizontalGroup(
            jpDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDestinoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfid_destino, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jtfnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(jpDestinoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jpDestinoLayout.setVerticalGroup(
            jpDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDestinoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtfid_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jpDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       if (!editar){
            // Agregar cliente
            accionAgregar();
        }else{
            // Editar cliente
            accionEditar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfid_destinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfid_destinoKeyReleased
        // TODO add your handling code here:
        camposRequeridos();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            completarCodigo(jtfid_destino.getText());
        } 
    }//GEN-LAST:event_jtfid_destinoKeyReleased

    private void jtfnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfnombreKeyReleased
        // TODO add your handling code here:
        camposRequeridos();
    }//GEN-LAST:event_jtfnombreKeyReleased

    private void jtfid_destinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfid_destinoFocusLost
        // TODO add your handling code here:
        completarCodigo(jtfid_destino.getText());   
    }//GEN-LAST:event_jtfid_destinoFocusLost

     // Limpiar todos los campos y hacer focus el primero
    private void limpiar() {
        jtfid_destino.setText("");
        jtfnombre.setText("");
        jtfid_destino.requestFocus();
        camposRequeridos();
    }
    
     // Permitir determinada longitud de caracteres
    private void maxLength() {
        keyboradUtil.maxLength(jtfid_destino, 4);
        keyboradUtil.maxLength(jtfnombre, 30);
    }
    
    // Permitir solo números
    private void soloNumeros() {
        keyboradUtil.soloNumeros(jtfid_destino);
    }
    
    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfid_destino, jtfnombre);
        keyboradUtil.siguienteCampo(jtfnombre, btnAceptar, btnCancelar);
    }
    
     //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfid_destino.getText().isEmpty() || jtfnombre.getText().isEmpty()) {
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
            jtfid_destino.setText(codigo);
        } 
                
    }
    
     // Agregar destino a bd
    private void accionAgregar(){
        Destino d = new Destino();
        d.setId_destino(jtfid_destino.getText());
        d.setNombre(jtfnombre.getText());
        d.setActivo((byte) (1));
        
         try {
            // Validar 
            if (d.isValido()) {
                if (dDAO.agregarDestino(d)) {
                    JOptionPane.showMessageDialog(this, "Destino agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cambios = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (LongitudException lon) {
            JOptionPane.showMessageDialog(this, lon.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     // Editar destino en bd
    private void accionEditar(){
        Destino d = new Destino();
        d.setId_destino(jtfid_destino.getText());
        d.setNombre(jtfnombre.getText());
 
        try {
            // Validar campos
            if (d.isValido()) {
                if (dDAO.actualizarDestino(codDestino, d)) {
                    JOptionPane.showMessageDialog(this, "Destino editado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    cambios = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al editar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (LongitudException lon) {
            JOptionPane.showMessageDialog(this, lon.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(JD_Adicionar_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Adicionar_destino dialog = new JD_Adicionar_destino(new javax.swing.JFrame(), true);
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

    //Cambios que se producirán si se va a editar el cliente
    public void dialogo_editar(Destino d){  
        editar = true;
        codDestino = d.getId_destino();
        // Editar título e icono
        setTitle("Editar Destino");
        setIconImage(getIconImage("edit_button"));
        // Cambiar toolTip del btnAceptar
        btnAceptar.setToolTipText("Editar destino");
        // Mostrar datos en campo correspondiente
        setJtfid_destino(d.getId_destino());
        setJtfnombre(d.getNombre());
        // Comprobar campos para que se active el btnAceptar
        camposRequeridos();
    }
    
    // retorna si se realizó algún cambio o no
    public boolean cambios() {
        return cambios;
    }
     
    // Setters
    public void setJtfid_destino(String jtfid_destino) {
        this.jtfid_destino.setText(jtfid_destino);
    }

    public void setJtfnombre(String jtfnombre) {
        this.jtfnombre.setText(jtfnombre);
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private javax.swing.JPanel jpDestino;
    private custom_swing.TextField jtfid_destino;
    private custom_swing.TextField jtfnombre;
    // End of variables declaration//GEN-END:variables
}
