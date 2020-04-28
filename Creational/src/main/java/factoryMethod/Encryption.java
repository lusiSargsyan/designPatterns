package factoryMethod;
/*
Common type which should implement our all encryption types
Here we can have an abstract class as well
 */
public interface Encryption {
  String encrypt(String plaintext);
}
