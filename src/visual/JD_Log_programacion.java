package visual;

import entidades.Historial;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.postgresql.util.PSQLException;
import ppago.ConexionPg;
import utiles.JTableUtil;

/**
 *
 * @author Edgar Moya
 */
public class JD_Log_programacion extends javax.swing.JDialog {
    
    private ConexionPg pg = new ConexionPg();
    private int idprog;

    public JD_Log_programacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(getIconImage("historial_button"));
        
        //Editar color de la tabla
        JTableUtil.headerTable(jtLog);
    }
    
    public Image getIconImage (String nombe_icono){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/"+nombe_icono+".png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollLog = new javax.swing.JScrollPane();
        jtLog = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scrollLog.setBackground(new java.awt.Color(255, 255, 255));
        scrollLog.setBorder(null);
        scrollLog.setOpaque(false);

        jtLog.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Fecha", "Operación"
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
        jtLog.setToolTipText("Historial de cambios");
        jtLog.setGridColor(new java.awt.Color(204, 204, 204));
        jtLog.setRowHeight(25);
        jtLog.setSelectionBackground(new java.awt.Color(228, 235, 245));
        jtLog.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jtLog.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollLog.setViewportView(jtLog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollLog, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método para actualizar la tabla con el historial
    private void mostrar() {
        String[] columnNames = {"Usuario", "Fecha", "Operación"};
        ArrayList<Historial> historial = new ArrayList<>();
        try {
            historial = historial(idprog);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[][] data = new String[historial.size()][3];        
        for (int i = 0; i < historial.size(); i++) {
            data[i][0] = historial.get(i).getUsuario();
            data[i][1] = historial.get(i).getFecha();
            data[i][2] = historial.get(i).getOperacion();
        }       
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //tabla no editable
                return false;
            }
        };       
        jtLog.setModel(model);
        // Efectuar todas las modificaciones
        JTableUtil.modTable(jtLog, scrollLog);
    }
    
    // Listar historial guardado en la bitácora de la bd
    public ArrayList<Historial> historial(int prog) throws SQLException, ClassNotFoundException, ConnectionException, BDException {
        Connection conn = pg.getConnection();
        ArrayList<Historial> historial = new ArrayList<>();
        if (conn == null) {
            throw new ConnectionException("No se pudo establecer conexión con la base de datos");
        } else {
            try {
                String sql = "SELECT * FROM historial_programacion(?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, prog);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    //Preparar los datos
                    Historial h = new Historial();
                    h.setUsuario(rs.getString(1));
                    h.setFecha(rs.getString(2));
                    h.setOperacion(accion(rs.getString(3)));                   
                    historial.add(h);
                }
            } catch (PSQLException e) {
                System.out.println("Error al mostrar el historial: " + e.getMessage());
                throw new BDException(e.getServerErrorMessage().getMessage());   
            } finally {
                conn.close();
            }
        }
        return historial;
    }
    
    private String accion(String a){
        String res;
        switch(a){
            case "i":
                res = "Inserción";
                break;
            case "m":
                res = "Modificación";
                break;
            case "c":
                res = "Confirmación";
                break;
            default:
                res = "";
                break;
        }
        return res;
    }

    public void setIdprog(int idprog) {
        this.idprog = idprog;
        mostrar();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_Log_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Log_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Log_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Log_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Log_programacion dialog = new JD_Log_programacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jtLog;
    private javax.swing.JScrollPane scrollLog;
    // End of variables declaration//GEN-END:variables
}
