package visual;

import dao.ClienteDAO;
import entidades.Cliente;
import excepciones.ConnectionException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utiles.JTableUtil;

/**
 *
 * @author Edgar Moya
 */
public class ClienteForm extends javax.swing.JPanel {

    private JD_Adicionar_cliente JDAdd;

    public ClienteForm() {
        initComponents();
        //Editar color de la tabla
        JTableUtil.headerTable(jtClientes);
        mostrarActivos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        btnAdd = new custom_swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();

        background.setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(748, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jtClientes.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Organismo", "NIT", "REEUP", "Correo", "Dirección", "Teléfono", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClientes.setToolTipText("Lista de Clientes");
        jtClientes.setGridColor(new java.awt.Color(204, 204, 204));
        jtClientes.setRowHeight(25);
        jtClientes.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtClientes.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtClientes);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
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

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        int pos = jtClientes.getSelectedRow();
        if (pos != -1) {
            //elementoSeleccionado(true);
        } else {
            //elementoSeleccionado(false);
        }
    }//GEN-LAST:event_jtClientesMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar cliente
        JDAdd = new JD_Adicionar_cliente(null, true);       
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);
        
        // Si se efectuaron cambios actualizar tabla
        if (JDAdd.cambios()){           
            mostrarActivos();
        }       
    }//GEN-LAST:event_btnAddActionPerformed

    //Método para actualizar la tabla con la lista de clientes
    private void mostrarActivos() {
        ClienteDAO dao = new ClienteDAO();
        String[] columnNames = {"Código", "Nombre", "Organismo", "NIT", "REEUP", "Correo", "Dirección", "Teléfono"};
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = dao.listaClientesActivos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[clientes.size()][8];        
        for (int i = 0; i < clientes.size(); i++) {
            data[i][0] = clientes.get(i).getCod_cliente();
            data[i][1] = clientes.get(i).getNombre();
            data[i][2] = clientes.get(i).getOrganismo();
            data[i][3] = clientes.get(i).getNit();
            data[i][4] = clientes.get(i).getReeup();
            data[i][5] = clientes.get(i).getCorreo();
            data[i][6] = clientes.get(i).getDireccion();
            data[i][7] = clientes.get(i).getTelefono();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtClientes.setModel(model);
        //Ordenar el jtable por código y nombre            
        jtClientes.setAutoCreateRowSorter(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel bg;
    private custom_swing.Button btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtClientes;
    // End of variables declaration//GEN-END:variables
}
