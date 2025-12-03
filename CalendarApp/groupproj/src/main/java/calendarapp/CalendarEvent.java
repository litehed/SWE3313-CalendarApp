package calendarapp;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarEvent
{
    private String eventId;
    private String taskId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean studySessionGenerated;

    //constructor
    public CalendarEvent(String eventId, String taskId, LocalDate date, LocalTime startTime,
                         LocalTime endTime, boolean studySessionGenerated) {
        this.eventId = eventId;
        this.taskId = taskId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.studySessionGenerated = studySessionGenerated; }

    //getters
    public String getEventId() {
        return eventId; }
    public String getTaskId() {
        return taskId; }
    public LocalDate getDate() {
        return date; }
    public LocalTime getStartTime() {
        return startTime; }
    public LocalTime getEndTime() {
        return endTime; }
    public boolean isStudySessionGenerated() {
        return studySessionGenerated; }
}
