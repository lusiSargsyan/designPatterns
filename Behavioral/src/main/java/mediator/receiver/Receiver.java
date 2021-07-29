package mediator.receiver;

import mediator.message.Message;

public interface Receiver {
  void receive(Message message);

  String getEmail();
}
