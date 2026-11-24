package Q2_Observer.Utils;

public class ColorConvertersUtil
{
    public static String convertColorToHex(Colors color)
    {
        return switch (color) {
            case RED -> "#FF0000";
            case GREEN -> "#00FF00";
            case BLUE -> "#0000FF";
            case YELLOW -> "#FFFF00";
            case PURPLE -> "#800080";
            case CYAN -> "#00FFFF";
            default -> "#000000"; // Default to black if color is not recognized
        };
    }

    public static String convertColorToRGB(Colors color)
    {
        return switch (color) {
            case RED -> "255, 0, 0";
            case GREEN -> "0, 255, 0";
            case BLUE -> "0, 0, 255";
            case YELLOW -> "255, 255, 0";
            case PURPLE -> "128, 0, 128";
            case CYAN -> "0, 255, 255";
            default -> "0, 0, 0"; // Default to black if color is not recognized
        };
    }
}
