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
        if (correo == null || correo.isEmpty()) {
            return true;
        } else {
            //Pattern patron = Pattern.compile("^[a-z0-9-\\+]+(\\.[a-z0-9-]+)*@[a-z0-9-]*(\\.[a-z]{2,})$");
            Pattern patron = Pattern.compile("^[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,}$");
            
            Matcher comparar = patron.matcher(correo);
            return comparar.find();
        }
    }
}
