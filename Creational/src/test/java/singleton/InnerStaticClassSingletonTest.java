package singleton;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class InnerStaticClassSingletonTest {

    /*
    testing not reflection safe singleton
    */
    @Test
    public void test() throws ReflectiveOperationException {
        Constructor<?>[] constructors = InnerStaticClassSingleton.class.getDeclaredConstructors();
        Constructor theConstructor = constructors[0];
        theConstructor.setAccessible(true);
        InnerStaticClassSingleton instance = (InnerStaticClassSingleton) theConstructor.newInstance();
        InnerStaticClassSingleton instance1 = (InnerStaticClassSingleton) theConstructor.newInstance();
        Assert.assertNotEquals(instance, instance1);
    }
}
