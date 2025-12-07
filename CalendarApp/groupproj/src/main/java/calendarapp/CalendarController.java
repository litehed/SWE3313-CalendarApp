package calendarapp;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import java.util.List;
import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarEvent;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class CalendarController implements Initializable {
    @FXML
    private BorderPane root;
    private CalendarView view;
    private Calendar<Task> taskCalendar;

    // creates the calendar and view
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        view = new CalendarView();
        taskCalendar = new Calendar<Task>("All Tasks");
        taskCalendar.setStyle(Calendar.Style.STYLE1);
        taskCalendar.setReadOnly(false);

        CalendarSource source = new CalendarSource("Tasks");
        source.getCalendars().add(taskCalendar);

        view.getCalendarSources().add(source);
        view.setRequestedTime(LocalTime.now());

        root.setCenter(view);
        loadAllTasks();
        setupEntryEventHandlers();
    }

    private void loadAllTasks() {
        taskCalendar.clear();
        List<Task> tasks = TaskController.getTasks();

        for (Task t : tasks) {
            Entry<Task> entry = new Entry<>(t.getName());
            String id = UUID.randomUUID().toString();
            entry.setId(id);

            TaskController.registerEntry(t, id);

            entry.setInterval(t.getDueDate().atTime(8, 0), t.getDueDate().atTime(12, 0));
            taskCalendar.addEntry(entry);
        }
    }
    private void setupEntryEventHandlers() {
        taskCalendar.addEventHandler(new EventHandler<CalendarEvent>() {
            @Override
            public void handle(CalendarEvent event) {
                Entry<?> entry = event.getEntry();
                if (entry == null)
                    return;
                Task t = TaskController.getTaskByEntryId(entry.getId());
                if (t == null)
                    return;

                if (event.isEntryAdded()) {
                    Task newTask = new Task(entry.getTitle(), "", entry.getStartDate(), t.getType(), t.getPriority());

                    String id = UUID.randomUUID().toString();
                    entry.setId(id);
                    TaskController.registerEntry(newTask, id);
                    TaskController.addTask(newTask);
                }

                else if (event.getEventType().getName().equals("ENTRY_CHANGED")) {
                    t.setName(entry.getTitle());
                    t.setDescription(entry.getTitle());
                    t.setDueDate(entry.getStartDate());
                    t.setType((Task.TaskType) entry.getUserObject());
                    t.setPriority((Task.Priority) entry.getUserObject());
                    t.setStatus((Task.Status) entry.getUserObject());
                    TaskController.updateTask(t);
                }

                else if (event.isEntryRemoved()) {
                    TaskController.deleteTask(t);
                }
            }
        });
    }

    // adding more methods here to find free time blocks during the day for more
    // study sessions

    @FXML
    private void goHome(MouseEvent event) {
        System.out.println("Home button clicked!");
        switchScene(event, "home_screen.fxml");
    }

    @FXML
    private void goTasks(MouseEvent event) {
        System.out.println("Tasks button clicked!");
    }

    @FXML
    private void goCalendar(MouseEvent event) {
        System.out.println("Calendar button clicked!");
    }

    @FXML
    private void goProfile(MouseEvent event) {
        System.out.println("Profile button clicked!");
    }

    private void switchScene(Event event, String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}