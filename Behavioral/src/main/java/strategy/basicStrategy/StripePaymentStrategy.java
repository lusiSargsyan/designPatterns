package strategy.basicStrategy;

import java.util.ArrayList;
import java.util.List;

public class StripePaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay() {
        return new PaymentResult("Payment via Stripe was done successfully.", PaymentStatus.OK);
    }

    @Override
    public List<PaymentDetails> getPaymentDetails() {
        System.out.println("Stripe payment details. No payments yet.");
        return new ArrayList<>();
    }
}
