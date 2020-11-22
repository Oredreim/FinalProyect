package presentacion;

import javax.sound.sampled.LineUnavailableException;

public interface Action {

    public abstract void doAction() throws LineUnavailableException;
}