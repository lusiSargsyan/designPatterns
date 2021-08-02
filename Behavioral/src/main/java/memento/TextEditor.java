package memento;

/*This is our CareTaker and decides when state will be kept or restored*/
public class TextEditor implements Editor {

  private TextEditorContent textEditorContent;
  private TextEditorContentState state;

  public TextEditor(TextEditorContent textWindow) {
    this.textEditorContent = textWindow;
    this.state = new TextEditorContentState(textWindow.getCurrentContent());
  }

  @Override
  public void pressUndo() {
    textEditorContent.restore(state);
  }

  @Override
  public void pressSave() {
    state = textEditorContent.save();
  }

  @Override
  public String getCurrentSavedState() {
    return state.getTextState();
  }

  @Override
  public void write(String text) {
    textEditorContent.add(text);
  }
}
