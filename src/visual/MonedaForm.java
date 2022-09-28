package visual;

import dao.MonedaDAO;
import entidades.Moneda;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;

/**
 *
 * @author Lester
 */
public class MonedaForm extends javax.swing.JPanel {

    private MonedaDAO mDAO = new MonedaDAO();
    
    public MonedaForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtMonedas);
        mostrarActivos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        botones = new javax.swing.JPanel();
        btnView = new custom_swing.ButtonCircular();
        btnEdit = new custom_swing.ButtonCircular();
        btnDelete = new custom_swing.ButtonCircular();
        btnAdd = new custom_swing.ButtonCircular();
        scrollMonedas = new javax.swing.JScrollPane();
        jtMonedas = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        botones.setBackground(new java.awt.Color(220, 227, 237));

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/view_button.png"))); // NOI18N
        btnView.setToolTipText("Ver moneda");
        btnView.setEnabled(false);
        btnView.setPreferredSize(new java.awt.Dimension(30, 30));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_button.png"))); // NOI18N
        btnEdit.setToolTipText("Editar moneda");
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(30, 30));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar moneda");
        btnDelete.setEnabled(false);
        btnDelete.setPreferredSize(new java.awt.Dimension(30, 30));

        btnAdd.setBackground(new java.awt.Color(228, 235, 245));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar moneda");
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(616, Short.MAX_VALUE))
        );
        botonesLayout.setVerticalGroup(
            botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        scrollMonedas.setBackground(new java.awt.Color(255, 255, 255));
        scrollMonedas.setBorder(null);
        scrollMonedas.setOpaque(false);

        jtMonedas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtMonedas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Siglas", "Nombre", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Byte.class
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
        jtMonedas.setToolTipText("Lista de Monedas");
        jtMonedas.setGridColor(new java.awt.Color(204, 204, 204));
        jtMonedas.setRowHeight(25);
        jtMonedas.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtMonedas.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtMonedas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtMonedas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMonedasMouseClicked(evt);
            }
        });
        scrollMonedas.setViewportView(jtMonedas);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollMonedas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollMonedas, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtMonedasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMonedasMouseClicked
        comprobarSeleccion();
    }//GEN-LAST:event_jtMonedasMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar cliente
        if (posicion() != -1){
            JD_Adicionar_moneda JDEdit = new JD_Adicionar_moneda(null, true);
            JDEdit.setLocationRelativeTo(this);
            Moneda m = getMonedaSeleccionada();
            JDEdit.dialogo_editar(m);
            JDEdit.setVisible(true);

            // Si se efectuaron cambios actualizar tabla
            if (JDEdit.cambios()){
                mostrarActivos();
                comprobarSeleccion();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione la fila que desea editar", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar moneda
        JD_Adicionar_moneda JDAdd = new JD_Adicionar_moneda(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){
            mostrarActivos();
            comprobarSeleccion();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    //Método para actualizar la tabla con la lista de monedas
    private void mostrarActivos() {
        MonedaDAO dao = new MonedaDAO();
        String[] columnNames = {"Siglas", "Nombre"};
        ArrayList<Moneda> monedas = new ArrayList<>();
        try {
            monedas = dao.listaMonedasActivas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[monedas.size()][2];        
        for (int i = 0; i < monedas.size(); i++) {
            data[i][0] = monedas.get(i).getSiglas();
            data[i][1] = monedas.get(i).getNombre();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtMonedas.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtMonedas, scrollMonedas);    
    }
    
    private Moneda getMonedaSeleccionada(){
        String value = jtMonedas.getModel().getValueAt(posicion(), 0).toString();
        Moneda m = new Moneda();
        try {
            m = mDAO.getMoneda(value);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }
    
    // Habilitar botones
    private void enabled(boolean estado){
        btnEdit.setEnabled(estado);
        btnView.setEnabled(estado);
        btnDelete.setEnabled(estado);
    }
    
    // Comprobar si hay fila seleccionada
    private void comprobarSeleccion(){   
        if (posicion() != -1) {
            // Si se selecciona una fila habilitar opciones
            enabled(true);
        } else {
            enabled(false);
        }
    }
    
    // Posición de la fila seleccionada
    private int posicion(){
        return jtMonedas.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel botones;
    private custom_swing.ButtonCircular btnAdd;
    private custom_swing.ButtonCircular btnDelete;
    private custom_swing.ButtonCircular btnEdit;
    private custom_swing.ButtonCircular btnView;
    private javax.swing.JTable jtMonedas;
    private javax.swing.JScrollPane scrollMonedas;
    // End of variables declaration//GEN-END:variables
}
