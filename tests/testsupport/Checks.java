package testsupport;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public final class Checks {
    private Checks() {
    }

    // Load classes students create so the starter tests can run before those classes exist.
    public static Class<?> studentClass(String className) {
        return assertDoesNotThrow(() -> Class.forName(className), "Create " + className);
    }

    public static List<String> consoleLines(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (PrintStream capture = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            action.run();
        } finally {
            System.setOut(original);
        }
        return output.toString(StandardCharsets.UTF_8).lines().toList();
    }
}
