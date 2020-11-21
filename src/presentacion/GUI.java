package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class GUI extends JFrame implements Runnable {

    public static final int width = 960, height = 750;
    private Canvas canvas; 
    private Thread thread;
    private boolean running = false;
    private Assets assets;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS = 60;
    private double TARGETTIME = 1000000000/FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;
    //private Player player;
    //private Player player2;

    private KeyBoard keyBoard;
    private MouseInput mouseInput;

    public GUI() {
        setTitle("Frogger-GAME");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        //this.addKeyListener(new KeyBoard(player,player2));
        keyBoard = new KeyBoard();
        mouseInput = new MouseInput();
        
        //Configuracion del canvas
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
    }

    //Metodo main
    public static void main(String[] args) {
        new GUI().start();
    }

    private void update(float dt){
    	//Se actualiza el tablero que se esta utilizando
        keyBoard.update();
        //Actualizaci�n del estado actual
        State.getCurrentState().update();
    }

    //todo que dibuja el tablero mientras se va actualizando
    private void draw(){

        bs = canvas.getBufferStrategy();

        if(bs == null)
        {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics(); 

        //-----------------------

        //Propiedades del fondo del juego
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);
        State.getCurrentState().draw(g);

        //g.drawString(""+AVERAGEFPS, 10, 20);

        //---------------------
        g.dispose();
        bs.show();
    }


    //metodo que inicializa cada uno de los elementos que conforman el tablero y actualiza el estado
    private void init(){
        Assets.init();
        State.changeState(new MenuState(" "));
    }

    //Metodo sobreescrito de la clase JFrame Que controla el tiempo y cada movimiento para que tenga fluidez
    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;
        init();
        //Bucle que controla el tiempo para la actualizacion
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if(delta >= 1)
            {
                update((float) (delta * TARGETTIME * 0.000001f));
                draw();
                delta --;
                frames ++;
            }
            if(time >= 1000000000)
            {

                AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }
        stop();
    }

    private void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    //Metodo que finaliza el juego 
    private void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
