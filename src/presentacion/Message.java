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

    /**
     * contructor de los mensajes textuales.
     * @param position, posicion de donde saldra la imagen.
     * @param fade
     * @param text, el texto a mostrar en pantalla.
     * @param color, el color del texto.
     * @param center, comprobar si esta centrado.
     * @param font, tipo de fuente del texto.
     */
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

    /**
     * dibuja la fuente.
     * @param g2d, recibe los graficos a mostrar en la interfaz.
     */
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