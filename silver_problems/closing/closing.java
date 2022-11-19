import java.io.*;
import java.util.*;
import java.lang.String; 

public class closing { 
    static boolean[] visited; 
    static int[] left; 
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("closing.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int paths = Integer.parseInt(st.nextToken()); 

        int[][] farm = new int[n][n]; 
        left = new int[n+1];
        for(int i = 0; i<paths; i++) {
            st = new StringTokenizer(f.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            farm[x-1][y-1] = 1; 
            farm[y-1][x-1] = 1; 
        }
        
        PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
        int start = 1; 

        for(int x = 0; x<n; x++){
            visited = new boolean[n];
            if(left[start] == 1) {
                int a = start +1; 
                while(left[a] == 1) {
                    a++;
                }
                start = a; 
            }
            int sum = dfs(farm, start-1); 
            int size = farm.length - x;

            if(sum == size) {
                out.println("YES");
            }
            else{
                out.println("NO");
            } 
            //remove next barn 
            int node = Integer.parseInt(f.readLine());  
            left[node] = 1; 
        }
        out.close(); 
        f.close();
    }

    public static int dfs (int[][] farm, int node) {
        int ind = left[node+1];
        if(visited[node] || ind==1) {
            return 0; 
        }
        else {
            visited[node] = true; 
            int sum = 1; 
            for(int j = 0; j<farm[0].length; j++){
                if(farm[node][j] == 1) {
                    sum += dfs(farm,j);
                }
            }
            return sum; 
        }
    }
}