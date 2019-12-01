/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=224
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class paint {
    public  static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("paint.in"));
        int dchanges = Integer.parseInt(f.readLine());
        int []changes = new int[dchanges];
        int totalM = 0;
        for (int i = 0; i<dchanges;i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            totalM = totalM+x;
            String y = st.nextToken();
            if(y.equalsIgnoreCase("L")) {
                x = x*-1;
            }
            changes[i] = x;
        }
        ArrayList<Integer> moves = new ArrayList<>();
        for(int i = 0; i<dchanges;i++) {
            int x = changes[i];
            int input = 1;
            if(x<0) {
                input = input*-1;
            }
            for(int j = 0; j<Math.abs(x); j++) {
                moves.add(input);
            }
        }
        int bessieLoco = 0;
        int coats = 0;
        HashMap<Integer,Integer> track = new HashMap<>();
        for(int i = 0; i<totalM; i++) {
            int x = moves.get(i);
            bessieLoco = bessieLoco+x;
            if(track.get(bessieLoco) == null) {
                track.put(bessieLoco,1);
            }
            else {
                int y = track.get(bessieLoco)+1;
                if(y==2) {
                    coats = coats+1;
                }
                track.put(bessieLoco, y);
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("paint.out"));
        out.println(coats);
        out.close();
    }
}
