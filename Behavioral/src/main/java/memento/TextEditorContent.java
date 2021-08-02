package memento;

/* This is our Originator */
public class TextEditorContent {

  private StringBuilder windowContent;

  TextEditorContent() {
    this.windowContent = new StringBuilder();
  }

  public void add(String text) {
    windowContent.append(text);
  }

  String getCurrentContent() {
    return windowContent.toString();
  }

  TextEditorContentState save() {
    return new TextEditorContentState(windowContent.toString());
  }

  void restore(TextEditorContentState state) {
    windowContent = new StringBuilder(state.getTextState());
  }
}
