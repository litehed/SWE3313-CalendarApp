package calendarapp;

import java.net.URL;
import java.util.ResourceBundle;

import com.calendarfx.view.CalendarView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable{

    @FXML
    private CalendarView calendarView;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        calendarView.showMonthPage();
        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowPageToolBarControls(false);
    }

}
