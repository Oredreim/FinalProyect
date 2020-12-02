package dominio.Obstaculos.Turtles;

import dominio.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class Turtle {
    protected int movio;
    public String estado;
    public Vector2D position;
    public AffineTransform at;
    public BufferedImage texture;
    public static double  speed=1.5;

    /**
     * Constructor de las tortugas.
     * @param position, posicion de la tortuga.
     * @param texture, imagen de la tortuga.
     */
    public Turtle(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
        this.estado="a";
        this.movio=0;
    }

    /**
     * actualiza la tortuga.
     */
    public abstract void update();

    /**
     * Dibuja los carros.
     * @param g, los graficos a mostrar de cada carro.
     */
    public abstract void draw(Graphics g);

    /**
     * obtiene la velocidad de las tortugas.
     * @return flotante con la velocidad de las tortugas.
     */
    public abstract double getSpeed();
}
