package dominio.States;

import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Trunks.TrunkA;
import dominio.Obstaculos.Trunks.TrunkB;
import dominio.Obstaculos.Trunks.TrunkC;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
import dominio.Players.Humans.Player;
import dominio.Vector2D;
import presentacion.*;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class GameState extends States {

    private Player player1;
    protected ArrayList<Lives> lives = new ArrayList<>();
    protected ArrayList<Ganar> win = new ArrayList<>();

    public GameState(int tipo,ArrayList<BufferedImage> personaje, BufferedImage background, String string) throws LineUnavailableException {
        this();
        this.tipo=tipo;
        this.string=string;
        this.background=background;
        this.personaje1=personaje;
        Car.speed=0.7;
        TrunkA.speed=0.7;
        TrunkB.speed=3.7;
        TrunkC.speed=2.;
        Turtle.speed=1.2;
        carsA();
        carsB();
        carsC();
        carsD();
        carsE();
        trunksA();
        trunksB();
        trunksC();
        turtlesA();
        turtlesB();
        turtlesC();
        turtlesD();
        charcos();
        ganar();
        lives();
        player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje1,lives,tipo);
    }

    public GameState() throws LineUnavailableException {
    }

    public void carsA(){
        super.carsA();
    }
    public void carsB(){
        super.carsB();
    }
    public void carsC(){
        super.carsC();
    }
    public void carsD() {
        super.carsD();
    }
    public void carsE(){
        super.carsE();
    }
    public void trunksA(){
        super.trunksA();
    }
    public void trunksB(){
        super.trunksB();
    }
    public void trunksC(){
        super.trunksC();
    }
    public void turtlesA(){
        super.turtlesA();
    }
    public void turtlesB(){
        super.turtlesB();
    }
    public void turtlesC(){
        super.turtlesC();
    }
    public void turtlesD(){
        super.turtlesD();
    }
    public void charcos(){
        super.charcos();
    }
    public void ganar(){
        Ganar ganar1 = new Ganar(new Vector2D(55,100),Assets.blanco);
        win.add(ganar1);
        Ganar ganar3 = new Ganar(new Vector2D(190,100),Assets.blanco);
        win.add(ganar3);
        Ganar ganar5 = new Ganar(new Vector2D(325,100),Assets.blanco);
        win.add(ganar5);
        Ganar ganar7 = new Ganar(new Vector2D(465,100),Assets.blanco);
        win.add(ganar7);
        Ganar ganar9 = new Ganar(new Vector2D(600,100),Assets.blanco);
        win.add(ganar9);
        Ganar ganar11 = new Ganar(new Vector2D(745,100),Assets.blanco);
        win.add(ganar11);
        Ganar ganar13 = new Ganar(new Vector2D(875,100),Assets.blanco);
        win.add(ganar13);
    }
    public void lives(){
        Lives live1p1 = new Lives(new Vector2D(0,680),personaje1.get(14));
        lives.add(live1p1);
        Lives live2p1 = new Lives(new Vector2D(15,680),personaje1.get(14));
        lives.add(live2p1);
        Lives live3p1 = new Lives(new Vector2D(30,680),personaje1.get(14));
        lives.add(live3p1);
        Lives live4p1 = new Lives(new Vector2D(45,680),personaje1.get(14));
        lives.add(live4p1);
        Lives live5p1 = new Lives(new Vector2D(60,680),personaje1.get(14));
        lives.add(live5p1);
        Lives live6p1 = new Lives(new Vector2D(75,680),personaje1.get(14));
        lives.add(live6p1);
        Lives live7p1 = new Lives(new Vector2D(90,680),personaje1.get(14));
        lives.add(live7p1);
        Lives live8p1 = new Lives(new Vector2D(105,680),personaje1.get(14));
        lives.add(live8p1);
        Lives live9p1 = new Lives(new Vector2D(120,680),personaje1.get(14));
        lives.add(live9p1);
        Lives live10p1 = new Lives(new Vector2D(135,680),personaje1.get(14));
        lives.add(live10p1);
    }
    public void verifica() throws LineUnavailableException {
        if (player1.getLives() > 0 && pausa == false && !sube) {
            super.update();
            player1.update(win, cars, trunks, turtles, charcos,sorpresas);
        } else if (player1.getLives() == 0) {
            Sounds.close(backsound);
            State.changeState(new GameOver(tipo, "Game over", player1.getScore(), string, personaje1, personaje2, background,"l"));
        }
    }
    public void cambia(){
        player1.caambiaincial();
        player1.reiniciar(win);
        player1.position.setY(635);
        cambia = false;
        if(level>1){
            player1.cargavidas();
        }
    }
    public void llega(){
        player1.llego=0;
        Sounds.close(backsound);
        detiene=true;
        sube = true;

    }
    public void gana() throws LineUnavailableException {
        Sounds.close(backsound);
        State.changeState(new GameOver(tipo, "Yow winner", player1.getScore(), string, personaje1, personaje2, background,"w"));
    }
    @Override
    public void sounds() {
        super.sounds();
    }

    @Override
    public void update() throws LineUnavailableException {
        end=new Date();
        System.out.println((int)((end.getTime()-start.getTime())/1000));
        if((int)((end.getTime()-start.getTime())/1000)==15){
            start=new Date();
            acelerador();
        }
        if(!cascaron &&(player1.getLives()==6 || player1.getLives()==2)){
            caparazon();
            cascaron=true;
        }
        else if(cascaron && player1.getLives()!=6 && player1.getLives()!=2){
            cascaron=false;
        }
        if(KeyBoard.pause && !pausa) {
            pausa = true;
            player1.iniciapausa();
        }
        else if(KeyBoard.pause && pausa) {
            pausa = false;
            player1.terminapausa();
            //player1.timer.start();
        }
        if(pausa==false) {
            verifica();
            if (cambia) {
                cambia();
            }
            if (player1.llego == 2) {
                llega();
            }
            if (sube && level == 6) {
                gana();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        if ((!sube) || (sube && level <= 5)) {
            super.draw(g);
            for (int i = 0; i < win.size(); i++) {
                win.get(i).draw(g);
            }
            for (int i = 0; i < lives.size(); i++) {
                lives.get(i).draw(g);
            }
            player1.draw(g);

        }

    }
    public void acelerador(){
        super.acelerador();
    }
    public void caparazon(){
        super.caparazon();
    }
    public ArrayList<Message> getMessages() {
        return messages;
    }
}
