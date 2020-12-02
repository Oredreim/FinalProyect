package presentacion;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;

public abstract class State {

    private static State currentState = null;

    /**
     * Devuelve el estado actual que se mostrara.
     * @return del estado a mostrar.
     */
    public static State getCurrentState() {return currentState;}
    public static void changeState(State newState) {
        currentState = newState;
    }


    /**
     * actualiza los estados.
     * @throws Exception
     */
    public abstract void update() throws Exception;

    /**
     * dibuja los estados.
     * @param g
     */
    public abstract void draw(Graphics g);
}