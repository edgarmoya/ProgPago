package visual;

import dao.DestinoDAO;
import entidades.Destino;
import entidades.DestinoDesglose;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;
import utiles.autoComplete;

/**
 *
 * @author Edgar Moya
 */
public class JD_Desglose_destino extends javax.swing.JDialog {
    
    private boolean editar;
    private ArrayList<Double> importes;
    private boolean accept;
    
    public JD_Desglose_destino(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("desglose_button"));

        //Editar color de la tabla
        JTableUtil.headerTable(jtDesglose);
        JTableUtil.headerAligment(jtDesglose, JLabel.CENTER);

        buscarDestinos();
        mostrarTablaVacia();
        listenerEvent();
        camposRequeridos();
    }

    public Image getIconImage(String nombre_icono) {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/" + nombre_icono + ".png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        scrollDesglose = new javax.swing.JScrollPane();
        jtDesglose = new javax.swing.JTable();
        btnCancelar = new custom_swing.Button();
        btnAceptar = new custom_swing.Button();
        jcbDestino = new custom_swing.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Desglose por Períodos");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        scrollDesglose.setBackground(new java.awt.Color(255, 255, 255));
        scrollDesglose.setBorder(null);
        scrollDesglose.setOpaque(false);

        jtDesglose.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtDesglose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Período", "Importe", "Acumulado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtDesglose.setToolTipText("Desglose por períodos");
        jtDesglose.setGridColor(new java.awt.Color(204, 204, 204));
        jtDesglose.setRowHeight(25);
        jtDesglose.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtDesglose.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtDesglose.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDesglose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDesgloseMouseClicked(evt);
            }
        });
        jtDesglose.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtDesgloseInputMethodTextChanged(evt);
            }
        });
        jtDesglose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtDesgloseKeyReleased(evt);
            }
        });
        scrollDesglose.setViewportView(jtDesglose);

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

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar destino");
        btnAceptar.setEnabled(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jcbDestino.setToolTipText("Seleccione el destino ");
        jcbDestino.setLabeText("DESTINO*");
        jcbDestino.setOpaque(false);
        jcbDestino.setPreferredSize(new java.awt.Dimension(58, 48));
        jcbDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDestinoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jcbDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollDesglose, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jcbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollDesglose, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jtDesgloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDesgloseMouseClicked
        updateAcumulado();
        camposRequeridos();
    }//GEN-LAST:event_jtDesgloseMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        accept = true;
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jcbDestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDestinoMouseClicked
        camposRequeridos();
    }//GEN-LAST:event_jcbDestinoMouseClicked

    private void jtDesgloseInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtDesgloseInputMethodTextChanged
        updateAcumulado();
        camposRequeridos();
    }//GEN-LAST:event_jtDesgloseInputMethodTextChanged

    private void jtDesgloseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDesgloseKeyReleased
        updateAcumulado();
        camposRequeridos();
    }//GEN-LAST:event_jtDesgloseKeyReleased

    //Método para actualizar la tabla con la lista de períodos
    private void mostrarTablaVacia() {
        String[] columnNames = {"Período", "Importe", "Acumulado"};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        String[][] data = new String[meses.length][3];
        for (int i = 0; i < meses.length; i++) {
            data[i][0] = meses[i];
            data[i][1] = "0.0";
            data[i][2] = "0.0";
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // tabla no editable, solo los importes
                return column == 1;   
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
                double valor = validateCell(aValue);
                super.setValueAt(valor, row, column); 
            }        
        };
        jtDesglose.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtDesglose, scrollDesglose);
        // Alinear los importes a la derecha
        jtDesglose.getColumnModel().getColumn(1).setCellRenderer(JTableUtil.alinearColumna(DefaultTableCellRenderer.RIGHT));
        jtDesglose.getColumnModel().getColumn(2).setCellRenderer(JTableUtil.alinearColumna(DefaultTableCellRenderer.RIGHT));
    }
    
    // Método para actualizar la tabla con la lista de importes correspondientes
    private void mostrarDesglose(DestinoDesglose ddesg) { 
        DefaultTableModel m = (DefaultTableModel) jtDesglose.getModel();
        for (int i = 0; i < ddesg.getImportes().size(); i++) {
            m.setValueAt(String.valueOf(ddesg.getImportes().get(i)), i, 1);
        }
    }
    
    // Validar que se escriban solo numeric
    private double validateCell(Object numberObj){
        try {
            double number = Double.parseDouble((String) numberObj);
            return number; 
        } catch (Exception e) {
            return 0.0;
        }
    }
    
    // Oyente para si se efectúa cualquir cambio
    private void listenerEvent(){
        jtDesglose.getModel().addTableModelListener(
        new TableModelListener() {
            public void tableChanged(TableModelEvent evt) {
                /*Nada*/
            }
        });
    }
    
    // Actualizar la columna de acumulados
    private void updateAcumulado(){    
        DefaultTableModel m = (DefaultTableModel) jtDesglose.getModel();
        for (int i = 0; i < 12; i++) {
            double acumAnterior;
            try {
                acumAnterior = Double.parseDouble((String.valueOf(m.getValueAt(i-1, 2))));
            } catch (Exception e) {
                acumAnterior = 0.0;
            }
            double impMes = Double.parseDouble(String.valueOf(m.getValueAt(i, 1)));
            m.setValueAt(String.valueOf(acumAnterior+impMes), i, 2);
        }
    }
    
    // Buscar destinos de la BD
    private void buscarDestinos() {
        //Limpiar ComboBox
        jcbDestino.removeAllItems();
        DestinoDAO dDAO = new DestinoDAO();
        try {
            ArrayList<Destino> destinos = dDAO.listaDestinosActivos();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[destinos.size()];
            for (int i = 0; i < destinos.size(); i++) {
                veDatos[i] = destinos.get(i).getId_destino()+ " " +destinos.get(i).getNombre();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbDestino, veDatos);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        DefaultTableModel m = (DefaultTableModel) jtDesglose.getModel();
        double importe = Double.parseDouble(String.valueOf(m.getValueAt(11, 2)));
        String destino = (jcbDestino.getSelectedIndex()!=-1) ? jcbDestino.getSelectedItem().toString() : "";          
        if (destino.isEmpty() || importe == 0.0) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }

    // Retornar una lista con los importes
    public ArrayList<Double> getImportes() {
        DefaultTableModel m = (DefaultTableModel) jtDesglose.getModel();
        importes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            importes.add(Double.parseDouble(String.valueOf(m.getValueAt(i, 1))));
        }
        return importes;
    }

    // Retornar destino seleccionado
    public String getDestino() { 
        return (jcbDestino.getSelectedIndex()!=-1) ? jcbDestino.getSelectedItem().toString() : "";
    }

    // Retorna si se aceptaron los cambios
    public boolean isAccept() {
        return accept;
    }   
    
    // 
    public void setDesglose(DestinoDesglose desglose){  
        jcbDestino.setSelectedItem((String) desglose.getDestino());
        mostrarDesglose(desglose);
        updateAcumulado();
        editar = true;
        camposRequeridos();
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
            java.util.logging.Logger.getLogger(JD_Desglose_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Desglose_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Desglose_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Desglose_destino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Desglose_destino dialog = new JD_Desglose_destino(new javax.swing.JFrame(), true);
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
    private custom_swing.Combobox jcbDestino;
    private javax.swing.JTable jtDesglose;
    private javax.swing.JScrollPane scrollDesglose;
    // End of variables declaration//GEN-END:variables
}
