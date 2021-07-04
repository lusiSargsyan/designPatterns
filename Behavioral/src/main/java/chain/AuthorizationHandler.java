package chain;

import chain.storage.UserStorageManager;

public class AuthorizationHandler implements ValidationHandler {

  private ValidationHandler nextHandler;

  @Override
  public void setNextHandler(ValidationHandler handler) {
    this.nextHandler = handler;
  }

  @Override
  public ResultCode isValid(User user) {
    if (UserStorageManager.getInstance().contains(user)) {
      return nextOrSuccess(user);
    }
    return ResultCode.INVALID;
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
