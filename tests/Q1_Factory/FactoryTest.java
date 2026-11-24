package Q1_Factory;

import Q1_Factory.Models.IComputer;
import Q1_Factory.Models.Mac;
import Q1_Factory.Models.Windows;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static testsupport.Checks.consoleLines;
import static testsupport.Checks.studentClass;

class FactoryTest {
    @Test
    void factoriesUseOneInterfaceToMakeBothKindsOfComputer() throws ReflectiveOperationException {
        Class<?> contract = studentClass("Q1_Factory.Factories.IComputerFactory");
        assertTrue(contract.isInterface(), "IComputerFactory should be an interface");
        Method make = contract.getMethod("makeComputer", String.class);
        assertEquals(IComputer.class, make.getReturnType());
        assertTrue(Modifier.isAbstract(make.getModifiers()), "Declare makeComputer as an abstract operation");

        checkFactory(make, "WindowsFactory", Windows.class, "W-42");
        checkFactory(make, "MacFactory", Mac.class, "M-18");
    }

    @Test
    void driverFillsBothOrders() {
        List<String> computers = consoleLines(() -> FactoryDriver.main(new String[0])).stream()
                .filter(line -> line.contains("computer created with model number: "))
                .toList();

        assertEquals(List.of(
                "Windows computer created with model number: TG01-0023w",
                "Windows computer created with model number: ProBook x360 435 G8",
                "Windows computer created with model number: Some kind of Dell",
                "Mac computer created with model number: iMac21.1",
                "Mac computer created with model number: A1706",
                "Mac computer created with model number: A3112"), computers);
    }

    private void checkFactory(Method make, String name, Class<? extends IComputer> product, String model)
            throws ReflectiveOperationException {
        Class<?> factoryType = studentClass("Q1_Factory.Factories." + name);
        assertTrue(make.getDeclaringClass().isAssignableFrom(factoryType),
                name + " should implement IComputerFactory");
        Object factory = factoryType.getConstructor().newInstance();

        List<String> output = consoleLines(() ->
                assertInstanceOf(product, assertDoesNotThrow(() -> make.invoke(factory, model))));
        assertEquals(List.of(product.getSimpleName() + " computer created with model number: " + model), output);
    }
}
