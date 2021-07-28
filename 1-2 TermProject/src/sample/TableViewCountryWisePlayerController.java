package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class TableViewCountryWisePlayerController {
    @FXML
    private TableView tableView;

    ObservableList<Country> List;
    List<PlayerInfo> SearchList1 = new ArrayList();
    Club club =new Club();

    private Main main;


    private boolean init = true;

    private void initializeColumns() {
        TableColumn<Country, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(60);
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Country, Integer> CountCol = new TableColumn<>("Number of Players");
        CountCol.setMinWidth(40);
        CountCol.setCellValueFactory(new PropertyValueFactory<>("NumberOfPlayers"));
        tableView.getColumns().addAll(NameCol,CountCol);
    }
    public void load() throws Exception{
        if (init) {
            initializeColumns();
            init = false;
        }
        SearchList1=SearchingPlayer.Country_list(club.Players);
        int [] count=SearchingPlayer.Country_PlayerCount(SearchList1,club.Players);
        List=PlayerInfoBeta.getCountryPlayerlsit(SearchList1,count);
        tableView.setEditable(true);
        tableView.setItems(List);
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
}
