package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClubCountryInput {
    @FXML
    public TextField Country_Name;
    private Main main;
    private String Country_name;
    public void Reset(ActionEvent actionEvent) {
        Country_Name.setText("");

    }

    public void Back(ActionEvent actionEvent)throws Exception {
       main.showMainMenu();

    }

    public void Submit(ActionEvent actionEvent)throws Exception {
        Country_name= Country_Name.getText();
        main.ShowClubCountryNameSearchResult(Country_name);
    }
    void setMain(Main main) {
        this.main = main;
    }
    public String getCountry_name() {
        return Country_name;
    }

}
