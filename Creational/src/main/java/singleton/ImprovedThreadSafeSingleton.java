package singleton;

/*
This provides Thread safe Singleton with performance improvement .
In most of cases when instance is not null we will not have locked Threads
 */
public class ImprovedThreadSafeSingleton {
    private static ImprovedThreadSafeSingleton instance;

    private ImprovedThreadSafeSingleton() {
    }

    public static ImprovedThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ImprovedThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
