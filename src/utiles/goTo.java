package utiles;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class goTo {             
    
    //Abrir JFrame desde otro JFrame 
    public static void frame(JFrame origen, JFrame destino) {         
        origen.dispose();
        destino.setVisible(true);    
    }
    
    //Abrir JFrame desde u JDialog
    public static void frame(JDialog origen, JFrame destino) {         
        origen.dispose();
        destino.setVisible(true);    
    }
    
    //Abrir JDialog desde otro JDialog
    public static void dialog(JDialog origen, JDialog destino) {          
        origen.dispose(); 
        destino.setVisible(true);   
    }
}
