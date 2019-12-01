/*
ID: chloe1
LANG: JAVA
TASK: cowtip
 */

import java.io.*;
import java.util.StringTokenizer;

public class cowtip {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));
        int n = Integer.parseInt(f.readLine());
        int[][] cows = new int[n][n];

        for (int i = 0; i < n; i++){
            String line = f.readLine();
            int d = 0;
            for (int z = 0; z < n; z++) {
                cows[i][z] = line.charAt(d) - '0';
                d++;
            }
        }

        int count = 0;

        for (int x = n-1; x >= 0; x--){
            for (int y = n-1; y >= 0; y--) {
                if (cows[x][y] == 1) {
                    useCowtipper(cows,x,y);
                    count++;
                }
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("cowtip.out"));
        out.write(count + "\n");
        out.close();
    }

    static void useCowtipper (int[][] array, int x, int y) {
        for(int a = x; a >= 0; a--) {
            for (int b = y; b >= 0; b--) {
                if (array[a][b] == 1) {
                    array[a][b] = 0;
                }
                else {
                    array[a][b] = 1;
                }
            }
        }
    }
}
