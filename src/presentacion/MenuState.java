package presentacion;

import dominio.Abrir;
import dominio.States.Seleccion;
import dominio.States.TipoMaquina;
import dominio.States.TipoMaquina2;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class MenuState extends State{

    private ArrayList<Button> buttons;
    private String string;
    private Clip elige= AudioSystem.getClip();
    File archivo;
    FileInputStream entrada;
    protected Clip moneda= AudioSystem.getClip();;
    public MenuState(String string) throws LineUnavailableException {
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        Sounds.init();
        Sounds.reproduce(moneda,Sounds.inicia,false);

        this.string = string;
        buttons = new ArrayList<Button>();

        /**
         * botones de tipo de juego
         */
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                125 - Assets.greyBtn.getHeight(),
                "1 player",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        Sounds.close(moneda);
                        FileInputStream entrada;

                        Sounds.reproduce(elige,Sounds.selec,true);
                        State.changeState(new Seleccion(elige,1,string,0,0,puntajes));

                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                180 - Assets.greyBtn.getHeight(),
                "Vs. Player",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                    	//GameState.getPlayer().setName(nombre1);
                    	//GameState.getPlayer2().setName(nombre2);
                        Sounds.close(moneda);
                        Sounds.reproduce(elige,Sounds.selec,true);
                        State.changeState(new Seleccion(elige,2,string,0,0,puntajes));
                    }
                }
                
        ));

        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                235 - Assets.greyBtn.getHeight(),
                "Vs. Machine",

                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        Sounds.close(moneda);
                        Sounds.reproduce(elige,Sounds.selec,true);
                        State.changeState(new TipoMaquina2(elige,3,string,0,puntajes));
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                290 - Assets.greyBtn.getHeight(),
                "Spectate",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        Sounds.close(moneda);
                        Sounds.reproduce(elige,Sounds.selec,true);
                        State.changeState(new TipoMaquina(elige,4,string,puntajes));
                    }
                }
        ));

        /**
         * Boton salida de juego
         */


        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400 ,
                600 + Assets.greyBtn.getHeight()/2 ,
                "EXIT",
                new Action() {
                    @Override
                    public void doAction() {
                        System.exit(0);

                    }
                }
        ));

    }

    @Override
    public void update() throws LineUnavailableException {
        for(Button b: buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}