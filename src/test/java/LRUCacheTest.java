

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.rajesh.Task;
import org.rajesh.LRUCache;
import java.util.*;

class LRUCacheTest {

    @Test
    void testCacheEviction() {
        LRUCache<String, List<Task>> cache = new LRUCache<>(2);
        cache.put("High", List.of(new Task(1, "Task 1", "Description", "High")));
        cache.put("Low", List.of(new Task(2, "Task 2", "Description", "Low")));
        cache.put("Medium", List.of(new Task(3, "Task 3", "Description", "Medium")));

        assertNull(cache.get("High")); // "High" should be evicted due to capacity
        assertNotNull(cache.get("Low"));
        assertNotNull(cache.get("Medium"));
    }
}
