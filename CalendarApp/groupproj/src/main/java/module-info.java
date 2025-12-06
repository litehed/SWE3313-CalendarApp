module calendarapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.calendarfx.view;
    requires com.google.gson;
    requires javafx.base;

    opens calendarapp to javafx.fxml, com.google.gson;
    exports calendarapp;
}
