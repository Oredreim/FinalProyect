package dominio.Players.Humans;

import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Charco.Charco;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
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

public class Player2 extends Jugador {


    public Player2(Vector2D position, BufferedImage texture, ArrayList<BufferedImage> personaje,ArrayList<Lives> vidas,int tipo) throws LineUnavailableException {
        super(position, texture, personaje,vidas,tipo);
        x=600;
    }
    public void desliza(){
        if(!charco){
            Sounds.reproduce(teletransporta,Sounds.teletransporta,false);
            charco=true;
        }
        if(position.getX()<900) {
            position.setX(position.getX()+10);
        }
        if(position.getX()>=900){

            position.setX(600);
            position.setY(365);
            Sounds.close(jump);
            charco=false;
        }
    }
    @Override
    public void finsonido(Clip murio, Clip teletransporta){
        super.finsonido(murio,teletransporta);
    }
    public void verificar(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos){
        muere = interacciones(cars, trunks, turtles, charcos, Sounds.pierdep1, murio);
        if (llego == 7) {
            score += 1000;
            reiniciar(win);
        }
        if (muere) {
            cortasalto=true;
            pierde=true;
            score -= 100;
            lives--;
            vidas.get(lives).update(Assets.blanco);
        }
    }
    public void movimiento(ArrayList<Ganar> win){
        if((KeyBoard.up2 && position.getY()>=170 && movido==0)||(movido!=0 && presiono=="a")){
            up(jump,Sounds.jumpp2);
        }
        else if((KeyBoard.up2 && position.getY()<170 && ((position.getX()>40 && position.getX()<70)||
                (position.getX()>180 && position.getX()<210)||(position.getX()>320 && position.getX()<350)||
                (position.getX()>450 && position.getX()<480)||(position.getX()>580 && position.getX()<625)||
                (position.getX()>725 && position.getX()<755)||(position.getX()>855 && position.getX()<885))&&
                movido==0)||(movido!=0 && presiono=="b")){
            fin(win,jump,Sounds.llegap2);
        }

        else if((KeyBoard.down2 && position.getY()<=600 && movido==0)||(movido!=0 && presiono=="c")){
            down(jump,Sounds.jumpp2);
        }

        else if((KeyBoard.left2 && position.getX()>30 && movido==0)||(movido!=0 && presiono=="d")){
            left(jump,Sounds.jumpp2);
        }

        else if((KeyBoard.right2 && position.getX()<880 && movido==0)||(movido!=0 && presiono=="e")){
            right(jump,Sounds.jumpp2);
        }
    }
    @Override
    public void update(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos ){
        if(!charco){
            desliza=charcos(charcos);
        }
        if(desliza){
            desliza();
        }
        if(!pierde && !desliza){
            verificar(win, cars, trunks, turtles, charcos);

        }
        if(!muere && !desliza) {
            if(cortasalto){
                Sounds.close(jump);
                cortasalto=false;
            }
            movimiento(win);
        }
        finsonido(murio,teletransporta);
    }
    public boolean interacciones(ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos,InputStream pierde, Clip murio){
        return super.interacciones(cars, trunks, turtles,charcos,pierde,murio);
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
        Text.drawText(g,"Score"+Integer.toString(score),new Vector2D(800,35),true, Color.WHITE,Assets.fontMed);
        Text.drawText(g,"X"+Integer.toString(lives),new Vector2D(930,702),true, Color.WHITE,Assets.fontMed);
        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
    @Override
    public void up(Clip jump, InputStream salto){
        super.up(jump,salto);
    }
    @Override
    public void fin(ArrayList<Ganar> win,Clip jump, InputStream salto){
        super.fin(win,jump,salto);
    }
    @Override
    public void  down(Clip jump, InputStream salto){
        super.down(jump,salto);
    }
    @Override
    public void left(Clip jump, InputStream salto){
        super.left(jump,salto);
    }
    @Override
    public void right(Clip jump, InputStream salto){
        super.right(jump,salto);
    }
    @Override
    public void reiniciar(ArrayList<Ganar> win) {
        super.reiniciar(win);
    }
}
