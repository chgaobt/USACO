import java.io.*;
import java.util.*; 
import java.lang.*; 

public class lazy {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lazy.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 

        int[][] prefix = new int[n+1][n+1]; 
        for(int i = 1; i<=n; i++) {
            st = new StringTokenizer(f.readLine()); 
            for(int j = 1; j<=n; j++) {
                int x = Integer.parseInt(st.nextToken()); 
                prefix[i][j] = prefix[i][j-1] + x; 
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("lazy.out")); 
        int max = 0; 
        int posi = 0;
        int posj = 0; 
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                int a = Math.max(1, j-k);
                int A = Math.min(n, j+k); 
                int sum = prefix[i][A]-prefix[i][a-1];  // origin row 

                for(int l = 1; l<=k; l++) {  //rows above and below origin row
                    if(i-l>=1){
                        sum += prefix[i-l][A-l] - prefix[i-l][a-1+l];
                    }
                    if(i+l <=n) {
                        sum += prefix[i+l][A-l] - prefix[i+l][a-1+l]; 
                    }
        
                }
                if(sum>max) {
                    max = sum; 
                    posi = i; 
                    posj = j; 
                }
            }
        }
        out.print(max);
        out.close();
    }
}