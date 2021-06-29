package strategy.basicStrategy;

class PaymentManager {

  PaymentResult doPayment(PaymentMethod paymentMethod) {

    switch (paymentMethod) {
      case PAYPAL:
        PaypalStrategy paypalStrategy = new PaypalStrategy();
        return paypalStrategy.pay();
      case STRIPE:
        StripePaymentStrategy stripePaymentStrategy = new StripePaymentStrategy();
        return stripePaymentStrategy.pay();
      default:
        throw new IllegalArgumentException();
    }
  }
}
