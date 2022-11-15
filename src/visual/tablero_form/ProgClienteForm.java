package visual.tablero_form;

import dao.ClienteDAO;
import dao.EjercicioDAO;
import entidades.Cliente;
import entidades.Ejercicio;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utiles.JTableUtil;
import utiles.autoComplete;

/**
 *
 * @author Edgar Moya
 */
public class ProgClienteForm extends javax.swing.JPanel {

    public ProgClienteForm() {
        initComponents();
        
        //Editar color de la tabla
        JTableUtil.headerTable(jtDestinos);
        JTableUtil.headerTable(jtDesglose);
        
        buscarClientes();
        buscarEjercicios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnAdd = new custom_swing.ButtonCircular();
        jcbEjercicio = new custom_swing.Combobox();
        jcbCliente = new custom_swing.Combobox();
        split = new javax.swing.JSplitPane();
        scrollDestinos = new javax.swing.JScrollPane();
        jtDestinos = new javax.swing.JTable();
        scrollDesglose = new javax.swing.JScrollPane();
        jtDesglose = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(228, 235, 245));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar ejercicio");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jcbEjercicio.setBackground(new java.awt.Color(255, 255, 255));
        jcbEjercicio.setToolTipText("Seleccione el ejercicio");
        jcbEjercicio.setLabeText("EJERCICIO*");
        jcbEjercicio.setOpaque(false);
        jcbEjercicio.setPreferredSize(new java.awt.Dimension(58, 48));

        jcbCliente.setBackground(new java.awt.Color(255, 255, 255));
        jcbCliente.setToolTipText("Seleccione el cliente");
        jcbCliente.setLabeText("CLIENTE*");
        jcbCliente.setOpaque(false);
        jcbCliente.setPreferredSize(new java.awt.Dimension(58, 48));
        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesLayout = new javax.swing.GroupLayout(botones);
        botones.setLayout(botonesLayout);
        botonesLayout.setHorizontalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(botonesLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(botonesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                "Destinos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
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
        jtDesglose.setToolTipText("Lista de Períodos");
        jtDesglose.setGridColor(new java.awt.Color(204, 204, 204));
        jtDesglose.setMinimumSize(new java.awt.Dimension(50, 0));
        jtDesglose.setRowHeight(25);
        jtDesglose.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtDesglose.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtDesglose.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDesglose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDesgloseMouseClicked(evt);
            }
        });
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtDestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDestinosMouseClicked

    }//GEN-LAST:event_jtDestinosMouseClicked

    private void jtDesgloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDesgloseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDesgloseMouseClicked

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbClienteActionPerformed

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
                veDatos[i] = clientes.get(i).getCod_cliente()+ " " +clientes.get(i).getNombre();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.ButtonCircular btnAdd;
    private custom_swing.Combobox jcbCliente;
    private custom_swing.Combobox jcbEjercicio;
    private javax.swing.JTable jtDesglose;
    private javax.swing.JTable jtDestinos;
    private javax.swing.JScrollPane scrollDesglose;
    private javax.swing.JScrollPane scrollDestinos;
    private javax.swing.JSplitPane split;
    // End of variables declaration//GEN-END:variables
}
