package calendarapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private Label progressText;

    @FXML
    private Label tasksText;

    @FXML
    private Label suggestionText;

    @FXML
    private Label deadlinesText;

    // Initialize method - will be called when FXML is loaded
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set initial data
        progressText.setText("75% Complete");
        tasksText.setText("3 of 5 Completed");
        suggestionText.setText("2 hours free - Study Calculus?");
        deadlinesText.setText("Physics HW - Tomorrow\nMath Quiz - Friday");
    }

    // Add methods for button actions here
    @FXML
    private void handleAddTask() {
        System.out.println("Add Task button clicked!");
        // Will connect to your team's task management logic
    }

    @FXML
    private void handleSettings(ActionEvent event) {
        System.out.println("Settings button clicked!");
        try {
            // Load settings screen
            Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings_screen.fxml"));

            // Get current stage and set new scene
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.setScene(new Scene(settingsRoot));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleHelp() {
        System.out.println("Help button clicked!");
        showHelpMenu();
    }

    private void showHelpMenu() {
        // Create help content
        VBox helpMenu = new VBox();
        helpMenu.getStyleClass().add("help-menu");
        helpMenu.setSpacing(15);
        helpMenu.setPadding(new Insets(20));
        helpMenu.setMaxWidth(300);
        helpMenu.setStyle(
                "-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 8; -fx-background-radius: 8;");

        // Title
        Label title = new Label("StudyFlow Help");
        title.getStyleClass().add("help-title");

        // Text content
        TextFlow helpContent = new TextFlow();

        Text intro = new Text("Welcome to StudyFlow!\n\n");
        intro.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

        Text featuresTitle = new Text("Features:\n");
        featuresTitle.setStyle("-fx-underline: true; -fx-font-size: 12;");

        Text features = new Text(
                "• Create and manage tasks (assignments, quizzes, exams)\n" +
                        "• Automatic calendar scheduling\n" +
                        "• Smart study session suggestions\n" +
                        "• Progress tracking\n\n");

        Text howToTitle = new Text("How to Use:\n");
        howToTitle.setStyle("-fx-underline: true; -fx-font-size: 12;");

        Text howTo = new Text(
                "1. Click '+' to add new tasks\n" +
                        "2. View deadlines in the calendar\n" +
                        "3. Accept/reject study session suggestions\n" +
                        "4. Track your weekly progress\n\n");

        Text settingsTitle = new Text("Settings:\n");
        settingsTitle.setStyle("-fx-underline: true; -fx-font-size: 12;");

        Text settings = new Text(
                "• Toggle notifications on/off\n" +
                        "• Change theme colors\n" +
                        "• Adjust study session length\n\n");

        helpContent.getChildren().addAll(intro, featuresTitle, features, howToTitle, howTo, settingsTitle, settings);

        Label content = new Label();
        content.setGraphic(helpContent);
        content.getStyleClass().add("help-content");
        content.setWrapText(true);

        // Close button
        Button closeButton = new Button("Got it!");
        closeButton.getStyleClass().add("close-help-button");

        // Create popup
        Popup popup = new Popup();
        popup.getContent().add(helpMenu);
        popup.setAutoHide(true);

        closeButton.setOnAction(e -> {
            popup.hide();
        });

        // Add everything to help menu
        helpMenu.getChildren().addAll(title, content, closeButton);

        // Center the help menu
        helpMenu.setAlignment(Pos.CENTER);

        Stage stage = (Stage) progressText.getScene().getWindow();

        if (stage != null) {
            popup.show(stage);
        }
    }
}
