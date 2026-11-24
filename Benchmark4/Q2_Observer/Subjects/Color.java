package Q2_Observer.Subjects;

import Q2_Observer.Observers.AbsObserver;
import Q2_Observer.Utils.Colors;

import java.util.List;

public class Color {
    private List<AbsObserver> observers;
    private Colors color;

    public Color(Colors initialColor) {
        // TODO: Start with the supplied color and no subscriptions.
    }

    public void addObserver(AbsObserver observer) {
        // TODO: Register this display after any existing subscriptions.
    }

    public void removeObserver(AbsObserver observer) {
        // TODO: End this display's subscription if it is registered.
    }

    public void changeColor(Colors newColor) {
        // TODO: Change the subject's color and publish the update.
    }

    public void notifyAllObservers() {
        // TODO: Share the current color with the subscribed displays.
    }
}
