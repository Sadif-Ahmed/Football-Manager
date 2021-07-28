package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    ArrayList<PlayerInfo> Players;
    private String clientName;
    NetworkUtil networkUtil;
    ArrayList<Sell> sellrequest;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        sellrequest=new ArrayList<>();

        try {
            this.networkUtil=new NetworkUtil("127.0.0.1",33355);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientthread=new clientThread(networkUtil,this);

        showLoginPage();
    }
    public void Addsell(Sell sell)
    {
        sellrequest.add(sell);

    }
    public void showAlert1() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The Player you entered is not in this club.");
        alert.showAndWait();
    }
    public ArrayList<Sell> getSellrequest() {
        return sellrequest;
    }

    public void setSellrequest(ArrayList<Sell> sellrequest) {
        this.sellrequest = sellrequest;
    }
    private clientThread clientthread;
    public String getClientName() {
        return clientName;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public Club refresh(){
        Club temp=new Club(clientName);

        try {
            networkUtil.write(temp);
            System.out.println("written");
            Object o=networkUtil.read();
            if(o instanceof Club)
            {
                temp=(Club) o;
                setPlayers((ArrayList<PlayerInfo>) temp.getPlayers());
                System.out.println("end");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public ArrayList<PlayerInfo> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<PlayerInfo> players) {
        Players = players;
    }
    public void showSell()
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Sell.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerSell controller = loader.getController();
        controller.SetMain(this);
        controller.setClientthread(clientthread);
        controller.setList(Players);

        // Set the primary stage
        stage.setTitle("Selling Page");
        stage.setScene(new Scene(root, 750, 450));
        stage.show();

    }
    public void showbuy()
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Buy.fxml"));
        Parent root=null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Loading the controller
        ControllerBuy controller = loader.getController();
        controller.SetMain(this);
        controller.setList(Players);
        controller.setClientthread(clientthread);
        // Set the primary stage
        stage.setTitle("Buying Page");
        stage.setScene(new Scene(root, 700, 450));
        stage.show();

    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);
        controller.setNetworkUtil(this.networkUtil);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 475, 400));
        stage.show();
    }
    public void showMainMenu() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Main_Menu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        MainMenu controller = loader.getController();
        controller.setClub(refresh());
        controller.Club.setText(refresh().getName());
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }


    public void ShowNameInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Name_Input.fxml"));
        Parent root = loader.load();

        // Loading the controller
       NameInput controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Name Input");
        stage.setScene(new Scene(root, 400, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubCountryInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Club_Country_input.fxml"));
        Parent root = loader.load();

        // Loading the controller
        ClubCountryInput controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Club and Country Input");
        stage.setScene(new Scene(root, 400, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowPositionInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Position_Input.fxml"));
        Parent root = loader.load();

        // Loading the controller
       PositionInput controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Position Input");
        stage.setScene(new Scene(root, 400, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowSalaryRangeInput() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Salary_Range_Input.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SalaryRangeInput controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Salary Range Input");
        stage.setScene(new Scene(root, 400, 400));
        stage.setResizable(false);
        stage.show();
    }


    public void ShowPlayerNameSearchResult(String name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewPlayerName.fxml"));
        Parent root = loader.load();

        TableViewPlayerNameController controller = loader.getController();
        controller.setName(name);
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Player Name Search Result");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubCountryNameSearchResult(String Country_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubCountryname.fxml"));
        Parent root = loader.load();

        TableViewClubCountryNameController controller = loader.getController();
        controller.setCountry_Name(Country_name);
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Country Search Result");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowPositionNameSearchResult(String position_name) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewPositionName.fxml"));
        Parent root = loader.load();

       TableViewPositionNameController controller = loader.getController();
        controller.setPosition_Name(position_name);
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Position Name Search Result");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowSalaryRangeNameSearchResult(double min_range,double max_range) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewSalaryRangeName.fxml"));
        Parent root = loader.load();

        TableViewSalaryRangeNameController controller = loader.getController();
        controller.setMin_Range(min_range);
        controller.setMax_Range(max_range);
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Salary Range Player Search Result");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowCountryWisePlayerCountSearchResult() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewCountryWisePlayer.fxml"));
        Parent root = loader.load();

        TableViewCountryWisePlayerController controller = loader.getController();
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Country Wise Player Count");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubMaxSalarySearchResult() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubMaxSalary.fxml"));
        Parent root = loader.load();

        TableViewClubMaxSalaryController controller = loader.getController();
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Maximum Salary Player");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubMaxAgeSearchResult() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubMaxAge.fxml"));
        Parent root = loader.load();

        TableViewClubMaxAgeController controller = loader.getController();
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Maximum Age Player");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubMaxHeightSearchResult() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableViewClubMaxHeight.fxml"));
        Parent root = loader.load();

        TableViewClubMaxHeightController controller = loader.getController();
        controller.setClub(refresh());
        controller.load();
        controller.setMain(this);
        stage.setTitle("Maximum Height Player");
        stage.setScene(new Scene(root, 700, 300));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowClubTotalSalary() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TotalClubSalaryOutput.fxml"));
        Parent root = loader.load();

        TotalClubSalaryOutput controller = loader.getController();
        controller.setClub(refresh());
        controller.work();
        controller.setMain(this);
        stage.setTitle("Total Salary");
        stage.setScene(new Scene(root, 477, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void ShowGratitude() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Thank_You.fxml"));
        Parent root = loader.load();
        ThankYou controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Gratitude");
        stage.setScene(new Scene(root, 300, 400));
        stage.setResizable(false);
        stage.show();
        Thread.sleep(600);
        System.exit(0);
    }
    public static List<Club> RefreshedClubList(ArrayList<PlayerInfo> Players)throws Exception
    {
        List<Club> Clubs;
        List<PlayerInfo> Search_list;
        Search_list=FileInputOutput.Club_list(Players);
        Clubs=FileInputOutput.Club_List_update(Search_list);
        FileInputOutput.Add_to_Clublist(Clubs,Players);
        return Clubs;

    }
    public void ShowSearchResult(List<PlayerInfo>PlayerList) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TableView.fxml"));
        Parent root = loader.load();

        TableViewController controller = loader.getController();
        controller.setTemp(PlayerList);
        controller.setMain(this);
        controller.load();
        stage.setTitle("Search Result");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    public void showPlayerInfo(PlayerInfoBeta player) throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerDetails.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlayerDetails controller = loader.getController();
        controller.setPlayer(player);
        controller.setClub(refresh());
        controller.setMain(this);
        controller.Work();

        // Set the primary stage
        stage.setTitle("Player Info Page");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }

}
