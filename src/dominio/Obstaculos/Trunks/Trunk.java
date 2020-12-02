package dominio.Obstaculos.Trunks;

import dominio.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class Trunk {

    public Vector2D position;
    public AffineTransform at;
    public BufferedImage texture;

    /**
     * Constructor de los Camiones.
     * @param position, Posicion en X y y de los camiones.
     * @param texture, imagen del camion.
     */
    public Trunk(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    /**
     * Actualiza los Camiones.
     */
    public abstract void update();

    /**
     * Dibuja los carros.
     * @param g, los graficos a mostrar de cada camion.
     */
    public abstract void draw(Graphics g);
    
    /**
     * Obtiene la velocidad en la que va el camion.
     * @return la velocidad actual del camion.
     */
    public abstract double getSpeed();
}
