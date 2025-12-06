package calendarapp;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveManager {
    // Creates new gson instance and defines file paths for save data
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String userFilePath = "saves/user_settings.json";

    public static void saveUserSettings(UserSettings settings) {
        try (FileWriter writer = new FileWriter(userFilePath)) {
            gson.toJson(settings, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
