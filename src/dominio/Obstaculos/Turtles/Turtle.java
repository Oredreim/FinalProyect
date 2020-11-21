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
    public Turtle(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
        this.estado="a";
        this.movio=0;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract double getSpeed();
}
