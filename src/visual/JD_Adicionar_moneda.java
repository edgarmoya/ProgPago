package visual;

import javax.swing.JOptionPane;
import entidades.Moneda;
import dao.MonedaDAO;
import excepciones.BDException;
import excepciones.ConnectionException;
import excepciones.FaltanDatosException;
import excepciones.LongitudException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import utiles.keyboradUtil;

/**
 *
 * @author Lester
 */
public class JD_Adicionar_moneda extends javax.swing.JDialog {

    private MonedaDAO mDAO = new MonedaDAO();
    private String sigMoneda;
    private boolean cambios;
    private boolean editar;
    
    public JD_Adicionar_moneda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("add_button"));
        
        siguienteCampo();
        focusButtons();
        maxLength();
    }
    
    public Image getIconImage (String nombe_icono){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/"+nombe_icono+".png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNueva_moneda = new javax.swing.JPanel();
        jtfsiglas = new custom_swing.TextField();
        jtfnombre = new custom_swing.TextField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Moneda");
        setResizable(false);

        jpNueva_moneda.setBackground(new java.awt.Color(255, 255, 255));

        jtfsiglas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfsiglas.setToolTipText("Inserte las siglas de la moneda");
        jtfsiglas.setLabelText("SIGLAS*");
        jtfsiglas.setOpaque(false);
        jtfsiglas.setPreferredSize(new java.awt.Dimension(64, 48));
        jtfsiglas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfsiglasKeyReleased(evt);
            }
        });

        jtfnombre.setToolTipText("Inserte el nombre de la moneda");
        jtfnombre.setLabelText("NOMBRE*");
        jtfnombre.setOpaque(false);
        jtfnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfnombreKeyReleased(evt);
            }
        });

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar nueva moneda");
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

        javax.swing.GroupLayout jpNueva_monedaLayout = new javax.swing.GroupLayout(jpNueva_moneda);
        jpNueva_moneda.setLayout(jpNueva_monedaLayout);
        jpNueva_monedaLayout.setHorizontalGroup(
            jpNueva_monedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNueva_monedaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpNueva_monedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfsiglas, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jtfnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(jpNueva_monedaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jpNueva_monedaLayout.setVerticalGroup(
            jpNueva_monedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNueva_monedaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtfsiglas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jpNueva_monedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNueva_moneda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNueva_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Limpiar todos los campos y hacer focus el primero
    private void limpiar(){
        jtfsiglas.setText("");
        jtfnombre.setText("");
        jtfsiglas.requestFocus();
        camposRequeridos();
    }
    
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

    private void jtfsiglasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfsiglasKeyReleased
        // TODO add your handling code here:
        camposRequeridos();    
    }//GEN-LAST:event_jtfsiglasKeyReleased

    private void jtfnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfnombreKeyReleased
        // TODO add your handling code here:
        camposRequeridos();
    }//GEN-LAST:event_jtfnombreKeyReleased

    // Permitir determinada longitud de caracteres
    private void maxLength() {
        keyboradUtil.maxLength(jtfsiglas, 3);
        keyboradUtil.maxLength(jtfnombre, 30);
    }
    
    // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfsiglas, jtfnombre);
        keyboradUtil.siguienteCampo(jtfnombre, btnAceptar, btnCancelar);
    }
    
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfsiglas.getText().isEmpty() || jtfnombre.getText().isEmpty()) {
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
            java.util.logging.Logger.getLogger(JD_Adicionar_moneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_moneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_moneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_moneda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Adicionar_moneda dialog = new JD_Adicionar_moneda(new javax.swing.JFrame(), true);
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
    
    // Agregar moneda a bd
    private void accionAgregar(){
        Moneda m = new Moneda();
        m.setSiglas(jtfsiglas.getText());
        m.setNombre(jtfnombre.getText());
        m.setActivo((byte) (1));
        
        try {
            if (m.isValido()) {  // Validar
                String res = mDAO.agregarMoneda(m);
                if (!res.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Moneda agregada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cambios = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException | LongitudException | ConnectionException | BDException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Editar moneda en bd
    private void accionEditar(){
        Moneda m = new Moneda();
        m.setSiglas(jtfsiglas.getText());
        m.setNombre(jtfnombre.getText());

        try {           
            if (m.isValido()) {   // Validar campos
                String res = mDAO.actualizarMoneda(sigMoneda, m);
                if (!res.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Moneda editada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    cambios = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al editar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException | LongitudException | ConnectionException | BDException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Cambios que se producirán si se va a editar la moneda
    public void dialogo_editar(Moneda m){  
        editar = true;
        sigMoneda = m.getSiglas();
        // Editar título e icono
        setTitle("Editar Moneda");
        setIconImage(getIconImage("edit_button"));
        // Cambiar toolTip del btnAceptar
        btnAceptar.setToolTipText("Editar moneda");
        // Mostrar datos en campo correspondiente
        setJtfsiglas(m.getSiglas());
        setJtfnombre(m.getNombre());
        // Comprobar campos para que se active el btnAceptar
        camposRequeridos();
    }
    
    // retorna si se realizó algún cambio o no
    public boolean cambios() {
        return cambios;
    }
     
    // Setters
    public void setJtfsiglas(String jtfsiglas) {
        this.jtfsiglas.setText(jtfsiglas);
    }

    public void setJtfnombre(String jtfnombre) {
        this.jtfnombre.setText(jtfnombre);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnCancelar;
    private javax.swing.JPanel jpNueva_moneda;
    private custom_swing.TextField jtfnombre;
    private custom_swing.TextField jtfsiglas;
    // End of variables declaration//GEN-END:variables
}
