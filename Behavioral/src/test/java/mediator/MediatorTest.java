package mediator;

import mediator.message.Mediator;
import mediator.message.Message;
import mediator.message.MessageMediator;
import org.junit.jupiter.api.Test;

public class MediatorTest {

    @Test
    void test() {
        String message = "sender@gmail.com:Check was failed.:receiver@gmail.com";
        Mediator mediator = new MessageMediator();
        mediator.send(Message.fromString(message));
    }
}
