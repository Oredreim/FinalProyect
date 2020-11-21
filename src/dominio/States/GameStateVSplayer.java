package dominio.States;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dominio.Obstaculos.Cars.*;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Trunks.TrunkA;
import dominio.Obstaculos.Trunks.TrunkB;
import dominio.Obstaculos.Trunks.TrunkC;
import dominio.Obstaculos.Turtles.*;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
import dominio.Players.Humans.Player;
import dominio.Players.Humans.Player2;
import dominio.Vector2D;
import presentacion.*;
import presentacion.Button;

public class GameStateVSplayer extends States {

    private Player player1;
    private Player2 player2;
    protected ArrayList<Lives> livesp1 = new ArrayList<>();
    protected ArrayList<Lives> livesp2 = new ArrayList<>();
    protected ArrayList<Ganar> winp1 = new ArrayList<>();
    protected ArrayList<Ganar> winp2 = new ArrayList<>();

    public GameStateVSplayer(int tipo,ArrayList<BufferedImage> personaje1, ArrayList<BufferedImage> personaje2, BufferedImage background, String string) {
        this.tipo=tipo;
        this.background=background;
        this.personaje1=personaje1;
        this.personaje2=personaje2;
        charcos();
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
        ganar();
        lives();
        player1 = new Player(new Vector2D(300, 635), personaje1.get(0), personaje1,livesp1);
        player2 = new Player2(new Vector2D(600, 635), personaje2.get(0), personaje2,livesp2);
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
        Ganar ganar1p1 = new Ganar(new Vector2D(55,100),Assets.blanco);
        winp1.add(ganar1p1);
        Ganar ganar2p1 = new Ganar(new Vector2D(190,100),Assets.blanco);
        winp1.add(ganar2p1);
        Ganar ganar3p1 = new Ganar(new Vector2D(325,100),Assets.blanco);
        winp1.add(ganar3p1);
        Ganar ganar4p1 = new Ganar(new Vector2D(465,100),Assets.blanco);
        winp1.add(ganar4p1);
        Ganar ganar5p1 = new Ganar(new Vector2D(600,100),Assets.blanco);
        winp1.add(ganar5p1);
        Ganar ganar6p1 = new Ganar(new Vector2D(745,100),Assets.blanco);
        winp1.add(ganar6p1);
        Ganar ganar7p1 = new Ganar(new Vector2D(875,100),Assets.blanco);
        winp1.add(ganar7p1);


        Ganar ganar1p2 = new Ganar(new Vector2D(71,100),Assets.blanco);
        winp2.add(ganar1p2);
        Ganar ganar2p2 = new Ganar(new Vector2D(206,100),Assets.blanco);
        winp2.add(ganar2p2);
        Ganar ganar3p2 = new Ganar(new Vector2D(341,100),Assets.blanco);
        winp2.add(ganar3p2);
        Ganar ganar4p2 = new Ganar(new Vector2D(481,100),Assets.blanco);
        winp2.add(ganar4p2);
        Ganar ganar5p2 = new Ganar(new Vector2D(616,100),Assets.blanco);
        winp2.add(ganar5p2);
        Ganar ganar6p2 = new Ganar(new Vector2D(761,100),Assets.blanco);
        winp2.add(ganar6p2);
        Ganar ganar7p2 = new Ganar(new Vector2D(891,100),Assets.blanco);
        winp2.add(ganar7p2);
    }
    public void lives(){
        Lives live1p1 = new Lives(new Vector2D(0,680),personaje1.get(14));
        livesp1.add(live1p1);
        Lives live2p1 = new Lives(new Vector2D(15,680),personaje1.get(14));
        livesp1.add(live2p1);
        Lives live3p1 = new Lives(new Vector2D(30,680),personaje1.get(14));
        livesp1.add(live3p1);
        Lives live4p1 = new Lives(new Vector2D(45,680),personaje1.get(14));
        livesp1.add(live4p1);
        Lives live5p1 = new Lives(new Vector2D(60,680),personaje1.get(14));
        livesp1.add(live5p1);
        Lives live6p1 = new Lives(new Vector2D(75,680),personaje1.get(14));
        livesp1.add(live6p1);
        Lives live7p1 = new Lives(new Vector2D(90,680),personaje1.get(14));
        livesp1.add(live7p1);
        Lives live8p1 = new Lives(new Vector2D(105,680),personaje1.get(14));
        livesp1.add(live8p1);
        Lives live9p1 = new Lives(new Vector2D(120,680),personaje1.get(14));
        livesp1.add(live9p1);
        Lives live10p1 = new Lives(new Vector2D(135,680),personaje1.get(14));
        livesp1.add(live10p1);

        Lives live1p2 = new Lives(new Vector2D(760,680),personaje2.get(14));
        livesp2.add(live1p2);
        Lives live2p2 = new Lives(new Vector2D(775,680),personaje2.get(14));
        livesp2.add(live2p2);
        Lives live3p2 = new Lives(new Vector2D(790,680),personaje2.get(14));
        livesp2.add(live3p2);
        Lives live4p2 = new Lives(new Vector2D(805,680),personaje2.get(14));
        livesp2.add(live4p2);
        Lives live5p2 = new Lives(new Vector2D(820,680),personaje2.get(14));
        livesp2.add(live5p2);
        Lives live6p2 = new Lives(new Vector2D(835,680),personaje2.get(14));
        livesp2.add(live6p2);
        Lives live7p2 = new Lives(new Vector2D(850,680),personaje2.get(14));
        livesp2.add(live7p2);
        Lives live8p2 = new Lives(new Vector2D(865,680),personaje2.get(14));
        livesp2.add(live8p2);
        Lives live9p2 = new Lives(new Vector2D(880,680),personaje2.get(14));
        livesp2.add(live9p2);
        Lives live10p2 = new Lives(new Vector2D(895,680),personaje2.get(14));
        livesp2.add(live10p2);
    }
    @Override
    public void update() {

        if(KeyBoard.pause && !pausa) {
            pausa = true;
        }
        else if(KeyBoard.pause && pausa) {
            pausa = false;
        }
        if(pausa==false) {
            if (((player1.getLives() > 0 || player2.getLives() > 0) && pausa == false) && !sube) {
                super.update();
                if (player1.getLives() > 0) {
                    player1.update(winp1, cars, trunks, turtles, charcos);
                }
                if (player2.getLives() > 0) {
                    player2.update(winp2, cars, trunks, turtles, charcos);
                }
            } else if (player1.getLives() == 0 && player2.getLives() == 0) {
                if (player1.getScore() > player2.getScore()) {
                    State.changeState(new GameOver(tipo, "Game over player 1 win", player1.getScore(), string, personaje1, personaje2, background));
                } else if (player1.getScore() < player2.getScore()) {
                    State.changeState(new GameOver(tipo, "Game over player 2 win", player2.getScore(), string, personaje1, personaje2, background));
                } else {
                    State.changeState(new GameOver(tipo, "Game over draw", player1.getScore(), string, personaje1, personaje2, background));
                }
            }
            if (cambia) {
                player1.position.setY(635);
                player2.position.setY(635);
                player1.llego = 0;
                player2.llego = 0;
                cambia = false;
                if(level>1) {
                    player1.cargavidas();
                    player2.cargavidas();
                }
            }
            if (player1.llego == 7) {

                sube = true;
            }
            if (sube && level == 5) {
                if (player1.getScore() > player2.getScore()) {
                    State.changeState(new GameOver(tipo, "Player 1 game´s winner", player1.getScore(), string, personaje1, personaje2, background));
                } else if (player1.getScore() < player2.getScore()) {
                    State.changeState(new GameOver(tipo, "Player 2 game´s winner", player1.getScore(), string, personaje1, personaje2, background));
                } else {
                    State.changeState(new GameOver(tipo, "Draw", player1.getScore(), string, personaje1, personaje2, background));
                }
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (int i = 0; i < winp1.size(); i++) {
            winp1.get(i).draw(g);
        }
        for (int i = 0; i < winp2.size(); i++) {
            winp2.get(i).draw(g);
        }
        for (int i = 0; i < livesp1.size(); i++) {
            livesp1.get(i).draw(g);
        }
        for (int i = 0; i < livesp2.size(); i++) {
            livesp2.get(i).draw(g);
        }
        player1.draw(g);
        player2.draw(g);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
