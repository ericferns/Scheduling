import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class InputJson {
    public Map<String, String> room_no, timeslot;
    public JSONArray course, times;
    public void getJsonData() {
        JSONParser parser = new JSONParser();
        room_no = new HashMap<>();
        timeslot = new HashMap<>();
        try {
            Object obj = parser.parse(new FileReader("course.json"));
            JSONObject jsonObject = (JSONObject) obj;
            room_no = (HashMap<String, String>) jsonObject.get("rooms");
            course = (JSONArray) jsonObject.get("courses");
            times = (JSONArray) jsonObject.get("times");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0; i< times.size(); i++){
            timeslot.put((String)times.get(i), null);
        }
    }
}