package utiles;

import custom_swing.Button;
import custom_swing.Combobox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Edgar Moya
 */
public class keyboradUtil {

    /**
     * Validar el máximo de caracteres permitidos en un JTextField
     *
     * @param jtf jtextfield a validar
     * @param cant máximo caracteres permitidos
     */
    public static void maxLength(JTextField jtf, int cant) {
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jtf.getText().length() >= cant) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Nada
            }
        });
    }

    /**
     * Permitir solo números en determinado JTextField
     *
     * @param jtf jtextfield a validar
     */
    public static void soloNumeros(JTextField jtf) {
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int key = e.getKeyChar();
                boolean isNum = key >= 48 && key <= 57;
                if (!isNum) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Nada
            }
        });
    }

    /**
     * Comprobar si es un correo válido
     * @param jtf jtextfield a validar
     */
    public static void isCorreo(JTextField jtf) {
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (CorreoUtil.isCorreo(jtf.getText()) == false) {
                        JOptionPane.showMessageDialog(null, "Correo electónico incorrecto, verifíquelo antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
                        jtf.requestFocus();
                    }
                }
            }
        });
    }

    /**
     * Método para cambiar al siguiente campo cuando se presiona ENTER
     *
     * @param jtf1 JTextField donde se está escribiendo
     * @param jtf2 JTextField hacia donde irá el cursor
     */
    public static void siguienteCampo(JTextField jtf1, JTextField jtf2) {
        jtf1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jtf2.requestFocus(true);
                }
            }
        });
    }

    /**
     * Método para cambiar al siguiente campo cuando se presiona ENTER Cuando es
     * el último campo y el siguiente es un botón
     * @param jtf JTextField donde se está escribiendo
     * @param btn Button hacia donde irá el cursor
     * @param btnAlt Button alterno hacia donde irá el cursor si btn está
     * inactivo
     */
    public static void siguienteCampo(JTextField jtf, Button btn, Button btnAlt) {
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (btn.isEnabled()) {
                        btn.requestFocus();
                    } else {
                        btnAlt.requestFocus();
                    }
                }
            }
        });
    }

    /**
     * Método para cambiar al siguiente campo cuando se presiona ENTER 
     * Cuando el siguiente es un ComboBox
     * @param jtf JTextField donde se está escribiendo
     * @param combo ComoBox hacia donde irá el cursor
     */
    public static void siguienteCampo(JTextField jtf, Combobox combo) {
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    combo.requestFocus(true);
                }
            }
        });
    }

    /**
     * Método para cambiar al siguiente campo cuando se presiona ENTER 
     * @param combo ComboBox donde se está escribiendo
     * @param jtf JTextField hacia donde irá el cursor
     */
    public static void siguienteCampo(Combobox combo, JTextField jtf) {
        JTextComponent editor = (JTextComponent) combo.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jtf.requestFocus(true);
                }
            }
        });
    }
    
    /**
     * Método para cambiar al siguiente campo cuando se presiona ENTER 
     * Cuando es el último campo y el siguiente es un botón
     * @param combo ComboBox donde se está escribiendo
     * @param btn Button hacia donde irá el cursor
     * @param btnAlt Button alterno hacia donde irá el cursor si btn está
     * inactivo
     */
    public static void siguienteCampo(Combobox combo, Button btn, Button btnAlt) {
        JTextComponent editor = (JTextComponent) combo.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (btn.isEnabled()) {
                        btn.requestFocus();
                    } else {
                        btnAlt.requestFocus();
                    }
                }
            }
        });
    }

    /**
     * Método para cambiar el focus al siguiente botón
     * @param btn1 Botón focalizado
     * @param btn2 Botón destino
     */
    public static void focusButton(Button btn1, Button btn2) {
        btn1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (btn2.isEnabled()) {
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
                        btn2.requestFocus();
                    }
                }
            }
        });
    }
    
    /**
     * Método para no permitir espacios
     * @param jtf JTextField donde se está escribiendo
     */
    public static void sinEspacio(JTextField jtf) {
        jtf.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (key == ' '){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Nada 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Nada
            }
        });
    }
}
