package singleton;

import javax.management.RuntimeErrorException;

/*
It is easy to break singleton using reflection by getting constructor
and setting accessible field as true.
Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
Constructor theConstructor = constructors[0];
theConstructor.setAccessible(true);
Here is an example how to avoid this .
*/
public class ReflectionSafeSingleton {

    private ReflectionSafeSingleton() {
        if(SingletonHelper.INSTANCE != null ){ //for reflection
            throw new IllegalStateException("Can't instantiate singleton twice");
        }
    }

    private static class SingletonHelper {
        private static final ReflectionSafeSingleton INSTANCE = new ReflectionSafeSingleton();
    }
    public static ReflectionSafeSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
