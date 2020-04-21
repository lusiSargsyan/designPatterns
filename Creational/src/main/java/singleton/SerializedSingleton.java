package singleton;

import java.io.Serializable;

/*
Sometimes we need to serialize Singleton.
The problem in this case is that when we deserialize serialized singleton
it creates new instance.See SerializedSingletonTest
 */
public class SerializedSingleton implements Serializable {

    /*
    * is used during deserialization to verify that the sender and receiver
    * of a serialized object  have loaded classes for that object that are
    * compatible with respect to serialization.*/
    static final long serialVersionUID = 91L;

    private SerializedSingleton() {
        if (SerializedSingleton.SingletonHelper.INSTANCE != null) { //to prevent reflection
            throw new IllegalStateException("Can't instantiate singleton twice");
        }
    }

    private static class SingletonHelper {
        private final static SerializedSingleton INSTANCE = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

}
