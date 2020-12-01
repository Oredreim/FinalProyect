package dominio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Guardar {
    public static void guarda(ArrayList<String> datos, String archivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < datos.size(); i++)
                pw.write(datos.get(i));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
