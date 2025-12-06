package calendarapp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TaskController
{
    private static List<Task> tasks;

    public static List<Task> getAllTasks() {
        return tasks; }

}

