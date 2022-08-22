import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class TimeAllotment {
    public static void timeAllotment(Map<String, String> timeslot, String[][] course_cat) {

        for (String[] course : course_cat) {
            boolean flag = false;
            if (course[0] == null)
                break;

            if (course[2] != null) {
                String[] pref = course[2].split(";");
                String[] prefStrip = new String[pref.length];


                for (int i = 0; i < pref.length; i++) {
                    prefStrip[i] = pref[i].strip();
                }

                for (String str : prefStrip) {
                    for (Map.Entry<String, String> set : timeslot.entrySet()) {
                        if (Objects.equals(set.getKey(), str) && course[2] != null) {
                            if (set.getValue() == null) {
                                timeslot.put(set.getKey(), course[0]);
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag)
                        break;
                }
            }
            else {
                for (Map.Entry<String, String> set : timeslot.entrySet()) {
                        if (set.getValue() == null) {
                            timeslot.put(set.getKey(), course[0]);
                            break;
                        }
                }
            }
        }
    }
}
