import javax.print.attribute.standard.PrintQuality;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class skidesign {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        int numHills = Integer.parseInt(f.readLine());
        int[] hillSize = new int[numHills];
        ArrayList<Integer> stat = new ArrayList<>();

        int g = 0;
        for (int i = 0; i < numHills; i++) {
            hillSize[i] = Integer.parseInt(f.readLine());
            if (hillSize[i] > g) {
                g = hillSize[i];
            }
        }
        int max = 0;
        for (int i =0; i < numHills; i++) {
            int z = hillSize[i];
            if (z>max) {
                max=z;
            }
        }
        int count = 0;
        int start = 0;
        stat.add(start);
        for (int i = 0; i < numHills; i++) {
            int num = 0;
            for (int j = 0; j < numHills; j++) {
                int x = (hillSize[i] + 17);
                if (x < max) {
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
        for (int k = 0; k < g; k++) {
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
            if(price < cost) {
                cost = price;
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("skidesign.out"));
        out.println(cost);
        out.close();
    }
}
