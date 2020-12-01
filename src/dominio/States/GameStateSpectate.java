package dominio.States;

import dominio.Abrir;
import dominio.FroggerException;
import dominio.Guardar;
import dominio.Obstaculos.Cars.Car;
import dominio.Obstaculos.Trunks.TrunkA;
import dominio.Obstaculos.Trunks.TrunkB;
import dominio.Obstaculos.Trunks.TrunkC;
import dominio.Obstaculos.Turtles.Turtle;
import dominio.Players.Generales.Ganar;
import dominio.Players.Generales.Lives;
import dominio.Players.Humans.machine1;
import dominio.Players.Humans.machine2;
import dominio.Sorpresas.Acelerar;
import dominio.Sorpresas.Caparazon;
import dominio.Vector2D;
import presentacion.*;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class GameStateSpectate extends States {
    private machine1 player1;
    private machine2 player2;
    protected ArrayList<Lives> livesp1 = new ArrayList<>();
    protected ArrayList<Lives> livesp2 = new ArrayList<>();
    protected ArrayList<Ganar> winp1 = new ArrayList<>();
    protected ArrayList<Ganar> winp2 = new ArrayList<>();
    private ArrayList<String> puntajes;
    public GameStateSpectate(int tipo, ArrayList<BufferedImage> personaje1, ArrayList<BufferedImage> personaje2, BufferedImage background, String string, int tipomachine1, int tipomachine2,ArrayList<String>puntajes) throws LineUnavailableException {
        this.puntajes=puntajes;
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
        player1 = new machine1(new Vector2D(300, 635), personaje1.get(0), personaje1,livesp1,tipo,tipomachine1);
        player2 = new machine2(new Vector2D(600, 635), personaje2.get(0), personaje2,livesp2,tipo,tipomachine2);
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
    public void carsD() { super.carsD(); }
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
        Ganar ganar1p1 = new Ganar(new Vector2D(55,100), Assets.blanco);
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
    public void verifica() throws LineUnavailableException, FroggerException {
        if (((player1.getLives() > 0 || player2.getLives() > 0) && pausa == false) && !sube) {
            super.update();
            if (player1.getLives() > 0) {
                player1.update(winp1, cars, trunks, turtles, charcos,sorpresas);
            }
            if (player2.getLives() > 0) {
                player2.update(winp2, cars, trunks, turtles, charcos,sorpresas);
            }
        } else if (player1.getLives() == 0 && player2.getLives() == 0) {
            Sounds.close(backsound);
            if (player1.getScore() > player2.getScore()) {
                State.changeState(new GameOver(tipo, "Game over player 1 win", player1.getScore(), string, personaje1, personaje2, background,"l",player1.getTipomachine(),player2.getTipomachine(),puntajes));
            } else if (player1.getScore() < player2.getScore()) {
                State.changeState(new GameOver(tipo, "Game over machine win", player2.getScore(), string, personaje1, personaje2, background,"l",player1.getTipomachine(),player2.getTipomachine(),puntajes));
            } else {
                State.changeState(new GameOver(tipo, "Game over draw", player1.getScore(), string, personaje1, personaje2, background,"l",player1.getTipomachine(),player2.getTipomachine(),puntajes));
            }
        }
    }
    public void cambia(){
        player1.caambiaincial();
        player2.caambiaincial();
        player1.position.setY(635);
        player2.position.setY(635);
        player1.reiniciar(winp1);
        player2.reiniciar(winp2);
        cambia = false;
        if(level>1) {
            player1.cargavidas();
            player2.cargavidas();
        }
    }
    public void llega(){
        player1.llego=0;
        player2.llego=0;
        Sounds.close(backsound);
        detiene=true;
        sube = true;
    }
    public void gana() throws LineUnavailableException {
        Sounds.close(backsound);
        if (player1.getScore() > player2.getScore()) {

            State.changeState(new GameOver(tipo, "Player 1 game´s winner", player1.getScore(), string, personaje1, personaje2, background,"w",player1.getTipomachine(),player2.getTipomachine(),puntajes));
        } else if (player1.getScore() < player2.getScore()) {
            State.changeState(new GameOver(tipo, "Machine´s winner", player1.getScore(), string, personaje1, personaje2, background,"w",player1.getTipomachine(),player2.getTipomachine(),puntajes));
        } else {
            State.changeState(new GameOver(tipo, "Draw", player1.getScore(), string, personaje1, personaje2, background,"w",player1.getTipomachine(),player2.getTipomachine(),puntajes));
        }
    }
    public void guarda(){
        ArrayList<String> datos=new ArrayList<>();
        datos.add(Double.toString(player1.position.getX())+"\n");
        datos.add(Double.toString(player1.position.getY())+"\n");
        datos.add(player1.poderes+"\n");
        datos.add(Integer.toString(player1.getLives())+"\n");
        datos.add(Integer.toString(player1.llego)+"\n");
        datos.add(player1.start+"\n");
        datos.add(player1.end+"\n");
        datos.add(Integer.toString(player1.tiempopausa)+"\n");
        datos.add(Integer.toString(player1.getScore())+"\n");
        if(player1.personaje.get(0)==Assets.player1up3){
            datos.add("1"+"\n");
        }
        else if(player1.personaje.get(0)==Assets.player2up3){
            datos.add("2"+"\n");
        }
        String sx="";
        for(int i=0;i<winp1.size()-1;i++){
            if(winp1.get(i).getTexture()==Assets.blanco){
                sx+="0"+" ";
            }
            else {
                sx+="1"+" ";
            }
        }
        if(winp1.get(winp1.size()-1).getTexture()==Assets.blanco){
            sx+="0";
        }
        else {
            sx+="1";
        }
        datos.add(sx+"\n");
        datos.add(Integer.toString(player1.getTipomachine()));


        datos.add(Double.toString(player2.position.getX())+"\n");
        datos.add(Double.toString(player2.position.getY())+"\n");
        datos.add(player2.poderes+"\n");
        datos.add(Integer.toString(player2.getLives())+"\n");
        datos.add(Integer.toString(player2.llego)+"\n");
        datos.add(player2.start+"\n");
        datos.add(player2.end+"\n");
        datos.add(Integer.toString(player2.tiempopausa)+"\n");
        datos.add(Integer.toString(player2.getScore())+"\n");
        if(player2.personaje.get(0)==Assets.player1up3){
            datos.add("1"+"\n");
        }
        else if(player2.personaje.get(0)==Assets.player2up3){
            datos.add("2"+"\n");
        }
        sx="";
        for(int i=0;i<winp2.size()-1;i++){
            if(winp2.get(i).getTexture()==Assets.blanco){
                sx+="0"+" ";
            }
            else {
                sx+="1"+" ";
            }
        }
        if(winp2.get(winp2.size()-1).getTexture()==Assets.blanco){
            sx+="0";
        }
        else {
            sx+="1";
        }
        datos.add(sx+"\n");
        datos.add(Integer.toString(player1.getTipomachine()));

        datos=super.guarda(datos);

        Guardar.guarda(datos,"C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\spectate.txt");
    }
    public void carga(){
        Datos= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\spectate.txt");

        player1.position.setX(Double.valueOf(Datos.get(0)));
        player1.position.setY(Double.valueOf(Datos.get(1)));
        player1.poderes=Datos.get(2);
        if(player1.poderes!=""){
            String[]powers=player1.poderes.split(" ");
            if(powers[0].equals("A")){
                player1.sorpresas.add(new Acelerar(new Vector2D(0,0),Assets.acelera));
            }
            else {
                player1.sorpresas.add(new Caparazon(new Vector2D(0,0),Assets.caparazon));
            }
            if(powers.length==2){
                if(powers[1].equals("A")){
                    player1.sorpresas.add(new Acelerar(new Vector2D(0,0),Assets.acelera));
                }
                else {
                    player1.sorpresas.add(new Caparazon(new Vector2D(0,0),Assets.caparazon));
                }
            }
        }
        player1.llego=Integer.valueOf(Datos.get(4));
        //player1.start= parse(Datos.get(5));
        //player1.end=new Date(Datos.get(6));
        //player1.tiempopausa=Integer.valueOf(Datos.get(7));
        player1.setScore(Integer.valueOf(Datos.get(8)));
        if(Datos.get(9).equals("1")){
            player1.personaje=Seleccion.getVerde();
        }
        else {
            player1.personaje=Seleccion.getRoja();
        }
        player1.setTexture();
        player1.setlives(Integer.valueOf(Datos.get(3)));
        cargo=true;
        String[]llegado=Datos.get(10).split(" ");
        for(int i=0;i<llegado.length;i++){
            if(llegado[i].equals("1")){
                winp1.get(i).setTexture(player1.personaje.get(12));
            }
        }
        player1.setTipomachine(Integer.valueOf(Datos.get(11)));


        player2.position.setX(Double.valueOf(Datos.get(12)));
        player2.position.setY(Double.valueOf(Datos.get(13)));
        player2.poderes=Datos.get(14);
        if(player2.poderes!=""){
            String[]powers=player2.poderes.split(" ");
            if(powers[0].equals("A")){
                player2.sorpresas.add(new Acelerar(new Vector2D(0,0),Assets.acelera));
            }
            else {
                player2.sorpresas.add(new Caparazon(new Vector2D(0,0),Assets.caparazon));
            }
            if(powers.length==2){
                if(powers[1].equals("A")){
                    player2.sorpresas.add(new Acelerar(new Vector2D(0,0),Assets.acelera));
                }
                else {
                    player2.sorpresas.add(new Caparazon(new Vector2D(0,0),Assets.caparazon));
                }
            }
        }
        player2.llego=Integer.valueOf(Datos.get(16));
        //player1.start= parse(Datos.get(17));
        //player1.end=new Date(Datos.get(18));
        //player1.tiempopausa=Integer.valueOf(Datos.get(19));
        player2.setScore(Integer.valueOf(Datos.get(20)));
        if(Datos.get(21).equals("1")){
            player2.personaje=Seleccion.getVerde();
        }
        else {
            player2.personaje=Seleccion.getRoja();
        }
        player2.setTexture();
        player2.setlives(Integer.valueOf(Datos.get(15)));
        cargo=true;
        String[]llegado2=Datos.get(22).split(" ");
        for(int i=0;i<llegado2.length;i++){
            if(llegado2[i].equals("1")){
                winp1.get(i).setTexture(player2.personaje.get(12));
            }
        }
        player2.setTipomachine(Integer.valueOf(Datos.get(23)));
        super.carga(Datos,24);
    }

    @Override
    public void sounds() {
        super.sounds();
    }

    @Override
    public void update() throws LineUnavailableException,FroggerException {
        if(!States.salir) {
            if (KeyBoard.load && !cargo) {
                carga();
            }
            if (KeyBoard.exit) {
                guarda();
            }
            end = new Date();

            if (!cascaron && (player1.getLives() == 6 || player1.getLives() == 2)) {
                caparazon();
                cascaron = true;
            } else if (cascaron && player1.getLives() != 6 && player1.getLives() != 2) {
                cascaron = false;
            }
            if (!cascaron2 && (player2.getLives() == 6 || player2.getLives() == 2)) {
                caparazon();
                cascaron2 = true;
            } else if (cascaron2 && player2.getLives() != 6 && player2.getLives() != 2) {
                cascaron2 = false;
            }
            if (KeyBoard.pause && !pausa) {
                pausa = true;
                player1.iniciapausa();
                player2.iniciapausa();
                pausestart = new Date();
            } else if (KeyBoard.pause && pausa) {
                pausa = false;
                player1.terminapausa();
                player2.terminapausa();
                pauseend = new Date();
                tiempopausa = (int) ((pauseend.getTime() - pausestart.getTime()) / 1000);
            }
            if (!pausa && (int) ((end.getTime() - start.getTime()) / 1000) + tiempopausa == 15) {
                start = new Date();
                acelerador();
            }
            if (pausa == false) {
                verifica();
                if (cambia) {
                    cambia();
                }
                if (player1.llego == 2 || player2.llego == 2) {
                    llega();
                }
                if (sube && level == 6) {
                    gana();
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
        Text.drawText(g, "HI-SCORE", new Vector2D(450, 40), true, Color.RED, Assets.fontMed);
        Text.drawText(g, puntajes.get(3), new Vector2D(450, 60), true, Color.RED, Assets.fontMed);
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