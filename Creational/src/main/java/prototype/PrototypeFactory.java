package prototype;

import prototype.fields.Color;

public class PrototypeFactory {
    private static java.util.Map<ItemTypes , Prototype> prototypes = new java.util.HashMap<ItemTypes , Prototype>();
    static
    {
        prototypes.put(ItemTypes.CAR, new GameItem(Color.RED,"SmallCar"));
        prototypes.put(ItemTypes.TREE, new GameItem(Color.GREEN,"BackgroundTree"));
    }
    public static Prototype getInstance(final ItemTypes type) throws CloneNotSupportedException {
        return ((Prototype) prototypes.get(type)).clone();
    }
}
