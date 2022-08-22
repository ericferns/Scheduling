import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputCsv {

    public String[][] course1 = new String[30][3];  // PG having preference
    public String[][] course2 = new String[30][3];  // UG with preference
    public String[][] course3 = new String[30][3];  // PG without preference
    public String[][] course4 = new String[30][3];  // UG without preference
    public void getCsvData() {

        String splitBy = ",", line; // use comma as separator
        int row_course1 = 0, row_course2 = 0, row_course3 = 0, row_course4 = 0;   // counter for course
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("course.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                int num_pref = 0;
                String[] courseDetails = line.split(splitBy);
                if (courseDetails.length > 2) {
                    courseDetails[2] = courseDetails[2].replaceAll("\"", "");
                    num_pref = courseDetails[2].split(";").length;
                }
                if (courseDetails[0].compareTo("cs599") > 0) {
                    if (num_pref > 0) {
                        System.arraycopy(courseDetails, 0, course1[row_course1], 0, 3);
                        row_course1++;
                    } else {
                        System.arraycopy(courseDetails, 0, course3[row_course3], 0, 2);
                        row_course3++;
                    }
                } else {
                    if (num_pref > 0) {
                        System.arraycopy(courseDetails, 0, course2[row_course2], 0, 3);
                        row_course2++;
                    } else {
                        System.arraycopy(courseDetails, 0, course4[row_course4], 0, 2);
                        row_course4++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < row_course1; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course1[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row_course3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course3[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row_course2; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course2[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row_course4; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(course4[i][j]);
//            }
//            System.out.println();
//        }
    }
}