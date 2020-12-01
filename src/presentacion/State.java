package presentacion;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static State getCurrentState() {return currentState;}
    public static void changeState(State newState) {
        currentState = newState;
    }

    public abstract void update() throws Exception;
    public abstract void draw(Graphics g);
}