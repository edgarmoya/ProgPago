package custom_swing.Header;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Edgar Moya
 */
public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }
    
    //Evento de mostrar y ocultar menú
    public void addMenuEvent(ActionListener event) {
        btnHome.addActionListener(event);
    }
    
    //Cambiar el icono de flecha
    public void setIconHome(ImageIcon icon){
        btnHome.setIcon(icon);
    }
    
    //Evento de mostrar opciones de perfil
    public void addOpcionesEvent(MouseListener event) {
        opciones.addMouseListener(event);
    }
    
    //Set nombre en el perfil
    public void setNombre(String n) {
        nombre.setText(n);
    }
    
    //Set apellidos en el perfil
    public void setApellidos(String a) {
        apellidos.setText(a);
    }   
    
    //Cambiar la imagen de perfil por la foto correspondiente
    public void setImagePerfil(){
        //Falta
    }
    
    //Retorna el label opciones donde se mostrará el popupMenu
    public JLabel getOpciones(){
        return opciones;
    }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new custom_swing.Button();
        profile = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        apellidos = new javax.swing.JLabel();
        opciones = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 125, 245));
        setPreferredSize(new java.awt.Dimension(655, 80));

        btnHome.setBackground(new java.awt.Color(45, 125, 246));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow_left.png"))); // NOI18N

        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/header_profile.png"))); // NOI18N
        profile.setToolTipText("");

        nombre.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombre.setText("Admin");
        nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        apellidos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        apellidos.setForeground(new java.awt.Color(255, 255, 255));
        apellidos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        apellidos.setText("Administrador");
        apellidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        opciones.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        opciones.setForeground(new java.awt.Color(255, 255, 255));
        opciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow_down.png"))); // NOI18N
        opciones.setText("Opciones");
        opciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        opciones.setFocusable(false);
        opciones.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        opciones.setIconTextGap(8);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tesorería");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Gestión Contable Financiera");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/header_library.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(profile)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(apellidos)
                        .addGap(2, 2, 2)
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidos;
    private custom_swing.Button btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel opciones;
    private javax.swing.JLabel profile;
    // End of variables declaration//GEN-END:variables
}
