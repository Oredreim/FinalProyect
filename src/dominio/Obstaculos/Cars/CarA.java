package dominio.Obstaculos.Cars;

import dominio.Vector2D;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class CarA extends Car{

    public CarA(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public void update(int a) {
        position.setX(position.getX()+speed);

        if(position.getX()> GUI.width){
            position.setX(0-texture.getWidth());
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
