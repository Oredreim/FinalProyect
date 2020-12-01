package presentacion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

    public boolean[] keys = new boolean[256];
    public static boolean up, down, left, right, up2, down2, left2, right2, pause, back,exit,powerp1,powerp2,load;

    public KeyBoard(){
        load=false;
        powerp1=false;
        powerp2=false;
        pause=false;
        exit = false;
        up = false;
        down = false;
        left = false;
        right = false;
        up2 = false;
        down2 = false;
        left2 = false;
        right2 = false;
    }

    public void update(){
        load=keys[KeyEvent.VK_X];
        powerp1=keys[KeyEvent.VK_F];
        powerp2=keys[KeyEvent.VK_M];
        pause=keys[KeyEvent.VK_P];
        exit = keys[KeyEvent.VK_Q];
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        up2 = keys[KeyEvent.VK_UP];
        down2 = keys[KeyEvent.VK_DOWN];
        left2 = keys[KeyEvent.VK_LEFT];
        right2 = keys[KeyEvent.VK_RIGHT];
        pause = keys[KeyEvent.VK_P];
        back = keys[KeyEvent.VK_ENTER];
    }
    public static void setKeys(){
        exit=false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}