package presentacion;

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

    }
}
