import java.io.*;
import java.util.*;

public class stacking {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("stacking.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 
        
        int[] diff = new int[n+1];
        int[] prefix = new int[n+1]; 

        for(int i = 0; i<k; i++) {
            st = new StringTokenizer(f.readLine()); 
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            diff[a-1] += 1; 
            diff[b] -= 1; 
        }

        for(int i = 1; i<n+1; i++) {
            prefix[i] = prefix[i-1] + diff[i];
        }
        Arrays.sort(prefix);
        PrintWriter out = new PrintWriter(new FileWriter("stacking.out")); 
        out.print(prefix[prefix.length/2]);
        out.close();
    }
}
