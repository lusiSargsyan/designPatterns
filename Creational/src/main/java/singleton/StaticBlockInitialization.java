package singleton;

/*
Static block initialization Singleton is similar with Eager Initialization ,
except that instance of class is created in static block so we can add
exception handling there
 */
public class StaticBlockInitialization {

    private static final StaticBlockInitialization STATIC_BLOCK_INITIALIZATION;

    static {
        try {
            STATIC_BLOCK_INITIALIZATION = new StaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException("Exception on creating singleton object");
        }
    }

    public StaticBlockInitialization getInstance() {
        return STATIC_BLOCK_INITIALIZATION;
    }
}
