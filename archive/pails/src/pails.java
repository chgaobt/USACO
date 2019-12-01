/*
ID: chloe1
LANG: JAVA
TASK: pails
 */

import java.io.*;
import java.util.StringTokenizer;

public class pails {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int small = Integer.parseInt(st.nextToken());
        int medium = Integer.parseInt(st.nextToken());
        int large = Integer.parseInt(st.nextToken());
        int milk = 0;
        int milk2 = 0;
        int repeat = large/small;

        for (int i = 1; i <= repeat; i++) {
            int sS = i;
            milk2 = small * sS;
            int left = large - milk2;
            if (left > small) {
                 int mS = left/medium;
                milk2 = milk2 + (medium*mS);
            }
            milk = Math.max(milk,milk2);
        }
        PrintWriter out = new PrintWriter(new FileWriter("pails.out"));
        out.println(milk);
        out.close();
    }
}
