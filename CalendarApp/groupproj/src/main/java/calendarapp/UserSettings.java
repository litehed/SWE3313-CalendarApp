package calendarapp;

public class UserSettings
{
    private boolean notificationEnabled;
    private String colorTheme;
    private int studySessionLength_Minutes;

    //constructor
    public UserSettings() {
        notificationEnabled = true;
        colorTheme = "Default";
        studySessionLength_Minutes = 60; }

    //getters
    public boolean isNotificationEnabled() {
        return notificationEnabled; }
    public String getColorTheme() {
        return colorTheme; }
    public int getStudySessionLength_Minutes() {
        return studySessionLength_Minutes; }

    //setters
    public void setNotificationEnabled(boolean enabled) {
        notificationEnabled = enabled; }
    public void setColorTheme(String theme) {
        colorTheme = theme; }
    public void setStudySessionLength_Minutes(int minutes) {
        studySessionLength_Minutes = minutes; }
}
