package chain;

public interface ValidationHandler {

  ResultCode isValid(User user);

  boolean hasNextHandler();

  void setNextHandler(ValidationHandler handler);

  ValidationHandler getNextHandler();

  default ResultCode nextOrSuccess(User user) {
    if (hasNextHandler()) {
      return getNextHandler().isValid(user);
    }
    return ResultCode.SUCCESS;
  }
}
