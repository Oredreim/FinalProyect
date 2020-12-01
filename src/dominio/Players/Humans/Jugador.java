package dominio.Players.Humans;

import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Charco.Charco;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Obstaculos.Turtles.TurtleB;
import dominio.Obstaculos.Turtles.TurtleD;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
import dominio.Sorpresas.Acelerar;
import dominio.Sorpresas.Caparazon;
import dominio.Sorpresas.Sorpresas;
import dominio.Vector2D;
import presentacion.Assets;
import presentacion.Sounds;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public abstract class Jugador{
    protected int tipo;
    protected BufferedImage texture;
    protected AffineTransform at;
    public Vector2D position;
    protected int movido=0;
    protected String presiono="a";
    public int llego=0;
    protected int reinicia=0;
    protected int lives=10;
    protected int score=0;
    public ArrayList<BufferedImage> personaje;
    protected ArrayList<Lives>vidas;
    protected Clip jump = AudioSystem.getClip();
    protected Clip murio = AudioSystem.getClip();
    protected Clip teletransporta=AudioSystem.getClip();
    protected Clip llega=AudioSystem.getClip();
    protected boolean muere=false;
    protected boolean pierde=false;
    protected boolean cortasalto=false;
    protected boolean desliza=false;
    protected boolean charco=false;
    protected boolean anden=false;
    protected int x;
    public int segundos;
    public Date start= new Date();
    public Date end = new Date();
    public Date pausestart= new Date();
    public Date pauseend = new Date();
    protected int interval;
    public int tiempopausa=0;
    public ArrayList<Sorpresas> sorpresas=new ArrayList<>();
    public String poderes="";
    protected boolean acelerador=false;
    protected boolean caparazon=false;
    protected int tiempoPower;
    protected double mueve;

    public Jugador(Vector2D position, BufferedImage texture, ArrayList<BufferedImage> personaje, ArrayList<Lives> vidas,int tipo) throws LineUnavailableException {
        this.tipo=tipo;
        this.vidas=vidas;
        this.position = position;
        this.texture = texture;
        this.personaje = personaje;
    }
    public boolean interacciones(ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles ,InputStream pierde, Clip murio){
        boolean muere=false;
        if (position.getY() < 635 && position.getY() > 410) {
            muere=cars(cars);
        }
        else if ((position.getY() >= 275 && position.getY() <= 305) || (position.getY() >= 230 && position.getY() <= 260) ||
                (position.getY() >= 140 && position.getY() <= 170) || (position.getY() + texture.getWidth() >= 275 && position.getY() + texture.getWidth() <= 305) ||
                (position.getY() + texture.getWidth() >= 230 && position.getY() + texture.getWidth() <= 260) ||
                (position.getY() + texture.getWidth() >= 140 && position.getY() + texture.getWidth() <= 170)
        ) {
            muere=trunks(trunks);
        }
        else if ((position.getY() >= 320 && position.getY() <= 350) || (position.getY() >= 185 && position.getY() <= 215) ||
                (position.getY() + texture.getWidth() >= 320 && position.getY() + texture.getWidth() <= 350) ||
                (position.getY() + texture.getWidth() >= 185 && position.getY() + texture.getWidth() <= 215)) {
            muere=turtles(turtles);
        }
        if(muere){
            Sounds.reproduce(murio, pierde,false);
        }
        return muere;
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
    public boolean charcos(ArrayList<Charco> charcos){
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
                movido=0;
                texture = personaje.get(0);

                return true;
            }
        }
        return false;
    }
    public void sorpresas(ArrayList<Sorpresas> sorpresas){
        for (int i = 0; i < sorpresas.size(); i++) {
            double xsorpresa = sorpresas.get(i).position.getX();
            double ysorpresa = sorpresas.get(i).position.getY();
            double wsorpresa = xsorpresa+sorpresas.get(i).texture.getWidth();
            double hsorpresa = ysorpresa+sorpresas.get(i).texture.getHeight();
            if((position.getX()==xsorpresa && position.getY()==ysorpresa && position.getX()+texture.getWidth()==wsorpresa && position.getY()+texture.getHeight()==hsorpresa)||
                    (position.getX()>=xsorpresa && position.getX()<=wsorpresa && ((position.getY()>=ysorpresa && position.getY()<=hsorpresa)||
                            (position.getY()+texture.getHeight()>=ysorpresa && position.getY()+texture.getHeight()<=hsorpresa)))||
                    (position.getX()+texture.getWidth()>=xsorpresa && position.getX()+texture.getWidth()<=wsorpresa && ((position.getY()>=ysorpresa && position.getY()<=hsorpresa)||
                            (position.getY()+texture.getHeight()>=ysorpresa && position.getY()+texture.getHeight()<=hsorpresa)))||
                    (position.getY()>=ysorpresa && position.getY()<=hsorpresa && ((position.getX()>=xsorpresa && position.getX()<=wsorpresa)||
                            (position.getX()+texture.getWidth()>=xsorpresa && position.getX()+texture.getWidth()<=wsorpresa)))||
                    (position.getY()+texture.getHeight()>=ysorpresa && position.getY()+texture.getHeight()<=hsorpresa && ((position.getX()>=xsorpresa && position.getX()<=wsorpresa)||
                            (position.getX()+texture.getWidth()>=xsorpresa && position.getX()+texture.getWidth()<=wsorpresa)))
            ){
                if((this.sorpresas.size()==0)||(this.sorpresas.size()==1 && ((this.sorpresas.get(0) instanceof Caparazon &&
                        sorpresas.get(i) instanceof Acelerar)||(this.sorpresas.get(0) instanceof Acelerar &&
                        sorpresas.get(i) instanceof Caparazon)))) {
                    this.sorpresas.add(sorpresas.get(i));
                    sorpresas.remove(i);
                }
            }
        }
    }
    public void activaPower(){
        if(sorpresas.get(0) instanceof Caparazon && acelerador==false){
            caparazon=true;
            if(interval>=3){
                tiempoPower=interval-3;
            }
        }
        else if(sorpresas.get(0) instanceof Acelerar && caparazon==false){
            acelerador=true;
            if(interval>=3){
                tiempoPower=interval-3;
            }
        }
    }
    public void up(Clip jump, InputStream salto){
        if(acelerador==true){
            mueve=4.50;
        }
        else{
            mueve=2.25;
        }

        presiono="a";
        if(movido==0){
            if(presiono=="a"){
               // Sounds.reproduce(jump,salto,false);
            }
        }
        else if(movido>0 && movido<=10){
            texture = personaje.get(0);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(1);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(2);
        }
        else if(movido==38){
            if (presiono=="a"){
               // Sounds.close(jump);
            }
            texture = personaje.get(0);
            movido=-2;
            if(presiono=="a"){
                score+=10;
            }
        }
        movido+=2;
        position.setY(position.getY() - mueve);
    }
    public void fin(ArrayList<Ganar> win,Clip llega, InputStream marca){
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
        if(!llega.isRunning()){
            //Sounds.reproduce(llega, marca,false);
        }
        llego+=1;
        movido=0;
        score+=50;
        start=new Date();
        position.setX(x);
        position.setY(635+42.75);
    }
    public void  down(Clip jump, InputStream salto){
        if(acelerador==true){
            mueve=4.50;
        }
        else{
            mueve=2.25;
        }
        presiono="c";
        if(movido==0){
            //Sounds.reproduce(jump,salto,false);
        }
        else if(movido>0 && movido<=10){
            texture = personaje.get(3);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(4);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(5);
        }
        else if(movido==38){
           // Sounds.close(jump);
            texture = personaje.get(3);
            movido=-2;
            score-=10;
        }
        movido+=2;
        position.setY(position.getY() + mueve);
    }
    public void left(Clip jump,InputStream salto){
        if(acelerador==true){
            mueve=4.50;
        }
        else{
            mueve=2.25;
        }
        presiono="d";
        if(movido==0){
            //Sounds.reproduce(jump,salto,false);
        }
        else if(movido>0 && movido<=10){
            texture = personaje.get(6);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(7);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(8);
        }
        else if(movido==38){
           // Sounds.close(jump);
            texture = personaje.get(6);
            movido=-2;
        }
        movido+=2;
        position.setX(position.getX() - mueve);
    }
    public void right(Clip jump,InputStream salto){
        if(acelerador==true){
            mueve=4.50;
        }
        else{
            mueve=2.25;
        }
        presiono="e";
        if(movido==0){
           // Sounds.reproduce(jump,salto,false);
        }
        else if(movido>0 && movido<=10){
            texture = personaje.get(9);
        }
        else if(movido>10 && movido<=20){
            texture = personaje.get(10);
        }
        else if(movido>20 && movido<38){
            texture = personaje.get(11);
        }
        else if(movido==38){
          //  Sounds.close(jump);
            texture = personaje.get(9);
            movido=-2;
        }
        movido+=2;
        position.setX(position.getX() + mueve);
    }
    public void reiniciar(ArrayList<Ganar> win) {
        win.get(0).update( Assets.blanco);
        win.get(1).update( Assets.blanco);
        win.get(2).update( Assets.blanco);
        win.get(3).update( Assets.blanco);
        win.get(4).update( Assets.blanco);
        win.get(5).update( Assets.blanco);
        win.get(6).update( Assets.blanco);
        movido=0;
        llego=0;
        position.setX(x);
        position.setY(635);
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
    public void finsonido(Clip murio, Clip teletransporta, Clip llegi){
        if(llegi.getMicrosecondPosition()==llegi.getMicrosecondLength() && llegi.getMicrosecondLength()!=0){
            Sounds.close(llegi);
        }
        if(murio.getMicrosecondPosition()==murio.getMicrosecondLength() && murio.getMicrosecondLength()!=0){
            Sounds.close(murio);
            pierde=false;
            start=new Date();
        }
        if(teletransporta.getMicrosecondLength()==teletransporta.getMicrosecondPosition() && teletransporta.getMicrosecondLength()!=0){
            Sounds.close(teletransporta);
        }
    }
    public abstract int getLives();
    public abstract int getScore();
    public abstract void caambiaincial();
    public void iniciapausa(){
        pausestart=new Date();
    }
    public void terminapausa(){
        pauseend=new Date();
        tiempopausa+=(int)((pauseend.getTime()-pausestart.getTime())/1000);
    }
    public void perdio(double x){
        if(caparazon){
            caparazon=false;
            sorpresas.remove(0);
        }
        if(acelerador){
            acelerador=false;
            sorpresas.remove(0);
        }
        movido=0;
        tiempopausa=0;
        muere=true;
        cortasalto=true;
        pierde=true;
        score -= 100;
        lives--;
        vidas.get(lives).update(Assets.blanco);
        position.setX(x);
        position.setY(635);
        texture=personaje.get(0);
    }
    public void setCantidadLives(){
        lives--;
        vidas.get(lives).update(Assets.blanco);
    }
    public void setAssetLives(int i){
        vidas.get(i).update(personaje.get(14));
    }
    public abstract void update(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos, ArrayList<Sorpresas> powers);

    public abstract void draw(Graphics g);

}
