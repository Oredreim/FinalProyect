package dominio.Obstaculos.Trunks;

import dominio.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class Trunk {

    public Vector2D position;
    public AffineTransform at;
    public BufferedImage texture;

    public Trunk(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }
    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract double getSpeed();
}
