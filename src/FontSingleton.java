import java.awt.Font;

public class FontSingleton {
    private static FontSingleton instance;
    private Font font;
    private Font smallerFont;
    private Font bolderFont;

    private FontSingleton() {
        font = new Font("Tahoma", Font.PLAIN, 20);
        smallerFont = new Font(font.getName(), font.getStyle(), 15);
        bolderFont = new Font(font.getName(), Font.BOLD, 20);
    }

    public static FontSingleton getInstance() {
        if (instance == null) {
            synchronized (FontSingleton.class) {
                if (instance == null) {
                    instance = new FontSingleton();
                }
            }
        }
        return instance;
    }

    public Font getBolderFont() {
        return bolderFont;
    }

    public Font getFont() {
        return font;
    }

    public Font getSmallerFont() {
        return smallerFont;
    }

}
