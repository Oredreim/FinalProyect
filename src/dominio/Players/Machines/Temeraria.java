package dominio.Players.Machines;

public class Temeraria {
    public static int generaMovimiento(){
        int num = (int) (Math.random() * (4 - 0)) + 0;
        return num;
    }
}
