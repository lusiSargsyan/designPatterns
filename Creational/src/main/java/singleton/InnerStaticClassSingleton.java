package singleton;

/*
This is one of best solutions to create thread safe Singleton without performance drawbacks .
 */
public class InnerStaticClassSingleton {

    private static InnerStaticClassSingleton instance;

    private InnerStaticClassSingleton() {
    }

    /*
    Unlike static final object instance this class will be loaded only
    when getInstance method is first time called .
     */
    private static class SingletonHelper {
        private static final InnerStaticClassSingleton INSTANCE = new InnerStaticClassSingleton();
    }

    /*
      And since it is guaranteed by the JLS
     class initialization phase is thread safe , non-concurrent, and that is why no
     further synchronization is required in getInstance
     */
    public static InnerStaticClassSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
