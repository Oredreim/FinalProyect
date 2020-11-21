package dominio.States;

import dominio.Vector2D;
import presentacion.*;
import presentacion.Button;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class GameOver extends State {
    private ArrayList<Button> buttons;
    private String string;
    private String text;
    private int score;
    public GameOver(int tipo, String text, int score, String string, ArrayList<BufferedImage>personaje1, ArrayList<BufferedImage>personaje2, BufferedImage background){
        this.text=text;
        this.score=score;
        this.string = string;
        buttons = new ArrayList<>();
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                370,
                400 - Assets.greyBtn.getHeight(),
                "Menu principal",
                new Action() {
                    @Override
                    public void doAction() {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new MenuState(string));
                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                370,
                500 - Assets.greyBtn.getHeight(),
                "Reintentar",
                new Action() {
                    @Override
                    public void doAction() {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        if(tipo==1){
                            State.changeState(new GameState(tipo,personaje1,background,string));
                        }
                        else if(tipo==2){
                            State.changeState(new GameStateVSplayer(tipo,personaje1,personaje2,background,string));
                        }
                    }
                }

        ));
    }

    @Override
    public void update() {
        for(Button b: buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        Text.drawText(g,text,new Vector2D(500,100),true, Color.WHITE,Assets.fontEnd);
        Text.drawText(g,Integer.toString(score),new Vector2D(500,300),true, Color.WHITE,Assets.fontEnd);
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}