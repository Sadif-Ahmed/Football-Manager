package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class PlayerInfoBeta {
    private SimpleStringProperty Name;
    private SimpleStringProperty Country;
    private SimpleIntegerProperty Age;
    private SimpleDoubleProperty Height;
    private SimpleStringProperty Club;
    private SimpleStringProperty Position;
    private SimpleIntegerProperty Number;
    private SimpleDoubleProperty Salary;
    PlayerInfoBeta(PlayerInfo Player)
    {
        this.Name = new SimpleStringProperty(Player.getName());
        this.Country = new SimpleStringProperty(Player.getCountry());
        this.Club = new SimpleStringProperty(Player.getClub());
        this.Age = new SimpleIntegerProperty(Player.getAge());
        this.Height = new SimpleDoubleProperty(Player.getHeight());
        this.Position= new SimpleStringProperty(Player.getPosition());
        this.Number = new SimpleIntegerProperty(Player.getNumber());
        this.Salary = new SimpleDoubleProperty(Player.getSalary());
    }
       public  void setName(String name) {Name.set(name);
    }

    public void setSalary(double salary) {
        Salary.set(salary);
    }

    public void setAge(int age) {
        Age.set(age);
    }

    public void setClub(String club) {
        Club.set(club);
    }

    public void setCountry(String country) {
        Country.set(country);
    }

    public void setHeight(double height) {
        Height.set(height);
    }

    public void setNumber(int number) {
        Number.set(number);
    }

    public void setPosition(String position) {
        Position.set(position);
    }

    public double getSalary() {
        return Salary.get();
    }

    public int getAge() {
        return Age.get();
    }

    public double getHeight() {
        return Height.get();
    }

    public int getNumber() {
        return Number.get();
    }

    public String getClub() {
        return Club.get();
    }

    public String getCountry() {
        return Country.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getPosition() {
        return Position.get();
    }

    public static ObservableList<PlayerInfoBeta> getObservablePlayerlsit(List<PlayerInfo> Players){
        ObservableList<PlayerInfoBeta> Searchlist =
                FXCollections.observableArrayList();
        for(int i=0;i<Players.size();i++)
        {
            Searchlist.add(new PlayerInfoBeta(Players.get(i)));
        }
        return Searchlist;
    }
    public static ObservableList<Country> getCountryPlayerlsit(List<PlayerInfo> Players,int [] count){
        ObservableList<Country> Searchlist =
                FXCollections.observableArrayList();
        for(int i=0;i<Players.size();i++)
        {
            Searchlist.add(new Country(Players.get(i).getCountry(),count[i]));
        }
        return Searchlist;
    }

    @Override
    public String toString() {
        return "PlayerInfoBeta{" +
                "Name=" + Name +
                ", Country=" + Country +
                ", Age=" + Age +
                ", Height=" + Height +
                ", Club=" + Club +
                ", Position=" + Position +
                ", Number=" + Number +
                ", Salary=" + Salary +
                '}';
    }
}
