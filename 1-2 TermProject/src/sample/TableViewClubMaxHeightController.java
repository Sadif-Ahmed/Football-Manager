package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TableViewClubMaxHeightController {
    @FXML
    private TableView tableView;

    ObservableList<PlayerInfoBeta> List;
   Club club;
    private Main main;

    private boolean init = true;

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
        if (init) {
            initializeColumns();
            init = false;
        }
        List = PlayerInfoBeta.getObservablePlayerlsit(ClubSearch.Search_Club_Max_Height(club.getName(),club.Players));
        tableView.setEditable(true);
        tableView.setItems(List);
        if(ClubSearch.Search_Club_Max_Height(club.getName(),club.getPlayers()).size()==0)
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Club Maximum Height Window");
            a.setContentText("No Player In The Search Criteria.");
            a.showAndWait();
        }
    }

    public void Back(ActionEvent actionEvent)throws Exception {
        main.showMainMenu();

    }
    void setMain(Main main) {
        this.main = main;
    }

    public void setClub(Club club) {
        this.club = club;
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