import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class paint {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paint.in"));
        int moves = Integer.parseInt(f.readLine());
        int [] totalMoves = new int[moves];
        int space = 0;
        int start = 0;
        for(int i = 0; i<moves; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int steps = Integer.parseInt(st.nextToken());
            space = space+steps;
            String direction = st.nextToken();
            if(direction.equalsIgnoreCase("R")) {
                steps = steps*-1;
            }
            if(steps<start) {
                start = steps;
            }
            totalMoves[i] = steps;
        }

        int [] fence = new int[space];
        int starting = Math.abs(start);
        for(int i = 0; i<moves;i++) {
            int steps = totalMoves[i];
            int change = (starting+steps)-1;
            for(int j = change; j<starting; j++) {
                fence[j] = fence[j]+1;
            }
            starting = change;
        }

        int painted = 0;
        for(int i = 0; i<space; i++) {
            if(fence[i] == 2) {
                painted = painted+1;
            }
        }

        System.out.println(painted);
    }
}
