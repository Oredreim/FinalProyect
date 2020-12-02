package dominio.Obstaculos.Cars;

import dominio.Vector2D;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class CarE extends Car{

    /**
     * Constructor de los carros tipo E.
     * @param position, Posicion del carro en eje X y Y.
     * @param texture, imagen del carro.
     */
    public CarE(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    /**
     * Actualiza los carros.
     * @param a, para saber la direccion en la que va el carro.
     */
    @Override
    public void update(int a) {
        position.setX(position.getX()+speed);

        if(position.getX()> GUI.width){
            position.setX(0-texture.getWidth());
        }
    }

    /**
     * Dibuja los carros.
     * @param g, los graficos a mostrar de cada carro.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
