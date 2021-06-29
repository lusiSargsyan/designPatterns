package singleton;

/*
Thread safe singleton is used in multithreaded applications
to avoid situations when several threads can create an instance of class and break a pattern.
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    /*
       The easiest way to create a thread-safe singleton is
       to make a getInstance method synchronized. This works fine from the
       thread-safe side but has performance issues because all threads will wait
       until one thread will leave the monitor regardless the fact is instance null or no .
       To avoid this kind of issues we need to use ImprovedThreadSafeSingleton solution
     */
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
