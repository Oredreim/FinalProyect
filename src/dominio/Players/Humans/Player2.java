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
import presentacion.Text;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player2 extends Jugador {


    public Player2(Vector2D position, BufferedImage texture, ArrayList<BufferedImage> personaje,ArrayList<Lives> vidas) {
        super(position, texture, personaje,vidas);
        x=600;
    }

    @Override
    public void update(ArrayList<Ganar> win, ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos ){

        boolean muere=false;
        muere=interacciones(cars, trunks, turtles,charcos);
        if(!muere){
            if (llego==7){
                reiniciar(win);
                score+=1000;
            }
            else if((KeyBoard.up2 && position.getY()>=170 && movido==0)||(movido!=0 && presiono=="a")){
                up();
            }
            else if((KeyBoard.up2 && position.getY()<170 && ((position.getX()>40 && position.getX()<70)||
                    (position.getX()>180 && position.getX()<210)||(position.getX()>320 && position.getX()<350)||
                    (position.getX()>450 && position.getX()<480)||(position.getX()>580 && position.getX()<625)||
                    (position.getX()>725 && position.getX()<755)||(position.getX()>855 && position.getX()<885))&&
                    movido==0)||(movido!=0 && presiono=="b")){
                fin(win);
            }

            else if((KeyBoard.down2 && position.getY()<=600 && movido==0)||(movido!=0 && presiono=="c")){
                down();
            }

            else if((KeyBoard.left2 && position.getX()>30 && movido==0)||(movido!=0 && presiono=="d")){
                left();
            }

            else if((KeyBoard.right2 && position.getX()<880 && movido==0)||(movido!=0 && presiono=="e")){
                right();
            }
        }
        else if(muere){
            score-=100;
            lives--;
            vidas.get(lives).update(Assets.blanco);
        }
    }
    public boolean interacciones(ArrayList<Car> cars, ArrayList<Trunk> trunks, ArrayList<Turtle> turtles,ArrayList<Charco> charcos){
        return super.interacciones(cars, trunks, turtles,charcos);
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
        Text.drawText(g,"Score"+Integer.toString(score),new Vector2D(800,35),true, Color.WHITE,Assets.fontMed);
        Text.drawText(g,"X"+Integer.toString(lives),new Vector2D(930,702),true, Color.WHITE,Assets.fontMed);
        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        g2d.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
    @Override
    public void up(){
        super.up();
    }
    @Override
    public void fin(ArrayList<Ganar> win){
        super.fin(win);
    }
    @Override
    public void  down(){
        super.down();
    }
    @Override
    public void left(){
        super.left();
    }
    @Override
    public void right(){
        super.right();
    }
    @Override
    public void reiniciar(ArrayList<Ganar> win) {
        super.reiniciar(win);
    }
}
