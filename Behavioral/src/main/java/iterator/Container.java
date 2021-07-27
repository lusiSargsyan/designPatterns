package iterator;

public interface Container<E> {

  E get(int index);

  void clear();

  Iterator<E> getIterator();

  void addAll(E ...elements);

  void add(E e);

  int size();

  void remove(E el);
}
