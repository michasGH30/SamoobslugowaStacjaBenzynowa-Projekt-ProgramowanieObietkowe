import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);
        setMargin(new Insets(10, 20, 10, 20));
        setCursor(CursorSingleton.getInstance().getHandCursor());
        setFont(FontSingleton.getInstance().getSmallerFont());
    }

    public CustomButton(String text, Font font) {
        super(text);
        setMargin(new Insets(10, 20, 10, 20));
        setCursor(CursorSingleton.getInstance().getHandCursor());
        setFont(font);
    }
}
