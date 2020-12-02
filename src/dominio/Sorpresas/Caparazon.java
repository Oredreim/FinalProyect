package dominio.Sorpresas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

import dominio.Vector2D;

public class Caparazon extends Sorpresas {

    /**
     * Constructor de la sorpresa Caparazon.
     * @param position, posicion donde estara la sorpresa.
     * @param texture, textura de la sorpresa.
     */
    public Caparazon(Vector2D position, BufferedImage texture) {
        super(position, texture);
        // TODO Auto-generated constructor stub
    }

    /**
     * actualiza el poder.
     */
    @Override
    public void update() {
        // TODO Auto-generated method stub
    }

    /**
     * dibuja el poder.
     * @param g, grafico a dibujar.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);

    }
    
}
