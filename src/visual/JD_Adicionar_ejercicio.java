package visual;

import javax.swing.JOptionPane;
import entidades.Ejercicio;
import dao.EjercicioDAO;
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
public class JD_Adicionar_ejercicio extends javax.swing.JDialog {

    private EjercicioDAO eDAO = new EjercicioDAO();
    private String codEjercicio;
    private boolean cambios;
    private boolean editar;
    
    public JD_Adicionar_ejercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("add_button"));
        
        siguienteCampo();
        soloNumeros();
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

        jpNuevo_ejercicio = new javax.swing.JPanel();
        jtfEjercicio = new custom_swing.TextField();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Ejercicio");
        setResizable(false);

        jpNuevo_ejercicio.setBackground(new java.awt.Color(255, 255, 255));

        jtfEjercicio.setToolTipText("Inserte el ejercicio");
        jtfEjercicio.setLabelText("EJERCICIO*");
        jtfEjercicio.setOpaque(false);
        jtfEjercicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfEjercicioKeyReleased(evt);
            }
        });

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar nuevo ejercicio");
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

        javax.swing.GroupLayout jpNuevo_ejercicioLayout = new javax.swing.GroupLayout(jpNuevo_ejercicio);
        jpNuevo_ejercicio.setLayout(jpNuevo_ejercicioLayout);
        jpNuevo_ejercicioLayout.setHorizontalGroup(
            jpNuevo_ejercicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevo_ejercicioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jtfEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jpNuevo_ejercicioLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jpNuevo_ejercicioLayout.setVerticalGroup(
            jpNuevo_ejercicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNuevo_ejercicioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtfEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jpNuevo_ejercicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevo_ejercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevo_ejercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!editar){
            // Agregar ejercicio
            accionAgregar();
        }else{
            // Editar ejercicio
            accionEditar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Limpiar todos los campos y hacer focus el primero
    private void limpiar() {
        jtfEjercicio.setText("");
        jtfEjercicio.requestFocus();
        camposRequeridos();
    }
    
    // Permitir determinada longitud de caracteres
    private void maxLength() {
        keyboradUtil.maxLength(jtfEjercicio, 4);
    }    
    
     // Ir al siguiente campo al presionar ENTER
    private void siguienteCampo() {
        keyboradUtil.siguienteCampo(jtfEjercicio, btnAceptar, btnCancelar);
    }
    
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        if (jtfEjercicio.getText().isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }
    
    // Permitir solo números
    private void soloNumeros() {
        keyboradUtil.soloNumeros(jtfEjercicio);       
    }
    
     // Método para cambiar el focus al siguiente botón 
    private void focusButtons(){
        keyboradUtil.focusButton(btnAceptar, btnCancelar);
        keyboradUtil.focusButton(btnCancelar, btnAceptar);
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtfEjercicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEjercicioKeyReleased
        // TODO add your handling code here:
        camposRequeridos();
    }//GEN-LAST:event_jtfEjercicioKeyReleased

    // Agregar ejercicio a bd
    private void accionAgregar(){
        Ejercicio e = new Ejercicio();
        e.setEjercicio(jtfEjercicio.getText());
        
         try {
            // Validar
            if (e.isValido()) {
                if (eDAO.agregarEjercicio(e)) {
                    JOptionPane.showMessageDialog(this, "Ejercicio agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    cambios = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FaltanDatosException | LongitudException | ConnectionException | BDException fd) {
            JOptionPane.showMessageDialog(this, fd.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);     
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     // Editar ejercicio en bd
    private void accionEditar(){
        Ejercicio e = new Ejercicio();
        e.setEjercicio(jtfEjercicio.getText());
        
         try {
            // Validar campos
            if (e.isValido()) {
                if (eDAO.editarEjercicio(codEjercicio, e)) {
                    JOptionPane.showMessageDialog(this, "Ejercicio editado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(JD_Adicionar_ejercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_ejercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_ejercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_ejercicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Adicionar_ejercicio dialog = new JD_Adicionar_ejercicio(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jpNuevo_ejercicio;
    private custom_swing.TextField jtfEjercicio;
    // End of variables declaration//GEN-END:variables

    //Cambios que se producirán si se va a editar el ejercicio
    public void dialogo_editar(Ejercicio e){  
        editar = true;
        codEjercicio = ""+e.getCod_ejercicio();
        // Editar título e icono
        setTitle("Editar Ejercicio");
        setIconImage(getIconImage("edit_button"));
        // Cambiar toolTip del btnAceptar
        btnAceptar.setToolTipText("Editar ejercicio");
        // Mostrar datos en campo correspondiente
        setJtfejercicio(e.getEjercicio());
        // Comprobar campos para que se active el btnAceptar
        camposRequeridos();
    }
    
    // retorna si se realizó algún cambio o no
    public boolean cambios() {
        return cambios;
    }
     
    // Setters
 
    public void setJtfejercicio(String jtfejercicio) {
        this.jtfEjercicio.setText(jtfejercicio);
    }
}
