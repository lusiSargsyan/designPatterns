package chain;

public class ActivationHandler implements ValidationHandler {

  private ValidationHandler nextHandler;

  @Override
  public void setNextHandler(ValidationHandler handler) {
    this.nextHandler = handler;
  }

  @Override
  public ResultCode isValid(User user) {
    if (user.isActive()) {
      return nextOrSuccess(user);
    }
    return ResultCode.NOT_ACTIVE;
  }

  @Override
  public ValidationHandler getNextHandler() {
    return nextHandler;
  }

  @Override
  public boolean hasNextHandler() {
    return nextHandler != null;
  }
}
