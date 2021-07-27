package iterator;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JobContainerTest {
  private static JobContainer<Executable> container = new JobContainer<Executable>();

  @Test
  @Order(1)
  void testAddAndGet() {
    ExecutableJob job = new ExecutableJob();
    container.add(job);
    assertEquals(job, container.get(0));
  }

  @Test
  @Order(2)
  void testGet() {
    assertThrows(IndexOutOfBoundsException.class, () -> container.get(11));
  }

  @Test
  @Order(3)
  void testClear() {
    container.clear();
    assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
    assertEquals(0, container.size());
  }

  @Test
  @Order(4)
  void testAddAll() {
    ExecutableJob job = new ExecutableJob();
    ExecutableJob job1 = new ExecutableJob();
    ExecutableJob job2 = new ExecutableJob();
    ExecutableJob job3 = new ExecutableJob();
    container.addAll(job, job1, job2, job3);
    assertEquals(4, container.size());
  }

  @Test
  @Order(5)
  void testHasNext() {
    Iterator<Executable> jobIterator = container.getIterator();
    Stream.iterate(0, i -> i++)
        .limit(4)
        .forEach(
            (item) -> {
              assertTrue(jobIterator.hasNext());
              assertNotNull(jobIterator.next());
            });
    assertFalse(jobIterator.hasNext());
    assertNull(jobIterator.next());
  }
}
