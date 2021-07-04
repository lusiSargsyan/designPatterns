package chain.storage;

import chain.User;
import java.util.HashSet;
import java.util.Set;

/*
 * just a dummy class
 *
 */
public class UserStorageManager implements IStorageManager {

  private final Set<User> storage = new HashSet<>();

  private UserStorageManager() {
    if (StorageHelper.STORAGE_MANAGER != null) {
      throw new IllegalStateException("Can't instantiate singleton twice");
    }
  }

  @Override
  public boolean add(User user) {
    return storage.add(user);
  }

  @Override
  public boolean contains(User user) {
    return storage.contains(user);
  }

  private static class StorageHelper {
    private static final UserStorageManager STORAGE_MANAGER = new UserStorageManager();
  }

  public static UserStorageManager getInstance() {
    return StorageHelper.STORAGE_MANAGER;
  }
}
