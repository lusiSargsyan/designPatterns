package mediator.message;

import mediator.receiver.Receiver;
import mediator.receiver.ReceiverStorage;
import mediator.receiver.Storage;

public class MessageMediator implements Mediator {

  private Storage<Receiver> storage;

  public MessageMediator() {
    this.storage = new ReceiverStorage();
  }

  @Override
  public void send(Message m) {
    Receiver receiver = storage.get(m.getReceiver());
    receiver.receive(m);
  }
}
