import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class odometer {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("odometer.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long start = Integer.parseInt(st.nextToken());
        long end = Integer.parseInt(st.nextToken());
        long dif = end-start;
        int count = 0;
        for (int i = 0; i <dif; i++) {
            start = start+1;
            count = count(start);
        }
    }

    static int count (long start) {
        String demo = start + '';
        for (int i = 0; i < dif; i++) {

        }
    }
}
