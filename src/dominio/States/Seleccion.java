package dominio.States;

import dominio.Vector2D;
import presentacion.Button;
import presentacion.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Seleccion extends  State{
    private ArrayList<Button> buttons;
    private ArrayList<BufferedImage> verde=new ArrayList<>();
    private ArrayList<BufferedImage> roja=new ArrayList<>();
    private String string;
    File archivo;
    FileInputStream entrada;
    private Clip elegir = AudioSystem.getClip();
    public Seleccion(int tipo, String string) throws LineUnavailableException {
        Sounds.reproduce(elegir,Sounds.selec,true);
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
                        State.changeState(new mapa(tipo, verde, roja,string,elegir));

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
                        State.changeState(new mapa(tipo, roja, verde,string,elegir));
                    }
                }

        ));
    }
    
    public String[] abrir(File archivo) {
        String[] partes = null;
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ban;
            while ((ban=entrada.read())!=-1) {
                char caracter = (char)ban;
                documento+=caracter;
            }

            partes = documento.split(" ");
            for(String s : partes) {
                System.out.println(s);
            }
        }catch(Exception e){
        }return partes;
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
}
