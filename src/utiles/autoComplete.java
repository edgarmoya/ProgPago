package utiles;

import javax.swing.JComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 * @author Edgar Moya
 */
public class autoComplete {

    /**
     * Permite escribir textos dentro de un combox y de forma automatica va
     * seleccionando el texto que queremos consultar. Los datos se cargan a
     * partir de un vector String[].
     * @param comboBox - Combo deseado
     * @param datos - Datos para el combox
     */
    public static void setAutoComplete(JComboBox comboBox, String[] datos) {
        comboBox.setEditable(true);
        comboBox.setModel(new javax.swing.DefaultComboBoxModel(datos));
        AutoCompleteDecorator.decorate(comboBox);
    }     
    
    
}
