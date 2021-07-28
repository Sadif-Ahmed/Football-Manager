package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;

public class ControllerSell implements Initializable {
    private Main main;
    ArrayList<PlayerInfo> players;
    private clientThread clientthread;

    public clientThread getClientthread() {
        return clientthread;
    }

    public void setClientthread(clientThread clientthread) {
        this.clientthread = clientthread;
    }

    void setList(ArrayList<PlayerInfo> players)
    {
        this.players=players;
    }

    void SetMain(Main main)
    {
        this.main=main;
    }


    @FXML
    private Button sell;
    @FXML
    private TableView<PlayerInfo> totaltable;

    @FXML
    private TableColumn<PlayerInfo, String> Name;

    @FXML
    private TableColumn<PlayerInfo, String> Country;

    @FXML
    private TableColumn<PlayerInfo, Integer> Age;

    @FXML
    private TableColumn<PlayerInfo, Double> Height;

    @FXML
    private TableColumn<PlayerInfo, String> Club;

    @FXML
    private TableColumn<PlayerInfo, String> Position;

    @FXML
    private TableColumn<PlayerInfo, Integer> Number;

    @FXML
    private TableColumn<PlayerInfo, Double> Salary;



    @FXML
    private Button back;


    @FXML
    private Label label;
    @FXML
    private Button showList;
    ObservableList<PlayerInfo> list= FXCollections.observableArrayList();

    @FXML
    void Back(ActionEvent event)throws Exception {
       main.showMainMenu();
    }

    @FXML
    void Showlist(ActionEvent event) {
        for(PlayerInfo a:players)
            list.remove(a);
        System.out.println("pressed");
        if(players==null)
            main.showAlert1();
        else {
            int flag=0;
            for (PlayerInfo a : players) {
                System.out.println(a);
                flag=0;
                for (Sell b:main.getSellrequest()) {
                    if (b.getPlayerName().equals(a.getName())) {
                        flag = -1;
                        break;
                    }
                }
                    if(flag==0) {
                        list.add(a);
                        System.out.println(a);
                    }
                }
            }
            Name.setCellValueFactory(new PropertyValueFactory<PlayerInfo, String>("Name"));
            Country.setCellValueFactory(new PropertyValueFactory<PlayerInfo, String>("Country"));
            Age.setCellValueFactory(new PropertyValueFactory<PlayerInfo, Integer>("Age"));
            Height.setCellValueFactory(new PropertyValueFactory<PlayerInfo, Double>("Height"));
            Club.setCellValueFactory(new PropertyValueFactory<PlayerInfo, String>("Club"));
            Position.setCellValueFactory(new PropertyValueFactory<PlayerInfo, String>("Position"));
            Number.setCellValueFactory(new PropertyValueFactory<PlayerInfo, Integer>("Number"));
            Salary.setCellValueFactory(new PropertyValueFactory<PlayerInfo, Double>("Salary"));
            totaltable.setItems(list);
        }


    @FXML
    void sellbtn(ActionEvent event) {
        try {
            System.out.println("pressed sell button");
            Object obja=totaltable.getSelectionModel().getSelectedItem();

            String str1 =((PlayerInfo) obja).getName();
            String str ="100";


                    Sell sell = new Sell();
                    int flag = 0;
                    for (PlayerInfo a : players) {
                        if (a.getName().equals(str1)) {
                            flag++;
                            sell.setClientName(a.getClub());
                            sell.setPlayer(a);
                            sell.setPlayerName(a.getName());
                            sell.setPrice(Double.parseDouble(str));
                        }
                    }
                    if (flag == 0)
                        System.out.println("Writing ....");
                    main.Addsell(sell);
            clientthread.setObj(sell);
            System.out.println("done writting");
                    System.out.println("writing done from client side of sell class");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }


    public void Info(ActionEvent actionEvent) {
        Object obj=totaltable.getSelectionModel().getSelectedItem();
        try {
            main.showPlayerInfo((PlayerInfoBeta) obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
