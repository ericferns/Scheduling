import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        InputCsv inputCsv = new InputCsv();
        InputJson inputJson = new InputJson();

        inputCsv.getCsvData();
        inputJson.getJsonData();

        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course1);
        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course2);
        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course3);
        Room_Allotment.bestFit(inputJson.room_no, inputCsv.course4);

        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course1);
        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course2);
        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course3);
        TimeAllotment.timeAllotment(inputJson.timeslot, inputCsv.course4);

        String[][] timeTable= new String[inputJson.room_no.size()+1][inputJson.timeslot.size()+1];//5+1 8+1

        System.out.println("\n\t\t\t\t\t\t\tTimeTable\n");

        //initializing timetable
        int i=1;
        timeTable[0][0]=" ";
        for (Map.Entry<String, String> set : inputJson.timeslot.entrySet()) //making x axis
        {
            timeTable[0][i]= set.getKey();
            i++;
        }
        i=1;
        for (Map.Entry<String, String> set : inputJson.room_no.entrySet()) {
            timeTable[i][0]= set.getKey();
            i++;
        }

        for(int a=1;a<inputJson.timeslot.size()+1;a++)// giving default values
        {
            for(int b=1;b<inputJson.room_no.size()+1;b++)
            {
                timeTable[b][a]="  -  ";
            }
        }
        // initializing over

        // filling timetable
        int a=1;//a rows
        boolean flag=false;

        for (ArrayList<String> set :Room_Allotment.alloted_rooms) {
            for(int j=0;j<inputJson.room_no.size()+1;j++) {
                if (Objects.equals(timeTable[j][0], set.get(1))) {
                    for (Map.Entry<String, String> time : inputJson.timeslot.entrySet()) {
                        if (Objects.equals(time.getKey(), timeTable[0][a]) && time.getValue()==set.get(0)) {
                            timeTable[j][a] = set.get(0);
                            flag = true;
                            a=1;
                            break;
                        }
                        a++;
                    }
                }
                if (flag) {
                    flag=false;
                    break;
                }
            }
        }

        //printing timetable
        for (int j=0;j<inputJson.room_no.size()+1;j++)
        {
            for(int k=0;k<inputJson.timeslot.size()+1;k++)
            {
                if(j==0) {
                    if (k == 0)
                        System.out.print("  " + timeTable[j][k] + "  ");
                    else
                        System.out.print(timeTable[j][k] + "    ");
                }
                else {
                    if(k>=inputJson.timeslot.size()-2)
                        System.out.print(timeTable[j][k] + "     ");
                    else
                        System.out.print(timeTable[j][k] + "   ");
                }
            }
            System.out.println();
        }

    }
}
