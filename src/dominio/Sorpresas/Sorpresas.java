package dominio.Sorpresas;

import dominio.Vector2D;
import dominio.Players.Humans.Player;
import dominio.Players.Humans.Player2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Sorpresas {

    protected AffineTransform at;
    protected BufferedImage texture;
    protected double x;
    protected double y;
    protected double vel = 0;
    protected Vector2D position;
    protected boolean dead;

    public Sorpresas(Vector2D position, BufferedImage texture) {
        
        this.position = position;
        this.texture = texture;
    }

    //Clase abstracta que actualiza el estado del juego con respecto al poder
    //@Param Ball ball que define la bola del juego a la que afecta el poder
    //@Param player player jugador 1 
    //@Param player player2 jugador 2
    //@Param float dt que maneja una diferencia de tiempo
    public abstract void update();

    public abstract void draw(Graphics g);

}
