package chain;

import chain.storage.IStorageManager;
import chain.storage.UserStorageManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ChainOfResponsibilityTest {

  private ValidationHandler validationHandler = null;
  private User activeUser = null;
  private User expiredUser = null;

  @Before
  public void init() {
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
    Assert.assertEquals(ResultCode.SUCCESS, validationHandler.isValid(activeUser));
  }

  @Test
  public void testExpiredUser() {
    Assert.assertEquals(ResultCode.EXPIRED, validationHandler.isValid(expiredUser));
  }

  @Test
  public void testInvalidUser() {
    User invalidUser = new User.UserBuilder("Wrong", "wrong").build();
    Assert.assertEquals(ResultCode.INVALID, validationHandler.isValid(invalidUser));
  }
}
