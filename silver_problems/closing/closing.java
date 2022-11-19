import java.io.*;
import java.util.*;
import java.lang.String; 

public class closing { 
    static boolean[] visited; 
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
        
        int[] remove = new int[n]; 
        ArrayList<Integer> left = new ArrayList<>(); 
        for(int i = 0; i<n; i++) {
            int x = Integer.parseInt(f.readLine()); 
            remove[i] = x; 
            left.add(i+1); 
        }
        PrintWriter out = new PrintWriter(new FileWriter("closing.out"));

        for(int x = 0; x<remove.length; x++){
            visited = new boolean[n];
            int sum = dfs(farm, left.get(0)-1); 
            int size = farm.length - x;

            if(sum == size) {
                out.println("YES");
            }
            else{
                out.println("NO");
            } 
            //remove next barn 
            int node = remove[x];  
            for(int i = 0; i<farm.length; i++) {
                farm[node-1][i] = 0;
                farm[i][node-1] = 0; 
            }   
            int index = left.indexOf(node); 
            left.remove(index); 
        }
        out.close(); 
        f.close();
    }

    public static int dfs (int[][] farm, int node) {
        if(visited[node]) {
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