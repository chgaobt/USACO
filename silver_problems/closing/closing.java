import java.io.*;
import java.util.*;
import java.lang.String; 

public class closing { 
    static boolean[] visited; 
    static int[] left; 
    static boolean done; 
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("closing.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int paths = Integer.parseInt(st.nextToken()); 

        ArrayList<ArrayList<Integer>> farm = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<n; i++) {
            farm.add(new ArrayList<Integer>()); 
        }
        left = new int[n];
        for(int i = 0; i<paths; i++) {
            st = new StringTokenizer(f.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            farm.get(x-1).add(y-1); 
            farm.get(y-1).add(x-1); 
        }
        
        PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
        
        int start = 0; 
        for(int x = 0; x<n; x++){
            visited = new boolean[n];
            done = false;
            while(left[start] == 1) {
                start++; 
            }
            int size = farm.size() - x;
            int sum = dfs(farm, start,0, size); 
            System.out.println(sum/2);

            if((sum/2)+1 == size) {
                out.println("YES");
            }
            else{
                out.println("NO");
            } 
            //remove next barn 
            int node = Integer.parseInt(f.readLine());  
            left[node-1] = 1; 
        }
        out.close(); 
        f.close();
    }

    public static int dfs (ArrayList<ArrayList<Integer>> farm, int node, int sum, int size) {
        int ind = left[node];
        if(visited[node] || ind==1) {
            return sum; 
        }
        else {
            visited[node] = true; 
            sum += farm.get(node).size(); 

            for(int paths: farm.get(node)){
                sum = dfs(farm, paths, sum, size); 
            }

            return sum; 
        }
    }
}