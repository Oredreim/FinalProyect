package dominio.Players.Generales;

import dominio.Vector2D;
import presentacion.Assets;
import presentacion.GUI;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public  class Ganar {
    protected Vector2D position;
    protected AffineTransform at;
    protected BufferedImage texture;
    protected String estado="a";

    public Ganar(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }
    public void update(BufferedImage cambio) {
        texture=cambio;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
