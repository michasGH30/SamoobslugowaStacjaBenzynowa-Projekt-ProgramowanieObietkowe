import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CustomLabel extends JLabel {
    public CustomLabel(String text, Font font) {
        super(text);
        setFont(font);
    }

    public CustomLabel(String text) {
        super(text);
        setFont(FontSingleton.getInstance().getFont());
    }

    public CustomLabel() {
        super();
    }

    public CustomLabel(String text, Color color) {
        super(text);
        setFont(FontSingleton.getInstance().getFont());
        setForeground(color);
    }

    CustomLabel(Color color) {
        super();
        setFont(FontSingleton.getInstance().getFont());
        setForeground(color);
    }
}
