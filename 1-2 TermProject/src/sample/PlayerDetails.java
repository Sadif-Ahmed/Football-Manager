package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerDetails {
    @FXML
    public Label Age;
    @FXML
    public Label Height;

    public sample.Club getClub() {
        return club;
    }

    public void setClub(sample.Club club) {
        this.club = club;
    }

    private Club club;

    public PlayerInfoBeta getPlayer() {
        return Player;
    }

    public void setPlayer(PlayerInfoBeta player) {
        Player = player;
    }

    public PlayerInfoBeta Player;
    private Main main;

    @FXML
    private Label Name;

    @FXML
    private Label Club;

    @FXML
    private Label Country;

    @FXML
    private Label Position;

    @FXML
    private Label Number;

    @FXML
    private Label Salary;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
    public void Work()
    {
        Name.setText(Player.getName());
        Club.setText(Player.getClub());
        Country.setText(Player.getCountry());
        Position.setText(Player.getPosition());
        Number.setText(String.valueOf(Player.getNumber()));
        Salary.setText(String.valueOf(Player.getSalary()));
        Age.setText(String.valueOf(Player.getAge()));
        Height.setText(String.valueOf(Player.getHeight()));
    }

    public void Back(ActionEvent actionEvent) {
        try {
            main.ShowSearchResult(club.getPlayers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
