package dominio;

import javax.swing.*;

public class FroggerException extends Exception{
    public final static String TEXTONULL = "El texto no puede estar en blanco";
    public final static String NOHAYDATOS = "No hay partidas guardas";
    public final static String YAVISITADA = "Ya llego a esa isla";
    public final static String NOHAYPODERES = "No tiene poderes para usar";

    public FroggerException(String message){
        JOptionPane.showMessageDialog(null,message);
    }
}
