package dominio.Obstaculos.Turtles;

import dominio.Vector2D;
import presentacion.Assets;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TurtleD extends Turtle{
    public int repite=0;
    public TurtleD(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public void update(){
        position.setX(position.getX()-speed);
        if(movio == 10 && repite<9){
            if (estado == "a") {
                texture = Assets.turtleh;
                estado = "a1";
            } else if (estado == "a1") {
                texture = Assets.turtlei;
                estado = "a2";
            } else if (estado == "a2") {
                texture = Assets.turtleg;
                estado = "a";
            }
            repite++;
            movio=0;
        }
        else if (movio==10 && repite==9 ){
            if (estado == "a") {
                texture = Assets.turtlej;
                estado = "b";
            } else if (estado == "b") {
                texture = Assets.turtlek;
                estado = "c";
            } else if (estado == "c") {
                texture = Assets.turtlel;
                estado = "d";
            } else if (estado == "d") {
                texture = Assets.turtlek;
                estado = "e";
            } else if (estado == "e") {
                texture = Assets.turtlej;
                estado = "f";
            } else if (estado == "f") {
                texture = Assets.turtleg;
                estado = "a";
                repite=0;
            }

            movio = 0;
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
