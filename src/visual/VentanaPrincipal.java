package visual;

import custom_swing.Menu.Event.EventMenuSelected;
import custom_swing.Menu.Event.EventShowPopupMenu;
import custom_swing.Header.Header;
import custom_swing.Menu.Menu;
import custom_swing.Menu.MenuItem;
import custom_swing.Popup.PopupMenu;
import entidades.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import ppago.ConexionPg;

public class VentanaPrincipal extends javax.swing.JFrame {

    private Usuario usuario;
    private MigLayout layout;
    private Header header;
    private Menu menu;
    private MainForm mainForm;
    private Animator animator;
    private JPopupMenu popupOpciones;
    
    public VentanaPrincipal(Usuario usuario) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);   
        setIconImage(getIconImage()); 
        
        this.usuario = usuario;
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);  
        menu = new Menu();
        header = new Header();
        mainForm = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex, String name) {            
                if(name.equals("Programación de Pago")){       //Menú Operaciones
                    //main.showForm(new Form_Home()); 
                    
                }else if(name.equals("Tablero de Control")){   //Menu Tablero de Control
                    System.out.println("tablero");
                    
                }else if(name.equals("Clientes")){             //Menu Codificadores
                    mainForm.showForm(new ClienteForm());   
                    
                }else if(name.equals("Destinos")){
                   mainForm.showForm(new DestinoForm()); 
                    
                }else if(name.equals("Ejercicios")){
                   mainForm.showForm(new EjercicioForm());
                    
                }else if(name.equals("Monedas")){
                    mainForm.showForm(new MonedaForm());
                    
                }else if(name.equals("Tipo de Financiamiento")){
                    mainForm.showForm(new TipoFinanForm());
                    
                }else if(name.equals("General")){            //Menú Configuración
                   
                    
                }else if(name.equals("Usuarios")){            //Menú Seguridad
                    mainForm.showForm(new UsuarioForm());
                    
                }                                   
            }
        });
        
        //Evento cuando está ocultado el munú
        //Muestra las opciones en un popup
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;               
                PopupMenu popup = new PopupMenu(VentanaPrincipal.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());                                             
                int x = VentanaPrincipal.this.getX() + 52;
                int y = VentanaPrincipal.this.getY() + com.getY() + 115;
                popup.setLocation(x, y);
                popup.setVisible(true);                              
            }
        });
        
        //Agregando componentes al panel
        menu.initMenuItem(usuario.getRoles());
        bg.add(menu, "w 230!, spany 3");    // SpanY 3cell
        bg.add(header, "h 80!, wrap");
        // bg.add(herramientas, "h 36!, spanx, wrap");
        bg.add(mainForm, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany3");
                menu.revalidate();               
                //Cambiar icono de flecha para la derecha o izquierda
                cambiarFlecha();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
                 //Cambia el logo a VERSAT ó V
                menu.setLogo();                   
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        
        
        /*********************
        //Eventos del Header
        **********************/
        //Evento para mostrar y ocultar el menú
        setHeader(usuario);
        header.addMenuEvent(new ActionListener() {        
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);                             
                if (menu.isShowMenu()) {
                    menu.hideallMenu();                   
                }
            }
        });   
        
        //Mouse clicked en jLabel OPCIONES
        header.addOpcionesEvent(new MouseAdapter() {           
            @Override
            public void mouseClicked(MouseEvent e) {       
                //Abrir popupMenu con todas las opciones
                popupOpciones.show(header.getOpciones(), e.getX(), e.getY()+10);
            }                           
        });
        //Iniciar formulario principal
        //main.showForm(new Form_Home());           
    }
    
    
    @Override
    public Image getIconImage (){
        Image res = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo_principal.png"));
        return res;
    } 
    
    //Cambiando el icono de la flecha al ocultar y mostrar
    private void cambiarFlecha(){
        if(menu.isShowMenu()){
            header.setIconHome(new ImageIcon(getClass().getResource("/imagenes/arrow_right.png")));
        }else{
            header.setIconHome(new ImageIcon(getClass().getResource("/imagenes/arrow_left.png")));
        }    
    }
    
    
    // Popup Opciones
    private void popupOpciones(){
        // Inicializar popup y poner fondo blanco
        popupOpciones = new JPopupMenu(){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }          
        };
        // Items del popup
        JMenuItem contrasena = new JMenuItem("Cambiar contraseña", getIcon("/imagenes/popup_contrasena.png", 16, 16));
        JMenuItem contacto = new JMenuItem("Datos de contacto", getIcon("/imagenes/popup_contacto.png", 16, 16));
        JMenuItem organizacion = new JMenuItem("Datos de la organización", getIcon("/imagenes/popup_organizacion.png", 16, 16));
        JMenuItem acerca = new JMenuItem("Acerca de Versat", getIcon("/imagenes/popup_acerca.png", 16, 16));
        JMenuItem cerrar_sesion = new JMenuItem("Cerrar sesión", getIcon("/imagenes/popup_cerrarsesion.png", 16, 16));
        JMenuItem salir = new JMenuItem("Salir", getIcon("/imagenes/popup_salir.png", 16, 16));
        
        // Agregar items y escuchar acción
        popupOpciones.add(contrasena);
        contrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JD_Cambiar_contrasena JDContrasena = new JD_Cambiar_contrasena(null, true);
                JDContrasena.setUsuario(usuario);
                JDContrasena.setVisible(true);
            }
        });
        
        // La opcion de cambiar contraseña no se debe mostrar si es el administrador del postgresql
        if (usuario.getIdentificador().equals(cargar().getUsuario())){
            contrasena.setEnabled(false);
        } 
        
        popupOpciones.add(organizacion);
        organizacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JD_Organizacion JDOrg = new JD_Organizacion(null, true);
                JDOrg.setVisible(true);
            }
        });      

        popupOpciones.addSeparator();
        popupOpciones.add(contacto);
        contacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JD_Contacto JDCont = new JD_Contacto(null, true);
                JDCont.setVisible(true);
            }
        });
                
        popupOpciones.add(acerca);
        acerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // nada por ahora
            }
        });
        
        popupOpciones.addSeparator();
        popupOpciones.add(cerrar_sesion);
        cerrar_sesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JD_Login JDLogin = new JD_Login(null, true);
                JDLogin.setVisible(true);
            }
        });
        
        popupOpciones.add(salir);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    public Icon getIcon(String ruta, int width, int heigth){
        Icon mIcono = new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(width, heigth, 0));
        return mIcono;       
    }   
    
    private ConexionPg cargar(){
        ConexionPg pg = new ConexionPg();
        try {
            pg = pg.cargar();
        } catch (IOException ex) {
            // error
        } catch (ClassNotFoundException ex) {
            // error
        }
        return pg;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Tesorería");

        bg.setBackground(new java.awt.Color(204, 204, 204));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables

    // Obtener usuario logueado desde Login
    public void setHeader(Usuario u) {
        header.setNombre(usuario.getNombre());
        header.setApellidos(usuario.getApellidos());
        popupOpciones();
    }
    
}
