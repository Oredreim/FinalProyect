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

public class TipoMaquina extends State {
    private static ArrayList<BufferedImage> verde=new ArrayList<>();
    private ArrayList<Button> buttons;
    private static ArrayList<BufferedImage> roja=new ArrayList<>();
    private String string;
    File archivo;
    FileInputStream entrada;
    protected Clip elige= AudioSystem.getClip();
    public TipoMaquina(Clip  elige, int tipo, String string,ArrayList<String>puntajes) throws LineUnavailableException {
        buttons = new ArrayList<>();
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                200,
                400 - Assets.greyBtn.getHeight(),
                "Irreflexiva",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new TipoMaquina2(elige,tipo,string,1,puntajes));

                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                200,
                500 - Assets.greyBtn.getHeight(),
                "Precavida",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new TipoMaquina2(elige,tipo,string,2,puntajes));
                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                200,
                600 - Assets.greyBtn.getHeight(),
                "Temeraria",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new TipoMaquina2(elige,tipo,string,3,puntajes));
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
        Text.drawText(g,"Seleccione el tipo de maquina de jugador 1",new Vector2D(500,100),true, Color.WHITE,Assets.fontMed);
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}
