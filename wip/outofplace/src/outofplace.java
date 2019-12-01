import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class outofplace {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
        int numCows = Integer.parseInt(f.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numCows; i++) {
             arrayList.add(Integer.parseInt(f.readLine()));
        }

        for (int i = 0; i <= numCows-2; i++) {
                if (arrayList.get(i) == arrayList.get(i + 1)) {
                    arrayList.remove(i);
                }
        }

        int cow = arrayList.size();
        int count = swap(arrayList,cow);

        System.out.println(count);
    }
    static int swap (ArrayList<Integer> array, int i) {
        int count = 0;
        for (int c = i-1; c > 0; c--) {
            int d = array.get(c);
            int z = array.get(c-1);

            if ( d > z) {
                int l = array.get(c);
                array.set(c,array.get(c--));
                array.set(c,l);
                count++;
            }
        }
        return count;
    }
}
