import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class milkorder {
    static public void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cowsTot = Integer.parseInt(st.nextToken());
        int cowSocial = Integer.parseInt(st.nextToken());
        int cowSpecific = Integer.parseInt(st.nextToken());

        int[] official = new int[cowsTot];
        int[] social = new int[cowSocial];
        int[] cowSpec = new int[cowSpecific];
        int[] cowOrder = new int[cowSpecific];

        StringTokenizer st1 = new StringTokenizer(f.readLine());
        for (int i = 0; i < cowSocial; i++) {
            social[i] = Integer.parseInt(st1.nextToken());
        }

        for (int i = 0; i < cowSpecific; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            cowSpec[i] = Integer.parseInt(st2.nextToken());
            cowOrder[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < cowsTot; i++) {
g            for (int j = 0; j < cowSpecific; j++) {
                if (i == (cowOrder[j] -1)) {
                    official[i] = swapValues(official, i, cowSpec);
                }
            }
            System.out.println(official[i]);
        }
    }

    static int swapValues (int[] array, int i, int[]cow) {
        int z = array[i];
        array[i] = cow[i];
        array[i++] = z;

        return cow[i];
    }
}
