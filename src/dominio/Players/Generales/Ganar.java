package dominio.Players.Generales;

import dominio.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public  class Ganar {
    protected Vector2D position;
    protected AffineTransform at;
    protected BufferedImage texture;
    protected String estado="a";

    /**
     * Constructor del ganar.
     * @param position, la posicion donde notifica quien gano.
     * @param texture, la imagen a mostrar del ganador.
     */
    public Ganar(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    /**
     * Actualiza la clase ganador.
     * @param cambio, cambia la imagen del ganador.
     */
    public void update(BufferedImage cambio) {
        texture=cambio;
    }

    /**
     * muestra graficamente el ganador.
     * @param g, Grafico a mostrar.
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }

    /**
     * Obtiene la textura (imagen) del ganador.
     * @return la textura del ganador.
     */
    public BufferedImage getTexture(){
        return texture;
    }

    /**
     * cambia la textura.
     * @param imagen, nueva imagen a mostrar.
     */
    public void setTexture(BufferedImage imagen){
        texture=imagen;
    }
}
