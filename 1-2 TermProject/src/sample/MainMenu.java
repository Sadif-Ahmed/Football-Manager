package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenu {
    public Label Club;
    private Main main;
    private Club club;
    @FXML
    private String Club_name;
    void setMain(Main main) {
        this.main = main;
    }

    public void setClub_name(String club_name) {
        Club_name = club_name;
    }
    public void Player_name(ActionEvent actionEvent) throws Exception {
        main.ShowNameInput();
    }
    public void Club_Country(ActionEvent actionEvent) throws Exception{
        main.ShowClubCountryInput();
    }

    public void Position(ActionEvent actionEvent) throws Exception{
        main.ShowPositionInput();
    }

    public void salary_range(ActionEvent actionEvent) throws Exception{
        main.ShowSalaryRangeInput();
    }

    public void country_player_count(ActionEvent actionEvent) throws Exception{
        main.ShowCountryWisePlayerCountSearchResult();
    }

    public void max_salary(ActionEvent actionEvent) throws Exception{
        main.ShowClubMaxSalarySearchResult();
    }

    public void max_age(ActionEvent actionEvent) throws Exception{
        main.ShowClubMaxAgeSearchResult();
    }

    public void max_height(ActionEvent actionEvent) throws Exception{
        main.ShowClubMaxHeightSearchResult();
    }

    public void total_salary(ActionEvent actionEvent) throws Exception{
        main.ShowClubTotalSalary();
    }
    public void buy(ActionEvent actionEvent) {
        main.showbuy();
    }

    public void sell(ActionEvent actionEvent) {
        main.showSell();
    }
    public void Save_Exit(ActionEvent actionEvent)throws Exception {
        main.ShowGratitude();
    }

    public void setClub(sample.Club club) {
        this.club = club;
    }

    public void my_players(ActionEvent actionEvent) throws Exception {
        main.ShowSearchResult(club.Players);
    }
}
