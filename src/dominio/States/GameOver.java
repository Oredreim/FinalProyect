package dominio.States;

import dominio.Vector2D;
import presentacion.Button;
import presentacion.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;

public class GameOver extends State {
    private ArrayList<Button> buttons;
    private String string;
    private String text;
    private int score;
    protected Clip backsound = AudioSystem.getClip();
    private InputStream back;
    public GameOver(int tipo, String text, int score, String string, ArrayList<BufferedImage>personaje1, ArrayList<BufferedImage>personaje2, BufferedImage background,String res) throws LineUnavailableException {
        if(res=="w"){
            back=Sounds.win;
        }
        else {
            back=Sounds.lose;
        }
        Sounds.reproduce(backsound,back,false);
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
                    public void doAction() throws LineUnavailableException {
                        Sounds.close(backsound);
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
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        Sounds.close(backsound);
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
    public void update() throws LineUnavailableException {
        if(backsound.getMicrosecondLength()==backsound.getMicrosecondPosition()){
            Sounds.close(backsound);
        }
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
