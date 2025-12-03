package calendarapp;

import java.time.LocalDate;

public class Task
{
    public enum TaskType { ASSIGNMENT, QUIZ, EXAM }
    public enum Priority { LOW, MEDIUM, HIGH }
    public enum Status { NOT_STARTED, IN_PROGRESS, COMPLETED }

    private String id;
    private String userId;
    private String name;
    private String description;
    private LocalDate dueDate;
    private TaskType type;
    private Priority priority;
    private Status status;

    //constructor
    public Task(String id, String userId, String name, String description,
                LocalDate dueDate, TaskType type, Priority priority) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.type = type;
        this.priority = priority;
        this.status = Status.NOT_STARTED; }

    //getters
    public String getId() {
        return id; }
    public String getUserId() {
        return userId; }
    public String getName() {
        return name; }
    public String getDescription() {
        return description; }
    public LocalDate getDueDate() {
        return dueDate; }
    public TaskType getType() {
        return type; }
    public Priority getPriority() {
        return priority; }
    public Status getStatus() {
        return status; }

    //setters
    public void setName(String name) {
        this.name = name; }
    public void setDescription(String description) {
        this.description = description; }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate; }
    public void setType(TaskType type) {
        this.type = type; }
    public void setPriority(Priority priority) {
        this.priority = priority; }
    public void setStatus(Status status) {
        this.status = status; }
}
