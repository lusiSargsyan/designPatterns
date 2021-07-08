package interpreter.languageInterpreter;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageInterpreter implements Interpreter {

    @Override
    public String toRU(String textKeyInLocales) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "language", Locale.forLanguageTag("ru"));
        return resourceBundle.getString(textKeyInLocales);
    }

    @Override
    public String toARM(String textKeyInLocales) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "language", Locale.forLanguageTag("arm"));
        return resourceBundle.getString(textKeyInLocales);
    }
}
