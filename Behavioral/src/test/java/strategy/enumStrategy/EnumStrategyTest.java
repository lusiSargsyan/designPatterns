package strategy.enumStrategy;

import org.junit.Assert;
import org.junit.Test;

public class EnumStrategyTest {

    @Test
    public void test() {
        ByItem item = EnumStrategy.MAIL.getBy("first@gmail.com");
        Assert.assertNotNull(item);
    }
}
