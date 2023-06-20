import java.awt.Color;

public class ColorSingleton {

    private static ColorSingleton instance;
    private Color red;

    private ColorSingleton() {
        red = new Color(255, 0, 0);
    }

    public static ColorSingleton getInstance() {
        if (instance == null) {
            synchronized (FontSingleton.class) {
                if (instance == null) {
                    instance = new ColorSingleton();
                }
            }
        }
        return instance;
    }

    public Color getRed() {
        return red;
    }

}