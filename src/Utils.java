public final class Utils {
    private Utils() {
        ;
    }

    public static boolean rand() {
        return Math.random() >= 0.5f;
    }

    public static float roundToTwoDigits(float number) {
        return (float) (Math.round(number * 100.0) / 100.0);
    }
}
