/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=376
 */

import java.io.*;
import java.util.ArrayList;

public class skidesign {
    public static void main (String []args) throws IOException {
        //read and store input data
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        int numHills = Integer.parseInt(f.readLine());
        int[] hillSize = new int[numHills];
        ArrayList<Integer> stat = new ArrayList<>();

        int g = 0; // value of the largest hill
        for (int i = 0; i < numHills; i++) { //store hill size values in array
            hillSize[i] = Integer.parseInt(f.readLine());
            if (hillSize[i] > g) {
                g = hillSize[i];
            }
        }
        int count = 0;
        int start = 0;
        stat.add(start);
        for (int i = 0; i < numHills; i++) {
            int num = 0;
            for (int j = 0; j < numHills; j++) {
                int x = (hillSize[i] + 17);
                if (x < g) {
                    int y = hillSize[j];
                    if (y <= x && y >= (x - 17)) {
                        num = num + 1;
                    }
                }
            }
            if (num > count) {
                count = num;
                start = i;
            }

            if(num == count) {
                start = i;
                stat.add(start);
            }
        }
        int cost = 900000000;
        for (int k = 0; k < g; k++) { // try all possible situations; the values in between the hill size are possible too
            start = k;
            int price = 0;
            for (int i = 0; i < numHills; i++) {
                int z = hillSize[i];

                if (z < start) {
                    int dif = start - z;
                    price = price + (dif * dif);
                } else {
                    if (z > (start + 17)) {
                        int dif = z - (start + 17);
                        price = price + (dif * dif);
                    }
                }
            }
            if(price < cost) { // the goal is to find the lowest cost
                cost = price;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));
        out.println(cost);
        out.close();
    }
}
