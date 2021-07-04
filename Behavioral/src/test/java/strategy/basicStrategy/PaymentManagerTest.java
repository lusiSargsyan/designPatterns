package strategy.basicStrategy;

import org.junit.Assert;
import org.junit.Test;

public class PaymentManagerTest {

  private static final PaymentManager manager = new PaymentManager();

  @Test
  public void testPaypal() {
    PaymentResult paypalResultExpected =
        new PaymentResult("Payment via Paypal was done successfully.", PaymentStatus.OK);
    PaymentResult paypalResultActual = manager.doPayment(PaymentMethod.PAYPAL);
    Assert.assertEquals(paypalResultExpected, paypalResultActual);
  }

  @Test
  public void testStripe() {
    PaymentResult stripeResultExpected =
        new PaymentResult("Payment via Stripe was done successfully.", PaymentStatus.OK);
    PaymentResult stripeResultActual = manager.doPayment(PaymentMethod.STRIPE);
    Assert.assertEquals(stripeResultExpected, stripeResultActual);
  }
}
