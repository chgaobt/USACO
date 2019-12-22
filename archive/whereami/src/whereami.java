import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class whereami {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter out = new PrintWriter(new FileWriter("whereami.out"));
        int length = Integer.parseInt(f.readLine());
        String road = f.readLine();
        char[] path = road.toCharArray();
        int starting = 3;
        for(int i = starting; i<length; i++) {
            int times = 0;
            int act = 0;
            Set<String> record = new HashSet<>();
            for (int j = 0; j<length-(i-1); j++) {
                String x = "";
                for(int k = 0; k<i; k++) {
                    x = x + "" +path[j+k];
                }
                int size = record.size();
                record.add(x);
                times = times +1;
                if(record.size() != size) {
                    act = act+1;
                }
            }
            if(times == act) {
                out.println(i);
                break;
            }
        }
        out.close();
    }
}
