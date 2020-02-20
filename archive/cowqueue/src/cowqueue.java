import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cowqueue {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowqueue.in"));
        int cows = Integer.parseInt(f.readLine());
        HashMap<Integer, Integer> log = new HashMap<>();
        int [] arrival = new int[cows];
        for(int i = 0; i<cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arrival[i] = a;
            log.put(a,t);
        }
        Arrays.sort(arrival);
        int time = 0;
        for(int arrive : arrival) {
            if(arrive > time ) {
                time = arrive;
            }
            time = time + log.get(arrive);
        }
        PrintWriter out = new PrintWriter(new FileWriter("cowqueue.out"));
        out.println(time);
        out.close();
    }
}
