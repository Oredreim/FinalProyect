package dominio.Obstaculos.Turtles;

import dominio.Vector2D;
import presentacion.Assets;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TurtleA extends Turtle{
    public TurtleA(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public void update(){
        position.setX(position.getX()-speed);
        if (movio==10) {
            if (estado == "a") {
                texture = Assets.turtleb;
                estado = "b";
            } else if (estado == "b") {
                texture = Assets.turtlec;
                estado = "c";
            } else if (estado == "c") {
                texture = Assets.turtlea;
                estado = "a";
            }
            movio=0;
        }
        else{
            movio++;
        }
        if(position.getX() < -texture.getWidth()){
            position.setX(GUI.width);
        }
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
