package calendarapp;

import java.util.*;

public class TaskController
{
    private static List<Task> tasks = new ArrayList<>();
    private static Map<String, Task> entryMap = new HashMap<>();

    public static void addTask(Task t) {
        tasks.add(t);
        /* save (saveCalendarData() here?) */ }

    public static void updateTask(Task t) {
        /* save */ }

    public static void deleteTask(Task t) {
        tasks.remove(t);
        /* save */ }
    
    public static List<Task> getTasks() {
        return tasks; }

    public static void registerEntry(Task t, String entryId) {
        entryMap.put(entryId, t); }

    public static Task getTaskByEntryId(String id) {
        return entryMap.get(id); }

}


