import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rajesh.TaskService;
import org.rajesh.Task;
import java.util.List;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp(){
        taskService = TaskService.getInstance();
    }

    @Test
    void testCreateTask(){
        Task task = taskService.createTask("Task 1", "Description of Task 1", "High");
        assertNotNull(task);
        assertEquals("Task 1",task.getTitle());

    }

    @Test
    void testSearchByPriority() {
        taskService.createTask("Task 1", "Description", "High");
        taskService.createTask("Task 2", "Description", "Low");
        taskService.createTask("Task 3", "Description", "High");

        List<Task> highPriorityTasks = taskService.searchPriority("High");
        assertEquals(2, highPriorityTasks.size());
    }
}
