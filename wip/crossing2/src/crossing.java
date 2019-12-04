/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=242
 */

import java.io.*;
import java.util.StringTokenizer;

public class crossing {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crossing.in"));
        int cows = Integer.parseInt(f.readLine());
        int [] sideA = new int[cows];
        int [] sideB = new int[cows];
        for(int i = 0; i<cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            sideA[i] = Integer.parseInt(st.nextToken());
            sideB[i] = Integer.parseInt(st.nextToken());
        }
        int safe = cows;
        for(int i = 0; i<cows; i++) {
            int cowpos1 = sideA[i];
            int cowend1 = sideB[i];
            for(int j = i+1; j<cows; j++) {
                int cowpos2 = sideA[j];
                int cowend2 = sideB[j];
                if(cowpos1<cowpos2 && cowend1>cowend2) {
                    safe = safe-1;
                }
                if(cowpos1>cowpos2 && cowend1<cowend2) {
                    safe = safe-2;
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("crossing.out"));
        out.println(safe);
        out.close();
    }
}
