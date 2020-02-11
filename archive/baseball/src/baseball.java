import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class baseball {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("baseball.in"));
        int cows = Integer.parseInt(f.readLine());
        ArrayList<Integer> order = new ArrayList<>(cows);
        for (int i = 0; i<cows; i++) {
            order.add(Integer.parseInt(f.readLine()));
        }
        Collections.sort(order);
        int count = 0;
        for (int i = 0; i<cows; i++) {
            int origin = order.get(i);
            for (int j = i+1; j<cows; j++) {
                int compare = order.get(j);
                for (int k = j+1; k<cows; k++) {
                    int last = order.get(k);
                    count = count + solve(origin, compare, last);
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("baseball.out"));
        out.println(count);
        out.close();
    }

    static int solve (int origin, int compare, int last) {
        int count = 0;
        int dif = compare - origin;
        int dif2 = last-compare;

        if (dif2 >= dif && dif2 <= dif*2 ) {
            count = 1;
        }
        return count;
    }
}
