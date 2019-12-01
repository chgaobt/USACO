import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class crossroad {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("crossroad.in"));
        int obser = Integer.parseInt(f.readLine());
        int [] cowID = new int[obser];
        int [] roadside = new int[obser];

        for (int i = 0; i < obser; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cowID[i] = Integer.parseInt(st.nextToken());
            roadside[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < obser; i++) {
            hashMap.put(cowID[i],null);
        }

        for(int i = 0; i < obser; i++) {
            if(hashMap.get(cowID[i]) == null) {
                hashMap.put(cowID[i], roadside[i]);
            }
        }

        int crossing = 0;
        for (int i = 0; i < obser; i++) {
            int x = hashMap.get(cowID[i]);
            if(roadside[i] != x) {
                crossing = crossing+1;
                hashMap.put(cowID[i],roadside[i]);
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("crossroad.out"));
        out.println(crossing);
        out.close();
    }
}
