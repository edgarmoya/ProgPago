package utiles;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Edgar Moya
 */
public class JTableCeldasUtil extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (condicion(row)) {
            this.setBackground(new Color(250, 250, 250));         
        } else {
            this.setBackground(Color.WHITE);
        }
        if(isSelected){
            this.setBackground(new Color(220, 227, 237));
        }
        return this;
    }

    private boolean condicion(int num) {
        return (num % 2 == 0);
    }
}
