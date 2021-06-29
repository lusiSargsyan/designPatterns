package prototype.fields;
/*
Just a simple class to demo prototype pattern
*/
public class Size {
    private int width;
    private int height;
    private int weight;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Size(int width, int height, int weight) {
        this.width = width;
        this.height = height;
        this.weight = weight;
    }
}
