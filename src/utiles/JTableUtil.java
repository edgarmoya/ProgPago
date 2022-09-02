package utiles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Edgar Moya
 */
public class JTableUtil {
    
    /**
     * Método para customizar el color y la letra del header de una tabla
     * @param jt JTable a editar 
     */
    public static void headerTable(JTable jt) {
        jt.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jt.getTableHeader().setOpaque(false);
        jt.getTableHeader().setBackground(new Color(45, 125, 246));
        jt.getTableHeader().setForeground(new Color(255, 255, 255));
        jt.setRowHeight(25);
    }

    /**
     * Método para centrar los textos del header
     * @param jt JTable a editar
     */
    public static void centerTable(JTable jt) {
        ((DefaultTableCellRenderer) jt.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(JLabel.CENTER);
        jt.getColumnModel().getColumn(0).setCellRenderer(rendar);
    }

    /**
     * Método para alinear los textos de una columna 
     * @param alig Tipo de alineación
     * @return DefaultTableCellRenderer
     */
    public static DefaultTableCellRenderer alinearColumna(int alig) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alig);
        return rightRenderer;
    }
    
}
