/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=279
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class blink {
    public static void main (String []args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("blink.out"));
        BufferedReader f = new BufferedReader(new FileReader("blink.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int  lights = Integer.parseInt(st.nextToken());
        long plays = Integer.parseInt(st.nextToken());
        Set<Integer> track = new HashSet<>();
        int[] chandelier = new int[lights];
        int[] previous = chandelier;
        int size = 0;
        for(int i = 0; i<lights; i++) {
            chandelier[i] = Integer.parseInt(f.readLine());
        }
        long index = plays;
        for(long i = 0; i<index; i++) {
            int[] newLights = new int[lights];
            for(int j = 0; j<lights; j++) {
                int dex = j-1;
                if(dex<0) {
                    dex = lights-1;
                }
                int status = previous[dex];
                int current = previous[j];
                current = Math.abs(status-current);
                newLights[j] = current;
            }
            String binaryString = "";
            for(int a = 0; a<lights; a++) {
                int x = newLights[a];
                binaryString = binaryString + x;
            }
            int situation = Integer.parseInt(binaryString,2);
            track.add(situation);
            size = size +1;

            if(size != track.size()) {
                int ori = situation;
                int y = (int) i;
                for(Integer a : track) {
                    if(a == ori) {
                        index = (plays-(a+1));
                        index=index/(y-a);
                        index = index + (a+1);
                        i = 0;
                        previous = chandelier;
                        continue;
                    }
                }
            }
            previous = newLights;
        }
        for(int j = 0; j<lights; j++) {
            out.println(previous[j]);
        }
        out.close();
    }
}
