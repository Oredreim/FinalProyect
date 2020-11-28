package dominio.States;

import dominio.Obstaculos.Cars.*;
import dominio.Obstaculos.Charco.Charco;
import dominio.Obstaculos.Trunks.Trunk;
import dominio.Obstaculos.Trunks.TrunkA;
import dominio.Obstaculos.Trunks.TrunkB;
import dominio.Obstaculos.Trunks.TrunkC;
import dominio.Obstaculos.Turtles.*;
import dominio.Sorpresas.Acelerar;
import dominio.Sorpresas.Sorpresas;
import dominio.Vector2D;
import presentacion.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public abstract class States extends State {
    protected ArrayList<Message> messages = new ArrayList<Message>();
    protected ArrayList<Car> cars = new ArrayList<>();
    protected ArrayList<Trunk> trunks = new ArrayList<>();
    protected ArrayList<Turtle> turtles = new ArrayList<>();

    protected ArrayList<Charco> charcos = new ArrayList<>();
    protected ArrayList<Sorpresas> sorpresas = new ArrayList<>();
    protected ArrayList<BufferedImage> personaje1,personaje2;
    protected BufferedImage background;
    protected String string;
    protected boolean pausa=false;
    protected boolean sube=true;
    protected int level;
    protected int tipo;
    protected boolean primera = true;
    protected boolean detiene = false;
    protected boolean cambia=false;
    protected Clip backsound = AudioSystem.getClip();
    protected InputStream back;
    protected Date start=new Date();
    protected Date end=new Date();

    public States() throws LineUnavailableException {};


    public void carsA(){
        CarA cara1 = new CarA(new Vector2D(0, 590), Assets.cara);
        cars.add(cara1);
        CarA cara2 = new CarA(new Vector2D(216, 590), Assets.cara);
        cars.add(cara2);
        CarA cara3 = new CarA(new Vector2D(618, 590), Assets.cara);
        cars.add(cara3);
        CarA cara4 = new CarA(new Vector2D(431, 590), Assets.cara);
        cars.add(cara4);
        CarA cara5 = new CarA(new Vector2D(370, 590), Assets.cara);
        cars.add(cara5);
    }
    public void carsB(){
        CarB carb1 = new CarB(new Vector2D(70, 545), Assets.carb);
        cars.add(carb1);
        CarB carb2 = new CarB(new Vector2D(GUI.width-Assets.carb.getWidth(), 545), Assets.carb);
        cars.add(carb2);
        CarB carb3 = new CarB(new Vector2D(200, 545), Assets.carb);
        cars.add(carb3);
        CarB carb4 = new CarB(new Vector2D(450, 545), Assets.carb);
        cars.add(carb4);
        CarB carb5 = new CarB(new Vector2D(630, 545), Assets.carb);
        cars.add(carb5);
    }
    public void carsC(){
        CarC carc1 = new CarC(new Vector2D(GUI.width-Assets.carc.getWidth(), 500), Assets.carc);
        cars.add(carc1);
        CarC carc2 = new CarC(new Vector2D(232, 500), Assets.carc);
        cars.add(carc2);
        CarC carc3 = new CarC(new Vector2D(450, 500), Assets.carc);
        cars.add(carc3);
        CarC carc4 = new CarC(new Vector2D(77, 500), Assets.carc);
        cars.add(carc4);
        CarC carc5 = new CarC(new Vector2D(682, 500), Assets.carc);
        cars.add(carc5);
    }
    public void carsD() {
        CarD card1 = new CarD(new Vector2D(75, 455), Assets.card);
        cars.add(card1);
        CarD card2 = new CarD(new Vector2D(160, 455), Assets.card);
        cars.add(card2);
        CarD card3 = new CarD(new Vector2D(341, 455), Assets.card);
        cars.add(card3);
        CarD card4 = new CarD(new Vector2D(715, 455), Assets.card);
        cars.add(card4);
        CarD card5 = new CarD(new Vector2D(800, 455), Assets.card);
        cars.add(card5);
        CarD card6 = new CarD(new Vector2D(444, 455), Assets.card);
        cars.add(card6);
    }
    public void carsE(){
        CarE care1 = new CarE(new Vector2D(0, 410), Assets.care);
        cars.add(care1);
        CarE care2 = new CarE(new Vector2D(115, 410), Assets.care);
        cars.add(care2);
        CarE care3 = new CarE(new Vector2D(210, 410), Assets.care);
        cars.add(care3);
        CarE care4 = new CarE(new Vector2D(335, 410), Assets.care);
        cars.add(care4);
        CarE care5 = new CarE(new Vector2D(560, 410), Assets.care);
        cars.add(care5);
        CarE care6 = new CarE(new Vector2D(705, 410), Assets.care);
        cars.add(care6);
        CarE care7 = new CarE(new Vector2D(850, 410), Assets.care);
        cars.add(care7);
    }
    public void trunksA(){
        TrunkA trunka1 = new TrunkA(new Vector2D(0,275),Assets.trunka);
        trunks.add(trunka1);
        TrunkA trunka2 = new TrunkA(new Vector2D(220,275),Assets.trunka);
        trunks.add(trunka2);
        TrunkA trunka3 = new TrunkA(new Vector2D(440,275),Assets.trunka);
        trunks.add(trunka3);
        TrunkA trunka4 = new TrunkA(new Vector2D(660,275),Assets.trunka);
        trunks.add(trunka4);
        TrunkA trunka5 = new TrunkA(new Vector2D(880,275),Assets.trunka);
        trunks.add(trunka5);
    }
    public void trunksB(){
        TrunkB trunkb1 = new TrunkB(new Vector2D(0,230),Assets.trunkb);
        trunks.add(trunkb1);
        TrunkB trunkb2 = new TrunkB(new Vector2D(400,230),Assets.trunkb);
        trunks.add(trunkb2);
        TrunkB trunkb3 = new TrunkB(new Vector2D(800,230),Assets.trunkb);
        trunks.add(trunkb3);
    }
    public void trunksC(){
        TrunkC trunkc1 = new TrunkC(new Vector2D(0,140),Assets.trunkc);
        trunks.add(trunkc1);
        TrunkC trunkc2 = new TrunkC(new Vector2D(270,140),Assets.trunkc);
        trunks.add(trunkc2);
        TrunkC trunkc3 = new TrunkC(new Vector2D(540,140),Assets.trunkc);
        trunks.add(trunkc3);
        TrunkC trunkc4 = new TrunkC(new Vector2D(810,140),Assets.trunkc);
        trunks.add(trunkc4);
    }
    public void turtlesA(){
        TurtleA turtlea1 = new TurtleA(new Vector2D(0,320),Assets.turtlea);
        turtles.add(turtlea1);
        TurtleA turtlea2 = new TurtleA(new Vector2D(300,320),Assets.turtlea);
        turtles.add(turtlea2);
        TurtleA turtlea3 = new TurtleA(new Vector2D(600,320),Assets.turtlea);
        turtles.add(turtlea3);
    }
    public void turtlesB(){
        TurtleB turtleb1 = new TurtleB(new Vector2D(150,320),Assets.turtlea);
        turtles.add(turtleb1);
        TurtleB turtleb2 = new TurtleB(new Vector2D(450,320),Assets.turtlea);
        turtles.add(turtleb2);
        TurtleB turtleb3 = new TurtleB(new Vector2D(750,320),Assets.turtlea);
        turtles.add(turtleb3);
        TurtleB turtleb4 = new TurtleB(new Vector2D(900,320),Assets.turtlea);
        turtles.add(turtleb4);
    }
    public void turtlesC(){
        TurtleC turtlec3 = new TurtleC(new Vector2D(520,185),Assets.turtleg);
        turtles.add(turtlec3);
    }
    public void turtlesD(){
        TurtleD turtled1 = new TurtleD(new Vector2D(180,185),Assets.turtleg);
        turtles.add(turtled1);
        TurtleD turtled2 = new TurtleD(new Vector2D(360,185),Assets.turtleg);
        turtles.add(turtled2);
        TurtleD turtled3 = new TurtleD(new Vector2D(700,185),Assets.turtleg);
        turtles.add(turtled3);
        TurtleD turtled4 = new TurtleD(new Vector2D(880,185),Assets.turtleg);
        turtles.add(turtled4);
    }
    public void charcos(){
        double x = (int) (Math.random() * (421 - 0)) + 0;
        double y = (int) (Math.random() * (591 - 410)) + 410;
        Charco charco1 = new Charco(new Vector2D(x,y),Assets.charco);
        charcos.add(charco1);
        x = (int) (Math.random() * (901 - 420)) + 420;
        y = (int) (Math.random() * (591 - 410)) + 410;
        Charco charco2 = new Charco(new Vector2D(x,y),Assets.charco);
        charcos.add(charco2);
    }
    public void levelup(){
        TrunkA.speed+=0.3;
        TrunkB.speed+=0.3;
        TrunkC.speed+=0.3;
        Car.speed+=0.3;
        Turtle.speed+=0.3;
    }
    public void sounds(){
        if(level==1){
            back=Sounds.backsound1;
        }
        else if(level==2){
            back=Sounds.backsound2;
        }
        else if(level==3){
            back=Sounds.backsound3;
        }
        else if(level==4){
            back=Sounds.backsound4;
        }
        else if(level==5){
            back=Sounds.backsound5;
        }
        Sounds.reproduce(backsound,back,true);
    }
    public void dicenivel(){
        if (level==1){
            back=Sounds.roundone;
        }
        if(level==2){
            back=Sounds.roundtwo;
        }
        else if(level==3){
            back=Sounds.roundthree;
        }
        else if(level==4){
            back=Sounds.roundfour;
        }
        else if(level==5){
            back=Sounds.roundfive;

        }
        Sounds.reproduce(backsound,back,false);

    }
    public void acelerador(){
        double x = (int) (Math.random() * (901 - 0)) + 0;
        double y = (int) (Math.random() * (591 - 410)) + 410;
        Acelerar acelerardor = new Acelerar(new Vector2D(x,y),Assets.acelera);
        sorpresas.add(acelerardor);
    }
    public void update() throws LineUnavailableException {

        if(KeyBoard.exit){
            State.changeState(new MenuState(string));
            Sounds.close(backsound);
        }

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) instanceof CarB) {
                cars.get(i).update(-1);
            } else {
                cars.get(i).update(1);
            }
        }
        for (int i = 0; i < trunks.size(); i++) {
            trunks.get(i).update();
        }
        for (int i = 0; i < turtles.size(); i++) {
            turtles.get(i).update();
        }

    }
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        for (int i = 0; i < sorpresas.size(); i++) {
            sorpresas.get(i).draw(g);
        }
        for (int i = 0; i < charcos.size(); i++) {
            charcos.get(i).draw(g);
        }
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).draw(g);
        }
        for (int i = 0; i < trunks.size(); i++) {
            trunks.get(i).draw(g);
        }
        for (int i = 0; i < turtles.size(); i++) {
            turtles.get(i).draw(g);
        }
        if(sube ) {
            if (backsound.getMicrosecondLength() == 0 ||detiene) {
                detiene=false;
                level++;
                dicenivel();
            }

            Text.drawText(g, "LEVEL UP", new Vector2D(450, 300), true, Color.RED, Assets.fontBig);
            Text.drawText(g, "ROUND " + Integer.toString(level), new Vector2D(450, 550), true, Color.RED, Assets.fontBig);
            /*System.out.print(backsound.getMicrosecondLength() == backsound.getMicrosecondPosition());
            System.out.println("\n");*/
            if (backsound.getMicrosecondLength() == backsound.getMicrosecondPosition()) {

                Sounds.close(backsound);
                levelup();
                sounds();
                sube = false;
                cambia = true;
                primera=false;
            }
        }
    }
}
