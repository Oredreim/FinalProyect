package dominio.Players.Machines;

public class Precavida {
    public static int generaMovimiento(){
        int num = (int) (Math.random() * (5 - 0)) + 0;
        return num;
    }
}
