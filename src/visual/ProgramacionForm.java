package visual;

import dao.ProgramacionDAO;
import entidades.Programacion;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.JTableUtil;

/**
 *
 * @author Edgar Moya
 */
public class ProgramacionForm extends javax.swing.JPanel {

    private ProgramacionDAO pDAO = new ProgramacionDAO();
    private boolean showAll;
    
    public ProgramacionForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtProgramacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnAdd = new custom_swing.ButtonCircular();
        btnEdit = new custom_swing.ButtonCircular();
        btnDelete = new custom_swing.ButtonCircular();
        btnShowAll = new custom_swing.ButtonCircular();
        btnActivate = new custom_swing.ButtonCircular();
        btnRefresh = new custom_swing.ButtonCircular();
        scrollProgramacion = new javax.swing.JScrollPane();
        jtProgramacion = new javax.swing.JTable();

        bg.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(220, 227, 237));

        btnAdd.setBackground(new java.awt.Color(228, 235, 245));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar programación de pago");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_button.png"))); // NOI18N
        btnEdit.setToolTipText("Editar programación de pago");
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar programación de pago");
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(30, 30));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png"))); // NOI18N
        btnShowAll.setToolTipText("Mostrar todas las programaciones");
        btnShowAll.setPreferredSize(new java.awt.Dimension(30, 30));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnActivate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activate_button.png"))); // NOI18N
        btnActivate.setToolTipText("Activar programación");
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
                .addContainerGap(523, Short.MAX_VALUE))
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

        scrollProgramacion.setBackground(new java.awt.Color(255, 255, 255));
        scrollProgramacion.setBorder(null);
        scrollProgramacion.setOpaque(false);

        jtProgramacion.setBackground(new java.awt.Color(255, 255, 255));
        jtProgramacion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtProgramacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ejercicio", "Tipo de Financiamiento", "Cliente", "Moneda", "Importe", "Estado", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProgramacion.setToolTipText("Lista de Programaciones");
        jtProgramacion.setGridColor(new java.awt.Color(204, 204, 204));
        jtProgramacion.setOpaque(false);
        jtProgramacion.setRowHeight(25);
        jtProgramacion.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtProgramacion.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtProgramacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtProgramacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProgramacionMouseClicked(evt);
            }
        });
        scrollProgramacion.setViewportView(jtProgramacion);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollProgramacion)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollProgramacion, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar programacion
        JD_Adicionar_programacion JDAdd = new JD_Adicionar_programacion(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        /*// Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){
            //refrescar();
            //comprobarSeleccion();
        }*/
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar programacion
        /*if (posicion() != -1){
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
        }*/
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Acción para eliminar programacion
        /*if (posicion() != -1) {
            String cod = jtClientes.getModel().getValueAt(posicion(), 0).toString();
            accionEliminar(cod);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el cliente que desea eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }*/
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        /*if (!showAll){
            mostrarTodo();
            showAll = true;
            btnShowAll.setToolTipText("Mostrar clientes activos");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_activos_button.png")));
        } else {
            mostrarActivos();
            showAll = false;
            btnShowAll.setToolTipText("Mostrar todos los clientes");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png")));
        }*/
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateActionPerformed
        // Acción para activar programacion
        /*if (posicion() != -1) {
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
        }*/
    }//GEN-LAST:event_btnActivateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        ProgramacionDAO pDAO = new ProgramacionDAO();
        Programacion prog = new Programacion(1, java.sql.Date.valueOf("2017-09-24"),"","0007","2022","0004", "CUP", "edgar", (byte) 1);
        String[] destinos = {"0005"};
        String[] importes = {"10", "20","30","40","50","60","70","80","90","100","110","120"};
        try {
            pDAO.agregarProgramacion(prog, destinos, importes);
        } catch (SQLException ex) {
            Logger.getLogger(ProgramacionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProgramacionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectionException ex) {
            Logger.getLogger(ProgramacionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BDException ex) {
            Logger.getLogger(ProgramacionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jtProgramacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProgramacionMouseClicked
        comprobarSeleccion();
        if (showAll){
            //comprobarActivo();
        }
    }//GEN-LAST:event_jtProgramacionMouseClicked

    // Comprobar si hay fila seleccionada
    private void comprobarSeleccion(){   
        if (posicion() != -1) {
            btnEdit.setEnabled(true);
            String cod = jtProgramacion.getModel().getValueAt(posicion(), 0).toString();
            // Comprobar si se puede activar el btnDelete
            /*try {
                if (cDAO.isActivo(cod) == 1){
                    btnDelete.setEnabled(true);
                } else {
                    btnDelete.setEnabled(false);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }*/    
        } else {
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        }
    }
    
    // Refrescar form con tabla correspondiente
    private void refrescar(){
        if (showAll){
            //mostrarTodo();
        } else{ 
            //mostrarActivos();
        }
    }
    
    // Posición de la fila seleccionada
    private int posicion(){
        return jtProgramacion.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel botones;
    private custom_swing.ButtonCircular btnActivate;
    private custom_swing.ButtonCircular btnAdd;
    private custom_swing.ButtonCircular btnDelete;
    private custom_swing.ButtonCircular btnEdit;
    private custom_swing.ButtonCircular btnRefresh;
    private custom_swing.ButtonCircular btnShowAll;
    private javax.swing.JTable jtProgramacion;
    private javax.swing.JScrollPane scrollProgramacion;
    // End of variables declaration//GEN-END:variables
}
