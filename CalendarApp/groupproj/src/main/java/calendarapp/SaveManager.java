package calendarapp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.calendarfx.model.Calendar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveManager {
    // Creates new gson instance and defines file paths for save data
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String userFilePath = "saves/user_settings.json";
    private static final String calendarFilePath = "saves/calendar_data.json";

    public static void saveUserSettings(UserSettings settings) {
        try (FileWriter writer = new FileWriter(userFilePath)) {
            gson.toJson(settings, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static void saveCalendarData(Calendar data) {
        try (FileWriter writer = new FileWriter(calendarFilePath)) {
            gson.toJson(data, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
