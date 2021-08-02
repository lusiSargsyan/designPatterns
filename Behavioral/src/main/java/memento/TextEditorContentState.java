package memento;

/* This is our Memento object which keeps state of TextWindow */
class TextEditorContentState {

  private String textState;

  TextEditorContentState(String textState) {
    this.textState = textState;
  }

  String getTextState() {
    return textState;
  }
}
