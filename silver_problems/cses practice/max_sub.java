import java.io.*;
import java.util.*;

public class max_sub {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(f.readLine()); 
        int[] prefix = new int[n+1]; 
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i<=n; i++) {
            prefix[i] = Integer.parseInt(st.nextToken())+prefix[i-1]; 
        }
        int max = 0; 
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                int sum = prefix[j]-prefix[i]; 
                if(sum>max){
                    max = sum; 
                }
            }
        }
        System.out.print(max);
    }
}