import java.io.*;
import java.util.StringTokenizer;

public class balancing  {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(st.nextToken());
        int[] xValue = new int[cows];
        int[] yValue = new int[cows];
        int z = Integer.parseInt(st.nextToken());

        for(int i = 0; i < cows; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            xValue[i] = Integer.parseInt(st1.nextToken());
            yValue[i] = Integer.parseInt(st1.nextToken());
        }
        int count = solve(xValue,yValue,cows);
        PrintWriter out = new PrintWriter(new FileWriter("balancing.out"));
        out.println(count);
        out.close();
    }

    static int solve (int[] x, int[] y,int cows) {
        int count = cows;
        for (int i = 0; i < cows; i++) {
            for (int k = 0; k < cows; k++) {
                int yy = y[k] + 1;
                int xx = x[i] + 1;
                int Ll = 0;
                int Lr = 0;
                int Ul = 0;
                int Ur = 0;
                for (int j = 0; j < cows; j++) {
                    if(x[j] < xx && y[j] < yy) {
                        Ll = Ll+1;
                    }
                    if(x[j] < xx && y[j] > yy) {
                        Ul = Ul+1;
                    }
                    if(x[j] > xx && y[j] < yy) {
                        Lr = Lr+1;
                    }
                    if(x[j] > xx && y[j] > yy) {
                        Ur = Ur+1;
                    }
                }
                int max = Math.max(Ll,Ul);
                max = Math.max(max,Lr);
                max = Math.max(max,Ur);
                count = Math.min(count,max);
            }
        }
        return count;
    }
}
