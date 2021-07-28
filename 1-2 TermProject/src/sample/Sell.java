package sample;

import java.io.Serializable;

public class Sell implements Serializable {
    private String playerName;
    private String clientName;
    private  PlayerInfo player;




    Sell()
    {

    }
    Sell(String clientName)
    {
        this.clientName=clientName;

    }
    public void setPrice(Double price)
    {
        player.setPrice(price);

    }
    public String getPlayerName() {
        return playerName;
    }

    public PlayerInfo getPlayer() {
        return player;
    }

    public void setPlayer(PlayerInfo player) {
        this.player = player;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


}
