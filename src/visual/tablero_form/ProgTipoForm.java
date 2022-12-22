package visual.tablero_form;

import dao.ClienteDAO;
import dao.TableroDAO;
import dao.TipoFinanDAO;
import entidades.Cliente;
import entidades.Periodo;
import entidades.Programacion;
import entidades.TipoFinan;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;
import utiles.autoComplete;

/**
 *
 * @author Edgar Moya
 */
public class ProgTipoForm extends javax.swing.JPanel {

    private TableroDAO tDAO = new TableroDAO();
    private String cliente;
    private String tipo;

    public ProgTipoForm() {
        initComponents();

        //Editar color de la tabla
        JTableUtil.headerTable(jtProgramacion);
        JTableUtil.headerTable(jtDesglose);
        JTableUtil.modTable(jtProgramacion, scrollProgramacion);
        JTableUtil.modTable(jtDesglose, scrollDesglose);
        JTableUtil.headerAligment(jtDesglose, JLabel.CENTER);

        buscarClientes();
        buscarTipos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        jcbTipo = new custom_swing.Combobox();
        jcbCliente = new custom_swing.Combobox();
        btnSearch = new custom_swing.Button();
        split = new javax.swing.JSplitPane();
        scrollProgramacion = new javax.swing.JScrollPane();
        jtProgramacion = new javax.swing.JTable();
        scrollDesglose = new javax.swing.JScrollPane();
        jtDesglose = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(255, 255, 255));

        jcbTipo.setToolTipText("Seleccione el tipo de financiamiento");
        jcbTipo.setLabeText("TIPO DE FINACIAMIENTO*");
        jcbTipo.setOpaque(false);
        jcbTipo.setPreferredSize(new java.awt.Dimension(58, 48));

        jcbCliente.setToolTipText("Seleccione el cliente");
        jcbCliente.setLabeText("CLIENTE*");
        jcbCliente.setOpaque(false);
        jcbCliente.setPreferredSize(new java.awt.Dimension(58, 48));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search_button.png"))); // NOI18N
        btnSearch.setToolTipText("Buscar destinos");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        split.setBackground(new java.awt.Color(45, 125, 246));
        split.setDividerSize(2);
        split.setResizeWeight(0.5);

        scrollProgramacion.setBackground(new java.awt.Color(255, 255, 255));
        scrollProgramacion.setBorder(null);
        scrollProgramacion.setOpaque(false);

        jtProgramacion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtProgramacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ejercicio", "Fecha", "Moneda", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        split.setLeftComponent(scrollProgramacion);

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
        jtDesglose.setToolTipText("Desglose por períodos");
        jtDesglose.setGridColor(new java.awt.Color(204, 204, 204));
        jtDesglose.setMinimumSize(new java.awt.Dimension(50, 0));
        jtDesglose.setRowHeight(25);
        jtDesglose.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtDesglose.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtDesglose.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollDesglose.setViewportView(jtDesglose);

