package Module4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class TaskServiceTest {
    private TaskService taskService;
    private Task task;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        task = new Task("1", "Task", "Description");
    }

    @Test
    public void testAddTask() {
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1"));
    }

    @Test
    public void testDeleteTask() {
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTaskName() {
        taskService.addTask(task);
        taskService.updateTaskName("1", "Updated Task Name");
        assertEquals("Updated Task Name", taskService.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        taskService.addTask(task);
        taskService.updateTaskDescription("1", "Updated Description");
        assertEquals("Updated Description", taskService.getTask("1").getDescription());
    }
    @Test
    public void testAddTask_NullTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(null);
        });
    }
    @Test
    public void testAddTask_DuplicateId() {
        // Create a task with an existing ID
        Task existingTask = new Task("1", "Existing Task", "Existing Description");
        taskService.addTask(existingTask);

        // Attempt to add a new task with the same ID
        Task newTask = new Task("1", "New Task", "New Description");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(newTask);
        });

    }
    @Test
    public void testUpdateTaskNameWithNullTaskId() {
        // Arrange
        Task newTask = new Task("1", "New Task", "New Description");
        taskService.addTask(newTask);

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName(null, "Updated Task Name");
        });
    }
    @Test
    public void testGetTaskWithNullTaskId() {
        // Arrange

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask(null);
        });
    }
    @Test
    public void testUpdateTaskNameWithNonExistingTaskId() {
        // Arrange
        String taskId = "nonExistingTaskId";
        String newName = "Updated Task Name";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName(taskId, newName);
        });
    }


}

