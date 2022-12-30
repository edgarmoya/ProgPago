package visual.tablero_form;

import dao.ClienteDAO;
import dao.TableroDAO;
import dao.TipoFinanDAO;
import entidades.Cliente;
import entidades.Organizacion;
import entidades.Periodo;
import entidades.Programacion;
import entidades.TipoFinan;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utiles.JTableUtil;
import utiles.autoComplete;
import visual.JD_Organizacion;

/**
 *
 * @author Edgar Moya
 */
public class ProgTipoForm extends javax.swing.JPanel {

    private TableroDAO tDAO = new TableroDAO();
    private String cliente;
    private String tipo;
    private String rpt_cliente, rpt_tipo, rpt_prog;

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
        btnExport = new custom_swing.Button();
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
        jcbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoItemStateChanged(evt);
            }
        });

        jcbCliente.setToolTipText("Seleccione el cliente");
        jcbCliente.setLabeText("CLIENTE*");
        jcbCliente.setOpaque(false);
        jcbCliente.setPreferredSize(new java.awt.Dimension(58, 48));
        jcbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbClienteItemStateChanged(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search_button.png"))); // NOI18N
        btnSearch.setToolTipText("Buscar programación");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/export_button.png"))); // NOI18N
        btnExport.setToolTipText("Exportar");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        rpt_cliente = (jcbCliente.getSelectedIndex() != -1) ? jcbCliente.getSelectedItem().toString() : "";
        rpt_tipo = (jcbTipo.getSelectedIndex() != -1) ? jcbTipo.getSelectedItem().toString() : "";
        
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

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        accionExportar();
    }//GEN-LAST:event_btnExportActionPerformed

    private void jcbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbClienteItemStateChanged
        jtProgramacion.clearSelection();
    }//GEN-LAST:event_jcbClienteItemStateChanged

    private void jcbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoItemStateChanged
        jtProgramacion.clearSelection();
    }//GEN-LAST:event_jcbTipoItemStateChanged

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
    
    public ArrayList<Periodo> getTableData(JTable jt) {
        DefaultTableModel dtm = (DefaultTableModel) jt.getModel();
        int nRow = dtm.getRowCount();
        ArrayList<Periodo> list = new ArrayList<>();
        for (int i = 0; i < nRow; i++) {
            Periodo p = new Periodo();
            p.setNombre((String) dtm.getValueAt(i, 0));
            p.setImporte(Double.parseDouble((String) dtm.getValueAt(i, 1)));
            p.setAcumulado(Double.parseDouble((String) dtm.getValueAt(i, 2)));
            list.add(p);
        }
        return list;
    }

    private void accionExportar() {
        if (posicion() != -1 && jtProgramacion.getModel().getRowCount() != 0) {    
            rpt_prog = jtProgramacion.getModel().getValueAt(posicion(), 0).toString();
            if (!rpt_cliente.isEmpty() && !rpt_tipo.isEmpty() && !rpt_prog.isEmpty() && jtDesglose.getModel().getRowCount() != 0) {
                exportar(rpt_cliente, rpt_tipo, rpt_prog);
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un tipo de financiamiento antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la programación que desea exportar.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void exportar(String cliente, String tipo, String prog) {        
        try {
            // obtener datos de la organización
            JD_Organizacion org = new JD_Organizacion(null, true);
            Organizacion o = org.cargar();
            File img = new File("logo.jpg");

            ArrayList<Periodo> periodos = new ArrayList<>();
            periodos.add(new Periodo());
            periodos.addAll(getTableData(jtDesglose));

            String reportUrl = "/reportes/reporte_progtipo.jasper"; //path
            InputStream reportFile = getClass().getResourceAsStream(reportUrl);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile);
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(periodos.toArray());

            Map<String, Object> parameters = new HashMap();
            parameters.put("ds", ds);
            if (img.exists()) {
                parameters.put("logotipo", new FileInputStream(img));
            } else {
                parameters.put("logotipo", getClass().getResourceAsStream("/imagenes/no_logo.png"));
            }
            parameters.put("org_cod", o.getCodigo());
            parameters.put("org_nombre", o.getNombre());
            parameters.put("org_direccion", o.getDireccion());
            parameters.put("org_telefono", o.getTelefono());
            parameters.put("org_correo", o.getCorreo());
            parameters.put("tipo", tipo);
            parameters.put("cliente", cliente);
            parameters.put("prog", prog);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parameters, ds);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Inserte los datos de la organización correspondiente antes de elaborar un reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            JD_Organizacion JDOrg = new JD_Organizacion(null, true);
            JDOrg.setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al elaborar reporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.Button btnExport;
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
