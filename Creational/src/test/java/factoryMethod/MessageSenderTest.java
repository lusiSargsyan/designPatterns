package factoryMethod;

import factoryMethod.bean.Message;
import factoryMethod.impl.Md5Encryption;
import org.junit.Test;

public class MessageSenderTest {

  @Test
  public void test() {
    Message message = new Message("Hello world", "sender", "receiver");
    MessageSender sender = new MessageSender(new Md5Encryption(), message);
    sender.sendEncryptedMessage();
  }
}
