package visual;

import dao.TipoFinanDAO;
import entidades.TipoFinan;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;

/**
 *
 * @author Lester
 */
public class TipoFinanForm extends javax.swing.JPanel {
    
    private TipoFinanDAO tfDAO = new TipoFinanDAO();
    private boolean showAll;

    public TipoFinanForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtTipoFinans);
        refrescar();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnAdd = new custom_swing.ButtonCircular();
        btnEdit = new custom_swing.ButtonCircular();
        btnDelete = new custom_swing.ButtonCircular();
        btnShowAll = new custom_swing.ButtonCircular();
        btnActivate = new custom_swing.ButtonCircular();
        btnRefresh = new custom_swing.ButtonCircular();
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
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png"))); // NOI18N
        btnShowAll.setToolTipText("Mostrar todos los tipo de financiamiento");
        btnShowAll.setPreferredSize(new java.awt.Dimension(30, 30));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnActivate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activate_button.png"))); // NOI18N
        btnActivate.setToolTipText("Activar tipo de financiamiento");
        btnActivate.setEnabled(false);
        btnActivate.setPreferredSize(new java.awt.Dimension(30, 30));
        btnActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh_button.png"))); // NOI18N
        btnRefresh.setToolTipText("Refrescar");
        btnRefresh.setPreferredSize(new java.awt.Dimension(30, 30));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(scrollTipoFinans, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
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
       if (showAll){
            comprobarActivo();
        }
    }//GEN-LAST:event_jtTipoFinansMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar tipo de finan
        JD_Adicionar_tipo_de_financiamiento JDAdd = new JD_Adicionar_tipo_de_financiamiento(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){
            refrescar();
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
                refrescar();
                comprobarSeleccion();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de financiamiento que desea editar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        if (!showAll){
            mostrarTodo();
            showAll = true;
            btnShowAll.setToolTipText("Mostrar los tipos de financiamiento activos");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_activos_button.png")));
        } else {
            mostrarActivos();
            showAll = false;
            btnShowAll.setToolTipText("Mostrar todos los tipos de financiamiento");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png")));
        }
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // Acción para activar tipo de financiamiento
        if (posicion() != -1) {
            String codigo = jtTipoFinans.getModel().getValueAt(posicion(), 0).toString();
            try {
                if (tfDAO.activarTipoFinan(codigo)){
                    refrescar();
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de financiamiento que desea activar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Acción para eliminar tipo de financiamiento
        if (posicion() != -1) {
            String codigo = jtTipoFinans.getModel().getValueAt(posicion(), 0).toString();
            accionEliminar(codigo);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de financiamiento que desea eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    //Método para actualizar la tabla con la lista de tipos de financiamiento ACTIVOS
    private void mostrarActivos() {
        TipoFinanDAO dao = new TipoFinanDAO();
        String[] columnNames = {"Código", "Descripción"};
        ArrayList<TipoFinan> tipofinans = new ArrayList<>();
        try {
            tipofinans = dao.listaTipoFinanActivos();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
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
    
    //Método para actualizar la tabla con la lista de TODOS los tipos de financiamiento
    private void mostrarTodo() {
        TipoFinanDAO dao = new TipoFinanDAO();
        String[] columnNames = {"Código", "Descripción", "Activo"};
        ArrayList<TipoFinan> tipofinans = new ArrayList<>();
        try {
            tipofinans = dao.listaTodoTipoFinan();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[tipofinans.size()][3];        
        for (int i = 0; i < tipofinans.size(); i++) {
            data[i][0] = tipofinans.get(i).getCod_tipo();
            data[i][1] = tipofinans.get(i).getDescripcion();
            data[i][2] = (tipofinans.get(i).getActivo()==1) ? "Sí" : "No";
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

    // Obtener datos del tipo de financiamiento a partir del código
    private TipoFinan getTipoFinanSeleccionado(){
        String value = jtTipoFinans.getModel().getValueAt(posicion(), 0).toString();
        TipoFinan tf = new TipoFinan();
        try {
            tf = tfDAO.getTipoFinan(value);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return tf;
    }
    
    // Eliminar tipo de financiamiento a partir del código
    private void accionEliminar(String codigo) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el tipo de financiamiento con código \"" + codigo + "\" ?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        try {
            if (input == 0) {   // 0=SI, 1=NO
                int result = tfDAO.useTipoFinan(codigo);
                if (result == 1) {   // si está en uso
                    int input2 = JOptionPane.showConfirmDialog(null, "No es posible eliminar al tipo de financiamiento con código \"" + codigo + "\" porque tiene información asociada. \n¿Desea desactivarlo del sistema?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (input2 == 0) {   // 0=SI, 1=NO
                        if (tfDAO.eliminarTipoFinan(codigo)) {
                            refrescar();
                            comprobarSeleccion();
                        }
                    } else {
                        JOptionPane.getRootFrame().dispose();
                    }
                } else {
                    if (tfDAO.eliminarTipoFinan(codigo)) {
                        refrescar();
                        comprobarSeleccion();
                    }
                }
            } else {
                JOptionPane.getRootFrame().dispose();
            }

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Comprobar si es un tipo de finan activo o inactivo
    private void comprobarActivo(){
        if (posicion() != -1) {
            String codigo = jtTipoFinans.getModel().getValueAt(posicion(), 0).toString();
            try {
                int res = tfDAO.isActivo(codigo);
                if (res == 1){
                    btnActivate.setEnabled(false);
                } else {
                    btnActivate.setEnabled(true);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de financiamiento que desea activar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Habilitar botones
    private void enabled(boolean estado){
        btnEdit.setEnabled(estado);
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
    
    // Refrescar form con tabla correspondiente
    private void refrescar(){
        if (showAll){
            mostrarTodo();
        } else{ 
            mostrarActivos();
        }
    }
    
    // Posición de la fila seleccionada
    private int posicion(){
        return jtTipoFinans.getSelectedRow();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.ButtonCircular btnActivate;
    private custom_swing.ButtonCircular btnAdd;
    private custom_swing.ButtonCircular btnDelete;
    private custom_swing.ButtonCircular btnEdit;
    private custom_swing.ButtonCircular btnRefresh;
    private custom_swing.ButtonCircular btnShowAll;
    private javax.swing.JTable jtTipoFinans;
    private javax.swing.JScrollPane scrollTipoFinans;
    // End of variables declaration//GEN-END:variables
}
