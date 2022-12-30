package visual;

import dao.ProgramacionDAO;
import entidades.Programacion;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;

/**
 *
 * @author Edgar Moya
 */
public class ProgramacionForm extends javax.swing.JPanel {

    private ProgramacionDAO pDAO = new ProgramacionDAO();
    private boolean showAll = true;
    private String usuario;

    public ProgramacionForm() {
        initComponents();
        // Editar color de la tabla
        JTableUtil.headerTable(jtProgramaciones);
        refrescar();
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
        btnConfirm = new custom_swing.ButtonCircular();
        btnRefresh = new custom_swing.ButtonCircular();
        btnHistory = new custom_swing.ButtonCircular();
        scrollProgramacion = new javax.swing.JScrollPane();
        jtProgramaciones = new javax.swing.JTable();

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
        btnShowAll.setToolTipText("Mostrar programaciones confirmadas");
        btnShowAll.setPreferredSize(new java.awt.Dimension(30, 30));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/activate_button.png"))); // NOI18N
        btnConfirm.setToolTipText("Confirmar programación");
        btnConfirm.setEnabled(false);
        btnConfirm.setPreferredSize(new java.awt.Dimension(30, 30));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
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

        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/historial_button.png"))); // NOI18N
        btnHistory.setToolTipText("Mostrar historial");
        btnHistory.setEnabled(false);
        btnHistory.setPreferredSize(new java.awt.Dimension(30, 30));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
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
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );

        scrollProgramacion.setBackground(new java.awt.Color(255, 255, 255));
        scrollProgramacion.setBorder(null);
        scrollProgramacion.setOpaque(false);

