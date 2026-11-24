package Q2_Observer;

import Q2_Observer.Subjects.Color;
import Q2_Observer.Utils.Colors;

public class ObserverDriver {
    public static void main(String[] args) {
        Color subject = new Color(Colors.BLUE);

        // TODO: Start the session with both displays subscribed.
        subject.changeColor(Colors.GREEN);
        // Hex String: #00FF00
        // RGB String: 0, 255, 0

        // TODO: Switch to RGB only.
        subject.changeColor(Colors.RED);
        // RGB String: 255, 0, 0

        // TODO: Switch to hex only.
        subject.changeColor(Colors.CYAN);
        // Hex String: #00FFFF
    }
}
