package builder;

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
  private final String address;
  private final int age;
  private final String phone;

  private User(UserBuilder builder) {
    this.name = builder.firstName;
    this.surname = builder.lastName;
    this.password = builder.password;
    this.email = builder.email;
    this.address = builder.address;
    this.age = builder.age;
    this.phone = builder.phone;
  }

  public static class UserBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;
    private final String email;
    private final String password;

    public UserBuilder(String email, String password) {
      this.email = email;
      this.password = password;
    }

    public UserBuilder age(int age) {
      this.age = age;
      return this;
    }

    public UserBuilder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public UserBuilder address(String address) {
      this.address = address;
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
