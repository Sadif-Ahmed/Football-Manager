package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class LoginController {

    private Main main;
    private NetworkUtil networkUtil;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    void Submit(ActionEvent event)throws Exception {
        String clubName= userText.getText();
        String password = passwordText.getText();
        if(!(clubName.equalsIgnoreCase("Liverpool")||clubName.equalsIgnoreCase("Chelsea")||clubName.equalsIgnoreCase("Arsenal")||clubName.equalsIgnoreCase("Manchester United")||clubName.equalsIgnoreCase("Manchester City")))
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Club Log In Window");
            a.setContentText("Wrong Club. Take a while and try to remember the ClubName.");
            a.showAndWait();
        }
        else
        {
            if (password.equalsIgnoreCase("123")) {
                String str = userText.getText();
                main.setClientName(str);

                Club club = new Club(str);
                Object obj;
                try {
                    System.out.println("Writing ...");
                    networkUtil.write(club);
                    System.out.println("Done. Reading..");
                    obj = networkUtil.read();
                    if (obj instanceof Club) {
                        System.out.println("Done");
                        club = (Club) obj;
                        main.setPlayers((ArrayList<PlayerInfo>) club.getPlayers());
                        main.showMainMenu();


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Club Log In Window");
                a.setContentText("Wrong Password. Take a while and try to remember the password.");
                a.showAndWait();
            }
        }
    }

    @FXML
    void Reset(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void setNetworkUtil(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }
}
