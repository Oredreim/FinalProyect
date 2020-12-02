package presentacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

    public static int X, Y;
    public static boolean MLB;


    /**
     * Metodo que muestra si esta la tecla presionada del mouse.
     * @param e, recibe las teclas presionadas del mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            MLB = true;
        }
    }

    /**
     * Metodo que muestra si las teclas del mouse estan siendo liberadas.
     * @param e, recibe las teclas liberadas del mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            MLB = false;
        }
    }

    /**
     * Metodo que reconoce si el mouse pasa por encima de un objeto.
     * @param e, recibe las teclas liberadas del mouse.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
    }

    /**
     * Metodo que reconoce el movimiento del mouse por el panel (interfaz).
     * @param e, recibe las teclas liberadas del mouse.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
    }

}