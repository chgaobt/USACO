import java.io.*;
import java.util.PrimitiveIterator;
import java.util.StringTokenizer;

public class cowjog {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowjog.in"));
        int cows = Integer.parseInt(f.readLine());
        int [] speed = new int[cows];
        for(int i = 0; i<cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int loco = Integer.parseInt(st.nextToken());
            speed[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int tempmin = speed[cows-1];
        for(int i = 0; i<cows; i++) {
            int pace = speed[cows-(i+1)];
            if(pace<=tempmin) {
                count = count+1;
                tempmin = pace;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("cowjog.out"));
        out.println(count);
        out.close();
    }
}