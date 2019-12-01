import java.io.*;
import java.util.StringTokenizer;

public class hoofball {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
        int cows = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] line = new int[cows];

        for (int i = 0; i < cows; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        int[] passed = new int[cows];
        for (int i = 0; i < cows; i++) {
            int distance = 1000000000;
            int place = 0;
            int x = line[i];
            for (int j = 0; j<cows; j++) {
                int y = line[j];
                int z = 0;

                if (x != y) {
                    z = Math.abs(x - y);
                    if (z != distance) {
                        if (z < distance) {
                            distance = z;
                            place = y;
                        }
                    }
                }

            }
            passed[i] = place;
        }

        int count = 0;
        for(int i = 0; i < cows; i++) {
            int start = line[i];
            int repeat = 0;
            for (int j = 0; j < cows; j++) {
                int compare = passed[j];

                if(compare == start) {
                    repeat = repeat+1;
                }
            }

            if(repeat == 0) {
                count = count+1;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("hoofball.out"));
        out.println(count);
        out.close();
    }
}
