package singleton;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializedSingletonTest {

    @Test
    public void test() throws Exception {
        SerializedSingleton singletonInstance = SerializedSingleton.getInstance();
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("file.ser"))) {
            output.writeObject(singletonInstance);
        }
        try(ObjectInput input = new ObjectInputStream(new FileInputStream("file.ser"))){
            SerializedSingleton deserializedInstance = (SerializedSingleton) input.readObject();
            Assert.assertNotEquals(singletonInstance,deserializedInstance);
            //after deserialization singleton creates new instance
            // that is why we are getting 2 different objects
        }
        Files.delete(Paths.get("file.ser"));
    }
}