        split.setRightComponent(scrollDesglose);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(split, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String c = (jcbCliente.getSelectedIndex() != -1) ? jcbCliente.getSelectedItem().toString() : "";
        String[] arrayCliente = c.split(" ");
        cliente = arrayCliente[0];

        String t = (jcbTipo.getSelectedIndex() != -1) ? jcbTipo.getSelectedItem().toString() : "";
        String[] arrayTipo = t.split(" ");
        tipo = arrayTipo[0];

        if (!cliente.isEmpty() && !tipo.isEmpty()) {
            mostrarProgramaciones(cliente, tipo);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un tipo antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jtProgramacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProgramacionMouseClicked
        try {
            String programacion = jtProgramacion.getModel().getValueAt(posicion(), 0).toString();
            if (posicion() != -1) {
                if (!programacion.isEmpty()) {
                    mostrarDesglose(Integer.valueOf(programacion));
                    updateAcumulado();
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una programación antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione la programación que desea ver el desglose.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener la programación seleccionada.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jtProgramacionMouseClicked

    // Buscar clientes de la BD
    private void buscarClientes() {
        //Limpiar ComboBox
        jcbCliente.removeAllItems();
        ClienteDAO cDAO = new ClienteDAO();
        try {
            ArrayList<Cliente> clientes = cDAO.listaClientesActivos();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[clientes.size()];
            for (int i = 0; i < clientes.size(); i++) {
                veDatos[i] = clientes.get(i).getCod_cliente() + " " + clientes.get(i).getNombre();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbCliente, veDatos);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Buscar tipos de la BD
    private void buscarTipos() {
        //Limpiar ComboBox
        jcbTipo.removeAllItems();
        TipoFinanDAO tDAO = new TipoFinanDAO();
        try {
            ArrayList<TipoFinan> tipos = tDAO.listaTipoFinanActivos();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[tipos.size()];
            for (int i = 0; i < tipos.size(); i++) {
                veDatos[i] = tipos.get(i).getCod_tipo() + " " + tipos.get(i).getDescripcion();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbTipo, veDatos);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar la tabla con la lista de programaciones correspondientes
    private void mostrarProgramaciones(String cliente, String tipo) {
        String[] columnNames = {"Id", "Ejercicio", "Fecha", "Moneda", "Estado"};
        ArrayList<Programacion> programaciones = new ArrayList<>();
        try {
            programaciones = tDAO.progXtipo(cliente, tipo);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[programaciones.size()][5];
        for (int i = 0; i < programaciones.size(); i++) {
            data[i][0] = "" + programaciones.get(i).getId_prog();
            data[i][1] = programaciones.get(i).getEjercicio();
            data[i][2] = "" + programaciones.get(i).getFecha();
            data[i][3] = programaciones.get(i).getMoneda();
            data[i][4] = (programaciones.get(i).getEstado() == 0) ? "En edición" : "Confirmada";
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtProgramacion.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtProgramacion, scrollProgramacion);
    }

    // Método para actualizar la tabla con la lista de periodos correspondientes
    private void mostrarDesglose(int prog) {
        String[] columnNames = {"Período", "Importe", "Acumulado"};
        ArrayList<Periodo> periodos = new ArrayList<>();
        try {
            periodos = tDAO.prog_desglose(prog);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[periodos.size()][3];
        for (int i = 0; i < periodos.size(); i++) {
            data[i][0] = periodos.get(i).getNombre();
            data[i][1] = "" + periodos.get(i).getImporte();
            data[i][2] = "0.0";
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtDesglose.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtDesglose, scrollDesglose);
        JTableUtil.headerAligment(jtDesglose, JLabel.CENTER);
        jtDesglose.getColumnModel().getColumn(1).setCellRenderer(JTableUtil.alinearColumna(jtDesglose, DefaultTableCellRenderer.RIGHT));
        jtDesglose.getColumnModel().getColumn(2).setCellRenderer(JTableUtil.alinearColumna(jtDesglose, DefaultTableCellRenderer.RIGHT));
    }

    // Actualizar la columna de acumulados
    private void updateAcumulado() {
        DefaultTableModel m = (DefaultTableModel) jtDesglose.getModel();
        for (int i = 0; i < m.getRowCount(); i++) {
            double acumAnterior;
            try {
                acumAnterior = Double.parseDouble((String.valueOf(m.getValueAt(i - 1, 2))));
            } catch (Exception e) {
                acumAnterior = 0.0;
            }
            double impMes = Double.parseDouble(String.valueOf(m.getValueAt(i, 1)));
            m.setValueAt(String.valueOf(acumAnterior + impMes), i, 2);
        }
    }

    // Posición de la fila seleccionada
    private int posicion() {
        return jtProgramacion.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.Button btnSearch;
    private custom_swing.Combobox jcbCliente;
    private custom_swing.Combobox jcbTipo;
    private javax.swing.JTable jtDesglose;
    private javax.swing.JTable jtProgramacion;
    private javax.swing.JScrollPane scrollDesglose;
    private javax.swing.JScrollPane scrollProgramacion;
    private javax.swing.JSplitPane split;
    // End of variables declaration//GEN-END:variables
}
