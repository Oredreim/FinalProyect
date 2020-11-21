package presentacion;

import dominio.*;
import dominio.States.GameStateVSplayer;

import java.awt.*;

public class Message {
    private GameStateVSplayer gameStateVSplayer;
    private float alpha;
    private String text;
    private Vector2D position;
    private Color color;
    private boolean center;
    private boolean fade;
    private Font font;
    private final float deltaAlpha = 0.01f;

    public Message(Vector2D position, boolean fade, String text, Color color,
                   boolean center, Font font) {
        this.font = font;
        this.text = text;
        this.position = position;
        this.fade = fade;
        this.color = color;
        this.center = center;

        if(fade)
            alpha = 1;
        else
            alpha = 0;

    }

    public void draw(Graphics2D g2d) {

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        Text.drawText(g2d, text, position, center, color, font);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

        position.setY(position.getY() - 1);

        if(fade)
            alpha -= deltaAlpha;
        else
            alpha += deltaAlpha;

        if(fade && alpha < 0 || !fade && alpha > 1) {
            gameStateVSplayer.getMessages().remove(this);
        }
    }


}