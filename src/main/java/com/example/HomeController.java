package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private Label progressText;

    @FXML
    private Label tasksText;

    @FXML
    private Label suggestionText;

    @FXML
    private Label deadlinesText;

    // Initialize method - will be called when FXML is loaded
    public void initialize() {
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
}