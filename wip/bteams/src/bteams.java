import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class bteams {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("bteams.in"));
        TreeMap<Integer, Integer> skillLevel = new TreeMap<>();
        for(int i = 0; i<12; i++) {
            skillLevel.put(Integer.parseInt(f.readLine()), 0);
        }
        int ateam = 0;
        int bteam = 0;
        int cteam = 0;

        int check = 3/2;
        System.out.println(check);

    }
}
