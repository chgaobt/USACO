import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Arrays;

public class shuffle {
    static public void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        int cows = Integer.parseInt(f.readLine());
        int [] shuffle = new int[cows];
        int[] original = new int[cows];
        StringTokenizer st = new StringTokenizer(f.readLine());
        HashMap<Integer,Integer> indexKey = new HashMap<>();
        for(int i = 0; i<cows; i++) {
            int x = Integer.parseInt(st.nextToken());
            shuffle[i] = x;
            indexKey.put(x,i);
        }
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        for(int i = 0; i<cows; i++) {
            original[i] = Integer.parseInt(st1.nextToken());
        }
        for(int i = 0; i<3; i++) {
            int[] moved = new int[cows];
            for(int j = 0; j<cows; j++) {
                int newLoco = indexKey.get(j+1);
                int cowMoved = original[j];
                moved[newLoco] = cowMoved;
            }
            original = moved;
        }
        PrintWriter out = new PrintWriter(new FileWriter("shuffle.out"));
        for(int i = 0 ; i<cows; i++) {
            out.println(original[i]);
        }
        out.close();
    }
}
