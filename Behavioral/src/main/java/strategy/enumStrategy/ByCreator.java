package strategy.enumStrategy;

import java.util.ArrayList;
import java.util.List;

class ByCreator {
  private static final List<ByItem> BY_ITEMS_LIST = new ArrayList<ByItem>();

  static {
    BY_ITEMS_LIST.add(new ByItem("first@gmail.com", "first"));
    BY_ITEMS_LIST.add(new ByItem("second@gmail.com", "second"));
    BY_ITEMS_LIST.add(new ByItem("third@gmail.com", "third"));
  }

  static ByItem getByMail(String mail) {
    return BY_ITEMS_LIST.stream().filter((i) -> i.getMail().equals(mail)).findFirst().get();
  }

  static ByItem getByName(String name) {
    return BY_ITEMS_LIST.stream().filter((i) -> i.getName().equals(name)).findFirst().get();
  }
}
