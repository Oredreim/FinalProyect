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

    public Lives(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }
    public void update(BufferedImage textura) {
        texture=textura;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