        jtProgramaciones.setBackground(new java.awt.Color(255, 255, 255));
        jtProgramaciones.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtProgramaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ejercicio", "Tipo de Financiamiento", "Cliente", "Moneda", "Importe", "Estado"
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
        jtProgramaciones.setToolTipText("Lista de Programaciones");
        jtProgramaciones.setGridColor(new java.awt.Color(204, 204, 204));
        jtProgramaciones.setOpaque(false);
        jtProgramaciones.setRowHeight(25);
        jtProgramaciones.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtProgramaciones.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtProgramaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtProgramaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProgramacionesMouseClicked(evt);
            }
        });
        scrollProgramacion.setViewportView(jtProgramaciones);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollProgramacion, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollProgramacion, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
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
        JDAdd.setUsuario(usuario);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()) {
            refrescar();
            comprobarSeleccion();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar programacion
        if (posicion() != -1) {
            JD_Adicionar_programacion JDEdit = new JD_Adicionar_programacion(null, true);
            JDEdit.setLocationRelativeTo(this);
            Programacion p = getProgramacionSeleccionada();
            JDEdit.setUsuario(usuario);
            JDEdit.dialogo_editar(p);
            JDEdit.setVisible(true);

            // Si se efectuaron cambios actualizar tabla
            if (JDEdit.cambios()) {
                refrescar();
                comprobarSeleccion();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la fila que desea editar", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Acción para eliminar programacion
        if (posicion() != -1) {
            String cod = jtProgramaciones.getModel().getValueAt(posicion(), 0).toString();
            accionEliminar(cod);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la programación que desea eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        if (!showAll) {
            mostrarTodo();
            showAll = true;
            btnShowAll.setToolTipText("Mostrar programaciones confirmadas");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_activos_button.png")));
        } else {
            mostrarConfirmadas();
            showAll = false;
            btnShowAll.setToolTipText("Mostrar todas las programaciones");
            btnShowAll.setIcon(new ImageIcon(getClass().getResource("/imagenes/mostrar_todo_button.png")));
        }
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // Acción para confirmar programacion
        if (posicion() != -1) {
            // mostrar diálogo de confirmación
            String cod = jtProgramaciones.getModel().getValueAt(posicion(), 0).toString();
            int input = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la programación con código \"" + cod + "\" ?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                try {
                    if (pDAO.confirmarProgramacion(Integer.parseInt(cod))) {
                        refrescar();
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ConnectionException | BDException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la programación que desea confirmar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refrescar();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jtProgramacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProgramacionesMouseClicked
        comprobarSeleccion();
        if (showAll) {
            comprobarConfirmada();
        }
    }//GEN-LAST:event_jtProgramacionesMouseClicked

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        if (posicion() != -1) {
            int cod = Integer.valueOf(jtProgramaciones.getModel().getValueAt(posicion(), 0).toString());
            JD_Log_programacion JDLog = new JD_Log_programacion(null, true);
            JDLog.setLocationRelativeTo(this);
            JDLog.setIdprog(cod);
            JDLog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la programación que desea ver el historial.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHistoryActionPerformed

    // Eliminar programacion a partir del codigo
    private void accionEliminar(String codigo) {
        int input = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la programación con código \"" + codigo + "\" ?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        try {
            if (input == 0) {   // 0=SI, 1=NO
                if (pDAO.eliminarProgramacion(Integer.parseInt(codigo))) {
                    refrescar();
                    comprobarSeleccion();
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

    //Método para actualizar la tabla con la lista de programaciones confirmadas
    private void mostrarConfirmadas() {
        String[] columnNames = {"Código", "Ejercicio", "Tipo de Financiamiento", "Cliente", "Moneda", "Importe", "Estado"};
        ArrayList<Programacion> programaciones = new ArrayList<>();
        try {
            programaciones = pDAO.listaProgramacionesConfirmadas();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[programaciones.size()][7];
        for (int i = 0; i < programaciones.size(); i++) {
            data[i][0] = "" + programaciones.get(i).getId_prog();
            data[i][1] = programaciones.get(i).getEjercicio();
            data[i][2] = programaciones.get(i).getTipofinan();
            data[i][3] = programaciones.get(i).getCliente();
            data[i][4] = programaciones.get(i).getMoneda();
            data[i][5] = "" + programaciones.get(i).getImporte();
            data[i][6] = (programaciones.get(i).getEstado() == 0) ? "Edición" : "Confirmada";
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtProgramaciones.setModel(model);
        // Tamaño de las columnas
        jtProgramaciones.getColumnModel().getColumn(0).setMaxWidth(100);
        jtProgramaciones.getColumnModel().getColumn(1).setMaxWidth(100);
        jtProgramaciones.getColumnModel().getColumn(4).setMaxWidth(100);
        jtProgramaciones.getColumnModel().getColumn(5).setMaxWidth(600);
        jtProgramaciones.getColumnModel().getColumn(6).setMinWidth(100);
        jtProgramaciones.getColumnModel().getColumn(6).setMaxWidth(101);
        // Alinear los importes a la derecha
        jtProgramaciones.getColumnModel().getColumn(4).setCellRenderer(JTableUtil.alinearColumna(jtProgramaciones, DefaultTableCellRenderer.CENTER));
        jtProgramaciones.getColumnModel().getColumn(5).setCellRenderer(JTableUtil.alinearColumna(jtProgramaciones, DefaultTableCellRenderer.RIGHT));
        jtProgramaciones.getColumnModel().getColumn(6).setCellRenderer(JTableUtil.alinearColumna(jtProgramaciones, DefaultTableCellRenderer.CENTER));
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtProgramaciones, scrollProgramacion);
             
    }

    //Método para actualizar la tabla con la lista de todas las programaciones
    private void mostrarTodo() {
        String[] columnNames = {"Código", "Ejercicio", "Tipo de Financiamiento", "Cliente", "Moneda", "Importe", "Estado"};
        ArrayList<Programacion> programaciones = new ArrayList<>();
        try {
            programaciones = pDAO.listaTodasProgramaciones();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[programaciones.size()][7];
        for (int i = 0; i < programaciones.size(); i++) {
            data[i][0] = "" + programaciones.get(i).getId_prog();
            data[i][1] = programaciones.get(i).getEjercicio();
            data[i][2] = programaciones.get(i).getTipofinan();
            data[i][3] = programaciones.get(i).getCliente();
            data[i][4] = programaciones.get(i).getMoneda();
            data[i][5] = "" + programaciones.get(i).getImporte();
            data[i][6] = (programaciones.get(i).getEstado() == 0) ? "Edición" : "Confirmada";
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtProgramaciones.setModel(model);
        // Tamaño de las columnas
        jtProgramaciones.getColumnModel().getColumn(0).setMaxWidth(100);
        jtProgramaciones.getColumnModel().getColumn(1).setMaxWidth(100);
        jtProgramaciones.getColumnModel().getColumn(4).setMaxWidth(100);
        jtProgramaciones.getColumnModel().getColumn(5).setMaxWidth(600);
        jtProgramaciones.getColumnModel().getColumn(6).setMinWidth(100);
        jtProgramaciones.getColumnModel().getColumn(6).setMaxWidth(101);
        // Alinear los importes a la derecha
        jtProgramaciones.getColumnModel().getColumn(4).setCellRenderer(JTableUtil.alinearColumna(jtProgramaciones, DefaultTableCellRenderer.CENTER));
        jtProgramaciones.getColumnModel().getColumn(5).setCellRenderer(JTableUtil.alinearColumna(jtProgramaciones, DefaultTableCellRenderer.RIGHT));
        jtProgramaciones.getColumnModel().getColumn(6).setCellRenderer(JTableUtil.alinearColumna(jtProgramaciones, DefaultTableCellRenderer.CENTER));
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtProgramaciones, scrollProgramacion);
    }

    // Obtener datos de la programacion a partir del codigo
    private Programacion getProgramacionSeleccionada() {
        String value = jtProgramaciones.getModel().getValueAt(posicion(), 0).toString();
        Programacion p = new Programacion();
        try {
            p = pDAO.getProgramacion(Integer.parseInt(value));
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }

    // Comprobar si es una programacion confirmada o en edicion
    private void comprobarConfirmada() {
        if (posicion() != -1) {
            String cod = jtProgramaciones.getModel().getValueAt(posicion(), 0).toString();
            try {
                int res = pDAO.isConfirmada(Integer.parseInt(cod));
                if (res == 1) {
                    btnConfirm.setEnabled(false);
                } else {
                    btnConfirm.setEnabled(true);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la programación que desea confirmar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Comprobar si hay fila seleccionada
    private void comprobarSeleccion() {
        if (posicion() != -1) {            
            btnHistory.setEnabled(true);
            String cod = jtProgramaciones.getModel().getValueAt(posicion(), 0).toString();
            // Comprobar si se puede activar el btnDelete
            try {
                if (pDAO.isConfirmada(Integer.parseInt(cod)) == 1) {
                    btnDelete.setEnabled(false);
                    btnEdit.setEnabled(false);
                } else {
                    btnDelete.setEnabled(true);
                    btnEdit.setEnabled(true);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            btnHistory.setEnabled(false);
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        }
    }

    // Refrescar form con tabla correspondiente
    private void refrescar() {
        if (showAll) {
            mostrarTodo();
        } else {
            mostrarConfirmadas();
        }
    }

    // Posición de la fila seleccionada
    private int posicion() {
        return jtProgramaciones.getSelectedRow();
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel botones;
    private custom_swing.ButtonCircular btnAdd;
    private custom_swing.ButtonCircular btnConfirm;
    private custom_swing.ButtonCircular btnDelete;
    private custom_swing.ButtonCircular btnEdit;
    private custom_swing.ButtonCircular btnHistory;
    private custom_swing.ButtonCircular btnRefresh;
    private custom_swing.ButtonCircular btnShowAll;
    private javax.swing.JTable jtProgramaciones;
    private javax.swing.JScrollPane scrollProgramacion;
    // End of variables declaration//GEN-END:variables
}
