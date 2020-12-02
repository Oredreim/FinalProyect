package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import dominio.*;

public class Text {

    /**
     * contructor de los textos.
     * @param g, el grafico a mostar,
     * @param text, el texto a mostrar.
     * @param pos, la posicion del texto.
     * @param center, si el texto esta centrado.
     * @param color, tipo de color del texto.
     * @param font, tipo de fuente de texto.
     */
    public static void drawText(Graphics g, String text, Vector2D pos, boolean center, Color color, Font font) {
        g.setColor(color);
        g.setFont(font);
        Vector2D position = new Vector2D(pos.getX(), pos.getY());

        if(center) {
            FontMetrics fm = g.getFontMetrics();
            position.setX(position.getX() - fm.stringWidth(text) / 2);
            position.setY(position.getY() - fm.getHeight() / 2);

        }

        g.drawString(text, (int)position.getX(), (int)position.getY());

    }
}
