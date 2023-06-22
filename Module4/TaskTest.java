package Module4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task 1", "Description 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("TaskID1234", null, "Description 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("TaskID1234", "Task 1", null));

        Task task = new Task("TaskID1234", "Task 1", "Description 1");

        assertEquals("TaskID1234", task.getTaskId());
        assertEquals("Task 1", task.getName());
        assertEquals("Description 1", task.getDescription());
    }

    @Test
    public void testTaskNameUpdate() {
        Task task = new Task("TaskID1234", "Task 1", "Description 1");

        task.setName("Updated Task Name");

        assertEquals("Updated Task Name", task.getName());
    }

    @Test
    public void testTaskDescriptionUpdate() {
        Task task = new Task("TaskID1234", "Task 1", "Description 1");

        task.setDescription("Updated Task Description");

        assertEquals("Updated Task Description", task.getDescription());
    }
}
