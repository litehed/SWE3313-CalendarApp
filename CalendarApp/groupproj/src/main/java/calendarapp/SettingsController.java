package calendarapp;

import java.io.IOException;

public class SettingsController
{
    private UserSettings settings;

    //constructor
    public SettingsController() {} //waiting for storage

    //methods
    public UserSettings getSettings() {
        return settings; }

    public void toggleNotifications(boolean enabled) throws IOException {
        settings.setNotificationEnabled(enabled);
        /* settings will be saved to storage by method call here */ }

    public void updateTheme(String theme) throws IOException {
        settings.setColorTheme(theme);
        /* settings will be saved here */ }

    public void updateStudySessionLength(int minutes) throws IOException {
        settings.setStudySessionLength_Minutes(minutes);
        /* settings will be saved here */ }

}
