import java.io.*;
import java.util.*;
import java.lang.String; 

public class closing {
    public static String connect; 
    public static int[] remove;
    public static void main (String[]args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("closing.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int paths = Integer.parseInt(st.nextToken()); 

        int[][] farm = new int[barns][barns]; 
        for(int i = 0; i<paths; i++) {
            st = new StringTokenizer(f.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()); 
            farm[x-1][y-1] = 1; 
            farm[y-1][x-1] = 1; 
        }

        remove = new int[n]; 
        connect = ""; 
        for(int i = 0; i<n; i++) {
            int x = Integer.parseInt(f.readLine()); 
            connect = connect+"0"; 
            remove[i] = x; 
        }

        PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
        for(int x = 0; x<n-1; x++){
            if(isConnected(farm,x)) {
                out.println("YES");
            }
            else{
                out.println("NO");
            }    
        }
        out.close(); 
    }
    public static boolean isConnected (int[][] farm, int round) { 
        int size = farm.length() - round;
        boolean ret = false;
        for(int i = 0; i<farm.length; i++) {
            for(int j = 0; j<farm[0].length; i++){
                int sum = 0;
                if(farm[i][j] == 1) {
                    connect.setChatAt((i-1),'1');
                    connect.setChatAt((j-1),'1'); 
                }
                for(char x : connect){
                    int a = Integer.parseInt(x);
                    sum += a; 
                }
                if(sum == size) {
                    ret = true;     
                    break; 
                }
            }
        }
        int node = remove[round]; 
        for(int i = 0; i<farm.length; i++) {
            connect[node-1][i] = 0;
            connect[i][node-1] = 0; 
        }
        return ret; 
    }
}