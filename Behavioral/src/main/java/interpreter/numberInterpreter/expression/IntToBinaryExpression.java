package interpreter.numberInterpreter.expression;

import interpreter.numberInterpreter.NumberInterpreter;

public class IntToBinaryExpression implements Expression {

  private int number;

  public IntToBinaryExpression(int number) {
    this.number = number;
  }

  @Override
  public String interpreter(NumberInterpreter in) {
    return in.getBinaryFormat(number);
  }
}
