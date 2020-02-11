import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class folding {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("folding.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int knots = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> rope = new TreeMap<>();
        for(int i = 0; i<knots; i++) {
            rope.put(Integer.parseInt(f.readLine()), 0);
        }

        int match = 0;
        int repeats = (knots-1) + (knots-2);

        //1. sort knots into array
        for(int i = 1; i<repeats; i++) {
            int count = 0;
            boolean reachedEnd = false;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            int index = 1;

            //folder
            while (!reachedEnd) {
                left.add(i-index);
                right.add(i+index);
                if((i-index) == 0 || (i+index) == maxValue) {
                    reachedEnd = true;
                }
            }
            int track = 0;
            for(Integer x : left) {
                if(rope.get(x) == 0 && rope.get(right.get(track)) == 0) {
                    count = count+1;
                }
            }
            if(count == left.size()) {
                match = match +1;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("folding.out"));
        out.println(match);
        out.close();
    }
}
