package strategy.basicStrategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentManagerTest {

  private static final PaymentManager manager = new PaymentManager();

  @Test
  public void testPaypal() {
    PaymentResult paypalResultExpected =
        new PaymentResult("Payment via Paypal was done successfully.", PaymentStatus.OK);
    PaymentResult paypalResultActual = manager.doPayment(PaymentMethod.PAYPAL);
    assertEquals(paypalResultExpected, paypalResultActual);
  }

  @Test
  public void testStripe() {
    PaymentResult stripeResultExpected =
        new PaymentResult("Payment via Stripe was done successfully.", PaymentStatus.OK);
    PaymentResult stripeResultActual = manager.doPayment(PaymentMethod.STRIPE);
    assertEquals(stripeResultExpected, stripeResultActual);
  }
}
