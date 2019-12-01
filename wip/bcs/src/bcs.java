/*
ID: chloe1
LANG: JAVA
TASK: bcs
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bcs {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("bcs.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] original = new int[n][n];

        for (int i = 0; i < n; i++){
            String line = f.readLine();
            int d = 0;
            for (int z = 0; z < n; z++) {
                original[i][z] = line.charAt(d) - '0'; //need to change to match input symbols
                d++;
            }
        }

        int[][] frag1= new int[n][n];
        for (int i = 0; i < n; i++){
            String line = f.readLine();
            int d = 0;
            for (int z = 0; z < n; z++) {
                frag1[i][z] = line.charAt(d) - '0'; //need to change to match input symbols
                d++;
            }
        }
        int row1 = 0;
        int x = 0;
        int y = 0;
        if (frag1[x][y] == 1 && x < n && y < n) {
            row1++;
        }
    }
}
