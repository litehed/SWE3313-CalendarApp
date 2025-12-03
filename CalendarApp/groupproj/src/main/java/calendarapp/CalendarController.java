package calendarapp;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class CalendarController
{
    private List<CalendarEvent> events;

    //constructor
    public CalendarController() {} //waiting for storage

    //methods
    public CalendarEvent addTaskToCalendar(Task task) throws IOException {
        LocalTime defaultStart = LocalTime.of(9, 0);
        LocalTime defaultEnd = defaultStart.plusHours(1);

        CalendarEvent event = new CalendarEvent(UUID.randomUUID().toString(), task.getId(),
                task.getDueDate(), defaultStart, defaultEnd, false);

        events.add(event);
        //event will be saved to storage by method call here
        return event; }

    public void updateCalendarForEditedTask(Task task) throws IOException {
        for (CalendarEvent event : events) {
            if (event.getEventId().equals(task.getId()) && !event.isStudySessionGenerated()) {
                events.remove(event);

                CalendarEvent updated = new CalendarEvent(UUID.randomUUID().toString(), task.getId(), task.getDueDate(),
                        LocalTime.of(9, 0), LocalTime.of(10, 0), false);

                events.add(updated);
                //event will be saved here
                return; } } }

    public void deleteEventsForTask(String taskId) throws IOException {
        events.removeIf(event -> event.getTaskId().equals(taskId));
        /* removed event will be saved here */ }

    //Set for the day before a due date and UI should allow users to choose to accept it or discard it
    public CalendarEvent createStudySession(Task task, int minutesBefore) throws IOException {
        LocalDate studyDate = task.getDueDate().minusDays(1);
        LocalTime start = LocalTime.of(17, 0);
        LocalTime end = start.plusMinutes(minutesBefore);

        CalendarEvent event = new CalendarEvent(UUID.randomUUID().toString(), task.getId(),
                studyDate, start, end, true);

        events.add(event);
        //event will be saved here
        return event; }

    //adding more methods here to find free time blocks during the day for more study sessions

    public List<CalendarEvent> getAllEvents() {
        return events; }

    //To help with UI color-coding
    public String getColorTagForTask(Task task) {
        String tag = "";

        switch(task.getType()) {
            case ASSIGNMENT: tag = "assignment"; break;
            case QUIZ: tag = "quiz"; break;
            case EXAM: tag = "exam"; break; }

        return tag; }
}
