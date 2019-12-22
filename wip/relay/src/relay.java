/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=241
 */

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class relay {
    public static void main (String []args) throws IOException { //read and store input data
        BufferedReader f = new BufferedReader(new FileReader("relay.in"));
        int cows = Integer.parseInt(f.readLine());
        int [] message = new int[cows];
        for(int i = 0; i<cows; i++) {
            message[i] = Integer.parseInt(f.readLine());
        }
        int nonLooping = cows;
        Set<Integer> loopy = new HashSet<>();

        //check with individual cow, starting message
        for(int i = 0; i<cows; i++) {
            Set<Integer> track = new HashSet<>();  //the message path,
            boolean notLooping = true;

            if (loopy.contains(i+1)){
                nonLooping = nonLooping-1;
                notLooping = false;
            }
            int next = message[i];
            track.add(i+1);
            if(next == 0) {
                notLooping=false;
            }
            while (notLooping) {

                if (loopy.contains(next)){
                    nonLooping = nonLooping-1;
                    notLooping = false;
                }

                int size = track.size();
                track.add(next);

                int growth = track.size()-size;

                next = message[next-1];
                //if the looping detected
                if(growth == 0) {
                    loopy.addAll(track);
                    nonLooping = nonLooping-1;
                    notLooping = false;
                }

                if(next == 0) {
                    notLooping = false;
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("relay.out"));
        out.println(nonLooping);
        out.close();
    }
}
