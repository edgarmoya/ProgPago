package visual;

import dao.ClienteDAO;
import entidades.Cliente;
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
 * @author Edgar Moya
 */
public class ClienteForm extends javax.swing.JPanel {

    private ClienteDAO cDAO = new ClienteDAO();
    private boolean showAll;
    
    public ClienteForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtClientes);
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
        scrollCliente = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(220, 227, 237));

        btnAdd.setBackground(new java.awt.Color(228, 235, 245));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar cliente");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png"))); // NOI18N
        btnShowAll.setToolTipText("Mostrar todos los clientes");
        btnShowAll.setPreferredSize(new java.awt.Dimension(30, 30));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnActivate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activate_button.png"))); // NOI18N
        btnActivate.setToolTipText("Activar cliente");
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
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        scrollCliente.setBackground(new java.awt.Color(255, 255, 255));
        scrollCliente.setBorder(null);
        scrollCliente.setOpaque(false);

        jtClientes.setBackground(new java.awt.Color(255, 255, 255));
        jtClientes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Organismo", "NIT", "REEUP", "Correo", "Dirección", "Teléfono", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClientes.setToolTipText("Lista de Clientes");
        jtClientes.setGridColor(new java.awt.Color(204, 204, 204));
        jtClientes.setOpaque(false);
        jtClientes.setRowHeight(25);
        jtClientes.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtClientes.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        scrollCliente.setViewportView(jtClientes);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        comprobarSeleccion();
        if (showAll){
            comprobarActivo();
        }
    }//GEN-LAST:event_jtClientesMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar cliente
        JD_Adicionar_cliente JDAdd = new JD_Adicionar_cliente(null, true);       
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);
        
        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){           
            refrescar();
            comprobarSeleccion();
        }    
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar cliente
        if (posicion() != -1){
            JD_Adicionar_cliente JDEdit = new JD_Adicionar_cliente(null, true); 
            JDEdit.setLocationRelativeTo(this);
            Cliente c = getClienteSeleccionado();
            JDEdit.dialogo_editar(c);
            JDEdit.setVisible(true);
        
            // Si se efectuaron cambios actualizar tabla
            if (JDEdit.cambios()){           
                refrescar();
                comprobarSeleccion();
            } 
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione la fila que desea editar", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        if (!showAll){
            mostrarTodo();
            showAll = true;
            btnShowAll.setToolTipText("Mostrar clientes activos");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_activos_button.png")));
        } else {
            mostrarActivos();
            showAll = false;
            btnShowAll.setToolTipText("Mostrar todos los clientes");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png")));
        }
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // Acción para activar cliente
        if (posicion() != -1) {
            String cod = jtClientes.getModel().getValueAt(posicion(), 0).toString();
            try {
                if (cDAO.activarCliente(cod)){
                    refrescar();
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el cliente que desea activar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Acción para eliminar cliente
        if (posicion() != -1) {
            String cod = jtClientes.getModel().getValueAt(posicion(), 0).toString();
            accionEliminar(cod);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el cliente que desea eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Eliminar cliente a partir del codigo
    private void accionEliminar(String codigo) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el cliente con código \"" + codigo + "\" ?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        try {
            if (input == 0) {   // 0=SI, 1=NO
                int result = cDAO.useCliente(codigo);
                if (result == 1) {   // si está en uso
                    int input2 = JOptionPane.showConfirmDialog(null, "No es posible eliminar el cliente con código \"" + codigo + "\" porque tiene información asociada. \n¿Desea desactivarlo del sistema?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (input2 == 0) {   // 0=SI, 1=NO
                        if (cDAO.eliminarCliente(codigo)) {
                            refrescar();
                            comprobarSeleccion();
                        }
                    } else {
                        JOptionPane.getRootFrame().dispose();
                    }
                } else {
                    if (cDAO.eliminarCliente(codigo)) {
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
    
    //Método para actualizar la tabla con la lista de clientes activos
    private void mostrarActivos() {
        String[] columnNames = {"Código", "Nombre", "Organismo", "NIT", "REEUP", "Correo", "Dirección", "Teléfono"};
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = cDAO.listaClientesActivos();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[clientes.size()][8];        
        for (int i = 0; i < clientes.size(); i++) {
            data[i][0] = clientes.get(i).getCod_cliente();
            data[i][1] = clientes.get(i).getNombre();
            data[i][2] = clientes.get(i).getOrganismo();
            data[i][3] = clientes.get(i).getNit();
            data[i][4] = clientes.get(i).getReeup();
            data[i][5] = clientes.get(i).getCorreo();
            data[i][6] = clientes.get(i).getDireccion();
            data[i][7] = clientes.get(i).getTelefono();
        }       
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtClientes.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtClientes, scrollCliente);
    }
    
    //Método para actualizar la tabla con la lista de todos los clientes
    private void mostrarTodo() {
        String[] columnNames = {"Código", "Nombre", "Organismo", "NIT", "REEUP", "Correo", "Dirección", "Teléfono", "Activo"};
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = cDAO.listaTodosClientes();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[clientes.size()][9];        
        for (int i = 0; i < clientes.size(); i++) {
            data[i][0] = clientes.get(i).getCod_cliente();
            data[i][1] = clientes.get(i).getNombre();
            data[i][2] = clientes.get(i).getOrganismo();
            data[i][3] = clientes.get(i).getNit();
            data[i][4] = clientes.get(i).getReeup();
            data[i][5] = clientes.get(i).getCorreo();
            data[i][6] = clientes.get(i).getDireccion();
            data[i][7] = clientes.get(i).getTelefono();
            data[i][8] = (clientes.get(i).getActivo()==1) ? "Sí" : "No";
        }       
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtClientes.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtClientes, scrollCliente);
    }
    
    // Obtener datos del cliente a partir del codigo
    private Cliente getClienteSeleccionado(){
        String value = jtClientes.getModel().getValueAt(posicion(), 0).toString();
        Cliente c = new Cliente();
        try {
            c = cDAO.getCliente(value);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }
    
    // Comprobar si es un cliente activo o inactivo
    private void comprobarActivo(){
        if (posicion() != -1) {
            String cod = jtClientes.getModel().getValueAt(posicion(), 0).toString();
            try {
                int res = cDAO.isActivo(cod);
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
            JOptionPane.showMessageDialog(this, "Seleccione el cliente que desea activar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }  
    
    // Comprobar si hay fila seleccionada
    private void comprobarSeleccion(){   
        if (posicion() != -1) {
            btnEdit.setEnabled(true);
            String cod = jtClientes.getModel().getValueAt(posicion(), 0).toString();
            // Comprobar si se puede activar el btnDelete
            try {
                if (cDAO.isActivo(cod) == 1){
                    btnDelete.setEnabled(true);
                } else {
                    btnDelete.setEnabled(false);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
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
        return jtClientes.getSelectedRow();
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
    private javax.swing.JTable jtClientes;
    private javax.swing.JScrollPane scrollCliente;
    // End of variables declaration//GEN-END:variables
}
