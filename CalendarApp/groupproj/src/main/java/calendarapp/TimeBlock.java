package calendarapp;

import java.time.Duration;
import java.time.LocalTime;

public class TimeBlock
{
    private LocalTime start;
    private LocalTime end;

    //constructor
    public TimeBlock(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end; }

    //getters
    public LocalTime getStart() {
        return start; }
    public LocalTime getEnd() {
        return end; }

    //method
    public long getDurationMinutes() {
        return (Duration.between(start, end).toMinutes()); }
}
