package dominio.Players.Humans;

import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Charco.Charco;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
import dominio.Sorpresas.Acelerar;
import dominio.Sorpresas.Caparazon;
import dominio.Sorpresas.Sorpresas;
import dominio.Vector2D;
import presentacion.Assets;
import presentacion.KeyBoard;
import presentacion.Sounds;
import presentacion.Text;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public  class Player extends Jugador {

    public Player(Vector2D position, BufferedImage texture, ArrayList<BufferedImage> personaje, ArrayList<Lives> vidas, int tipo) throws LineUnavailableException {
        super(position,texture,personaje,vidas,tipo);
        x=300;
    }
    public void desliza(){
        if(!charco){
            Sounds.reproduce(teletransporta,Sounds.teletransportap2,false);
            charco=true;
        }
        if(position.getX()<900) {
            position.setX(position.getX()+10);
        }
        if(position.getX()>=900){
            position.setX(300);
            position.setY(365);
            Sounds.close(jump);
            charco=false;
        }
    }
    @Override
    public void finsonido(Clip murio, Clip teletransporta, Clip llego){
        super.finsonido(murio,teletransporta, llego);
    }

    public void verificar(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles){
        muere = interacciones(cars, trunks, turtles, Sounds.pierdep1, murio);
        if (llego == 7) {
            score += 1000;
            reiniciar(win);
        }
        if (muere) {
            perdio();
        }
    }
    public void movimientodoble(ArrayList<Ganar> win){
        if (((KeyBoard.up || KeyBoard.up2)&& position.getY() >= 180 && movido == 0) || (movido != 0 && presiono == "a")) {
            up(jump,Sounds.jumpp1);
        } else if (((KeyBoard.up || KeyBoard.up2) && position.getY() <= 180 && ((position.getX() > 40 && position.getX() < 70) ||
                (position.getX() > 180 && position.getX() < 210) || (position.getX() > 320 && position.getX() < 350) ||
                (position.getX() > 450 && position.getX() < 480) || (position.getX() > 580 && position.getX() < 625) ||
                (position.getX() > 725 && position.getX() < 755) || (position.getX() > 855 && position.getX() < 885)) &&
                movido == 0) || (movido != 0 && presiono == "b")) {
            fin(win, llega,Sounds.llegap1);
        } else if (((KeyBoard.down ||KeyBoard.down2) && position.getY() <= 600 && movido == 0) || (movido != 0 && presiono == "c")) {
            down(jump,Sounds.jumpp1);
        } else if (((KeyBoard.left || KeyBoard.left2) && position.getX() > 10 && movido == 0) || (movido != 0 && presiono == "d")) {
            left(jump,Sounds.jumpp1);
        } else if (((KeyBoard.right || KeyBoard.right2) && position.getX() < 880 && movido == 0) || (movido != 0 && presiono == "e")) {
            right(jump,Sounds.jumpp1);
        }
        else if (KeyBoard.powerp1){
            activaPower();
        }

    }
    public void activaPower(){
        super.activaPower();
    }
    public void movimiento(ArrayList<Ganar> win){
        if ((KeyBoard.up && position.getY() >= 170 && movido == 0) || (movido != 0 && presiono == "a")) {
            up(jump,Sounds.jumpp1);
        } else if ((KeyBoard.up && position.getY() <= 170 && ((position.getX() > 40 && position.getX() < 70) ||
                (position.getX() > 180 && position.getX() < 210) || (position.getX() > 320 && position.getX() < 350) ||
                (position.getX() > 450 && position.getX() < 480) || (position.getX() > 580 && position.getX() < 625) ||
                (position.getX() > 725 && position.getX() < 755) || (position.getX() > 855 && position.getX() < 885)) &&
                movido == 0) || (movido != 0 && presiono == "b")) {
            fin(win, llega,Sounds.llegap1);
            tiempopausa=0;
        } else if ((KeyBoard.down && position.getY() <= 600 && movido == 0) || (movido != 0 && presiono == "c")) {
            down(jump,Sounds.jumpp1);
        } else if ((KeyBoard.left && position.getX() > 10 && movido == 0) || (movido != 0 && presiono == "d")) {
            left(jump,Sounds.jumpp1);
        } else if ((KeyBoard.right && position.getX() < 880 && movido == 0) || (movido != 0 && presiono == "e")) {
            right(jump,Sounds.jumpp1);
        }

    }
    public void tiempo(){
        end=new Date();
        interval=30-(int)((end.getTime()-start.getTime())/1000)+tiempopausa;
        if(interval==0){
            Sounds.reproduce(murio,Sounds.pierdep1,false);
            perdio();

        }
        if ((position.getY() == 635 || position.getY() == 365) && !anden) {
            segundos=interval-5;
            anden=true;
        }
        if(anden && position.getY()!=635 && position.getY()!=365){
            anden=false;
        }
        if(anden && interval==segundos){
            Sounds.reproduce(murio,Sounds.pierdep1,false);
            perdio();
        }
    }
    public void sorpresas(ArrayList<Sorpresas>powers){
        super.sorpresas(powers);
    }
    public void activos(){
        if(interval==tiempoPower && caparazon==true){
            caparazon=false;
            sorpresas.remove(0);
        }
        else if(interval==tiempoPower && acelerador==true){
            acelerador=false;
            sorpresas.remove(0);
        }
    }
    @Override
    public void update(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos,ArrayList<Sorpresas> powers) {
        sorpresas(powers);
        activos();
        if(!charco){
            desliza=charcos(charcos);
        }
        if(desliza){
            desliza();
        }
        if(!pierde && !desliza){
            verificar(win, cars, trunks, turtles);
        }
        if (!muere && !desliza) {
            tiempo();
            if(cortasalto && jump.getMicrosecondLength()==jump.getMicrosecondPosition()){
                Sounds.close(jump);
                cortasalto=false;
            }
            if(tipo==1){
                movimientodoble(win);
            }else{
                movimiento(win);
            }
        }
        poderes="";
        if(sorpresas.size()>0) {
            if (sorpresas.get(0) instanceof Acelerar) {
                poderes += "A";
            }
            if (sorpresas.get(0) instanceof Caparazon) {
                poderes += "C";
            }
        }
        if(sorpresas.size()>1){
            if(sorpresas.get(1) instanceof Caparazon){
                poderes+=" C";
            }
            if (sorpresas.get(1) instanceof Acelerar) {
                poderes += " A";
            }
        }
        finsonido(murio,teletransporta,llega);
    }
    @Override
    public boolean interacciones(ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,InputStream pierde, Clip murio){
        return super.interacciones(cars,trunks,turtles,pierde,murio);

    }

    @Override
    public boolean charcos(ArrayList<Charco> charcos) {
        return super.charcos(charcos);
    }

    @Override
    public int getScore() {
        return score;
    }
    @Override
    public int getLives() {
        return lives;
    }
    @Override
    public void cargavidas() {
        super.cargavidas();
    }
    @Override
    public void draw(Graphics g) {
        if(score<0){
            score=0;
        }
        Text.drawText(g,"Time: "+Integer.toString(interval),new Vector2D(50,70),true, Color.WHITE,Assets.fontMed);
        Text.drawText(g,"Score: "+Integer.toString(score),new Vector2D(50,35),true, Color.WHITE,Assets.fontMed);
        Text.drawText(g,"X"+Integer.toString(lives),new Vector2D(170,702),true, Color.WHITE,Assets.fontMed);
        Text.drawText(g,"Powers "+poderes,new Vector2D(240,702),true, Color.WHITE,Assets.fontMed);
        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
   }
    @Override
    public void up(Clip jump, InputStream sonido){
        super.up(jump,sonido);
    }
    @Override
    public void fin(ArrayList<Ganar> win,Clip jump, InputStream sonido){
        super.fin(win,jump,sonido);
    }
    @Override
    public void  down(Clip jump, InputStream sonido){
        super.down(jump,sonido);
    }
    @Override
    public void left(Clip jump, InputStream sonido){
        super.left(jump,sonido);
    }
    @Override
    public void right(Clip jump, InputStream sonido){
        super.right(jump,sonido);
    }
    @Override
    public void reiniciar(ArrayList<Ganar> win) {
        super.reiniciar(win);
    }
    public Vector2D getPosition() {
        return position;
    }
    public void setPosition(Vector2D position) {
        this.position = position;
    }
    public BufferedImage getTexture() {
        return this.texture;
    }

    @Override
    public void caambiaincial() {
        start=new Date();
    }
    public void perdio(){
        super.perdio(position.getX());

    }
    public void iniciapausa(){
        super.iniciapausa();
    }
    public void terminapausa(){
        super.terminapausa();
    }
}