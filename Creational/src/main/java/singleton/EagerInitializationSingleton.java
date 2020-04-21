package singleton;

/*
In eager initialization, the instance of Singleton Class is created at the time of
class loading. The main drawback of this type is that instance is created even though
client application might not be using it.
Here is the implementation of the static initialization singleton class.
 */
public class EagerInitializationSingleton {

    private static final EagerInitializationSingleton SINGLETON_INSTANCE =
            new EagerInitializationSingleton();

    //private constructor to avoid making a new instance
    private EagerInitializationSingleton() {
    }

    public static EagerInitializationSingleton getInstance() {
        return SINGLETON_INSTANCE;
    }
}
