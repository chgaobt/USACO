import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class folding {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("folding.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int knots = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        ArrayList<Integer> rope = new ArrayList<>(knots);
        for (int i = 0; i < knots; i++) {
            rope.add(Integer.parseInt(f.readLine()));
        }
        Collections.sort(rope);
        int count = 0;
        for(int i = (rope.get(0))+1; i<rope.get(knots-1);i++) {
            int index = position(i,rope,knots);
            int sum = 0;
            boolean cont = true;
            for (int j = index; j>=0; j--) {
                if (cont) {
                    int k = index;
                    int dif = Math.abs(rope.get(j) - i);
                    if(i+dif > length-i) {
                        cont = false;
                        sum = 0;
                        break;
                    }
                    int compare = rope.get(k+dif);
                    if (compare == i) {
                        compare = rope.get(k+1);
                    }
                    int temp = Math.abs(compare - i);
                    if (dif == temp) {
                        sum = sum + 1;
                    }
                    else {
                        cont = false;
                        sum = 0;
                    }
                    k = k+1;
                }
            }
            count = count + sum;
        }
        System.out.println(count);
    }
    static int position (int i, ArrayList<Integer> rope, int knots) {
        int index = 0;
        int dif = 10000000;
        for (int j = 0; j<knots-1; j++) {
            if (rope.get(j) < i && i < rope.get(j+1)) {
                int temp = i-rope.get(j);
                if(temp<dif) {
                    index = j;
                }
            }
        }
        return index;
    }
}
