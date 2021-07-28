package sample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable {
    private int id;
    private String name;
    List<PlayerInfo> Players = new ArrayList();
    private int playerCount;
    // add your code here

    // you are not allowed to write any other constructor
    public Club() {
    }
    public Club(String name)
    {
        this.name=name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public int getId()
    {
        return this.id;
    }
    public void addPlayer(PlayerInfo obj)
    {
       Players.add(obj);
    }
    public List<PlayerInfo> getPlayers() {
        return Players;
    }

    public void setPlayers(List<PlayerInfo> players) {
        Players = players;
    }
}
