package presentacion;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @web https://www.jc-mouse.net
 * @author Mouse
 */
public class tiempo {

    public static Timer timer;
    public static int segundos=0;


    //Clase interna que funciona como contador
    static class Contador extends TimerTask {

        public void run() {
            segundos++;
        }
    }
    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void Contar(int segundos)
    {
        this.segundos=segundos;
        timer = new Timer();
        timer.schedule(new Contador(), segundos, 1000);
    }
    //Detiene el contador
    public void Detener() {
        timer.cancel();
    }
    //Metodo que retorna los segundos transcurridos
    public int getSegundos()
    {
        return this.segundos;
    }
    public void reinicia(){
        segundos=0;
    }
}
