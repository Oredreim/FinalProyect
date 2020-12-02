package presentacion;

import dominio.*;

import javax.sound.sampled.LineUnavailableException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Button {

    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private Action action;
    private String text;

    /**
     * contructor de botones.
     * @param mouseOutImg, la imagen que mostrara si el mouse no pasa por encima del boton.
     * @param mouseInImg, la imagen que mostrara si el mouse pasa por encima del boton.
     * @param x, posicion en el eje x del boton.
     * @param y, posiicon en el eje y del boton.
     * @param text, tipo de fuente del texto dentro del boton.
     * @param action, la accion que hara el boton al oprimirse.
     */

    public Button(BufferedImage mouseOutImg, BufferedImage mouseInImg, int x, int y, String text, Action action) {
        this.mouseInImg = mouseInImg;
        this.mouseOutImg = mouseOutImg;
        this.text = text;
        boundingBox = new Rectangle(x, y, mouseInImg.getWidth(), mouseInImg.getHeight());
        this.action = action;
    }
    /**
     * actualizacion de los botones.
     * @throws LineUnavailableException
     */

    public void update() throws LineUnavailableException {
        if(boundingBox.contains(MouseInput.X, MouseInput.Y)) {
            mouseIn = true;
        }else {
            mouseIn = false;
        }

        if(mouseIn && MouseInput.MLB) {
            action.doAction();
        }
    }

    /**
     * Muestra los botones graficamente.
     * @param g, los graficos (texturas) que mostrara en la interfaz.
    */

    public void draw(Graphics g) {

        if(mouseIn) {
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        }else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }
        Text.drawText(
                g,
                text,
                new Vector2D(
                        boundingBox.getX() + boundingBox.getWidth() / 2,
                        boundingBox.getY() + boundingBox.getHeight()),
                true,
                Color.BLACK,
                Assets.fontMed);
    }
}