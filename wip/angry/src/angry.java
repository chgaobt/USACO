import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class angry {
    public static void main (String []args) throws IOException {
        String path = new File("angry.in").getAbsolutePath();
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        System.out.println(new File("angry.in").getAbsolutePath());
        int hay = Integer.parseInt(f.readLine());
        int [] loco = new int[hay];
        for(int i = 0; i<hay; i++) {
            loco[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(loco);
        int big = loco[hay-1];
        int max = 0;
        for(int bale : loco) {
            Set<Integer> track = new HashSet<>();
            track.add(bale);
            boolean stop = false;
            int radius = 1;
            int tot = 0;
            while (!stop) {
                int size = track.size();
                int start = bale - radius;
                if (start < 0) {
                    start = 0;
                }
                int end = bale + radius;
                if (end > big) {
                    end = big;
                }
                for(int i = 0; i<hay; i++) {
                    int compare = loco[i];
                    if(compare >= start && compare<=end) {
                        track.add(compare);
                    }
                }
                int newSize = track.size();
                if(newSize == size) {
                    stop = true;
                }
                size = newSize;
                radius = radius+1;
                tot = size;
            }
            if(tot>max) {
                max = tot;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("angry.out"));
        out.println(max);
        out.close();
    }
}
