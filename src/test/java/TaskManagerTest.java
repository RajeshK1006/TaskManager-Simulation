
import org.junit.jupiter.api.*;
import org.rajesh.TaskService;
import org.rajesh.Task;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    // Logger setup
    private static final Logger logger = Logger.getLogger(TaskServiceTest.class.getName());
    private static FileHandler fileHandler;
    private TaskService taskService;

    // Before all tests
    @BeforeAll
    public static void setupBeforeAll() throws Exception {
        fileHandler = new FileHandler("test-logs.log");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.info("Starting Test Suite...");
    }

    // After all tests
    @AfterAll
    public static void tearDownAfterAll() throws Exception {
        logger.info("Test Suite Completed.");
        fileHandler.close();
    }

    // Before each test
    @BeforeEach
    public void setupBeforeEach() {
        taskService = TaskService.getInstance();  // Get the singleton instance of TaskService
        logger.info("Setting up for a new test...");
    }

    // After each test
    @AfterEach
    public void tearDownAfterEach() {
        logger.info("Test completed. Tearing down...");
    }

    // Sample test case with DisplayName
    @Test
    @DisplayName("Test: Create Task - Valid Task")
    public void testCreateTask() {
        Task task = taskService.createTask("Task 1", "Description of Task 1", "High");
        assertNotNull(task);
        assertEquals("Task 1", task.getTitle());
        logger.info("Task 'Task 1' was created.");
    }

    // Sample test case with DisplayName
    @Test
    @DisplayName("Test: Search Tasks by Priority")
    public void testSearchByPriority() {
        taskService.createTask("Task 1", "Description", "High");
        taskService.createTask("Task 2", "Description", "Low");
        taskService.createTask("Task 3", "Description", "High");

        var highPriorityTasks = taskService.searchPriority("High");
        assertEquals(2, highPriorityTasks.size());
        logger.info("Two tasks found with high priority.");
    }

    // Sample test case with DisplayName
    @Test
    @DisplayName("Test: Get Tasks - Empty List")
    public void testGetTasksWhenEmpty() {
        var tasks = taskService.searchPriority("Low");
        assertFalse(tasks.isEmpty());
        logger.info("No tasks found with low priority, as expected.");
    }

    @AfterAll
    public  static void getDone(){
        System.out.println("All test cases are passed!!!");
    }
}
