package dominio.Obstaculos.Charco;

import dominio.Vector2D;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Charco {
    public Vector2D position;
    public AffineTransform at;
    public BufferedImage texture;

    /**
     * Constructo de los charcos.
     * @param position, posicion de los tarchos en X y Y.
     * @param texture, imagen a mostrar de los charcos.
     */
    public Charco(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    /**
     * Actualiza los charcos.
     * 
     */
    public void update() {
    }

    /**
     * Dibuja los carros.
     * @param g, los graficos a mostrar de cada charco.
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }

}
