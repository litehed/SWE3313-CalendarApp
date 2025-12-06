package calendarapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable{

    @FXML 
    private CheckBox notificationsCheckBox;
    @FXML 
    private ColorPicker themeColorPicker;
    @FXML 
    private TextField sessionLengthField;


    private UserSettings settings;

    //constructor
    public SettingsController() {
    } //waiting for storage

    //methods
    public UserSettings getSettings() {
        return settings;
    }

    public void toggleNotifications(boolean enabled) throws IOException {
        settings.setNotificationEnabled(enabled);
        /* settings will be saved to storage by method call here */
    }

    public void updateTheme(String theme) throws IOException {
        settings.setColorTheme(theme);
        /* settings will be saved here */
    }

    public void updateStudySessionLength(int minutes) throws IOException {
        settings.setStudySessionLength_Minutes(minutes);
        /* settings will be saved here */
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        try {
            Parent mainRoot = FXMLLoader.load(getClass().getResource("home_screen.fxml"));
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(mainRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSave(ActionEvent actionEvent) {
        SaveManager.saveUserSettings(settings);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        settings = SaveManager.loadUserSettings();
        notificationsCheckBox.setSelected(settings.isNotificationEnabled());
        themeColorPicker.setValue(Color.web(settings.getColorTheme()));
        sessionLengthField.setText(String.valueOf(settings.getStudySessionLength_Minutes()));
        setListeners();
    }

    private void setListeners() {
        notificationsCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
            settings.setNotificationEnabled(newVal);
        });

        themeColorPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            String colorHex = String.format("#%02X%02X%02X",
                    (int) (newVal.getRed() * 255),
                    (int) (newVal.getGreen() * 255),
                    (int) (newVal.getBlue() * 255));
            settings.setColorTheme(colorHex);
        });

        sessionLengthField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                int minutes = Integer.parseInt(newVal);
                settings.setStudySessionLength_Minutes(minutes);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input for study session length: " + newVal);
            }
        });
    }
}
