import java.io.*;
import java.util.HashMap;

public class outofplace {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
        int cows = Integer.parseInt(f.readLine());
        HashMap<Integer, Integer> bleh = new HashMap<>();
        int[] currentOrder = new int[cows];
        for(int i = 0; i<cows; i++) {
            currentOrder[i] = Integer.parseInt(f.readLine());
        }
        int before = 0;
        int after = 0;
        int re = 0;
        int reAfter = 0;
        int error = 0;
        int standing = 0;
        boolean behind = false;
        for(int i = 0; i<cows; i++) {
            int x = currentOrder[i];
            if(i+1 != cows) {
                after = currentOrder[i+1];
            }
            else {
                if(x<before) {
                    error = x;
                    standing = i;
                }
            }
            if(!behind) {
                if (x < before || x > after) {
                    error = x;
                    standing = i;
                    behind = true;
                }
            }
            before = x;
            if(!behind) {
                if (bleh.get(x) != null) {
                    re = re + 1;
                }
            }
            if(behind) {
                if (bleh.get(x) != null) {
                    reAfter = reAfter + 1;
                }
            }
            bleh.put(x, 0);
        }
        //suppose location
        boolean found = false;
        int loco = 0;
        int index = 0;
        before = 0;
        while (!found) {
            int x = currentOrder[index];
            if(index+1 != cows) {
                after = currentOrder[index + 1];
            }
            else {
                loco = cows-1;
                found = true;
            }
            if(x<error && error<after) {
                loco = index+1;
                found = true;
            }
            if(before == error) {
                loco = index+1;
                found = true;
            }
            index = index+1;
        }
        //calculate
        int dist = 0;
        if (loco<standing) {
            dist = standing-loco;
            dist = dist - re;
        }
        else {
            dist = loco - standing;
            dist = dist - reAfter;
        }
        PrintWriter out = new PrintWriter(new FileWriter("outofplace.out"));
        out.println(dist);
        out.close();
    }
}
