package calendarapp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import com.calendarfx.model.Calendar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveManager {
    // Creates new gson instance and defines file paths for save data
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String userFilePath = "saves/user_settings.json";
    private static final String calendarFilePath = "saves/calendar_data.json";

    // Saves the user settings to a json file based on annotations in UserSettings
    public static void saveUserSettings(UserSettings settings) {
        try (FileWriter writer = new FileWriter(userFilePath)) {
            gson.toJson(settings, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Loads the user settings from a json file, or creates new settings if none exist
    public static UserSettings loadUserSettings() {
        try {
            File file = new File(userFilePath);
            if (!file.exists()) {
                return new UserSettings();
            }
            try (FileReader reader = new FileReader(file)) {
                return gson.fromJson(reader, UserSettings.class);
            }
        } catch (Exception e) {
            System.err.println("Failed to load user settings: " + e.getMessage());
            return new UserSettings();
        }
    }

    // Saves the calendar data to a json file
    public static void saveCalendarData() {
        try (FileWriter writer = new FileWriter(calendarFilePath)) {
            List<Task> tasks = TaskController.getTasks();
            gson.toJson(tasks, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Task> loadCalendarData() {
        try {
            File file = new File(calendarFilePath);
            if (!file.exists()) {
                return List.of();
            }
            try (FileReader reader = new FileReader(file)) {
                Task[] tasks = gson.fromJson(reader, Task[].class);
                return List.of(tasks);
            }
        } catch (Exception e) {
            System.err.println("Failed to load calendar data: " + e.getMessage());
            return List.of();
        }
    }
}
