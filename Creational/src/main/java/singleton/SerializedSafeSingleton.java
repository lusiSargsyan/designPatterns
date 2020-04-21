package singleton;

import java.io.Serializable;

public class SerializedSafeSingleton implements Serializable {
    /*
     * is used during deserialization to verify that the sender and receiver
     * of a serialized object  have loaded classes for that object that are
     * compatible with respect to serialization.*/
    static final long serialVersionUID = 91L;

    private SerializedSafeSingleton() {
        if (SerializedSafeSingleton.SingletonHelper.INSTANCE != null) { //to prevent reflection
            throw new IllegalStateException("Can't instantiate singleton twice");
        }
    }

    private static class SingletonHelper {
        private final static SerializedSafeSingleton INSTANCE = new SerializedSafeSingleton();
    }

    public static SerializedSafeSingleton getInstance() {
        return SerializedSafeSingleton.SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
