package presentacion;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class Sounds {
    public static InputStream inicia;
    public static InputStream selec;
    public static InputStream roundone;
    public static InputStream roundtwo;
    public static InputStream roundthree;
    public static InputStream roundfour;
    public static InputStream roundfive;
    public static InputStream lose;
    public static InputStream win;
    public static InputStream backsound1;
    public static InputStream backsound2;
    public static InputStream backsound3;
    public static InputStream backsound4;
    public static InputStream backsound5;
    public static InputStream jumpp1;
    public static InputStream jumpp2;
    public static InputStream pierdep1;
    public static InputStream pierdep2;
    public static InputStream teletransportap1;
    public static InputStream teletransportap2;
    public static InputStream llegap1;
    public static InputStream llegap2;
    public static void init() {


        inicia = Assets.class.getResourceAsStream("/res/start.wav");
        selec = Assets.class.getResourceAsStream("/res/selec.wav");
        roundone = Assets.class.getResourceAsStream("/res/roundone.wav");
        roundtwo = Assets.class.getResourceAsStream("/res/roundtwo.wav");
        roundthree = Assets.class.getResourceAsStream("/res/roundthree.wav");
        roundfour = Assets.class.getResourceAsStream("/res/roundfour.wav");
        roundfive = Assets.class.getResourceAsStream("/res/roundfive.wav");
        lose = Assets.class.getResourceAsStream("/res/gameover.wav");
        win = Assets.class.getResourceAsStream("/res/win.wav");
        backsound1 = Assets.class.getResourceAsStream("/res/backsound1.wav");
        backsound2 = Assets.class.getResourceAsStream("/res/backsound2.wav");
        backsound3 = Assets.class.getResourceAsStream("/res/backsound3.wav");
        backsound4 = Assets.class.getResourceAsStream("/res/backsound4.wav");
        backsound5 = Assets.class.getResourceAsStream("/res/backsound5.wav");
        jumpp1 = Assets.class.getResourceAsStream("/res/jump.wav");
        jumpp2 = Assets.class.getResourceAsStream("/res/jump1.wav");
        pierdep1= Assets.class.getResourceAsStream("/res/pierdevida.wav");
        pierdep2= Assets.class.getResourceAsStream("/res/pierdevida1.wav");
        teletransportap1=Assets.class.getResourceAsStream("/res/teletransporta.wav");
        teletransportap2=Assets.class.getResourceAsStream("/res/teletransporta1.wav");
        llegap1= Assets.class.getResourceAsStream("/res/llega.wav");
        llegap2= Assets.class.getResourceAsStream("/res/llega1.wav");
    }
    public static void recarga(InputStream back){
        if(back.equals(inicia)){
            inicia = Assets.class.getResourceAsStream("/res/start.wav");
        }
        if(back.equals(selec)){
            selec = Assets.class.getResourceAsStream("/res/selec.wav");
        }
        if(back.equals(roundone)){
            roundone = Assets.class.getResourceAsStream("/res/roundone.wav");
        }
        if(back.equals(roundtwo)){
            roundtwo = Assets.class.getResourceAsStream("/res/roundtwo.wav");
        }
        if(back.equals(roundthree)){
            roundthree = Assets.class.getResourceAsStream("/res/roundthree.wav");
        }
        if(back.equals(roundfour)){
            roundfour = Assets.class.getResourceAsStream("/res/roundfour.wav");
        }
        if(back.equals(roundfive)){
            roundfive = Assets.class.getResourceAsStream("/res/roundfive.wav");
        }
        if(back.equals(lose)){
            lose = Assets.class.getResourceAsStream("/res/gameover.wav");
        }
        if(back.equals(win)){
            win = Assets.class.getResourceAsStream("/res/win.wav");
        }
        if(back.equals(backsound1)){
            backsound1 = Assets.class.getResourceAsStream("/res/backsound1.wav");
        }
        if(back.equals(backsound2)){
            backsound2 = Assets.class.getResourceAsStream("/res/backsound2.wav");
        }
        if(back.equals(backsound3)){
            backsound3 = Assets.class.getResourceAsStream("/res/backsound3.wav");
        }
        if(back.equals(backsound4)){
            backsound4 = Assets.class.getResourceAsStream("/res/backsound4.wav");
        }
        if(back.equals(backsound5)){
            backsound5 = Assets.class.getResourceAsStream("/res/backsound5.wav");
        }
        if(back.equals(jumpp1)){
            jumpp1=Assets.class.getResourceAsStream("/res/jump.wav");
        }
        else if(back.equals(jumpp2)){
            jumpp2=Assets.class.getResourceAsStream("/res/jump.wav");
        }
        if(back.equals(pierdep1)){
            pierdep1= Assets.class.getResourceAsStream("/res/pierdevida.wav");
        }
        if(back.equals(pierdep2)){
            pierdep2= Assets.class.getResourceAsStream("/res/pierdevida1.wav");
        }
        if(back.equals(teletransportap1)){
            teletransportap1=Assets.class.getResourceAsStream("/res/teletransporta.wav");
        }
        if(back.equals(teletransportap2)){
            teletransportap2=Assets.class.getResourceAsStream("/res/teletransporta.wav");
        }
        if(back.equals(llegap1)){
            llegap1= Assets.class.getResourceAsStream("/res/llega.wav");
        }
        if(back.equals(llegap2)){
            llegap2= Assets.class.getResourceAsStream("/res/llega1.wav");
        }
    }

    public static void reproduce(Clip backsound, InputStream back,boolean loop){
        try {
            backsound.open(AudioSystem.getAudioInputStream(back));
            backsound.start();
            if(loop){
                backsound.loop(Clip.LOOP_CONTINUOUSLY);
            }
            recarga(back);

        } catch (Exception fallo) {
            System.out.println(fallo);
        }
    }
    /*public static void reinicia(Clip backsound){
        backsound.stop();
        backsound.setMicrosecondPosition(0);

    }*/
    public static void close(Clip backsound){
        backsound.close();
    }
}
