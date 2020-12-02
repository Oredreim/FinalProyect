package presentacion;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Loader {


    /**
     * carga las imagenes(recursos) para mostrar en la interfaz.
     * @param path, recibe la ruta en la que esta la imagen.
     * @return retorna la imagen cargada.
     */
    public static BufferedImage imageLoader(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * carga las fuentes de texto para mostrarlas en la interfaz.
     * @param path, recibe la ruta en la que esta la imagen.
     * @param size, el tamaño que se desea la fuente.
     * @return retorna la fuente cargada.
     */

    public static Font loadFont(String path, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * carga los sonidos para reproducirlos en la interfaz.
     * @param path, recibe la ruta en la que esta la imagen.
     * @return retorna la musica cargada.
     */
    public static Clip loadSound(String path) {
        try {
            Clip clip = AudioSystem.getClip();
            InputStream ayuda = Loader.class.getResourceAsStream(path);
            AudioInputStream ayuda2 = AudioSystem.getAudioInputStream(ayuda);
            clip.open(ayuda2);
            return clip;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return null;
    }
}
