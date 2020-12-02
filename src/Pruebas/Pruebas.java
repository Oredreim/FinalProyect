package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import dominio.Abrir;
import dominio.Vector2D;
import dominio.Players.Generales.Lives;
import dominio.Players.Humans.Player;
import dominio.States.GameState;
import dominio.States.Seleccion;
import presentacion.Assets;
import presentacion.GUI;
import presentacion.MenuState;
import presentacion.Sounds;
import presentacion.State;

class Pruebas {

    @Test
    public void deberiacrearJuego() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        assertEquals(new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes), gameState);
    }

    @Test
    public void deberiacrearMenuJuego() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        State.changeState(new MenuState(" "));
        assertTrue(true);
    }


    @Test
    public void deberiacrearjugador() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        ArrayList<BufferedImage> personaje = Seleccion.getRoja();
        ArrayList<Lives> lives = new ArrayList<>();
        Player player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje,lives,tipo);
    }

    @Test
    public void deberiacMoverJugadorALaIzquierda() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        ArrayList<BufferedImage> personaje = Seleccion.getRoja();
        ArrayList<Lives> lives = new ArrayList<>();
        Player player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje,lives,tipo);
        Clip jump = AudioSystem.getClip();
        
        player1.left(jump, Sounds.jumpp1);
    }

    @Test
    public void deberiacMoverJugadorALaDerecha() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        ArrayList<BufferedImage> personaje = Seleccion.getRoja();
        ArrayList<Lives> lives = new ArrayList<>();
        Player player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje,lives,tipo);
        Clip jump = AudioSystem.getClip();
        player1.right(jump, Sounds.jumpp1);
    }

    @Test
    public void deberiacMoverJugadorAbajo() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        ArrayList<BufferedImage> personaje = Seleccion.getRoja();
        ArrayList<Lives> lives = new ArrayList<>();
        Player player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje,lives,tipo);
        Clip jump = AudioSystem.getClip();
        player1.down(jump, Sounds.jumpp1);
    }


    @Test
    public void deberiacMoverJugadorArriba() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        ArrayList<BufferedImage> personaje = Seleccion.getRoja();
        ArrayList<Lives> lives = new ArrayList<>();
        Player player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje,lives,tipo);
        Clip jump = AudioSystem.getClip();
        player1.up(jump, Sounds.jumpp1);
    }

    @Test
    public void deberiacActivarPoder() throws LineUnavailableException {
        GUI gui = new GUI();
        gui.init();
        int tipo = 1;
        ArrayList<String> puntajes= Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\HIScores.txt");
        GameState gameState = new GameState(1,Seleccion.getRoja(),Assets.backgroundnoche, " ", puntajes);
        ArrayList<BufferedImage> personaje = Seleccion.getRoja();
        ArrayList<Lives> lives = new ArrayList<>();
        Player player1 = new Player(new Vector2D(300, 635), personaje.get(0),personaje,lives,tipo);
        Clip jump = AudioSystem.getClip();
        player1.activaPower();

    }
}
