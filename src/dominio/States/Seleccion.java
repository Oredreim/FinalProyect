package dominio.States;

import dominio.Vector2D;
import presentacion.Button;
import presentacion.*;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Seleccion extends  State{
    private static ArrayList<BufferedImage> verde=new ArrayList<>();
    private ArrayList<Button> buttons;
    private static ArrayList<BufferedImage> roja=new ArrayList<>();
    private String string;
    File archivo;

    public Seleccion(Clip elige,int tipo, String string, int tipomachine1, int tipomachine2,ArrayList<String>puntajes) throws LineUnavailableException {

        //Texturas verde
        verde.add(Assets.player1up3);
        verde.add(Assets.player1up2);
        verde.add(Assets.player1up1);
        verde.add(Assets.player1down3);
        verde.add(Assets.player1down2);
        verde.add(Assets.player1down1);
        verde.add(Assets.player1left3);
        verde.add(Assets.player1left2);
        verde.add(Assets.player1left1);
        verde.add(Assets.player1right3);
        verde.add(Assets.player1right2);
        verde.add(Assets.player1right1);
        verde.add(Assets.winplayer1);
        verde.add(Assets.winallplayer1);
        verde.add(Assets.livesplayer1);

        //Texturas roja
        roja.add(Assets.player2up3);
        roja.add(Assets.player2up2);
        roja.add(Assets.player2up1);
        roja.add(Assets.player2down3);
        roja.add(Assets.player2down2);
        roja.add(Assets.player2down1);
        roja.add(Assets.player2left3);
        roja.add(Assets.player2left2);
        roja.add(Assets.player2left1);
        roja.add(Assets.player2right3);
        roja.add(Assets.player2right2);
        roja.add(Assets.player2right1);
        roja.add(Assets.winplayer2);
        roja.add(Assets.winallplayer2);
        roja.add(Assets.livesplayer2);

        this.string = string;
        buttons = new ArrayList<>();
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                250,
                300 - Assets.greyBtn.getHeight(),
                "Verde",
                new Action() {
                    @Override
                    public void doAction() {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new mapa(tipo, verde, roja,string,elige,tipomachine1,tipomachine2,puntajes));

                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                500,
                300 - Assets.greyBtn.getHeight(),
                "Roja",
                new Action() {
                    @Override
                    public void doAction() {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new mapa(tipo, roja, verde,string,elige,tipomachine1,tipomachine2,puntajes));
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
        Text.drawText(g,"Jugador 1 seleccione su personaje",new Vector2D(500,100),true, Color.WHITE,Assets.fontMed);
        g.drawImage(Assets.player1up3,350,200,null);
        g.drawImage(Assets.player2up3,600,200,null);
        for(Button b: buttons) {
            b.draw(g);
        }
    }
    public static ArrayList<BufferedImage> getVerde(){
        return verde;
    }
    public static ArrayList<BufferedImage> getRoja(){
        return roja;
    }
}
