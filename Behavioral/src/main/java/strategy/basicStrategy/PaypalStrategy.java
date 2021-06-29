package strategy.basicStrategy;

import java.util.ArrayList;
import java.util.List;

public class PaypalStrategy implements PaymentStrategy {

    @Override
    public PaymentResult pay() {
        return new PaymentResult("Payment via Paypal was done successfully.", PaymentStatus.OK);
    }

    @Override
    public List<PaymentDetails> getPaymentDetails() {
    System.out.println("Paypal payment details. No payments yet.");
        return new ArrayList<>();
    }
}
