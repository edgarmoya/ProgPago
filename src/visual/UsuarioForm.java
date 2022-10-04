package visual;

import dao.UsuarioDAO;
import entidades.Usuario;
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
public class UsuarioForm extends javax.swing.JPanel {

    private UsuarioDAO uDAO = new UsuarioDAO();
    private boolean showAll;

    public UsuarioForm() {
        initComponents();

        //Editar color de la tabla
        JTableUtil.headerTable(jtUsuarios);
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
        scrollUsuarios = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(220, 227, 237));

        btnAdd.setBackground(new java.awt.Color(228, 235, 245));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar usuario");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_button.png"))); // NOI18N
        btnEdit.setToolTipText("Editar usuario");
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar usuario");
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(30, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png"))); // NOI18N
        btnShowAll.setToolTipText("Mostrar todos los usuario");
        btnShowAll.setPreferredSize(new java.awt.Dimension(30, 30));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnActivate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activate_button.png"))); // NOI18N
        btnActivate.setToolTipText("Activar usuario");
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
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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

        scrollUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        scrollUsuarios.setBorder(null);
        scrollUsuarios.setOpaque(false);

        jtUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nombre y Apellidos", "Niveles de Acceso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jtUsuarios.setToolTipText("Lista de Usuarios");
        jtUsuarios.setGridColor(new java.awt.Color(204, 204, 204));
        jtUsuarios.setRowHeight(25);
        jtUsuarios.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtUsuarios.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        scrollUsuarios.setViewportView(jtUsuarios);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        comprobarSeleccion();
        if (showAll){
            comprobarActivo();
        }
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar usuario
        JD_Adicionar_usuario JDAdd = new JD_Adicionar_usuario(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()) {
            refrescar();
            comprobarSeleccion();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar usuario
        if (posicion() != -1) {
            JD_Adicionar_usuario JDEdit = new JD_Adicionar_usuario(null, true);
            JDEdit.setLocationRelativeTo(this);
            Usuario u = getUsuarioSeleccionado();
            JDEdit.dialogo_editar(u);
            JDEdit.setRoles(u.getRoles());
            JDEdit.setVisible(true);

            // Si se efectuaron cambios actualizar tabla
            if (JDEdit.cambios()) {
                refrescar();
                comprobarSeleccion();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el usuario que desea editar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Acción para eliminar usuario
        if (posicion() != -1) {
            String identificador = jtUsuarios.getModel().getValueAt(posicion(), 0).toString();
            accionEliminar(identificador);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el usuario que desea eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        if (!showAll){
            mostrarTodo();
            showAll = true;
            btnShowAll.setToolTipText("Mostrar usuarios activos");    
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_activos_button.png")));
        } else {
            mostrarActivos();
            showAll = false;
            btnShowAll.setToolTipText("Mostrar todos los usuarios");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png")));
        }
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // Acción para activar usuario
        if (posicion() != -1) {
            String identificador = jtUsuarios.getModel().getValueAt(posicion(), 0).toString();
            try {
                if (uDAO.activarUsuario(identificador)){
                    refrescar();
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el usuario que desea activar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivateActionPerformed

    // Eliminar usuario a partir del identificador
    private void accionEliminar(String identificador) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario \"" + identificador + "\" ?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        try {
            if (input == 0) {   // 0=SI, 1=NO
                int result = uDAO.useUsuario(identificador);
                if (result == 1) {   // si está en uso
                    int input2 = JOptionPane.showConfirmDialog(null, "No es posible eliminar al usuario \"" + identificador + "\" porque tiene información asociada. \n¿Desea desactivarlo del sistema?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (input2 == 0) {   // 0=SI, 1=NO
                        if (uDAO.eliminarUsuario(identificador)) {
                            refrescar();
                            comprobarSeleccion();
                        }
                    } else {
                        JOptionPane.getRootFrame().dispose();
                    }
                } else {
                    if (uDAO.eliminarUsuario(identificador)) {
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

    //Método para actualizar la tabla con la lista de usuarios activos
    private void mostrarActivos() {
        UsuarioDAO dao = new UsuarioDAO();
        String[] columnNames = {"Identificador", "Nombre y Apellidos", "Niveles de Acceso"};
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = dao.listaUsuariosActivos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos." + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[usuarios.size()][3];
        for (int i = 0; i < usuarios.size(); i++) {
            data[i][0] = usuarios.get(i).getIdentificador();
            data[i][1] = usuarios.get(i).getNombre();
            data[i][2] = usuarios.get(i).getRoles();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtUsuarios.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtUsuarios, scrollUsuarios);
    }
    
    //Método para actualizar la tabla con la lista de todos los usuarios
    private void mostrarTodo() {
        UsuarioDAO dao = new UsuarioDAO();
        String[] columnNames = {"Identificador", "Nombre y Apellidos", "Niveles de Acceso", "Activo"};
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = dao.listaTodosUsuarios();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos." + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[usuarios.size()][4];
        for (int i = 0; i < usuarios.size(); i++) {
            data[i][0] = usuarios.get(i).getIdentificador();
            data[i][1] = usuarios.get(i).getNombre();
            data[i][2] = usuarios.get(i).getRoles();
            data[i][3] = (usuarios.get(i).getActivo()==1) ? "Sí" : "No";
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtUsuarios.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtUsuarios, scrollUsuarios);
    }

    // Obtener datos del usuario a partir del identificador
    private Usuario getUsuarioSeleccionado() {
        String value = jtUsuarios.getModel().getValueAt(posicion(), 0).toString();
        Usuario u = new Usuario();
        try {
            u = uDAO.getUsuario(value);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return u;
    }
    
    // Comprobar si es un usuario activo o inactivo
    private void comprobarActivo(){
        if (posicion() != -1) {
            String identificador = jtUsuarios.getModel().getValueAt(posicion(), 0).toString();
            try {
                int res = uDAO.isActivo(identificador);
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
            JOptionPane.showMessageDialog(this, "Seleccione el usuario que desea activar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Comprobar si hay fila seleccionada
    private void comprobarSeleccion() {
        if (posicion() != -1) {
            btnEdit.setEnabled(true);
            String ident = jtUsuarios.getModel().getValueAt(posicion(), 0).toString();
            // Comprobar si se puede activar el btnDelete
            try {
                if (uDAO.isActivo(ident) == 1){
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
    private int posicion() {
        return jtUsuarios.getSelectedRow();
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
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JScrollPane scrollUsuarios;
    // End of variables declaration//GEN-END:variables
}
