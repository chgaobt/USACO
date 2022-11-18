import java.io.*;
import java.util.*;
import java.lang.String; 

public class closing { 
    static int[] remove;
    static boolean done; 
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("closing.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int paths = Integer.parseInt(st.nextToken()); 

        int[][] farm = new int[n][n]; 
        for(int i = 0; i<paths; i++) {
            st = new StringTokenizer(f.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            farm[x-1][y-1] = 1; 
            farm[y-1][x-1] = 1; 
        }
        
        remove = new int[n]; 
        for(int i = 0; i<n; i++) {
            int x = Integer.parseInt(f.readLine()); 
            remove[i] = x; 
        }

        PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
        for(int x = 0; x<remove.length; x++){
            done = false;
            if(isConnected(farm,x)) {
                out.println("YES");
            }
            else{
                out.println("NO");
            } 
            //remove next barn 
            int node = remove[x]; 
            farm[node-1][node-1] = -1; 
            for(int i = 0; i<farm.length; i++) {
                farm[node-1][i] = 0;
                farm[i][node-1] = 0; 
            }   
        }
        out.close(); 
        f.close();
    }

    public static boolean isConnected (int[][] farm, int round) { 
        int size = farm.length - round;
        boolean ret = false;
        int sum = dfs(farm, 0);

        if(size == sum) {
            ret = true; 
        }
        System.out.println(sum);
        return ret; 
    }

    public static int dfs (int[][] farm, int node) {
        int sum = 1;
        for(int i = node; i<farm.length; i++) {
            if(farm[i][i] == -1) {
                continue; 
            }
            for(int j = i+1; j<farm[0].length; j++){
                if(farm[i][j] == 1) {
                    sum += dfs(farm,j);
                    if(done) {
                        return sum;
                    } 
                }
            }
            if(i+1 == farm[0].length) {
                done = true; 
                return sum;
            }
        }
        return sum;
    }
}