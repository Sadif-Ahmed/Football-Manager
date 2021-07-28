package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PositionInput {
    @FXML
    public TextField Position;
    private String position;
    private Main main;
    public void Submit(ActionEvent actionEvent) throws Exception {
        position= Position.getText();

        if (position.equalsIgnoreCase("Forward")||position.equalsIgnoreCase("Midfielder")||position.equalsIgnoreCase("Goalkeeper")||position.equalsIgnoreCase("Defender"))
        {
             main.ShowPositionNameSearchResult(position);
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Position Input Window");
            a.setContentText("Wrong Position");
            a.showAndWait();
        }

    }

    public void Reset(ActionEvent actionEvent) {
        Position.setText("");
    }

    public void Back(ActionEvent actionEvent)throws Exception {
       main.showMainMenu();
    }
    void setMain(Main main) {
        this.main = main;
    }
    public String getPosition()
    {
        return position;
    }


}
