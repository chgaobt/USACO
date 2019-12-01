import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class shuffle {
    static public void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        int cows = Integer.parseInt(f.readLine());
        int[]dance = new int[cows];
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[]cow = new int[cows];
        Arrays.fill(cow,1);

        for (int i = 0; i < cows; i++) {
            dance[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 3; i >= 0; i--) {
            int move = dance[i];
            cow[i] = cow[i] -1;
            int spot = (i-move);
            if(spot<0) {
                spot = Math.abs(spot);
                spot=cows-spot;
            }
            cow[spot] = cow[spot] +1;
        }

        int empty = 0;
        for (int i =0; i < cows; i++) {
            if(cow[i] != 0){
                empty= empty+1;
            }
        }

        System.out.println(empty);
        PrintWriter out = new PrintWriter(new FileWriter("shuffle.out"));
        out.println(empty);
        out.close();
    }
}
