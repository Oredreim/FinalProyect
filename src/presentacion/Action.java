package presentacion;

import javax.sound.sampled.LineUnavailableException;

public interface Action {
    /**
     * Crea las acciones de los botones.
     * @throws LineUnavailableException
     */
    public abstract void doAction() throws LineUnavailableException;
}