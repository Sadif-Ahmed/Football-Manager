package sample;
import java.util.ArrayList;
import java.util.List;

public class SearchingPlayer{
    public static List<PlayerInfo> Search_by_Name(String name, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();

        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getName().equalsIgnoreCase(name)) {
                SearchList.add(Players.get(i));
                break;
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_by_Position(String Position, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();


        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getPosition().equalsIgnoreCase(Position)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_by_SalaryRange(double minSalary, double maxSalary, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();


        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getSalary() > minSalary) && (Players.get(i).getSalary() < maxSalary)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }
    public static List<PlayerInfo>  Country_list(List<PlayerInfo> Players) {
        List<PlayerInfo> SearchList = new ArrayList();
        SearchList.add(Players.get(0));
        for(int i=0;i< Players.size();i++)
        {
            boolean Repeater=false;
            for (int j = 0; j <= (SearchList.size()-1); j++) {
                if(SearchList.get(j).getCountry().equalsIgnoreCase(Players.get(i).getCountry()))
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

    public static int [] Country_PlayerCount(List<PlayerInfo> Countrylist,List<PlayerInfo> Players) {
        int [] country_count=new int[Countrylist.size()];
        for (int i = 0; i < Countrylist.size(); i++) {
            for(int j=0;j<Players.size();j++)
            {
                if(Countrylist.get(i).getCountry().equalsIgnoreCase(Players.get(j).getCountry()))
                {
                    country_count[i]++;
                }
            }
        }
        return country_count;
    }

    public static List<PlayerInfo> Search_by_Club_and_Country(String Country, String Club, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();
        if (Club.equalsIgnoreCase("ANY")) {
            for (i = 0; i < Players.size(); i++) {
                if (Players.get(i).getCountry().equalsIgnoreCase(Country)) {
                    SearchList.add(Players.get(i));
                }
            }
        } else {
            for (i = 0; i < Players.size(); i++) {
                if (Players.get(i).getCountry().equalsIgnoreCase(Country) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                    SearchList.add(Players.get(i));
                }
            }
        }
        return SearchList;
    }

}
