import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class slowdown {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("slowdown.in"));
        int slowpoint = Integer.parseInt(f.readLine());
        ArrayList<Integer> T = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String x = st.nextToken();
            if (x.equals("D")) {
                D.add(Integer.parseInt(st.nextToken()));
            }
            else {
                T.add(Integer.parseInt(st.nextToken()));
            }
        }
        int time = 0;
        int dis = 1000;
        int speed = 1;
        for (int i = 0; i<slowpoint; i++) {
            int x = 0;
            int t = 0;
            if(T.size()== 0) {
                x= 1000;
            }
            else {
                x = findNextPoint(slowpoint, speed, T);
                t = T.get(x);
            }
            int y = 0;
            int d = 0;
            if(D.size() == 0) {
                y=1000;
            }
            else {
                y = findNextPointD(slowpoint, speed, D);
                d = D.get(y);
            }
            int poz = Math.min(t,d);
            int di = 0;
            int ti = 0;
            if(poz==t){
                if(T.size()!= 0) {
                    T.remove(x);
                    di = (t / speed);
                    ti = t;
                }
            }
            else{
                if(D.size()!=0) {
                    D.remove(y);
                    di = d;
                    ti = d * speed;
                }
            }

            time = ti;
            dis= dis - di;

            if(dis == 0) {
                break;
            }
            speed = speed+1;
        }

        time = time + (dis*speed);

        PrintWriter out = new PrintWriter(new FileWriter("slowdown.out"));
        out.println(time);
        out.close();
    }

    static int findNextPoint (int slowpoint, int speed, ArrayList<Integer> T) {
        int k = 1000;
        for (int i:T) {
            int index = 0;
            int y = i;
            int dis = y/speed;
            if(dis<k) {
                dis = y;
                k=index;

            }
        }
        return k;
    }

    static int findNextPointD (int slowpoint, int speed, ArrayList<Integer> D) {
        int k = 1000;
        for (int i:D) {
            int index = 0;
            int y = i;
            int dis = y/speed;
            if(dis<k) {
                dis = y;
                k=index;

            }
        }
        return k;
    }
}
