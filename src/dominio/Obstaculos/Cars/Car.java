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

    /**
     * Constructo de los carros.
     * @param position, Posicion del carro en eje X y Y.
     * @param texture, imagen del carro.
     */
    public Car(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    /**
     * Actualiza los carros.
     * @param a, para saber la direccion en la que va el carro.
     */
    public abstract void update(int a);

    /**
     * Dibuja los carros.
     * @param g, los graficos a mostrar de cada carro.
     */
    public abstract void draw(Graphics g);

}
