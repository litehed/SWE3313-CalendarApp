module calendarapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.calendarfx.view;

    opens calendarapp to javafx.fxml;
    exports calendarapp;
}
