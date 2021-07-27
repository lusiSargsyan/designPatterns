package interpreter.languageInterpreter;

import interpreter.languageInterpreter.expression.ARMExpression;
import interpreter.languageInterpreter.expression.LanguageExpression;
import interpreter.languageInterpreter.expression.RUExpression;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageInterpreterTest {
  private final String HELLO_TEXT_KEY = "hello";
  private final LanguageInterpreter languageInterpreter = new LanguageInterpreter();

  @Test
  public void testARM() {
    LanguageExpression expression = new ARMExpression(HELLO_TEXT_KEY);
    assertEquals("բարև", expression.interpret(languageInterpreter));
  }

  @Test
  public void testRU() {
    LanguageExpression expression = new RUExpression(HELLO_TEXT_KEY);
    assertEquals("Привет", expression.interpret(languageInterpreter));
  }
}
