package dominio.Players.Generales;

import dominio.Vector2D;
import presentacion.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Lives {
    protected Vector2D position;
    protected AffineTransform at;
    protected BufferedImage texture;
    protected String estado="a";

    /**
     * Constructor de vidas del jugador.
     * @param position, posicion donde van las vidas.
     * @param texture, imagen de las vidas.
     */
    public Lives(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    /**
     * actualiza las vidas del jugador.
     * @param textura, recibe las texturas de cantidad de vidas.
     */
    public void update(BufferedImage textura) {
        texture=textura;
    }

    /**
     * dibuja las vidas del jugador.
     * @param g, grafica de las vidas.
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
