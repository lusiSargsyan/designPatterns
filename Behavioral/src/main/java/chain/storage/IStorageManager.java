package chain.storage;

import chain.User;

public interface IStorageManager {
    boolean add(User u);
    boolean contains(User u);
}
