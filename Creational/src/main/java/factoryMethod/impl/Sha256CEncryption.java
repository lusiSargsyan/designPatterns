package factoryMethod.impl;

import factoryMethod.Encryption;
import org.apache.commons.codec.digest.DigestUtils;

/** Type which will be used depend on requirements */
public class Sha256CEncryption implements Encryption {
  public String encrypt(String plaintext) {
    return DigestUtils.sha256Hex(plaintext);
  }
}
