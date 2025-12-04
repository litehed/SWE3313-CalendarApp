package calendarapp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    private void handleSettings() {
        System.out.println("Settings button clicked!");
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

        // Title
        Label title = new Label("📚 StudyFlow Help");
        title.getStyleClass().add("help-title");

        // Content - Use regular string concatenation instead of text block
        String helpText = "Welcome to StudyFlow!\n\n" +
                "📋 **Features:**\n" +
                "• Create and manage tasks (assignments, quizzes, exams)\n" +
                "• Automatic calendar scheduling\n" +
                "• Smart study session suggestions\n" +
                "• Progress tracking\n\n" +
                "🎯 **How to Use:**\n" +
                "1. Click '+' to add new tasks\n" +
                "2. View deadlines in the calendar\n" +
                "3. Accept/reject study session suggestions\n" +
                "4. Track your weekly progress\n\n" +
                "⚙️ **Settings:**\n" +
                "• Toggle notifications on/off\n" +
                "• Change theme colors\n" +
                "• Adjust study session length\n\n" +
                "Questions? Contact support@studyflow.app";

        Label content = new Label(helpText);
        content.getStyleClass().add("help-content");
        content.setWrapText(true);

        // Close button
        Button closeButton = new Button("Got it!");
        closeButton.getStyleClass().add("close-help-button");
        closeButton.setOnAction(e -> {
            // Remove help menu from root
            if (rootPane != null) {
                rootPane.getChildren().remove(helpMenu);
            }
        });

        // Add everything to help menu
        helpMenu.getChildren().addAll(title, content, closeButton);

        // Center the help menu
        helpMenu.setAlignment(Pos.CENTER);

        // Add to root pane (make sure your FXML has a StackPane as root)
        if (rootPane != null) {
            // Center the menu
            StackPane.setAlignment(helpMenu, Pos.CENTER);
            rootPane.getChildren().add(helpMenu);
        } else {
            // Alternative: Create a popup stage
            createHelpPopup(helpMenu);
        }
    }
    private void createHelpPopup(VBox helpMenu) {
        // Create a new stage for the help popup
        javafx.stage.Stage helpStage = new javafx.stage.Stage();
        helpStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
        helpStage.setTitle("StudyFlow Help");
        helpStage.setResizable(false);

        javafx.scene.Scene scene = new javafx.scene.Scene(helpMenu, 320, 450);
        scene.getStylesheets().add(getClass().getResource("mobile-styles.css").toExternalForm());
        helpStage.setScene(scene);
        helpStage.show();
    }

}

