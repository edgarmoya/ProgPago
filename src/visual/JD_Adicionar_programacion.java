package visual;

import dao.ClienteDAO;
import dao.EjercicioDAO;
import dao.MonedaDAO;
import dao.ProgramacionDAO;
import dao.TipoFinanDAO;
import entidades.Cliente;
import entidades.DestinoDesglose;
import entidades.Ejercicio;
import entidades.Moneda;
import entidades.Programacion;
import entidades.TipoFinan;
import excepciones.BDException;
import excepciones.ConnectionException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utiles.JTableCeldasUtil;
import utiles.JTableUtil;
import utiles.autoComplete;

/**
 *
 * @author Edgar Moya
 */
public class JD_Adicionar_programacion extends javax.swing.JDialog {

    private ArrayList<DestinoDesglose> ddesg = new ArrayList<>();
    private ProgramacionDAO pDAO = new ProgramacionDAO();
    private int codProgramacion;
    private boolean cambios;
    private boolean editar;

    public JD_Adicionar_programacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage("add_button"));

        //Editar color de la tabla
        JTableUtil.headerTable(jtDestinos);

        buscarClientes();
        buscarMonedas();
        buscarTipoFinan();
        buscarEjercicios();
        
        actualizarTabla();  
        camposRequeridos();
    }

    public Image getIconImage(String nombre_icono) {
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/" + nombre_icono + ".png"));
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        bg = new javax.swing.JPanel();
        scrollDestinos = new javax.swing.JScrollPane();
        jtDestinos = new javax.swing.JTable();
        btnAceptar = new custom_swing.Button();
        btnCancelar = new custom_swing.Button();
        jcbCliente = new custom_swing.Combobox();
        jcbMoneda = new custom_swing.Combobox();
        jcbTipoFinan = new custom_swing.Combobox();
        jtfFecha = new custom_swing.TextField();
        jtfObservacion = new custom_swing.TextField();
        btnDate = new custom_swing.Button();
        btnAdd = new custom_swing.Button();
        btnEdit = new custom_swing.Button();
        btnDelete = new custom_swing.Button();
        jcbEjercicio = new custom_swing.Combobox();

        date.setForeground(new java.awt.Color(45, 125, 246));
        date.setTextRefernce(jtfFecha);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva programación");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        scrollDestinos.setBackground(new java.awt.Color(255, 255, 255));
        scrollDestinos.setBorder(null);
        scrollDestinos.setOpaque(false);

        jtDestinos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Destino", "Importe"
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

        btnAceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Agregar nueva programación");
        btnAceptar.setEnabled(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(45, 125, 246)));
        btnCancelar.setForeground(new java.awt.Color(45, 125, 246));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cerrar diálogo de captación");
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jcbCliente.setToolTipText("Seleccione el cliente");
        jcbCliente.setLabeText("CLIENTE*");
        jcbCliente.setOpaque(false);
        jcbCliente.setPreferredSize(new java.awt.Dimension(58, 48));
        jcbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbClienteMouseClicked(evt);
            }
        });

        jcbMoneda.setToolTipText("Seleccione la moneda");
        jcbMoneda.setLabeText("MONEDA*");
        jcbMoneda.setOpaque(false);
        jcbMoneda.setPreferredSize(new java.awt.Dimension(64, 48));
        jcbMoneda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMonedaMouseClicked(evt);
            }
        });

        jcbTipoFinan.setToolTipText("Seleccione el tipo de financiamiento");
        jcbTipoFinan.setLabeText("TIPO DE FINANCIAMIENTO*");
        jcbTipoFinan.setMinimumSize(new java.awt.Dimension(58, 48));
        jcbTipoFinan.setOpaque(false);
        jcbTipoFinan.setPreferredSize(new java.awt.Dimension(58, 48));
        jcbTipoFinan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbTipoFinanMouseClicked(evt);
            }
        });

        jtfFecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfFecha.setToolTipText("Seleccione la fecha ");
        jtfFecha.setLabelText("FECHA*");
        jtfFecha.setMinimumSize(new java.awt.Dimension(64, 48));
        jtfFecha.setOpaque(false);
        jtfFecha.setPreferredSize(new java.awt.Dimension(64, 48));

        jtfObservacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfObservacion.setToolTipText("Inserte las observaciones ");
        jtfObservacion.setLabelText("OBSERVACIÓN");
        jtfObservacion.setOpaque(false);
        jtfObservacion.setPreferredSize(new java.awt.Dimension(64, 48));
        jtfObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfObservacionKeyReleased(evt);
            }
        });

        btnDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendar_button.png"))); // NOI18N
        btnDate.setToolTipText("Agregar logotipo");
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_button.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar destino");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_button.png"))); // NOI18N
        btnEdit.setToolTipText("Editar destino");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_button.png"))); // NOI18N
        btnDelete.setToolTipText("Eliminar destino");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jcbEjercicio.setToolTipText("Seleccione el ejercicio");
        jcbEjercicio.setLabeText("EJERCICIO*");
        jcbEjercicio.setOpaque(false);
        jcbEjercicio.setPreferredSize(new java.awt.Dimension(58, 48));
        jcbEjercicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbEjercicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfObservacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollDestinos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jcbMoneda, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                        .addComponent(jcbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jcbTipoFinan, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbMoneda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jcbTipoFinan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(scrollDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtDestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDestinosMouseClicked

    }//GEN-LAST:event_jtDestinosMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       if (!editar){
            // Agregar programacion
            accionAgregar();
        }else{
            // Editar programacion
            accionEditar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        date.showPopup();
    }//GEN-LAST:event_btnDateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Acción para agregar destino
        JD_Desglose_destino JDAdd = new JD_Desglose_destino(null, true);
        JDAdd.setLocationRelativeTo(this);
        JDAdd.setVisible(true);

        if (JDAdd.isAccept()) {
            String destino = JDAdd.getDestino();
            ArrayList<Double> importes = JDAdd.getImportes();
            DestinoDesglose dd = new DestinoDesglose(destino, importes);
            ddesg.add(dd);
            actualizarTabla();
        }
        camposRequeridos();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Acción para editar destino
        if (posicion() != -1){
            int pos = posicion();
            JD_Desglose_destino JDEdit = new JD_Desglose_destino(null, true);
            JDEdit.setLocationRelativeTo(this);
            JDEdit.setDesglose(ddesg.get(pos));
            JDEdit.setVisible(true);

            if (JDEdit.isAccept()) {
                String destino = JDEdit.getDestino();
                ArrayList<Double> importes = JDEdit.getImportes();
                DestinoDesglose dd = new DestinoDesglose(destino, importes);
                ddesg.set(pos, dd);
                actualizarTabla();
            }
            camposRequeridos();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el destino que desea editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Acción para eliminar destino
        if (posicion() != -1){
            int pos = posicion();
            ddesg.remove(pos);
            actualizarTabla();
            camposRequeridos();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el destino que desea eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jcbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbClienteMouseClicked
        camposRequeridos();
    }//GEN-LAST:event_jcbClienteMouseClicked

    private void jcbEjercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbEjercicioMouseClicked
        camposRequeridos();
    }//GEN-LAST:event_jcbEjercicioMouseClicked

    private void jcbMonedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMonedaMouseClicked
        camposRequeridos();
    }//GEN-LAST:event_jcbMonedaMouseClicked

    private void jcbTipoFinanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbTipoFinanMouseClicked
        camposRequeridos();
    }//GEN-LAST:event_jcbTipoFinanMouseClicked

    private void jtfObservacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfObservacionKeyReleased
        camposRequeridos();
    }//GEN-LAST:event_jtfObservacionKeyReleased

    // Buscar clientes de la BD
    private void buscarClientes() {
        //Limpiar ComboBox
        jcbCliente.removeAllItems();
        ClienteDAO cDAO = new ClienteDAO();
        try {
            ArrayList<Cliente> clientes = cDAO.listaTodosClientes();
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

    // Buscar monedas de la BD
    private void buscarMonedas() {
        //Limpiar ComboBox
        jcbMoneda.removeAllItems();
        MonedaDAO mDAO = new MonedaDAO();
        try {
            ArrayList<Moneda> monedas = mDAO.listaTodasMonedas();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[monedas.size()];
            for (int i = 0; i < monedas.size(); i++) {
                veDatos[i] = monedas.get(i).getSiglas() + " " + monedas.get(i).getNombre();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbMoneda, veDatos);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Buscar tipofinan de la BD
    private void buscarTipoFinan() {
        //Limpiar ComboBox
        jcbTipoFinan.removeAllItems();
        TipoFinanDAO tDAO = new TipoFinanDAO();
        try {
            ArrayList<TipoFinan> tipos = tDAO.listaTodoTipoFinan();
            //Copiar la lista a un arreglo
            String[] veDatos = new String[tipos.size()];
            for (int i = 0; i < tipos.size(); i++) {
                veDatos[i] = tipos.get(i).getCod_tipo() + " " + tipos.get(i).getDescripcion();
            }
            //Agregar datos al comboBox
            autoComplete.setAutoComplete(jcbTipoFinan, veDatos);
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

    // Método para actualizar la tabla con la lista de destinos
    private void actualizarTabla() {
        String[] columnNames = {"Destino", "Importe"};
        String[][] data = new String[ddesg.size()][columnNames.length];
        for (int i = 0; i < ddesg.size(); i++) {
            data[i][0] = ddesg.get(i).getDestino();
            data[i][1] = "" + ddesg.get(i).importeTotal();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // tabla no editable
                return false;
            }
        };
        jtDestinos.setModel(model);
        JTableUtil.scrollBackground(scrollDestinos);
        // Cambiar color de las filas de forma alternada
        jtDestinos.setDefaultRenderer(Object.class, new JTableCeldasUtil());  
        // Solo lineas horizontales
        JTableUtil.onlyHorizontalLine(jtDestinos);
        // Alinear los importes a la derecha
        jtDestinos.getColumnModel().getColumn(1).setCellRenderer(JTableUtil.alinearColumna(DefaultTableCellRenderer.RIGHT));
    }

    private Programacion datos_programacion() {
        Programacion p = new Programacion();
        // cliente
        String cliente = (jcbCliente.getSelectedIndex() != -1) ? jcbCliente.getSelectedItem().toString() : "";
        p.setCliente(cliente.split(" ")[0]);
        // ejercicio
        String ejercicio = (jcbEjercicio.getSelectedIndex() != -1) ? jcbEjercicio.getSelectedItem().toString() : "";
        p.setEjercicio(ejercicio);
        // moneda
        String moneda = (jcbMoneda.getSelectedIndex() != -1) ? jcbMoneda.getSelectedItem().toString() : "";
        p.setMoneda(moneda.split(" ")[0]);
        // tipo
        String tipo = (jcbTipoFinan.getSelectedIndex() != -1) ? jcbTipoFinan.getSelectedItem().toString() : "";
        p.setTipofinan(tipo.split(" ")[0]);
        // fecha
        p.setFecha(java.sql.Date.valueOf(convertStringtoDate(jtfFecha.getText())));
        // observación
        p.setObservacion(jtfObservacion.getText());
        System.out.println("" + p);
        return p;
    }

    private String[] arrayDestinos() {
        String[] array = new String[ddesg.size()];
        for (int i = 0; i < ddesg.size(); i++) {
            array[i] = ddesg.get(i).getDestino().split(" ")[0];
        }
        return array;
    }

    private String[] arrayImportes() {
        String[] array = new String[ddesg.size() * 12];
        for (int i = 0; i < ddesg.size(); i++) {
            for (int j = 0; j < 12; j++) {
                array[i * 12 + j] = ddesg.get(i).getImportes().get(j).toString();
            }
        }
        return array;
    }

    // Método para validar que no exista los campos requeridos vacíos
    private void camposRequeridos() {
        String cliente = jcbCliente.getSelectedItem().toString();
        String ejercicio = jcbEjercicio.getSelectedItem().toString();
        String moneda = jcbMoneda.getSelectedItem().toString();
        String tipo = jcbTipoFinan.getSelectedItem().toString();
        if (cliente.isEmpty() || ejercicio.isEmpty() || moneda.isEmpty() || tipo.isEmpty()
                || jtfFecha.getText().isEmpty() || ddesg.isEmpty()) {
            btnAceptar.setEnabled(false);
        } else {
            btnAceptar.setEnabled(true);
        }
    }

    // convertir fecha con formato dd-MM-yyyy a date
    private String convertStringtoDate(String fecha) {
        DateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = (Date) parser.parse(fecha);
        } catch (ParseException ex) {
            // nada
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
    

    // convertir fecha con formato yyyy-MM-dd a date
    private String convertDatetoString(String fecha) {
        DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) parser.parse(fecha);
        } catch (ParseException ex) {
            // nada
        }
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }
    
    // Posición de la fila seleccionada
    private int posicion() {
        return jtDestinos.getSelectedRow();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_Adicionar_programacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_Adicionar_programacion dialog = new JD_Adicionar_programacion(new javax.swing.JFrame(), true);
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
    
    // Agregar programacion a bd
    private void accionAgregar(){
        Programacion prog = datos_programacion();
        if (!ddesg.isEmpty()) {
            try {
                int res = pDAO.agregarProgramacion(prog, arrayDestinos(), arrayImportes());
                if (res != -1) {
                    JOptionPane.showMessageDialog(this, "Programación agregada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    cambios = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar la programación", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ConnectionException | BDException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe agregar al menos un destino en la programación.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Editar programacion en bd
    private void accionEditar(){
        Programacion prog = datos_programacion();
        try {
            int res = pDAO.editarProgramacion(codProgramacion, prog, arrayDestinos(), arrayImportes());
            if (res != -1) {
                JOptionPane.showMessageDialog(this, "Programación editada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                cambios = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al editar la programación", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private custom_swing.Button btnAceptar;
    private custom_swing.Button btnAdd;
    private custom_swing.Button btnCancelar;
    private custom_swing.Button btnDate;
    private custom_swing.Button btnDelete;
    private custom_swing.Button btnEdit;
    private com.raven.datechooser.DateChooser date;
    private custom_swing.Combobox jcbCliente;
    private custom_swing.Combobox jcbEjercicio;
    private custom_swing.Combobox jcbMoneda;
    private custom_swing.Combobox jcbTipoFinan;
    private javax.swing.JTable jtDestinos;
    private custom_swing.TextField jtfFecha;
    private custom_swing.TextField jtfObservacion;
    private javax.swing.JScrollPane scrollDestinos;
    // End of variables declaration//GEN-END:variables


    //Cambios que se producirán si se va a editar la programacion
    public void dialogo_editar(Programacion p){  
        editar = true;
        codProgramacion = p.getId_prog();
        // Editar título e icono
        setTitle("Editar Programación");
        setIconImage(getIconImage("edit_button"));
        // Cambiar toolTip del btnAceptar
        btnAceptar.setToolTipText("Editar programación");

        // Mostrar datos en campo correspondiente     
        setJcbCliente(p.getCliente());
        setJcbEjercicio(p.getEjercicio()); 
        setJcbMoneda(p.getMoneda()); 
        setJcbTipoFinan(p.getTipofinan()); 
        setJtfFecha(""+p.getFecha());
        setJtfObservacion(p.getObservacion());
        
        try {
            // actualizar tabla destinos
            ddesg = pDAO.getDestinos(codProgramacion);
            actualizarTabla();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ConnectionException | BDException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Comprobar campos para que se active el btnAceptar
        camposRequeridos();
    }
      
    // retorna si se realizó algún cambio o no
    public boolean cambios() {
        return cambios;
    }
     
    // Setters
    public void setJcbCliente(String jcbCliente) {
        this.jcbCliente.setSelectedItem(jcbCliente); 
    }
    public void setJcbEjercicio(String jcbEjercicio) {
        this.jcbEjercicio.setSelectedItem(jcbEjercicio); 
    }
     public void setJcbMoneda(String jcbMoneda) {
        this.jcbMoneda.setSelectedItem(jcbMoneda); 
    }
    public void setJcbTipoFinan(String jcbTipoFinan) {
        this.jcbTipoFinan.setSelectedItem(jcbTipoFinan); 
    }
    public void setJtfFecha(String jtffecha) {
        this.jtfFecha.setText(convertDatetoString(jtffecha));
    }
     public void setJtfObservacion(String jtfobservacion) {
        this.jtfObservacion.setText(jtfobservacion);
    }

}
