package mediator.receiver;

import mediator.message.Message;

public class User implements Receiver {
  private String email;

    public User(String email) {
        this.email = email;
    }

    @Override
  public void receive(Message message) {
    System.out.println(message);
    }

  @Override
  public String getEmail() {
    return email;
  }
}
