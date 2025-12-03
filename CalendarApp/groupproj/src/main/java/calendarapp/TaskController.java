package calendarapp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TaskController
{
    private static List<Task> tasks;

    //constructor
    public TaskController() {} //need a load tasks method in the save system (waiting for storage)

    //methods
    public Task createTask(String userId, String name, String description, LocalDate dueDate,
                           Task.TaskType type, Task.Priority priority) throws IOException {
        Task task = new Task(UUID.randomUUID().toString(), userId, name, description, dueDate, type, priority);

        tasks.add(task);
        //task will be saved to storage by method call here
        return task; }

    public void editTask(String taskId, String newName, String newDescription, LocalDate newDueDate,
                         Task.TaskType newType, Task.Priority newPriority) throws IOException {
        Task task = getTaskById(taskId);
        if (task == null) return;

        task.setName(newName);
        task.setDescription(newDescription);
        task.setDueDate(newDueDate);
        task.setType(newType);
        task.setPriority(newPriority);

        /* task will be saved here */ }

    public void deleteTask(String taskId) throws IOException {
        Task task = getTaskById(taskId);
        if (task == null) return;

        tasks.remove(task);
        /* removed task will be saved here */ }

    public void updateStatus(String taskId, Task.Status newStatus) throws IOException {
        Task task = getTaskById(taskId);
        if (task != null) {
            task.setStatus(newStatus);
            /* task will be saved here */ } }

    public static List<Task> getAllTasks() {
        return tasks; }

    public Task getTaskById(String taskId) {
        Task task = tasks.stream().filter(t -> t.getId().equals(taskId)).findFirst().orElse(null);
        return task; }
}
