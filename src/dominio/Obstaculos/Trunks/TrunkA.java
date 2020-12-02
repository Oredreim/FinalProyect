package dominio.Obstaculos.Trunks;

import dominio.Vector2D;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TrunkA extends Trunk{
    public static double speed=1;

    /**
     * Constructor de los Camiones.
     * @param position, Posicion en X y y de los camiones.
     * @param texture, imagen del camion.
     */
    public TrunkA (Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    /**
     * Actualiza los Camiones.
     */
    @Override
    public void update() {
        position.setX(position.getX()+speed);

        if(position.getX()> GUI.width){
            position.setX(0-texture.getWidth());
        }
    }

    /**
     * Dibuja los carros.
     * @param g, los graficos a mostrar de cada camion.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }

    /**
     * Obtiene la velocidad en la que va el camion.
     * @return la velocidad actual del camion.
     */
    @Override
    public double getSpeed() {
        return speed;
    }
}
