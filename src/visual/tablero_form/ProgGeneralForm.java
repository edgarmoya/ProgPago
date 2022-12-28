package visual.tablero_form;

import dao.EjercicioDAO;
import dao.TableroDAO;
import entidades.Ejercicio;
import entidades.Organizacion;
import entidades.Periodo;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
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
public class ProgGeneralForm extends javax.swing.JPanel {

    private TableroDAO tDAO = new TableroDAO();

    public ProgGeneralForm() {
        initComponents();

        //Editar color de la tabla
        JTableUtil.headerTable(jtPeriodos);
        JTableUtil.modTable(jtPeriodos, scrollPeriodos);

        buscarEjercicios();
        accionMostrar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        scrollPeriodos = new javax.swing.JScrollPane();
        jtPeriodos = new javax.swing.JTable();
        botones = new javax.swing.JPanel();
        jcbEjercicio = new custom_swing.Combobox();
        btnSearch = new custom_swing.Button();
        btnExport = new custom_swing.Button();

        background.setBackground(new java.awt.Color(255, 255, 255));

        scrollPeriodos.setBackground(new java.awt.Color(255, 255, 255));
        scrollPeriodos.setBorder(null);
        scrollPeriodos.setOpaque(false);

        jtPeriodos.setBackground(new java.awt.Color(255, 255, 255));
        jtPeriodos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtPeriodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fecha Inicio", "Fecha Fin", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPeriodos.setToolTipText("Lista de Clientes");
        jtPeriodos.setGridColor(new java.awt.Color(204, 204, 204));
        jtPeriodos.setOpaque(false);
        jtPeriodos.setRowHeight(25);
        jtPeriodos.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtPeriodos.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtPeriodos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPeriodos.setViewportView(jtPeriodos);

        botones.setBackground(new java.awt.Color(255, 255, 255));

        jcbEjercicio.setToolTipText("Seleccione el ejercicio");
        jcbEjercicio.setLabeText("EJERCICIO*");
        jcbEjercicio.setOpaque(false);
        jcbEjercicio.setPreferredSize(new java.awt.Dimension(58, 48));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search_button.png"))); // NOI18N
        btnSearch.setToolTipText("Buscar períodos");
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
                .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        accionMostrar();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        accionExportar();
    }//GEN-LAST:event_btnExportActionPerformed

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

    // Método para actualizar la tabla con la lista de periodos correspondientes
    private void mostrarPeriodos(String ejercicio) {
        String[] columnNames = {"Nombre", "Fecha Inicio", "Fecha Fin", "Importe"};
        ArrayList<Periodo> periodos = new ArrayList<>();
        try {
            periodos = tDAO.proggeneral(ejercicio);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[periodos.size()][4];
        for (int i = 0; i < periodos.size(); i++) {
            data[i][0] = periodos.get(i).getNombre();
            data[i][1] = "" + periodos.get(i).getFecha_inicio();
            data[i][2] = "" + periodos.get(i).getFecha_fin();
            data[i][3] = "" + periodos.get(i).getImporte();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };
        jtPeriodos.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtPeriodos, scrollPeriodos);
        jtPeriodos.getColumnModel().getColumn(3).setMaxWidth(200);
        jtPeriodos.getColumnModel().getColumn(3).setCellRenderer(JTableUtil.alinearColumna(jtPeriodos, DefaultTableCellRenderer.RIGHT));
    }

    private void accionMostrar() {
        String ejercicio = (jcbEjercicio.getSelectedIndex() != -1) ? jcbEjercicio.getSelectedItem().toString() : "";
        if (!ejercicio.isEmpty()) {
            mostrarPeriodos(ejercicio);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un ejercicio antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionExportar() {
        String ejercicio = (jcbEjercicio.getSelectedIndex() != -1) ? jcbEjercicio.getSelectedItem().toString() : "";
        if (!ejercicio.isEmpty()) {
            exportar(ejercicio);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un ejercicio antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportar(String ejercicio) {
        try {
            // obtener datos de la organización
            JD_Organizacion org = new JD_Organizacion(null, true);
            Organizacion o = org.cargar();          
            File img = new File("logo.jpg"); 
            
            ArrayList<Periodo> periodos = new ArrayList<>();     
            periodos.add(new Periodo());
            ArrayList<Periodo> datos = tDAO.proggeneral(ejercicio);           
            periodos.addAll(datos);
            
            String path = "src\\reportes\\reporte_proggeneral.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JRBeanArrayDataSource ds = new JRBeanArrayDataSource(periodos.toArray());

            Map<String, Object> parameters = new HashMap();
            parameters.put("ds", ds);
            if(img.exists()){
                parameters.put("logotipo", new FileInputStream(img));
            }else{
                parameters.put("logotipo", getClass().getResourceAsStream("/imagenes/no_logo.png"));
            }       
            parameters.put("org_cod", o.getCodigo());
            parameters.put("org_nombre", o.getNombre());
            parameters.put("org_direccion", o.getDireccion());
            parameters.put("org_telefono", o.getTelefono());
            parameters.put("org_correo", o.getCorreo());
            parameters.put("ejercicio", "PROGRAMACIÓN GENERAL - AÑO "+ejercicio);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parameters, ds);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    private custom_swing.Combobox jcbEjercicio;
    private javax.swing.JTable jtPeriodos;
    private javax.swing.JScrollPane scrollPeriodos;
    // End of variables declaration//GEN-END:variables
}
