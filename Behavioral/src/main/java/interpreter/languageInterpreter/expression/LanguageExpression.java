package interpreter.languageInterpreter.expression;

import interpreter.languageInterpreter.Interpreter;

public abstract class LanguageExpression {
  protected String text;

  public LanguageExpression(String text) {
    this.text = text;
  }

  public abstract String interpret(Interpreter interpreter);
}
