package sample;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutput {
    final private static String TEXTFILE="players.txt";
    public static List<PlayerInfo> readFromFile() throws Exception {
        List<PlayerInfo> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(TEXTFILE));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            PlayerInfo p = new PlayerInfo();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setSalary(Double.parseDouble(tokens[7]));
            PlayerList.add(p);
        }
        br.close();
        return PlayerList;
    }
    public static void writeToFile(List<PlayerInfo> Players) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(TEXTFILE));

        for(int i=0;i<Players.size();i++) {
            bw.write(Players.get(i).getName() + "," + Players.get(i).getCountry() + "," + Players.get(i).getAge() + "," + Players.get(i).getHeight() + "," + Players.get(i).getClub() + "," + Players.get(i).getPosition() + "," + Players.get(i).getNumber() + "," + Players.get(i).getSalary());
            bw.write("\n");
        }
        bw.close();
    }
    public static List<Club>  Club_List_update(List<PlayerInfo> Players)
    {    List<Club> Clublist = new ArrayList();
        for(int i=0;i<Players.size();i++)
        {   Club temp= new Club();
            temp.setId(i+1);
            temp.setName(Players.get(i).getClub());
            Clublist.add(temp);
        }
        return Clublist;
    }
    public static void Add_to_Clublist(List<Club> Clublist,List<PlayerInfo> Players)
    {
        for(int i=0;i<Players.size();i++)
        {
            for(int j=0;j<Clublist.size();j++)
            {
                if(Clublist.get(j).getName().equalsIgnoreCase(Players.get(i).getClub()))
                {
                    Clublist.get(j).addPlayer(Players.get(i));
                }
            }
        }
    }
    public static Club Search_Club(String ClubName,List<Club> Clublist)
    {
        Club Ret=new Club();
        for(int i=0;i<Clublist.size();i++)
        {
            if(Clublist.get(i).getName().equalsIgnoreCase(ClubName))
            {
                Ret=Clublist.get(i);
            }
        }
        return Ret;
    }
    public static List<PlayerInfo>  Club_list(List<PlayerInfo> Players) {
        List<PlayerInfo> SearchList = new ArrayList();
        SearchList.add(Players.get(0));
        for(int i=0;i< Players.size();i++)
        {
            boolean Repeater=false;
            for (int j = 0; j <= (SearchList.size()-1); j++) {
                if(SearchList.get(j).getClub().equalsIgnoreCase(Players.get(i).getClub()))
                {
                    Repeater = true;
                    break;
                }
            }
            if(Repeater == false)
            {

                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

}
