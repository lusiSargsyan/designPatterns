package strategy.basicStrategy;

import java.util.List;

/*
* Basic strategy implementation is  based on Abstraction principle in java.
* We are defining an interface with our task and only during runtime execution jvm decides
* which concrete implementation of our strategy will be executed.
* */
public interface PaymentStrategy {
    PaymentResult pay();
    List<PaymentDetails> getPaymentDetails();
}
