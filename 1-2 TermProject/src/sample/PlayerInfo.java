package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
    private String Name;
    private String Country;
    private  int Age;
    private double Height;
    private  String Club;
    private String Position;
    private int Number;
    private double Salary;
    private double Price;
    PlayerInfo(String name,String country,int age,double height,String club,String position,int number,double salary)
    {
        Name=name;
        Country=country;
        Club=club;
        Age=age;
        Height=height;
        Position=position;
        Number=number;
        Salary=salary;
    }
    PlayerInfo(PlayerInfoBeta Player)
    {
        this.Name =Player.getName();
        this.Country =Player.getCountry();
        this.Club =Player.getClub();
        this.Age =Player.getAge();
        this.Height =Player.getHeight();
        this.Position=Player.getPosition();
        this.Number = Player.getNumber();
        this.Salary = Player.getSalary();
    }
    PlayerInfo()
    {

    }
    public  void setName(String name) {
        Name = name;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setClub(String club) {
        Club = club;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public double getSalary() {
        return Salary;
    }

    public int getAge() {
        return Age;
    }

    public double getHeight() {
        return Height;
    }

    public int getNumber() {
        return Number;
    }

    public String getClub() {
        return Club;
    }

    public String getCountry() {
        return Country;
    }

    public String getName() {
        return Name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getPrice() {
        return Price;
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                ", Age=" + Age +
                ", Height=" + Height +
                ", Club='" + Club + '\'' +
                ", Position='" + Position + '\'' +
                ", Number=" + Number +
                ", Salary=" + Salary +
                ", Price=" + Price +
                '}';
    }
}


