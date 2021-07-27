package singleton;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializedSafeSingletonTest {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        SerializedSafeSingleton singletonInstance = SerializedSafeSingleton.getInstance();
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("file.ser"))) {
            output.writeObject(singletonInstance);
        }

        try (ObjectInput input = new ObjectInputStream(new FileInputStream("file.ser"))) {
            SerializedSafeSingleton deserializedInstance = (SerializedSafeSingleton) input.readObject();
            assertEquals(singletonInstance, deserializedInstance);
            //after deserialization singleton creates new instance in case when we don't have
            // implemented Object readResolve method
            //in SerializedSafeSingleton we have implemented that method
            // that is why we have the same objects here
        }
        Files.delete(Paths.get("file.ser"));
    }
}
