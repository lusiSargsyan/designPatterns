package singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSafeSingletonTest {

    @Test
    public void test() {
        Constructor<?>[] constructors = ReflectionSafeSingletonTest.class.getDeclaredConstructors();
        Constructor theConstructor = constructors[0];
        theConstructor.setAccessible(true);
        assertThrows(InvocationTargetException.class, theConstructor::newInstance);
    }
}
