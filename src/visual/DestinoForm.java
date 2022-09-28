package visual;

import dao.DestinoDAO;
import entidades.Destino;
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
public class DestinoForm extends javax.swing.JPanel {
    
    private DestinoDAO dao = new DestinoDAO();
 
    public DestinoForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtDestinos);
        mostrarActivos();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        btnAdd = new custom_swing.Button();
        btnView = new custom_swing.ButtonCircular();
        btnEdit = new custom_swing.ButtonCircular();
        btnDelete = new custom_swing.ButtonCircular();
        scrollDestinos = new javax.swing.JScrollPane();
        jtDestinos = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar destino");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view_button.png"))); // NOI18N
        btnView.setToolTipText("Ver cliente");
        btnView.setEnabled(false);
        btnView.setPreferredSize(new java.awt.Dimension(30, 30));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_button.png"))); // NOI18N
        btnEdit.setToolTipText("Editar cliente");
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar cliente");
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        scrollDestinos.setBackground(new java.awt.Color(255, 255, 255));
        scrollDestinos.setBorder(null);
        scrollDestinos.setOpaque(false);

        jtDestinos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDestinos.setToolTipText("Lista de Destinos");
        jtDestinos.setGridColor(new java.awt.Color(204, 204, 204));
        jtDestinos.setRowHeight(25);
        jtDestinos.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtDestinos.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtDestinos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDestinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDestinosMouseClicked(evt);
            }
        });
        scrollDestinos.setViewportView(jtDestinos);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollDestinos, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollDestinos, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar destino
        JD_Adicionar_destino JDAdd = new JD_Adicionar_destino(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){
            mostrarActivos();
           comprobarSeleccion();
        }
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void jtDestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDestinosMouseClicked
        comprobarSeleccion();
    }//GEN-LAST:event_jtDestinosMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar destino
        if (posicion() != -1){
            JD_Adicionar_destino JDEdit = new JD_Adicionar_destino(null, true);
            JDEdit.setLocationRelativeTo(this);
            Destino d = getDestinoSeleccionado();
            JDEdit.dialogo_editar(d);
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

     //Método para actualizar la tabla con la lista de destinos
    private void mostrarActivos() {
        DestinoDAO dao = new DestinoDAO();
        String[] columnNames = {"Código", "Nombre"};
        ArrayList<Destino> destinos = new ArrayList<>();
        try {
            destinos = dao.listaDestinosActivos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[destinos.size()][2];        
        for (int i = 0; i < destinos.size(); i++) {
            data[i][0] = destinos.get(i).getId_destino();
            data[i][1] = destinos.get(i).getNombre();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtDestinos.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtDestinos, scrollDestinos); 
    }
    
    private Destino getDestinoSeleccionado(){
        String value = jtDestinos.getModel().getValueAt(posicion(), 0).toString();
        Destino d = new Destino();
        try {
            d = dao.getDestino(value);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return d;
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
        return jtDestinos.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel bg;
    private custom_swing.Button btnAdd;
    private custom_swing.ButtonCircular btnDelete;
    private custom_swing.ButtonCircular btnEdit;
    private custom_swing.ButtonCircular btnView;
    private javax.swing.JTable jtDestinos;
    private javax.swing.JScrollPane scrollDestinos;
    // End of variables declaration//GEN-END:variables
}
