package Q2_Observer;

import Q2_Observer.Observers.AbsObserver;
import Q2_Observer.Subjects.Color;
import Q2_Observer.Utils.Colors;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static testsupport.Checks.consoleLines;
import static testsupport.Checks.studentClass;

class ObserverTest {
    @Test
    void displaysReceiveTheCurrentColorWhileSubscribed() throws ReflectiveOperationException {
        assertTrue(Modifier.isAbstract(AbsObserver.class.getModifiers()), "Make AbsObserver abstract");
        Method update = AbsObserver.class.getMethod("update", Colors.class);
        assertEquals(void.class, update.getReturnType());
        assertTrue(Modifier.isAbstract(update.getModifiers()), "Declare a shared abstract update callback");

        Color subject = new Color(Colors.BLUE);
        AbsObserver hex = newDisplay("HexObserver", subject);
        AbsObserver rgb = newDisplay("RGBObserver", subject);

        assertEquals(List.of("Hex String: #0000FF", "RGB String: 0, 0, 255"),
                consoleLines(subject::notifyAllObservers));

        subject.removeObserver(hex);
        assertEquals(List.of("RGB String: 128, 0, 128"), consoleLines(() -> subject.changeColor(Colors.PURPLE)));

        subject.removeObserver(rgb);
        assertEquals(List.of(), consoleLines(() -> subject.changeColor(Colors.YELLOW)));

        subject.addObserver(hex);
        assertEquals(List.of("Hex String: #FFFF00"), consoleLines(subject::notifyAllObservers));
    }

    @Test
    void driverShowsTheThreeSubscriptionStates() {
        assertEquals(List.of(
                "Hex String: #00FF00",
                "RGB String: 0, 255, 0",
                "RGB String: 255, 0, 0",
                "Hex String: #00FFFF"), consoleLines(() -> ObserverDriver.main(new String[0])));
    }

    private AbsObserver newDisplay(String name, Color subject) throws ReflectiveOperationException {
        Class<?> display = studentClass("Q2_Observer.Observers." + name);
        assertTrue(AbsObserver.class.isAssignableFrom(display), name + " should extend AbsObserver");
        return display.asSubclass(AbsObserver.class).getConstructor(Color.class).newInstance(subject);
    }
}
