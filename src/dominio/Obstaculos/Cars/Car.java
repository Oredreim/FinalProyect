package dominio.Obstaculos.Cars;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import dominio.Vector2D;

public abstract class Car {

    public Vector2D position;
    public AffineTransform at;
    public BufferedImage texture;
    public static double speed=1;
    public Car(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    public abstract void update(int a);

    public abstract void draw(Graphics g);

}
