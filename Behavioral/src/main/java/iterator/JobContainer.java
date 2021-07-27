package iterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class JobContainer<E> implements Container<E> {

  private final int DEFAULT_CAPACITY = 10;
  private E[] jobs;
  private int size = 0;

  @SafeVarargs
  JobContainer(E... elements) {
    jobs = elements;
    size = elements.length;
  }

  public JobContainer(Class<? extends E> type, int size) {
    jobs = newArray(size);
  }

  @Override
  public E get(int index) {
    return jobs[index];
  }

  @Override
  public void clear() {
    jobs = newArray(0);
    size = 0;
  }

  @Override
  public void add(E element) {
    if (size == jobs.length) {
      jobs = extend();
    }
    jobs[size++] = element;
  }

  @Override
  public void remove(E element) {
    int index = getIndex(element);
    E[] newArray = newArray(jobs.length - 1);
    if (index != -1) {
      System.arraycopy(jobs, index + 1, newArray, size, jobs.length);
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  @SafeVarargs
  public final void addAll(E... elements) {
    if (jobs.length <= elements.length) {
      jobs = extend();
    }
    System.arraycopy(elements, 0, jobs, size, elements.length);
    size += elements.length;
  }

  @Override
  public Iterator<E> getIterator() {
    return new JobIterator();
  }

  private int getIndex(E element) {
    return IntStream.of(0, jobs.length).filter(e -> jobs[e] == element).findFirst().orElse(-1);
  }

  private E[] extend() {
    return jobs = Arrays.copyOf(jobs, increasedCapacity());
  }

  private int increasedCapacity() {
    return jobs.length + DEFAULT_CAPACITY;
  }

  private E[] newArray(int size) {
    Class elementClass = jobs.getClass().getComponentType();
    @SuppressWarnings("unchecked")
    E[] newArray = (E[]) Array.newInstance(elementClass, size);
    return newArray;
  }

  private class JobIterator implements Iterator<E> {

    private int index;

    @Override
    public E next() {
      if (hasNext()) {
        return jobs[index++];
      }
      return null;
    }

    @Override
    public boolean hasNext() {
      return index < size;
    }
  }
}
