package Module4;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        String taskId = task.getTaskId();
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with the same ID already exists.");
        }

        tasks.put(taskId, task);
    }

    public void deleteTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null.");
        }

        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with the specified ID does not exist.");
        }

        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null.");
        }

        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with the specified ID does not exist.");
        }

        Task task = tasks.get(taskId);
        task.setName(newName);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null.");
        }

        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with the specified ID does not exist.");
        }

        Task task = tasks.get(taskId);
        task.setDescription(newDescription);
    }

    public Task getTask(String taskId) {
        if (taskId == null) {
            throw new IllegalArgumentException("Task ID cannot be null.");
        }

        return tasks.get(taskId);
    }
}
