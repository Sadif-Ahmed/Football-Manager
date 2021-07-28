package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Country {
    private SimpleStringProperty Name;
    private SimpleIntegerProperty NumberOfPlayers;
    Country(String name,int number)
        {
        this.Name=new SimpleStringProperty(name);
        this.NumberOfPlayers=new SimpleIntegerProperty(number);
    }

    public String getName() {
        return Name.get();
    }

    public int getNumberOfPlayers() {
        return NumberOfPlayers.get();
    }
}
