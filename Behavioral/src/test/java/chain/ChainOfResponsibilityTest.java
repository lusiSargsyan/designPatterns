package chain;

import chain.storage.IStorageManager;
import chain.storage.UserStorageManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChainOfResponsibilityTest {

  private static ValidationHandler validationHandler = null;
  private static User activeUser = null;
  private static User expiredUser = null;

  @BeforeAll
  public static void init() {
    IStorageManager storageManager = UserStorageManager.getInstance();
    activeUser = new User.UserBuilder("John", "pass").status(Status.ACTIVE).build();
    expiredUser =
        new User.UserBuilder("Jack", "pass1")
            .status(Status.ACTIVE)
            .expireDate(LocalDate.of(2015, 5, 5))
            .build();
    storageManager.add(activeUser);
    storageManager.add(expiredUser);
    PermissionHandler permissionHandler = new PermissionHandler();
    ActivationHandler activationHandler = new ActivationHandler();
    activationHandler.setNextHandler(permissionHandler);
    validationHandler = new AuthorizationHandler();
    validationHandler.setNextHandler(activationHandler);
  }

  @Test
  public void testActiveUser() {
    assertEquals(ResultCode.SUCCESS, validationHandler.isValid(activeUser));
  }

  @Test
  public void testExpiredUser() {
    assertEquals(ResultCode.EXPIRED, validationHandler.isValid(expiredUser));
  }

  @Test
  public void testInvalidUser() {
    User invalidUser = new User.UserBuilder("Wrong", "wrong").build();
    assertEquals(ResultCode.INVALID, validationHandler.isValid(invalidUser));
  }
}
