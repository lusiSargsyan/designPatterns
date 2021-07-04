package chain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Builder pattern aims to “Separate the construction of a complex object from its representation so
 * that the same construction process can create different representations.” This is mostly helpful
 * when we need to create an immutable state of object Lets assume we have an User class which has
 * too many field . Some of that fields are required and some of not. TO avoid creating a several
 * constructors with all possible cases we can use a builder pattern. Note!! We cant use a setter
 * because they will break an immutability
 */
public class User {
  private final String name;
  private String email; // required
  private final String surname;
  private final String password; // required
  private final LocalDate expireDate;
  private final int age;
  private final Status status;

  private User(UserBuilder builder) {
    this.name = builder.firstName;
    this.surname = builder.lastName;
    this.password = builder.password;
    this.email = builder.email;
    this.expireDate = builder.expireDate;
    this.age = builder.age;
    this.status = builder.status;
  }

  boolean isActive() {
    return Status.ACTIVE.equals(status);
  }

  boolean isExpired() {
    return expireDate.isBefore(LocalDate.now());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return email.equals(user.email) && password.equals(user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  public static class UserBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private Status status;
    private LocalDate expireDate;
    private final String email;
    private final String password;

    UserBuilder(String email, String password) {
      this.email = email;
      this.password = password;
      this.expireDate = LocalDate.now().plusMonths(1);
    }

    public UserBuilder age(int age) {
      this.age = age;
      return this;
    }

    UserBuilder status(Status status) {
      this.status = status;
      return this;
    }

    public UserBuilder expireDate(LocalDate expireDate) {
      this.expireDate = expireDate;
      return this;
    }

    public UserBuilder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public UserBuilder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }
    // Return the final User object
    public User build() {
      User user = new User(this);
      validateUserObject(user);
      return user;
    }

    private void validateUserObject(User user) {
      // Do some basic validations to check
      // if user object does not break any assumption of system
    }
  }
}
