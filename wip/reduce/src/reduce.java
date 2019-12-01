import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class reduce {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
        int cows = Integer.parseInt(f.readLine());
        ArrayList<Integer> xValue = new ArrayList<>(cows);
        ArrayList<Integer> yValue = new ArrayList<>(cows);
        ArrayList<cowPlacement> original = new ArrayList<>(cows);
        for (int i = 0; i < cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xValue.add(x);
            yValue.add(y);
            original.add(new cowPlacement(x,y));
        }
        Collections.sort(xValue);
        Collections.sort(yValue);
        ArrayList<cowPlacement> mm = new ArrayList<>(8);
        xValue.get(cows-1)
    }
}

class cowPlacement {
    int x;
    int y;

    public cowPlacement (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
