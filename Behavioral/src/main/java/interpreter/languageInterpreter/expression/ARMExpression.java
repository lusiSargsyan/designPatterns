package interpreter.languageInterpreter.expression;

import interpreter.languageInterpreter.Interpreter;

public class ARMExpression extends LanguageExpression {

    public ARMExpression(String text) {
        super(text);
    }

    @Override
    public String interpret(Interpreter interpreter) {
        return interpreter.toARM(text);
    }
}
