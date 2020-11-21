package dominio.Players.Machines;

import dominio.Players.Generales.Ganar;
import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class machine {
    protected BufferedImage texture;
    protected AffineTransform at;
    protected Vector2D position;
    protected int movido=0;
    protected String presiono="a";
    protected int llego=0;
    protected int reinicia=0;
    protected int lives=10;
    protected int score=0;
    protected String string;
    protected ArrayList<BufferedImage> personaje;
    protected boolean pausa=false;
    public machine(Vector2D position, BufferedImage texture, ArrayList<BufferedImage> personaje, String string) {
        this.string=string;
        this.position = position;
        this.texture = texture;
        this.personaje = personaje;
    }

    public abstract void update(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles);

    public abstract void draw(Graphics g);
}
