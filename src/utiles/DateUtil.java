package utiles;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edgar Moya
 */
public class DateUtil {
    
    // convertir fecha con formato dd-MM-yyyy a yyyy-MM-dd
    public static String convertStringtoDate(String fecha) {
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

    // convertir fecha con formato yyyy-MM-dd a dd-MM-yyyy
    public static String convertDatetoString(String fecha) {
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
}
