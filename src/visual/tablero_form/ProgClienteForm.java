package visual.tablero_form;

import dao.ClienteDAO;
import dao.EjercicioDAO;
import dao.TableroDAO;
import entidades.Cliente;
import entidades.Destino;
import entidades.Ejercicio;
import entidades.Periodo;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;
import utiles.autoComplete;

/**
 *
 * @author Edgar Moya
 */
public class ProgClienteForm extends javax.swing.JPanel {

    private TableroDAO tDAO = new TableroDAO();
    private String cliente;
    private String ejercicio;

    public ProgClienteForm() {
        initComponents();

        //Editar color de la tabla
        JTableUtil.headerTable(jtDestinos);
        JTableUtil.headerTable(jtDesglose);
        JTableUtil.modTable(jtDestinos, scrollDestinos);
        JTableUtil.modTable(jtDesglose, scrollDesglose);

        buscarClientes();
        buscarEjercicios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        jcbEjercicio = new custom_swing.Combobox();
        jcbCliente = new custom_swing.Combobox();
        btnSearch = new custom_swing.Button();
        split = new javax.swing.JSplitPane();
        scrollDestinos = new javax.swing.JScrollPane();
        jtDestinos = new javax.swing.JTable();
        scrollDesglose = new javax.swing.JScrollPane();
        jtDesglose = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(255, 255, 255));

        jcbEjercicio.setToolTipText("Seleccione el ejercicio");
        jcbEjercicio.setLabeText("EJERCICIO*");
        jcbEjercicio.setOpaque(false);
        jcbEjercicio.setPreferredSize(new java.awt.Dimension(58, 48));

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
                .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        split.setBackground(new java.awt.Color(45, 125, 246));
        split.setDividerSize(2);
        split.setResizeWeight(0.4);

        scrollDestinos.setBackground(new java.awt.Color(255, 255, 255));
        scrollDestinos.setBorder(null);
        scrollDestinos.setOpaque(false);

        jtDestinos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre"
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

        split.setLeftComponent(scrollDestinos);

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
            .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(split, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtDestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDestinosMouseClicked
        String destino = jtDestinos.getModel().getValueAt(posicion(), 0).toString();
        if (posicion() != -1) {            
            if (!cliente.isEmpty() && !ejercicio.isEmpty() && !destino.isEmpty()) {
                mostrarDesglose(cliente, ejercicio, destino);
                updateAcumulado();
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un ejercicio antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el destino que desea ver el desglose.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jtDestinosMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String cliente = (jcbCliente.getSelectedIndex() != -1) ? jcbCliente.getSelectedItem().toString() : "";
        String[] arrayCliente = cliente.split(" ");
        this.cliente = arrayCliente[0];
        ejercicio = (jcbEjercicio.getSelectedIndex() != -1) ? jcbEjercicio.getSelectedItem().toString() : "";
        if (!cliente.isEmpty() && !ejercicio.isEmpty()) {
            mostrarDestinos(this.cliente, ejercicio);
            // seleccionar la primera fila
            seleccionarItem(0);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un ejercicio antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    // Seleccionar item y actualizar los desgloses correspondientes
    private void seleccionarItem(int pos) {
        jtDestinos.getSelectionModel().setSelectionInterval(pos, pos);
        if (jtDestinos.getModel().getRowCount() >= 1) {
            String destino = jtDestinos.getModel().getValueAt(pos, pos).toString();
            mostrarDesglose(cliente, ejercicio, destino);
            updateAcumulado();
        }else{
            limpiarTabla(jtDesglose);
        }
    }
    
    private void limpiarTabla(JTable jt) {
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
    }
    
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

    // Buscar ejercicios de la BD
    private void buscarEjercicios() {
        //Limpiar ComboBox
        jcbEjercicio.removeAllItems();
        EjercicioDAO eDAO = new EjercicioDAO();
        try {
            ArrayList<Ejercicio> ejercicios = eDAO.listaEjercicios();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[ejercicios.size()];
            for (int i = 0; i < ejercicios.size(); i++) {
                veDatos[i] = ejercicios.get(i).getEjercicio();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbEjercicio, veDatos);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar la tabla con la lista de destinos correspondientes
    private void mostrarDestinos(String cliente, String ejercicio) {
        String[] columnNames = {"Código", "Nombre"};
        ArrayList<Destino> destinos = new ArrayList<>();
        try {
            destinos = tDAO.progXcliente(cliente, ejercicio);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
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

    // Método para actualizar la tabla con la lista de periodos correspondientes
    private void mostrarDesglose(String cliente, String ejercicio, String destino) {
        String[] columnNames = {"Período", "Importe", "Acumulado"};
        ArrayList<Periodo> periodos = new ArrayList<>();
        try {
            periodos = tDAO.progXcliente_desglose(cliente, ejercicio, destino);
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
    }
    
    // Actualizar la columna de acumulados
    private void updateAcumulado(){    
        DefaultTableModel m = (DefaultTableModel) jtDesglose.getModel();
        for (int i = 0; i < m.getRowCount(); i++) {
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

    // Posición de la fila seleccionada
    private int posicion() {
        return jtDestinos.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.Button btnSearch;
    private custom_swing.Combobox jcbCliente;
    private custom_swing.Combobox jcbEjercicio;
    private javax.swing.JTable jtDesglose;
    private javax.swing.JTable jtDestinos;
    private javax.swing.JScrollPane scrollDesglose;
    private javax.swing.JScrollPane scrollDestinos;
    private javax.swing.JSplitPane split;
    // End of variables declaration//GEN-END:variables
}
