package prototype;

import prototype.fields.Color;
import prototype.fields.Position;
import prototype.fields.Size;

public class GameItem implements Prototype{
  private Color color;
  private Size size;
  private Position position;
  private String name;
  private int order;

    public GameItem(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException{
        return (GameItem) super.clone();
    }
}
