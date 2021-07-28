package sample;
import java.util.ArrayList;
import java.util.List;

public class ClubSearch {
    public static List<PlayerInfo> Search_Club_Highest_Salary(String Club, List<PlayerInfo> Players) {
        int i;
        double max = 0;
        List<PlayerInfo> SearchList = new ArrayList();
        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getSalary() >= max) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                max = Players.get(i).getSalary();
            }
        }
        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club) && (Players.get(i).getSalary() == max)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_Club_Max_Age(String Club, List<PlayerInfo> Players) {
        int i;
        double max = 0;
        List<PlayerInfo> SearchList = new ArrayList();
        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getAge() >= max) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                max = Players.get(i).getAge();
            }
        }
        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club) && (Players.get(i).getAge() == max)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_Club_Max_Height(String Club, List<PlayerInfo> Players) {
        int i;
        double max = 0;
        List<PlayerInfo> SearchList = new ArrayList();
        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getHeight() >= max) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                max = Players.get(i).getHeight();
            }
        }
        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club) && (Players.get(i).getHeight() == max)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static double Yearly_Club_Salary(String Club, List<PlayerInfo> Players) {
        int i;
        double salary = 0;

        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club)) {
                salary += Players.get(i).getSalary();
            }
        }
        salary *= 52;
        return salary;
    }

}
