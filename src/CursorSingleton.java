import java.awt.Cursor;

public class CursorSingleton {
    private static CursorSingleton instance;
    private Cursor handCursor;

    private CursorSingleton() {
        handCursor = new Cursor(Cursor.HAND_CURSOR);
    }

    public static CursorSingleton getInstance() {
        if (instance == null) {
            synchronized (CursorSingleton.class) {
                if (instance == null) {
                    instance = new CursorSingleton();
                }
            }
        }
        return instance;
    }

    public Cursor getHandCursor() {
        return handCursor;
    }
}
