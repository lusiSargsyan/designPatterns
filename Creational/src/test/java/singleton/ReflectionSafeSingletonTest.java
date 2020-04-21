package singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSafeSingletonTest {

    @Test(expected = InvocationTargetException.class)
    public void test() throws ReflectiveOperationException {
        Constructor<?>[] constructors = ReflectionSafeSingletonTest.class.getDeclaredConstructors();
        Constructor theConstructor = constructors[0];
        theConstructor.setAccessible(true);
        theConstructor.newInstance();
    }
}
