package dominio.Sorpresas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

import dominio.Vector2D;

public class Acelerar extends Sorpresas {

    public Acelerar(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
    
}
