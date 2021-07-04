package chain;

public class PermissionHandler implements ValidationHandler {

  private ValidationHandler nextHandler;

  @Override
  public void setNextHandler(ValidationHandler handler) {
    nextHandler = handler;
  }

  public ResultCode isValid(User user) {
    if (!user.isExpired()) {
      return nextOrSuccess(user);
    }
    return ResultCode.EXPIRED;
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
