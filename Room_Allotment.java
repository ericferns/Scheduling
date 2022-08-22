import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class Room_Allotment {
    public static ArrayList<ArrayList<String>>alloted_rooms = new ArrayList<ArrayList<String>>();

    public static void bestFit(Map<String, String> rooms, String[][] course_cat){
        int lowest, temp, i= alloted_rooms.size();
        for (String[] course: course_cat) {
            if(course[0] == null)
                continue;
            lowest = 999;
            for (Map.Entry<String, String> set :rooms.entrySet()) {
                if(course[1] != null) {
                    temp = Integer.parseInt(set.getValue().strip()) - Integer.parseInt(course[1].strip());
                    if(temp>=0) {
                        if (lowest > temp){
                            ArrayList<String> temp_AL = new ArrayList<>(Arrays.asList(course[0], set.getKey()));
                            if(lowest == 999)
                               alloted_rooms.add(temp_AL);
                            else
                                alloted_rooms.set(i, temp_AL);
                            lowest = temp;
                        }
                    }
                }
            }
            i++;
        }
        System.out.println(alloted_rooms);
    }
}

