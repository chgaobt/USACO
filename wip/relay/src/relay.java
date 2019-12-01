/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=241
 */

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class relay {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("relay.in"));
        int cows = Integer.parseInt(f.readLine());
        int [] message = new int[cows];
        for(int i = 0; i<cows; i++) {
            message[i] = Integer.parseInt(f.readLine());
        }
        int nonLooping = cows;
        for(int i = 0; i< cows; i++) {
            Set<Integer> track = new HashSet<>();
            int starting = i+1;
            track.add(starting);
            int ori = message[i];
            if(ori == 0) {
                continue;
            }
            int size = 0;
            for(int j = 0; j<cows; j++) {
                int forward = message[ori-1];
                if(forward == 0) {
                    size = cows;
                    break;
                }
                track.add(ori-1);
                ori = forward;
                size = track.size();
            }
            if (size<cows) {
                nonLooping = nonLooping-1;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("relay.out"));
        out.println(nonLooping);
        out.close();
    }
}
