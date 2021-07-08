package interpreter.numberInterpreter.expression;

import interpreter.numberInterpreter.NumberInterpreter;

public class IntToHexExpression implements Expression {

  private int number;

  public IntToHexExpression(int number) {
    this.number = number;
  }

  @Override
  public String interpreter(NumberInterpreter in) {
    return in.getHexadecimalFormat(number);
  }
}
