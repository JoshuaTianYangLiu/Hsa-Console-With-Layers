// The "LayerConsole" class.
import java.awt.Color;
import java.awt.image.BufferedImage;

public class LayerConsoleUtil {
    BufferedImage b;
    Color c = new Color(0, 0, 0, 0);
    LayerConsoleUtil() {
        b = new BufferedImage(640, 500, BufferedImage.TYPE_INT_ARGB);
        c = new Color(0, 0, 0);
    }
    LayerConsoleUtil(int length, int width) {
        b = new BufferedImage(length, width, BufferedImage.TYPE_INT_ARGB);
        c = new Color(0, 0, 0);
    }
    BufferedImage getImage() {
        return b;
    }
    Graphics2D getGraphics() {
        return b.createGraphics();
    }
    void setImage(BufferedImage b) {
        this.b = b;
    }
    Color getColor() {
        return c;
    }
    void setColor(Color c) {
        this.c = c;
    }
} // LayerConsole class
