/*
ID: chloe1
LANG: JAVA
TASK: square
 */

import java.io.*;
import java.util.StringTokenizer;

public class square {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int rec1w1 = Integer.parseInt(st.nextToken());
        int rec1h1 = Integer.parseInt(st.nextToken());
        int rec1w2 = Integer.parseInt(st.nextToken());
        int rec1h2 = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int rec2w1 = Integer.parseInt(st1.nextToken());
        int rec2h1 = Integer.parseInt(st1.nextToken());
        int rec2w2 = Integer.parseInt(st1.nextToken());
        int rec2h2 = Integer.parseInt(st1.nextToken());

        int w = 0;
        int h = 0;

        w = Math.min(rec1w1, rec1w2);
        int x = Math.min(rec2w1, rec2w2);
        w = Math.min(w,x);

        int wB = 0;
        int x1 = 0;
        wB = Math.max(rec1w1, rec1w2);
        x1 = Math.max(rec2w1, rec2w2);
        wB = Math.max(wB,x1);

        h = Math.min(rec1h1, rec1h2);
        int s = Math.min(rec2h1, rec2h2);
        h = Math.min(h,s);

        int hB = 0;
        int x2 = 0;
        hB = Math.max(rec1h1, rec1h2);
        x2 = Math.max(rec2h1, rec2h2);
        hB = Math.max(hB,x2);

        int square = 0;

        w = wB - w;
        h = hB - h;

        if (w > h) {
            square = w*w;
        }
        else {
            square = h*h;
        }

        PrintWriter out = new PrintWriter(new FileWriter("square.out"));
        out.println(square);
        out.close();
    }
}
