import java.io.*;
import java.util.StringTokenizer;

public class sleepy {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
        int size = Integer.parseInt(f.readLine());
        int[] original = new int[size];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < size; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(original[i], max);
        }
        int sortedSize = 1;

        int x = original[size-1];
        for( int i = size-1; i>0 ;i--) {
            if (original[i] > original[i-1]){
                sortedSize++;
            }
            else {
                break;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("sleepy.out"));
        out.println(size-sortedSize);
        out.close();
    }

}
