package memento;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MementoTest {

  private static TextEditor textEditor;
  private String helloText = "Hello!!";

  @BeforeAll
  static void init() {
    TextEditorContent textEditorContent = new TextEditorContent();
    textEditor = new TextEditor(textEditorContent);
  }

  @Test
  void testWriteAndPressSave() {

    textEditor.write(helloText);
    String emptyString = "";
    assertEquals(textEditor.getCurrentSavedState(), emptyString);

    String introText = "I am a test message.";
    textEditor.write(introText);
    textEditor.pressSave();
    assertEquals(textEditor.getCurrentSavedState(), helloText + introText);
  }

  @Test
  void testPressUndo() {
    textEditor.pressUndo();
    assertEquals(textEditor.getCurrentSavedState(), helloText);
  }
}
