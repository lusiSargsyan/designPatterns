package interpreter.languageInterpreter.expression;

import interpreter.languageInterpreter.Interpreter;

public class RUExpression extends LanguageExpression {

    public RUExpression(String text) {
        super(text);
    }

    @Override
    public String interpret(Interpreter interpreter) {
        return interpreter.toRU(text);
    }
}
