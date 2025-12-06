package calendarapp;

import javafx.event.Event;
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

public class CalendarController
{


    //adding more methods here to find free time blocks during the day for more study sessions


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

