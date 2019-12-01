/*
ID: chloe1
LANG: JAVA
TASK: pails
 */
/**
 *http://www.usaco.org/index.php?page=viewproblem2&cpid=615
 */

import java.io.*;
import java.util.StringTokenizer;

public class pails {
    public static void main (String []args) throws IOException{
        //read and store input data
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int small = Integer.parseInt(st.nextToken());
        int medium = Integer.parseInt(st.nextToken());
        int large = Integer.parseInt(st.nextToken());

        int milk = 0;
        int milk2 = 0;
        int repeat = large/small; // max amount of possible combinations

        for (int i = 1; i <= repeat; i++) { // loop through all possible combinations of filling the large bucket with small and medium sized buckets
            int sS = i; // number of small buckets used
            milk2 = small * sS;
            int left = large - milk2; // amount of milk left to be filled with medium sized bucket
            if (left > small) {
                 int mS = left/medium;
                milk2 = milk2 + (medium*mS);
            }
            milk = Math.max(milk,milk2); // always take the bigger number because the end goal is to fill the bucket with as much milk as possible
        }
        PrintWriter out = new PrintWriter(new FileWriter("pails.out"));
        out.println(milk);
        out.close();
    }
}
