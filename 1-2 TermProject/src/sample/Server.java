package sample;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

class Server {
     private ServerSocket serverSocket;
     public HashMap<String, NetworkUtil> clientMap;


    ArrayList<PlayerInfo> Players;
    ArrayList<Sell> sellList;
    ArrayList<Club> Clubs;

    public ArrayList<PlayerInfo> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<PlayerInfo> players) {
        Players = players;
    }

    Server() throws Exception{
        sellList=new ArrayList<>();
        clientMap=new HashMap<>();
         Players = new ArrayList<>(1000);
         Players= (ArrayList<PlayerInfo>) FileInputOutput.readFromFile();
         Clubs= (ArrayList<Club>) Main.RefreshedClubList(Players);

         //clientMap = new HashMap<>();
         try {
             serverSocket = new ServerSocket(33355);
             while (true) {
                 Socket clientSocket = serverSocket.accept();
                 serve(clientSocket);
             }
         } catch (Exception e) {
             System.out.println("server.Server starts:" + e);
         }
     }

     public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
         NetworkUtil networkUtil = new NetworkUtil(clientSocket);
         new ReadThreadServer(clientMap, networkUtil,this,sellList);
     }
     public static void main(String [] args)throws Exception
     {
         Server server=new Server();
     }

    public ArrayList<Club> getClubs() {
        return Clubs;
    }
}
