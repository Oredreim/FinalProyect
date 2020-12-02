package dominio.Sorpresas;

import dominio.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class Sorpresas {

    protected AffineTransform at;
    public BufferedImage texture;
    protected double x;
    protected double y;
    protected double vel = 0;
    public Vector2D position;
    protected boolean dead;

    /**
     * Constructor de la sorpresa.
     * @param position, posicion donde estara la sorpresa.
     * @param texture, textura de la sorpresa.
     */
    public Sorpresas(Vector2D position, BufferedImage texture) {
        
        this.position = position;
        this.texture = texture;
    }

    /**
     * actualiza el poder.
     */
    public abstract void update();

    /**
     * dibuja el poder.
     * @param g, grafico a dibujar.
     */
    public abstract void draw(Graphics g);

}
