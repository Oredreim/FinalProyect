package dominio.Obstaculos.Turtles;

import dominio.Vector2D;
import presentacion.Assets;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TurtleB extends Turtle{
    public int repite=0;

    /**
     * Constructor de las tortugas tipo B.
     * @param position, posicion de la tortuga.
     * @param texture, imagen de la tortuga.
     */
    public TurtleB(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

     /**
     * actualiza la tortuga tipo B.
     */
    public void update(){
        position.setX(position.getX()-speed);
        if(movio == 10 && repite<9){
            if (estado == "a") {
                texture = Assets.turtleb;
                estado = "a1";
            } else if (estado == "a1") {
                texture = Assets.turtlec;
                estado = "a2";
            } else if (estado == "a2") {
                texture = Assets.turtlea;
                estado = "a";
            }
            repite++;
            movio=0;
        }
        else if (movio==10 && repite==9 ){
            if (estado == "a") {
                texture = Assets.turtled;
                estado = "b";
            } else if (estado == "b") {
                texture = Assets.turtlee;
                estado = "c";
            } else if (estado == "c") {
                texture = Assets.turtlef;
                estado = "d";
            } else if (estado == "d") {
                texture = Assets.turtlee;
                estado = "e";
            } else if (estado == "e") {
                texture = Assets.turtled;
                estado = "f";
            } else if (estado == "f") {
                texture = Assets.turtlea;
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

    /**
     * obtiene la velocidad de las tortugas.
     * @return flotante con la velocidad de las tortugas.
     */
    @Override
    public double getSpeed() {
        return speed;
    }
}
