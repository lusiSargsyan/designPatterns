package memento;

public interface Editor {
    void pressSave();
    void pressUndo();
    String getCurrentSavedState();
    void write(String text);
}
