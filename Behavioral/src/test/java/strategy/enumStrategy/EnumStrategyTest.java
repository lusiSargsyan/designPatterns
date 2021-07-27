package strategy.enumStrategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnumStrategyTest {

  @Test
  public void test() {
    ByItem item = EnumStrategy.MAIL.getBy("first@gmail.com");
    assertNotNull(item);
  }
}
