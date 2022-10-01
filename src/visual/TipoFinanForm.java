package visual;

import dao.TipoFinanDAO;
import entidades.TipoFinan;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;

/**
 *
 * @author Lester
 */
public class TipoFinanForm extends javax.swing.JPanel {
    
    private TipoFinanDAO tfDAO = new TipoFinanDAO();

    public TipoFinanForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtTipoFinans);
        mostrarActivos();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnAdd = new custom_swing.ButtonCircular();
        btnView = new custom_swing.ButtonCircular();
        btnEdit = new custom_swing.ButtonCircular();
        btnDelete = new custom_swing.ButtonCircular();
        scrollTipoFinans = new javax.swing.JScrollPane();
        jtTipoFinans = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(220, 227, 237));

        btnAdd.setBackground(new java.awt.Color(228, 235, 245));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar tipo de financiamiento");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view_button.png"))); // NOI18N
        btnView.setToolTipText("Ver tipo de financiamiento");
        btnView.setEnabled(false);
        btnView.setPreferredSize(new java.awt.Dimension(30, 30));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_button.png"))); // NOI18N
        btnEdit.setToolTipText("Editar tipo de financiamiento");
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar tipo de financiamiento");
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        scrollTipoFinans.setBackground(new java.awt.Color(255, 255, 255));
        scrollTipoFinans.setBorder(null);
        scrollTipoFinans.setOpaque(false);

        jtTipoFinans.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtTipoFinans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTipoFinans.setToolTipText("Lista de Tipos de Financiamiento");
        jtTipoFinans.setGridColor(new java.awt.Color(204, 204, 204));
        jtTipoFinans.setRowHeight(25);
        jtTipoFinans.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtTipoFinans.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtTipoFinans.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtTipoFinans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTipoFinansMouseClicked(evt);
            }
        });
        scrollTipoFinans.setViewportView(jtTipoFinans);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollTipoFinans, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollTipoFinans, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtTipoFinansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTipoFinansMouseClicked
       comprobarSeleccion();
    }//GEN-LAST:event_jtTipoFinansMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar tipo de finan
        JD_Adicionar_tipo_de_financiamiento JDAdd = new JD_Adicionar_tipo_de_financiamiento(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){
            mostrarActivos();
            comprobarSeleccion();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar tipo de financiamiento
        if (posicion() != -1){
            JD_Adicionar_tipo_de_financiamiento JDEdit = new JD_Adicionar_tipo_de_financiamiento(null, true);
            JDEdit.setLocationRelativeTo(this);
            TipoFinan tf = getTipoFinanSeleccionado();
            JDEdit.dialogo_editar(tf);
            JDEdit.setVisible(true);

            // Si se efectuaron cambios actualizar tabla
            if (JDEdit.cambios()){
                mostrarActivos();
                comprobarSeleccion();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione la fila que desea editar", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    //Método para actualizar la tabla con la lista de tipos de financiamiento
    private void mostrarActivos() {
        TipoFinanDAO dao = new TipoFinanDAO();
        String[] columnNames = {"Código", "Descripción"};
        ArrayList<TipoFinan> tipofinans = new ArrayList<>();
        try {
            tipofinans = dao.listaTipoFinans();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[tipofinans.size()][2];        
        for (int i = 0; i < tipofinans.size(); i++) {
            data[i][0] = tipofinans.get(i).getCod_tipo();
            data[i][1] = tipofinans.get(i).getDescripcion();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtTipoFinans.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtTipoFinans, scrollTipoFinans);
    }

    private TipoFinan getTipoFinanSeleccionado(){
        String value = jtTipoFinans.getModel().getValueAt(posicion(), 0).toString();
        TipoFinan tf = new TipoFinan();
        try {
            tf = tfDAO.getTipoFinan(value);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return tf;
    }
    
    // Habilitar botones
    private void enabled(boolean estado){
        btnEdit.setEnabled(estado);
        btnView.setEnabled(estado);
        btnDelete.setEnabled(estado);
    }
    
    // Comprobar si hay fila seleccionada
    private void comprobarSeleccion(){   
        if (posicion() != -1) {
            // Si se selecciona una fila habilitar opciones
            enabled(true);
        } else {
            enabled(false);
        }
    }
    
    // Posición de la fila seleccionada
    private int posicion(){
        return jtTipoFinans.getSelectedRow();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.ButtonCircular btnAdd;
    private custom_swing.ButtonCircular btnDelete;
    private custom_swing.ButtonCircular btnEdit;
    private custom_swing.ButtonCircular btnView;
    private javax.swing.JTable jtTipoFinans;
    private javax.swing.JScrollPane scrollTipoFinans;
    // End of variables declaration//GEN-END:variables
}
