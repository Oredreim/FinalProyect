package dominio.States;

import dominio.Vector2D;
import presentacion.*;
import presentacion.Button;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class TipoMaquina2 extends State {
    private static ArrayList<BufferedImage> verde=new ArrayList<>();
    private ArrayList<Button> buttons;
    private static ArrayList<BufferedImage> roja=new ArrayList<>();
    private String string;
    File archivo;
    FileInputStream entrada;
    protected Clip elige= AudioSystem.getClip();
    public TipoMaquina2(Clip  elige, int tipo, String string,int tipomachine1,ArrayList<String>puntajes) throws LineUnavailableException {
        buttons = new ArrayList<>();
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                600,
                400 - Assets.greyBtn.getHeight(),
                "Irreflexiva",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new Seleccion(elige,tipo,string,tipomachine1,1,puntajes));

                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                600,
                500 - Assets.greyBtn.getHeight(),
                "Precavida",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new Seleccion(elige,tipo,string,tipomachine1,2,puntajes));
                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                600,
                600 - Assets.greyBtn.getHeight(),
                "Temeraria",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new Seleccion(elige,tipo,string,tipomachine1,3,puntajes));
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
        Text.drawText(g,"Seleccione el tipo de maquina que enfrentara",new Vector2D(500,100),true, Color.WHITE,Assets.fontMed);
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}
