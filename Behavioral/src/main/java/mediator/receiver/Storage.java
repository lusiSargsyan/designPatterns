package mediator.receiver;

public interface Storage<E> {
  Receiver get(int index);

  E get(String identifier);

  void add(E e);

  void addAll(E... elements);
}
