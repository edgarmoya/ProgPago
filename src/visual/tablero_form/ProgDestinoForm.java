package visual.tablero_form;

import dao.DestinoDAO;
import dao.EjercicioDAO;
import dao.TableroDAO;
import entidades.ClienteImporteDE;
import entidades.Destino;
import entidades.Ejercicio;
import entidades.Organizacion;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
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
public class ProgDestinoForm extends javax.swing.JPanel {

    private TableroDAO tDAO = new TableroDAO();

    public ProgDestinoForm() {
        initComponents();

        //Editar color de la tabla
        JTableUtil.headerTable(jtClientesImporteDE);
        JTableUtil.modTable(jtClientesImporteDE, scrollClientesImporteDE);

        buscarDestinos();
        buscarEjercicios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        scrollClientesImporteDE = new javax.swing.JScrollPane();
        jtClientesImporteDE = new javax.swing.JTable();
        botones = new javax.swing.JPanel();
        jcbEjercicio = new custom_swing.Combobox();
        btnSearch = new custom_swing.Button();
        jcbDestino = new custom_swing.Combobox();
        btnExport = new custom_swing.Button();

        background.setBackground(new java.awt.Color(255, 255, 255));

        scrollClientesImporteDE.setBackground(new java.awt.Color(255, 255, 255));
        scrollClientesImporteDE.setBorder(null);
        scrollClientesImporteDE.setOpaque(false);

        jtClientesImporteDE.setBackground(new java.awt.Color(255, 255, 255));
        jtClientesImporteDE.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtClientesImporteDE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Importe"
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
        jtClientesImporteDE.setToolTipText("Lista de Clientes");
        jtClientesImporteDE.setGridColor(new java.awt.Color(204, 204, 204));
        jtClientesImporteDE.setOpaque(false);
        jtClientesImporteDE.setRowHeight(25);
        jtClientesImporteDE.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtClientesImporteDE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtClientesImporteDE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtClientesImporteDE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesImporteDEMouseClicked(evt);
            }
        });
        scrollClientesImporteDE.setViewportView(jtClientesImporteDE);

        botones.setBackground(new java.awt.Color(255, 255, 255));

        jcbEjercicio.setToolTipText("Seleccione el ejercicio");
        jcbEjercicio.setLabeText("EJERCICIO*");
        jcbEjercicio.setOpaque(false);
        jcbEjercicio.setPreferredSize(new java.awt.Dimension(58, 48));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search_button.png"))); // NOI18N
        btnSearch.setToolTipText("Buscar destinos");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jcbDestino.setToolTipText("Seleccione el destino");
        jcbDestino.setLabeText("DESTINO*");
        jcbDestino.setOpaque(false);
        jcbDestino.setPreferredSize(new java.awt.Dimension(58, 48));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollClientesImporteDE)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollClientesImporteDE, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtClientesImporteDEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesImporteDEMouseClicked
        /*comprobarSeleccion();
        if (showAll){
            comprobarActivo();
        }*/
    }//GEN-LAST:event_jtClientesImporteDEMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String destino = (jcbDestino.getSelectedIndex() != -1) ? jcbDestino.getSelectedItem().toString() : "";
        String ejercicio = (jcbEjercicio.getSelectedIndex() != -1) ? jcbEjercicio.getSelectedItem().toString() : "";
        if (!destino.isEmpty() && !ejercicio.isEmpty()) {
            mostrarClientesImporteDE(destino, ejercicio);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un destino y un ejercicio antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        accionExportar();
    }//GEN-LAST:event_btnExportActionPerformed

    // Buscar destinoss de la BD
    private void buscarDestinos() {
        //Limpiar ComboBox
        jcbDestino.removeAllItems();
        DestinoDAO dDAO = new DestinoDAO();
        try {
            ArrayList<Destino> destinos = dDAO.listaDestinosActivos();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[destinos.size()];
            for (int i = 0; i < destinos.size(); i++) {
                veDatos[i] = destinos.get(i).getId_destino() + " " + destinos.get(i).getNombre();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbDestino, veDatos);
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

    // Método para actualizar la tabla con la lista de clientesimportede correspondientes
    private void mostrarClientesImporteDE(String destino, String ejercicio) {
        String[] columnNames = {"Código", "Nombre", "Importe"};
        ArrayList<ClienteImporteDE> clientesimportede = new ArrayList<>();
        try {
            clientesimportede = tDAO.progxdestinoyejer(destino, ejercicio);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[clientesimportede.size()][3];
        for (int i = 0; i < clientesimportede.size(); i++) {
            data[i][0] = clientesimportede.get(i).getCod_cliente();
            data[i][1] = "" + clientesimportede.get(i).getNombre();
            data[i][2] = "" + clientesimportede.get(i).getImporte();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtClientesImporteDE.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtClientesImporteDE, scrollClientesImporteDE);
        jtClientesImporteDE.getColumnModel().getColumn(0).setMinWidth(150);
        jtClientesImporteDE.getColumnModel().getColumn(0).setMaxWidth(200);
        // jtClientesImporteDE.getColumnModel().getColumn(2).setMaxWidth(300);
        // jtClientesImporteDE.getColumnModel().getColumn(2).setCellRenderer(JTableUtil.alinearColumna(jtClientesImporteDE, DefaultTableCellRenderer.RIGHT));
    }

    private void accionExportar() {
        String destino = (jcbDestino.getSelectedIndex() != -1) ? jcbDestino.getSelectedItem().toString() : "";
        String ejercicio = (jcbEjercicio.getSelectedIndex() != -1) ? jcbEjercicio.getSelectedItem().toString() : "";
        if (!ejercicio.isEmpty() || !destino.isEmpty()) {
            exportar(destino, ejercicio);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un destino y un ejercicio antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportar(String destino, String ejercicio) {
        try {
            // obtener datos de la organización
            JD_Organizacion org = new JD_Organizacion(null, true);
            Organizacion o = org.cargar();
            File img = new File("logo.jpg");

            ArrayList<ClienteImporteDE> list = new ArrayList<>();
            list.add(new ClienteImporteDE());
            ArrayList<ClienteImporteDE> datos = tDAO.progxdestinoyejer(destino, ejercicio);
            list.addAll(datos);

            String reportUrl = "/reportes/reporte_progdestino.jasper"; //path
            InputStream reportFile = getClass().getResourceAsStream(reportUrl);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile);
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(list.toArray());

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
            parameters.put("ejercicio", ejercicio);
            parameters.put("destino", destino);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parameters, ds);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Inserte los datos de la organización correspondiente antes de elaborar un reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            JD_Organizacion JDOrg = new JD_Organizacion(null, true);
            JDOrg.setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al elaborar reporte.", "Error", JOptionPane.ERROR_MESSAGE);       
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.Button btnExport;
    private custom_swing.Button btnSearch;
    private custom_swing.Combobox jcbDestino;
    private custom_swing.Combobox jcbEjercicio;
    private javax.swing.JTable jtClientesImporteDE;
    private javax.swing.JScrollPane scrollClientesImporteDE;
    // End of variables declaration//GEN-END:variables
}
