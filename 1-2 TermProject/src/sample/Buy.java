package sample;

import java.io.Serializable;
import java.util.ArrayList;

class Buy implements Serializable {
     private ArrayList<PlayerInfo> availablePlayers;
     private String desiredPlayerName;
     private String sellerClient;
     private String buyerClient;
     private int state;
     private PlayerInfo desiredPlayer;

     public PlayerInfo getDesiredPlayer() {
          return desiredPlayer;
     }

     public void setDesiredPlayer(PlayerInfo desiredPlayer) {
          this.desiredPlayer = desiredPlayer;
     }

     public void AddPlayer(PlayerInfo a)
     {
          availablePlayers.add(a);


     }
     public int getState() {
          return state;
     }

     public void setState(int state) {
          this.state = state;
     }

     public String getSellerClient() {
          return sellerClient;
     }

     public void setSellerClient(String sellerClient) {
          this.sellerClient = sellerClient;
     }

     Buy()
     {
          availablePlayers=new ArrayList<>();

     }

     public String getBuyerClient() {
          return buyerClient;
     }

     public void setBuyerClient(String buyerClient) {
          this.buyerClient = buyerClient;
     }

     public String getDesiredPlayerName() {
          return desiredPlayerName;
     }

     public void setDesiredPlayerName(String desiredPlayerName) {
          this.desiredPlayerName = desiredPlayerName;
     }

     public ArrayList<PlayerInfo> getAvailablePlayers() {
          return availablePlayers;
     }

     public void setAvailablePlayers(ArrayList<PlayerInfo> availablePlayers) {
          this.availablePlayers = availablePlayers;
     }

     @Override
     public String toString() {
          return "Buy{" +
                  "availablePlayers=" + availablePlayers +
                  ", desiredPlayerName='" + desiredPlayerName + '\'' +
                  ", sellerClient='" + sellerClient + '\'' +
                  ", buyerClient='" + buyerClient + '\'' +
                  ", state=" + state +
                  ", desiredPlayer=" + desiredPlayer +
                  '}';
     }
}
