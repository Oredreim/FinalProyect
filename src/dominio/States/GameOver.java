package dominio.States;

import dominio.Guardar;
import dominio.Vector2D;
import presentacion.Button;
import presentacion.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameOver extends State {
    private ArrayList<Button> buttons;
    private String string;
    private String text;
    private int score;
    private boolean superado=false;
    protected Clip backsound = AudioSystem.getClip();

    /**
     * Constructor del estado actual que se mostrara.
     * @return del estado a mostrar.
     */
    public GameOver(int tipo, String text, int score, String string, ArrayList<BufferedImage>personaje1, ArrayList<BufferedImage>personaje2, BufferedImage background,String res,int tipomachine1,int tipomachine2,ArrayList<String>puntajes) throws LineUnavailableException {
        if(score>Integer.valueOf(puntajes.get(tipo-1))){
            superado=true;
            puntajes.set(0,Integer.toString(score));
            Guardar.guarda(puntajes,"C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        }
        if(res=="w"){
            Sounds.reproduce(backsound,Sounds.win,false);
        }
        else {
            Sounds.reproduce(backsound,Sounds.lose,false);
        }
        Sounds.init();
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
                        Sounds.close(backsound);
                        if(tipo==1){
                            State.changeState(new GameState(tipo,personaje1,background,string,puntajes));
                        }
                        else if(tipo==2){
                            State.changeState(new GameStateVSplayer(tipo,personaje1,personaje2,background,string,puntajes));
                        }
                        else if(tipo==3){
                            State.changeState(new GameStateVSmachine(tipo,personaje1,personaje2,background,string,tipomachine2,puntajes));
                        }
                        else if(tipo==4){
                            State.changeState(new GameStateSpectate(tipo,personaje1,personaje2,background,string,tipomachine1,tipomachine2,puntajes));
                        }
                    }
                }

        ));
    }
    /**
     * actualiza el estado.
     */
    @Override
    public void update() throws LineUnavailableException {
        if(backsound.getMicrosecondLength()==backsound.getMicrosecondPosition()){
            Sounds.close(backsound);
        }
        for(Button b: buttons) {
            b.update();
        }
    }

    /**
     * dibuja el estado.
     * @param g, grafico del estado.
     */
    @Override
    public void draw(Graphics g) {
        Text.drawText(g,text,new Vector2D(500,100),true, Color.WHITE,Assets.fontEnd);
        Text.drawText(g,Integer.toString(score),new Vector2D(500,300),true, Color.WHITE,Assets.fontEnd);
        if(superado){
            Text.drawText(g,Integer.toString(score),new Vector2D(500,500),true, Color.RED,Assets.fontEnd);
        }
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}
