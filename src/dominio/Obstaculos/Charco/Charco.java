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

    public Charco(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }
    public void update() {
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }

}
