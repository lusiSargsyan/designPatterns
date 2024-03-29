package prototype;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrototypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        GameItem car = (GameItem) PrototypeFactory.getInstance(ItemTypes.CAR);
        GameItem secondCar = (GameItem) PrototypeFactory.getInstance(ItemTypes.CAR);
        // If the class contains members of any class type then only the object references to those
        // members are copied and hence the member references in both the original object as well as the
        // cloned object refer to the same object.
        assertEquals(car.getColor(), secondCar.getColor());
    }
}
