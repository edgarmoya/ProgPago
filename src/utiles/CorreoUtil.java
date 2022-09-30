package utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Edgar Moya
 */
public class CorreoUtil {
    
    // Validar el correo electrónico
    public static boolean isCorreo(String correo) {
        if (correo.isEmpty()) {
            return true;
        } else {
            Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher comparar = patron.matcher(correo);
            return comparar.find();
        }
    }
}
