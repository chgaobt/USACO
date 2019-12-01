/*
ID: chloe1
LANG: JAVA
TASK: promotion
 */

import java.io.*;
import java.util.StringTokenizer;

public class promotion {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("promote.in"));

        String line1 = f.readLine();
        StringTokenizer st = new StringTokenizer(line1);
        int Bb = Integer.parseInt(st.nextToken());
        int Ba = Integer.parseInt(st.nextToken());

        String line2 = f.readLine();
        StringTokenizer st1 = new StringTokenizer(line2);
        int Sb = Integer.parseInt(st1.nextToken());
        int Sa = Integer.parseInt(st1.nextToken());

        String line3 = f.readLine();
        StringTokenizer st2 = new StringTokenizer(line3);
        int Gb = Integer.parseInt(st2.nextToken());
        int Ga = Integer.parseInt(st2.nextToken());

        String line4 = f.readLine();
        StringTokenizer st3 = new StringTokenizer(line4);
        int Pb = Integer.parseInt(st3.nextToken());
        int Pa = Integer.parseInt(st3.nextToken());

        int Pu = (Pa - Pb);
        int Gu = (Ga - Gb) + Pu;
        int Su = (Sa - Sb) + Gu;

        BufferedWriter out = new BufferedWriter(new FileWriter("promote.out"));
        out.write(Su + "\n");
        out.write(Gu + "\n");
        out.write(Pu + "\n");
        out.close();
    }
}
