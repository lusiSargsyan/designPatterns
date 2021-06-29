package singleton;

/*
Lazy initialization method to implement Singleton pattern creates the instance
in the global access method.
  */
public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {
    }

    /*
     works fine in case of the single-threaded environment
     */
    private static LazyInitialization getInstance() {
        if (instance == null)
            instance = new LazyInitialization();
        return instance;
    }
}
