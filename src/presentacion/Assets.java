package presentacion;

import java.awt.*;
import java.awt.image.BufferedImage;

//Clase Assets que maneja las imagenes del directorio y pertenece al paquete de presentacion
public class Assets {

	//Definicion de cada atributo perteneciente a las imagenes

    public static BufferedImage blueBtn;
    public static BufferedImage greyBtn;
    public static BufferedImage number;
    public static BufferedImage number2;

    public static BufferedImage backgrounddia;
    public static BufferedImage backgroundnoche;
    public static BufferedImage blanco;

    public static BufferedImage player1up1;
    public static BufferedImage player1up2;
    public static BufferedImage player1up3;
    public static BufferedImage player1down1;
    public static BufferedImage player1down2;
    public static BufferedImage player1down3;
    public static BufferedImage player1left1;
    public static BufferedImage player1left2;
    public static BufferedImage player1left3;
    public static BufferedImage player1right1;
    public static BufferedImage player1right2;
    public static BufferedImage player1right3;
    public static BufferedImage winplayer1;
    public static BufferedImage winallplayer1;

    public static BufferedImage player2up1;
    public static BufferedImage player2up2;
    public static BufferedImage player2up3;
    public static BufferedImage player2down1;
    public static BufferedImage player2down2;
    public static BufferedImage player2down3;
    public static BufferedImage player2left1;
    public static BufferedImage player2left2;
    public static BufferedImage player2left3;
    public static BufferedImage player2right1;
    public static BufferedImage player2right2;
    public static BufferedImage player2right3;
    public static BufferedImage winplayer2;
    public static BufferedImage winallplayer2;
    public static BufferedImage livesplayer1;
    public static BufferedImage livesplayer2;

    public static BufferedImage charco;

    public static BufferedImage cara;
    public static BufferedImage carb;
    public static BufferedImage carc;
    public static BufferedImage card;
    public static BufferedImage care;

    public static BufferedImage trunka;
    public static BufferedImage trunkb;
    public static BufferedImage trunkc;

    public static BufferedImage turtlea;
    public static BufferedImage turtleb;
    public static BufferedImage turtlec;
    public static BufferedImage turtled;
    public static BufferedImage turtlee;
    public static BufferedImage turtlef;
    public static BufferedImage turtleg;
    public static BufferedImage turtleh;
    public static BufferedImage turtlei;
    public static BufferedImage turtlej;
    public static BufferedImage turtlek;
    public static BufferedImage turtlel;

    public static BufferedImage dia;
    public static BufferedImage noche;
    public static Font fontMed;
    public static Font fontBig;
    public static Font fontEnd;

    public static BufferedImage acelera;
    public static BufferedImage caparazon;




    //Metodo que da valor a las variables locales
    public static void init()  {

        //ManuState Images
        greyBtn = Loader.imageLoader("/res/grey_button00.png");
        blueBtn = Loader.imageLoader("/res/green_button00.png");
        number = Loader.imageLoader("/res/grey_button08.png");
        number2 = Loader.imageLoader("/res/green_button07.png");

        //GameState images
        backgroundnoche = Loader.imageLoader("/res/otrofondo.png");
        backgrounddia = Loader.imageLoader("/res/otrofondodia.png");
        player1up1 = Loader.imageLoader("/res/frog_up_0.png");
        player1up2 = Loader.imageLoader("/res/frog_up_1.png");
        player1up3 = Loader.imageLoader("/res/frog_up_2.png");
        player1down1 = Loader.imageLoader("/res/frog_down_0.png");
        player1down2 = Loader.imageLoader("/res/frog_down_1.png");
        player1down3 = Loader.imageLoader("/res/frog_down_2.png");
        player1left1 = Loader.imageLoader("/res/frog_left_0.png");
        player1left2 = Loader.imageLoader("/res/frog_left_1.png");
        player1left3 = Loader.imageLoader("/res/frog_left_2.png");
        player1right1 = Loader.imageLoader("/res/frog_right_0.png");
        player1right2 = Loader.imageLoader("/res/frog_right_1.png");
        player1right3 = Loader.imageLoader("/res/frog_right_2.png");
        player2up1 = Loader.imageLoader("/res/frog_up_01.png");
        player2up2 = Loader.imageLoader("/res/frog_up_11.png");
        player2up3 = Loader.imageLoader("/res/frog_up_21.png");
        player2down1 = Loader.imageLoader("/res/frog_down_01.png");
        player2down2 = Loader.imageLoader("/res/frog_down_11.png");
        player2down3 = Loader.imageLoader("/res/frog_down_21.png");
        player2left1 = Loader.imageLoader("/res/frog_left_01.png");
        player2left2 = Loader.imageLoader("/res/frog_left_11.png");
        player2left3 = Loader.imageLoader("/res/frog_left_21.png");
        player2right1 = Loader.imageLoader("/res/frog_right_01.png");
        player2right2 = Loader.imageLoader("/res/frog_right_11.png");
        player2right3 = Loader.imageLoader("/res/frog_right_21.png");
        winplayer1=Loader.imageLoader("/res/win_0.png");
        winallplayer1=Loader.imageLoader("/res/win_1.png");
        winplayer2=Loader.imageLoader("/res/win_01.png");
        winallplayer2=Loader.imageLoader("/res/win_11.png");
        cara = Loader.imageLoader("/res/car_a_0.png");
        carb = Loader.imageLoader("/res/car_b_0.png");
        carc = Loader.imageLoader("/res/car_c_0.png");
        card = Loader.imageLoader("/res/car_d_0.png");
        care = Loader.imageLoader("/res/car_e_0.png");
        trunka =Loader.imageLoader("/res/log_0.png");
        trunkb =Loader.imageLoader("/res/log_1.png");
        trunkc =Loader.imageLoader("/res/log_2.png");
        turtlea =Loader.imageLoader("/res/turtle_0.png");
        turtleb =Loader.imageLoader("/res/turtle_1.png");
        turtlec =Loader.imageLoader("/res/turtle_2.png");
        turtled =Loader.imageLoader("/res/turtle_3.png");
        turtlee =Loader.imageLoader("/res/turtle_4.png");
        turtlef =Loader.imageLoader("/res/turtle_5.png");
        turtleg =Loader.imageLoader("/res/turtle_01.png");
        turtleh =Loader.imageLoader("/res/turtle_11.png");
        turtlei =Loader.imageLoader("/res/turtle_21.png");
        turtlej =Loader.imageLoader("/res/turtle_31.png");
        turtlek =Loader.imageLoader("/res/turtle_41.png");
        turtlel =Loader.imageLoader("/res/turtle_51.png");
        livesplayer1=Loader.imageLoader("/res/live_0.png");
        livesplayer2=Loader.imageLoader("/res/live_1.png");
        dia=Loader.imageLoader("/res/dia.png");
        noche=Loader.imageLoader("/res/noche.png");
        charco= Loader.imageLoader("/res/charco.png");
        acelera= Loader.imageLoader("/res/acelerar.png");
        caparazon= Loader.imageLoader("/res/turtle.png");

        //sonido = Loader.loadSound("/Resources/sonido.mp3");

        //font text
        fontMed = Loader.loadFont("/res/futureFont.ttf", 20);
        fontEnd = Loader.loadFont("/res/futureFont.ttf", 50);
        fontBig = Loader.loadFont("/res/futureFont.ttf", 100);




    }
}
