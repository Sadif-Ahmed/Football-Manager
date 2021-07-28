package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerBuy implements Initializable {
private clientThread clientthread;
    private Main main;
    ArrayList<PlayerInfo> players;

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
        temporary=new ArrayList<>();
        this.main=main;
    }


    @FXML
    private Button buy;
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
    private Buy buyobj;
    ArrayList<PlayerInfo> temporary;

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

        System.out.println("Entering showlist");
        list.removeAll(temporary);
Buy buy=new Buy();
buy.setState(0);
buy.setBuyerClient(main.getClientName());


Object obj=null;
        try {
            System.out.println("writting");
            clientthread.setObj(buy);
            System.out.println("reading");
            obj=null;
            while (obj==null)
             obj=clientthread.getFinalobj();
            clientthread.setFinalobj(null);
            System.out.println("reading done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(obj instanceof Buy) {
            System.out.println("entered");
            Buy ob1 = (Buy) obj;
            ob1.setState(2);
            buyobj=ob1;
            System.out.println("my query");
            for(PlayerInfo a:ob1.getAvailablePlayers())
                System.out.println(a);
            System.out.println("halfway there");
            int flag=0;
            for (PlayerInfo a :ob1.getAvailablePlayers())
            {
                flag=0;
                for(PlayerInfo b:list)
                {

                    if(b.getName().equals(a.getName()))
                    {
                        flag=-1;
                        break;
                    }
                }
                if(flag==0) {
                    list.add(a);
                    temporary.add(a);
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

        }




    @FXML
    void buybutton(ActionEvent event) {

                PlayerInfo obja=totaltable.getSelectionModel().getSelectedItem();
                String str=obja.getName();
               buyobj.setDesiredPlayerName(str);
        System.out.println(buyobj);

        try {

            clientthread.setObj(buyobj);
            Object o=null;
            while (o==null)
                o=clientthread.getFinalobj();
            clientthread.setFinalobj(null);
            if(o instanceof Buy)
            {
                System.out.println("final object received");
                buyobj=(Buy) o;
                if(buyobj.getBuyerClient().equals(main.getClientName()))
                {
                    System.out.println("reached");
                   ArrayList<PlayerInfo> temp= main.getPlayers();
                   temp.add(buyobj.getDesiredPlayer());
                    System.out.println("Done adding");
                }
            }
        } catch (Exception e) {
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
