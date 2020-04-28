package factoryMethod;

import factoryMethod.bean.Message;

public class MessageSender {

  private Encryption encryption;
  private Message message;

  public MessageSender(Encryption encryption, Message message) {
    this.encryption = encryption;
    this.message = message;
  }

  public void sendEncryptedMessage() {
    System.out.printf("Sending encrypted message %s!%n", encryption.encrypt(message.getContent()));
  }
}
