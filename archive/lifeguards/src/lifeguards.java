import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class lifeguards {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        int num = Integer.parseInt(f.readLine());
        int[] start = new int[num];
        int [] end = new int[num];
        for(int i = 0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }
        int out = 0;
        for(int i = 0;i<num; i++) {
            ArrayList<Integer> modStart = new ArrayList<>();
            ArrayList<Integer> modEnd = new ArrayList<>();
            for(int j = 0; j<num; j++) {
                if(j == i) {
                    continue;
                }
                else {
                    modStart.add(start[j]);
                    modEnd.add(end[j]);
                }
            }
            int total = 0;
            HashSet<Integer> track = new HashSet<>();
            for(int j = 0; j<num-1; j++) {
                int s = modStart.get(j);
                int e = modEnd.get(j);
                int index = s+1;
                while(index<=e) {
                    track.add(index);
                    index = index+1;
                }
            }
            total = track.size();
            if(total>out) {
                out = total;
            }
        }
        PrintWriter o = new PrintWriter(new FileWriter("lifeguards.out"));
        o.println(out);
        o.close();
    }
}
