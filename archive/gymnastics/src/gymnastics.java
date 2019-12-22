import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class gymnastics {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int rounds = Integer.parseInt(st1.nextToken());
        int cows = Integer.parseInt(st1.nextToken());
        HashMap<String,Integer> record = new HashMap<>();
        for(int i = 0; i<rounds; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] cowplace = new int[cows];
            for(int j = 0; j<cows; j++) {
                cowplace[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j<cows; j++) {
                for(int k = j+1; k<cows; k++) {
                    int x = cowplace[j];
                    int y = cowplace[k];
                    String xy = x+"-"+y;
                    if(record.get(xy) == null) {
                        record.put(xy,1);
                    }
                    else {
                        int past = record.get(xy);
                        record.put(xy,past+1);
                    }
                }
            }
        }
        int pairs = 0;
        for(String x : record.keySet()) {
            int times = record.get(x);
            if (times == rounds) {
                pairs = pairs+1;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("gymnastics.out"));
        out.println(pairs);
        out.close();
    }
}
