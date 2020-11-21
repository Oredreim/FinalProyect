package presentacion;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import dominio.States.Seleccion;

public class MenuState extends State{

    private ArrayList<Button> buttons;
    private String string;
    File archivo;
    FileInputStream entrada;

    public MenuState(String string) {


        this.string = string;
        buttons = new ArrayList<Button>();

        /**
         * botones de tipo de juego
         */
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                125 - Assets.greyBtn.getHeight(),
                "1 player",
                new Action() {
                    @Override
                    public void doAction() {
                        //GameState.getPlayer().setName(nombre1);
                        //GameState.getPlayer2().setName(nombre2);
                        State.changeState(new Seleccion(1,string));
                    }
                }

        ));
        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                180 - Assets.greyBtn.getHeight(),
                "Vs. Player",
                new Action() {
                    @Override
                    public void doAction() {
                    	//GameState.getPlayer().setName(nombre1);
                    	//GameState.getPlayer2().setName(nombre2);
                        State.changeState(new Seleccion(2,string));
                    }
                }
                
        ));

        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                235 - Assets.greyBtn.getHeight(),
                "Vs. Machine",

                new Action() {
                    @Override
                    public void doAction() {
                        State.changeState(new Seleccion(2,string));
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                290 - Assets.greyBtn.getHeight(),
                "Spectate",
                new Action() {
                    @Override
                    public void doAction() {
                        State.changeState(new Seleccion(2,string));
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400,
                345 - Assets.greyBtn.getHeight(),
                "Prubea Piñeros",
                new Action() {
                    @Override
                    public void doAction() {
                        State.changeState(new Seleccion(2,string));
                    }
                }
        ));

        /**
         * Boton salida de juego
         */


        buttons.add(new Button(
                Assets.greyBtn,
                Assets.blueBtn,
                400 ,
                600 + Assets.greyBtn.getHeight()/2 ,
                "EXIT",
                new Action() {
                    @Override
                    public void doAction() {
                        System.exit(0);
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
    public void update() {
        for(Button b: buttons) {
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for(Button b: buttons) {
            b.draw(g);
        }
    }
}