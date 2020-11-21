package dominio;

import javax.swing.*;

public class FroggerExcption extends Exception{
    public final static String OBJETO_FINALIZADO = "El objeto ha sido finalizado";
    public FroggerExcption(String message){
        JOptionPane.showMessageDialog(null,message);
    }
}
