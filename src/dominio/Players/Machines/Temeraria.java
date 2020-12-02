package dominio.Players.Machines;

public class Temeraria {

    /**
     * retorna el movimiento random de la maquina
     * @return entero que movera la maquina.
     */
    public static int generaMovimiento(){
        int num = (int) (Math.random() * (4 - 0)) + 0;
        return num;
    }
}
