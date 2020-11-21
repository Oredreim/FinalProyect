package dominio.Players.Humans;

import dominio.*;
import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Charco.Charco;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Obstaculos.Turtles.TurtleB;
import dominio.Obstaculos.Turtles.TurtleD;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
import presentacion.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Jugador {

    protected BufferedImage texture;
    protected AffineTransform at;
    public Vector2D position;
    protected int movido=0;
    protected String presiono="a";
    public int llego=0;
    protected int reinicia=0;
    protected int lives=10;
    protected int score=0;
    protected ArrayList<BufferedImage> personaje;
    protected ArrayList<Lives>vidas;
    protected int x;
    public Jugador(Vector2D position, BufferedImage texture, ArrayList<BufferedImage> personaje, ArrayList<Lives> vidas) {
        this.vidas=vidas;
        this.position = position;
        this.texture = texture;
        this.personaje = personaje;
    }
    public boolean interacciones(ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles, ArrayList<Charco> charcos){
        if (position.getY() < 635 && position.getY() > 410) {
            return cars(cars);
        }
        else if ((position.getY() >= 275 && position.getY() <= 305) || (position.getY() >= 230 && position.getY() <= 260) ||
                (position.getY() >= 140 && position.getY() <= 170) || (position.getY() + texture.getWidth() >= 275 && position.getY() + texture.getWidth() <= 305) ||
                (position.getY() + texture.getWidth() >= 230 && position.getY() + texture.getWidth() <= 260) ||
                (position.getY() + texture.getWidth() >= 140 && position.getY() + texture.getWidth() <= 170)
        ) {
            return trunks(trunks);
        }
        else if ((position.getY() >= 320 && position.getY() <= 350) || (position.getY() >= 185 && position.getY() <= 215) ||
                (position.getY() + texture.getWidth() >= 320 && position.getY() + texture.getWidth() <= 350) ||
                (position.getY() + texture.getWidth() >= 185 && position.getY() + texture.getWidth() <= 215)) {
            return turtles(turtles);
        }
        charcos(charcos);
        return false;
    }
    public boolean cars(ArrayList<Car> cars){
        for (int i = 0; i < cars.size(); i++) {
            double xcar = cars.get(i).position.getX();
            double ycar = cars.get(i).position.getY();
            double wcar = xcar+cars.get(i).texture.getWidth();
            double hcar = ycar+cars.get(i).texture.getHeight();
            if((position.getX()==xcar && position.getY()==ycar && position.getX()+texture.getWidth()==wcar && position.getY()+texture.getHeight()==hcar)||
                    (position.getX()>=xcar && position.getX()<=wcar && ((position.getY()>=ycar && position.getY()<=hcar)||
                            (position.getY()+texture.getHeight()>=ycar && position.getY()+texture.getHeight()<=hcar)))||
                    (position.getX()+texture.getWidth()>=xcar && position.getX()+texture.getWidth()<=wcar && ((position.getY()>=ycar && position.getY()<=hcar)||
                            (position.getY()+texture.getHeight()>=ycar && position.getY()+texture.getHeight()<=hcar)))||
                    (position.getY()>=ycar && position.getY()<=hcar && ((position.getX()>=xcar && position.getX()<=wcar)||
                            (position.getX()+texture.getWidth()>=xcar && position.getX()+texture.getWidth()<=wcar)))||
                    (position.getY()+texture.getHeight()>=ycar && position.getY()+texture.getHeight()<=hcar && ((position.getX()>=xcar && position.getX()<=wcar)||
                            (position.getX()+texture.getWidth()>=xcar && position.getX()+texture.getWidth()<=wcar)))
            ){
                position.setX(x);

                position.setY(635);
                movido = 0;
                texture = personaje.get(0);
                return true;
            }
        }
        return false;
    }
    public boolean trunks(ArrayList<Trunk> trunks){
        for (int i = 0; i < trunks.size(); i++) {
            double xtrunk = trunks.get(i).position.getX();
            double ytrunk = trunks.get(i).position.getY();
            double wtrunk = xtrunk+trunks.get(i).texture.getWidth();
            double htrunk = ytrunk+trunks.get(i).texture.getHeight();
            if((position.getX()==xtrunk && position.getY()==ytrunk && position.getX()+texture.getWidth()==wtrunk && position.getY()+texture.getHeight()==htrunk)||
                    (position.getX()>=xtrunk && position.getX()<=wtrunk && ((position.getY()>=ytrunk && position.getY()<=htrunk)||
                            (position.getY()+texture.getHeight()>=ytrunk && position.getY()+texture.getHeight()<=htrunk)))||
                    (position.getX()+texture.getWidth()>=xtrunk && position.getX()+texture.getWidth()<=wtrunk && ((position.getY()>=ytrunk && position.getY()<=htrunk)||
                            (position.getY()+texture.getHeight()>=ytrunk && position.getY()+texture.getHeight()<=htrunk)))||
                    (position.getY()>=ytrunk && position.getY()<=htrunk && ((position.getX()>=xtrunk && position.getX()<=wtrunk)||
                            (position.getX()+texture.getWidth()>=xtrunk && position.getX()+texture.getWidth()<=wtrunk)))||
                    (position.getY()+texture.getHeight()>=ytrunk && position.getY()+texture.getHeight()<=htrunk && ((position.getX()>=xtrunk && position.getX()<=wtrunk)||
                            (position.getX()+texture.getWidth()>=xtrunk && position.getX()+texture.getWidth()<=wtrunk)))
            ){
                if (movido==0){
                    position.setX(position.getX() + trunks.get(i).getSpeed());
                }
                return false;
            }
        }
        position.setX(x);
        position.setY(635);
        movido=0;
        texture = personaje.get(0);
        return true;
    }
    public boolean turtles(ArrayList<Turtle> turtles){
        for (int i = 0; i < turtles.size(); i++) {
            double xturtle = turtles.get(i).position.getX();
            double yturtle = turtles.get(i).position.getY();
            double wturtle = xturtle+turtles.get(i).texture.getWidth();
            double hturtle = yturtle+turtles.get(i).texture.getHeight();
            if((position.getX()==xturtle && position.getY()==yturtle && position.getX()+texture.getWidth()==wturtle && position.getY()+texture.getHeight()==hturtle)||
                    (position.getX()>=xturtle && position.getX()<=wturtle && ((position.getY()>=yturtle && position.getY()<=hturtle)||
                            (position.getY()+texture.getHeight()>=yturtle && position.getY()+texture.getHeight()<=hturtle)))||
                    (position.getX()+texture.getWidth()>=xturtle && position.getX()+texture.getWidth()<=wturtle && ((position.getY()>=yturtle && position.getY()<=hturtle)||
                            (position.getY()+texture.getHeight()>=yturtle && position.getY()+texture.getHeight()<=hturtle)))||
                    (position.getY()>=yturtle && position.getY()<=hturtle && ((position.getX()>=xturtle && position.getX()<=wturtle)||
                            (position.getX()+texture.getWidth()>=xturtle && position.getX()+texture.getWidth()<=wturtle)))||
                    (position.getY()+texture.getHeight()>=yturtle && position.getY()+texture.getHeight()<=hturtle && ((position.getX()>=xturtle && position.getX()<=wturtle)||
                            (position.getX()+texture.getWidth()>=xturtle && position.getX()+texture.getWidth()<=wturtle)))
            ){
                if((turtles.get(i) instanceof TurtleB ||turtles.get(i) instanceof TurtleD) && turtles.get(i).estado=="c"){
                    position.setX(x);
                    position.setY(635);
                    movido=0;
                    texture = personaje.get(0);
                    return true;
                }
                else if (movido==0) {
                    position.setX(position.getX() - turtles.get(i).getSpeed());
                }
                return false;
            }
        }
        position.setX(x);
        position.setY(635);
        movido=0;
        texture = personaje.get(0);
        return true;
    }
    public void charcos(ArrayList<Charco> charcos){
        for (int i = 0; i < charcos.size(); i++) {
            double xcharco = charcos.get(i).position.getX();
            double ycharco = charcos.get(i).position.getY();
            double wcharco = xcharco+charcos.get(i).texture.getWidth();
            double hcharco = ycharco+charcos.get(i).texture.getHeight();
            if((position.getX()==xcharco && position.getY()==ycharco && position.getX()+texture.getWidth()==wcharco && position.getY()+texture.getHeight()==hcharco)||
                    (position.getX()>=xcharco && position.getX()<=wcharco && ((position.getY()>=ycharco && position.getY()<=hcharco)||
                            (position.getY()+texture.getHeight()>=ycharco && position.getY()+texture.getHeight()<=hcharco)))||
                    (position.getX()+texture.getWidth()>=xcharco && position.getX()+texture.getWidth()<=wcharco && ((position.getY()>=ycharco && position.getY()<=hcharco)||
                            (position.getY()+texture.getHeight()>=ycharco && position.getY()+texture.getHeight()<=hcharco)))||
                    (position.getY()>=ycharco && position.getY()<=hcharco && ((position.getX()>=xcharco && position.getX()<=wcharco)||
                            (position.getX()+texture.getWidth()>=xcharco && position.getX()+texture.getWidth()<=wcharco)))||
                    (position.getY()+texture.getHeight()>=ycharco && position.getY()+texture.getHeight()<=hcharco && ((position.getX()>=xcharco && position.getX()<=wcharco)||
                            (position.getX()+texture.getWidth()>=xcharco && position.getX()+texture.getWidth()<=wcharco)))
            ){
                position.setX(x);
                position.setY(365);
                movido=0;
                texture = personaje.get(0);
            }
        }
    }
    public void up(){
        presiono="a";
        if(movido>0 && movido<=10){
            texture = personaje.get(0);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(1);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(2);
        }
        else if(movido>=38){
            texture = personaje.get(0);
            movido=-2;
            if(presiono=="a"){
                score+=10;
            }
        }
        movido+=2;
        position.setY(position.getY() - 2.25);
    }
    public void fin(ArrayList<Ganar> win){
        presiono="b";
        if(position.getX()>30 && position.getX()<100){
            win.get(0).update(personaje.get(12));
        }
        else if(position.getX()>180 && position.getX()<210){
            win.get(1).update(personaje.get(12));
        }
        else if(position.getX()>320 && position.getX()<350){
            win.get(2).update(personaje.get(12));
        }
        else if(position.getX()>450 && position.getX()<480){
            win.get(3).update(personaje.get(12));
        }
        else if(position.getX()>580 && position.getX()<625){
            win.get(4).update(personaje.get(12));
        }
        else if(position.getX()>725 && position.getX()<755){
            win.get(5).update(personaje.get(12));
        }
        else if(position.getX()>855 && position.getX()<885){
            win.get(6).update(personaje.get(12));
        }
        llego+=1;
        movido=0;
        score+=50;
        position.setX(x);
        position.setY(635+42.75);
    }
    public void  down(){
        presiono="c";
        if(movido>0 && movido<=10){
            texture = personaje.get(3);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(4);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(5);
        }
        else if(movido>=38){
            texture = personaje.get(3);
            movido=-2;
            score-=10;
        }
        movido+=2;
        position.setY(position.getY() + 2.25);
    }
    public void left(){
        presiono="d";
        if(movido>0 && movido<=10){
            texture = personaje.get(6);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(7);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(8);
        }
        else if(movido>=38){
            texture = personaje.get(6);
            movido=-2;
        }
        movido+=2;
        position.setX(position.getX() - 2.25);
    }
    public void right(){
        presiono="e";
        if(movido>0 && movido<=10){
            texture = personaje.get(9);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(10);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(11);
        }
        else if(movido>=38){
            texture = personaje.get(9);
            movido=-2;
        }
        movido+=2;
        position.setX(position.getX() + 2.25);
    }
    public void reiniciar(ArrayList<Ganar> win) {
        if (reinicia == 0) {
            win.get(0).update( personaje.get(12));
        } else if (reinicia == 10) {
            win.get(1).update( personaje.get(12));
        } else if (reinicia == 20) {
            win.get(2).update( personaje.get(12));
        } else if (reinicia == 30) {
            win.get(3).update( personaje.get(12));
        } else if (reinicia == 40) {
            win.get(4).update(personaje.get(12));
        } else if (reinicia == 50) {
            win.get(5).update(personaje.get(12));
        } else if (reinicia == 60) {
            win.get(6).update( personaje.get(12));
        } else if (reinicia == 70) {
            win.get(0).update( Assets.blanco);
            win.get(2).update( Assets.blanco);
            win.get(4).update( Assets.blanco);
            win.get(6).update( Assets.blanco);
            win.get(8).update( Assets.blanco);
            win.get(10).update( Assets.blanco);
            win.get(12).update( Assets.blanco);
            movido=0;
            llego=0;
            reinicia=-1;
            position.setX(300);
            position.setY(635);
        }
        reinicia++;
    }
    public void cargavidas(){
        if(lives==10){
            score+=1000;
        }
        score+=(lives*100);
        for(int i=lives;i<10;i++){
            lives++;
            vidas.get(i).update(personaje.get(14));
        }
    }
    public abstract int getLives();
    public abstract int getScore();
    public abstract void update(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos);

    public abstract void draw(Graphics g);

}
