package dominio.States;

import dominio.Vector2D;
import presentacion.Button;
import presentacion.*;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class mapa extends State{
    private ArrayList<Button> buttons;
    private String string;
    File archivo;
    FileInputStream entrada;
    public mapa(int tipo, ArrayList<BufferedImage> personaje1, ArrayList<BufferedImage> personaje2, String string, Clip elige,int tipomachine1, int tipomachine2,ArrayList<String>puntajes){
        this.string = string;
        buttons = new ArrayList<>();
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                250,
                250 - Assets.greyBtn.getHeight(),
                "día",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        Sounds.close(elige);
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        if (tipo==1){
                            State.changeState(new GameState(tipo,personaje1,Assets.backgrounddia,string,puntajes));
                        }
                        else if (tipo==2){
                            State.changeState(new GameStateVSplayer(tipo,personaje1,personaje2,Assets.backgrounddia,string,puntajes));
                        }
                        else if(tipo==3){
                            State.changeState(new GameStateVSmachine(tipo,personaje1,personaje2,Assets.backgrounddia,string,tipomachine2,puntajes));
                        }
                        else if(tipo==4){
                            State.changeState(new GameStateSpectate(tipo,personaje1,personaje2,Assets.backgrounddia,string,tipomachine1,tipomachine2,puntajes));
                        }

                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                500,
                250 - Assets.greyBtn.getHeight(),
                "noche",
                new Action() {
                    @Override
                    public void doAction() throws LineUnavailableException {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        Sounds.close(elige);
                        if (tipo==1){
                            State.changeState(new GameState(tipo,personaje1,Assets.backgroundnoche,string,puntajes));
                        }
                        else if (tipo==2){
                            State.changeState(new GameStateVSplayer(tipo,personaje1,personaje2,Assets.backgroundnoche,string,puntajes));
                        }
                        else if(tipo==3){
                            State.changeState(new GameStateVSmachine(tipo,personaje1,personaje2,Assets.backgroundnoche,string,tipomachine2,puntajes));
                        }
                        else if(tipo==4){
                            State.changeState(new GameStateSpectate(tipo,personaje1,personaje2,Assets.backgroundnoche,string,tipomachine1,tipomachine2,puntajes));
                        }
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
        Text.drawText(g,"Jugador 1 seleccione el mapa",new Vector2D(500,100),true, Color.WHITE,Assets.fontMed);
        g.drawImage(Assets.dia,250,300,null);
        g.drawImage(Assets.noche,500,300,null);
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}
