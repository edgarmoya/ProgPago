package utiles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
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
     * @param pos
     */
    public static void headerAligment(JTable jt, int pos) {
        ((DefaultTableCellRenderer) jt.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(pos);
        /*DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(pos);
        jt.getColumnModel().getColumn(column).setCellRenderer(rendar);*/
    }

    /**
     * Método para alinear los textos de una columna
     * @param jt
     * @param alig Tipo de alineación
     * @return DefaultTableCellRenderer
     */
    public static DefaultTableCellRenderer alinearColumna(JTable jt, int alig) {
        DefaultTableCellRenderer rightRenderer = new JTableCeldasUtil();    
        rightRenderer.setHorizontalAlignment(alig);
        return rightRenderer;
    }

    /**
     * Método para mostar solo las líneas horizontales
     * @param jt JTable a editar
     */
    public static void onlyHorizontalLine(JTable jt) {
        jt.setShowGrid(false);
        jt.setShowHorizontalLines(true);
    }

    /**
     * Método para colorear el fondo de blanco
     * @param jsp Scroll correspondiente al jtable
     */
    public static void scrollBackground(JScrollPane jsp) {
        //jt.setFillsViewportHeight(true);
        jsp.getViewport().setBackground(new Color(255, 255, 255));
    }
    
    /**
     * Método que reune todos los cambios
     * @param jt
     * @param jsp 
     */
    public static void modTable(JTable jt, JScrollPane jsp){
        //Ordenar el jtable          
        jt.setAutoCreateRowSorter(true);
        // Completar con blanco el jtable que no tiene datos
        JTableUtil.scrollBackground(jsp);
        // Cambiar color de las filas de forma alternada
        jt.setDefaultRenderer(Object.class, new JTableCeldasUtil());  
        // Solo lineas horizontales
        JTableUtil.onlyHorizontalLine(jt);
    }
    
}
