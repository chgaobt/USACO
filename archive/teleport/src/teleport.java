/*
ID: chloe1
LANG: JAVA
TASK: teleport
 */

import java.io.*;
import java.util.StringTokenizer;

public class teleport {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (a > b) {
            int buffer = a;
            a = b;
            b = buffer;
        }

        if (x < y) {
            int buffer = x;
            x = y;
            y = buffer;
        }

        int moved = 0;
        int c = Math.abs(x - b);
        moved = moved+c;
        int d = Math.abs(y - a);
        moved = moved+d;

        int z = b-a;

        if (z < moved) {
            moved = z;
        }

        PrintWriter out = new PrintWriter(new FileWriter("teleport.out"));
        out.println(moved);
        out.close();
    }
}
