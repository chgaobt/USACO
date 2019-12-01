import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class cowqueue {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cow.queue.in"));
        int cows = Integer.parseInt(f.readLine());
        int[] startTime = new int[cows];
        int[] waitTime = new int[cows];

        for (int i = 0; i < cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            startTime[i] = Integer.parseInt(st.nextToken());
            waitTime[i] = Integer.parseInt(st.nextToken());
        }

        startTime = sort(startTime,cows);
    }

    static int[] sort (int[] array, int cows) {
        for(int i = 0; i < cows; i++) {
            for (int j = 0; j < cows; j++) {
                int start = array[i];
                int compare = array[j];

                if(compare<start) {
                    array[i] = compare;
                    array[j] = start;
                }
            }
        }
        return array;
    }
}
