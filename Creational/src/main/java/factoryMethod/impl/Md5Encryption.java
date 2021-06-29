package factoryMethod.impl;
import factoryMethod.Encryption;
import org.apache.commons.codec.digest.DigestUtils;

/** Type which will be used depend on requirements */
public class Md5Encryption implements Encryption {
    public String encrypt(String plaintext) {
        return DigestUtils.md5Hex(plaintext);
    }
}
