package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TableViewController {
    @FXML
    private TableView tableView;

    ObservableList<PlayerInfoBeta> List;
    List<PlayerInfo> temp=new ArrayList<>();
    private Main main;


    private boolean in = true;
    private void initializeColumns() {
        TableColumn<PlayerInfoBeta, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(60);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<PlayerInfoBeta, String> CountryCol = new TableColumn<>("Country");
        CountryCol.setMinWidth(40);
        CountryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));

        TableColumn<PlayerInfoBeta, Integer> AgeCol = new TableColumn<>("Age");
        AgeCol.setMinWidth(20);
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("Age"));

        TableColumn<PlayerInfoBeta, Double> HeightCol = new TableColumn<>("Height");
        HeightCol.setMinWidth(20);
        HeightCol.setCellValueFactory(new PropertyValueFactory<>("Height"));
        TableColumn<PlayerInfoBeta, String> ClubCol = new TableColumn<>("Club");
        ClubCol.setMinWidth(60);
        ClubCol.setCellValueFactory(new PropertyValueFactory<>("Club"));
        TableColumn<PlayerInfoBeta, String> PositionCol = new TableColumn<>("Position");
        PositionCol.setMinWidth(60);
        PositionCol.setCellValueFactory(new PropertyValueFactory<>("Position"));
        TableColumn<PlayerInfoBeta, Integer> NumberCol = new TableColumn<>("Number");
        NumberCol.setMinWidth(20);
        NumberCol.setCellValueFactory(new PropertyValueFactory<>("Number"));
        TableColumn<PlayerInfoBeta, Double> SalaryCol = new TableColumn<>("Salary");
        SalaryCol.setMinWidth(40);
        SalaryCol.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        tableView.getColumns().addAll(NameCol,CountryCol,AgeCol,HeightCol,ClubCol,PositionCol,NumberCol,SalaryCol);
    }
    public void load() throws Exception{
        if (in) {
            initializeColumns();
            in = false;
        }

        List = PlayerInfoBeta.getObservablePlayerlsit(temp);
        tableView.setEditable(true);
        tableView.setItems(List);
    }
    void setMain(Main main) {
        this.main = main;
    }

    public void setTemp(java.util.List<PlayerInfo> temp) {
        this.temp = temp;
    }

    public void Back(ActionEvent actionEvent) {
        try {
            main.showMainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Info(ActionEvent actionEvent) {
        Object obj=tableView.getSelectionModel().getSelectedItem();
        try {
            main.showPlayerInfo((PlayerInfoBeta) obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}