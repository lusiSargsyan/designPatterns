package strategy.basicStrategy;

import java.util.Comparator;
import java.util.Objects;

public class PaymentResult implements Comparable {

  private String message;
  private PaymentStatus status;

  public PaymentResult(String message, PaymentStatus status) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PaymentResult that = (PaymentResult) o;
    return message.equals(that.message) && status == that.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, status);
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof PaymentResult) {
      PaymentResult paymentResult = (PaymentResult) o;
      return Comparator.comparing(PaymentResult::getMessage)
          .thenComparing(PaymentResult::getStatus)
          .compare(this, paymentResult);
    }
    return -1;
  }
}
