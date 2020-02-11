import java.io.*;
import java.util.StringTokenizer;

public class lostcow {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lostcow.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int FJ = Integer.parseInt(st.nextToken());
        int Bessie = Integer.parseInt(st.nextToken());
        int direction = 0;
        if(FJ>Bessie) {
            direction = 1;
        }
        else {
            direction = 0;
        }
        int distance = 1;
        int walked = 0;
        if(direction == 0) {
            int count = 0;
            distance = (int) Math.pow(2,count);
            boolean start = false;
            while (!start) {
                if (FJ + distance >= Bessie) {
                    start = true;
                } else {
                    walked = walked + (distance * 2);
                    walked = walked + ((distance*2) *2);
                    count = count+2;
                    distance = (int) Math.pow(2,count);
                }
            }
            for (int i = 0; i < distance; i++) {
                if (FJ == Bessie) {
                    break;
                }
                FJ = FJ + 1;
                walked = walked + 1;
            }
        }
        if(direction == 1) {
            walked = 2;
            int count = 1;
            distance = (int) Math.pow(2,count);
            boolean start = false;
            while (!start) {
                if (FJ - distance <= Bessie) {
                    start = true;
                } else {
                    walked = walked + (distance * 2);
                    walked = walked + ((distance*2) *2);
                    count = count+2;
                    distance = (int) Math.pow(2,count);
                }
            }
            for (int i = 0; i < distance; i++) {
                if (FJ == Bessie) {
                    break;
                }
                FJ = FJ - 1;
                walked = walked + 1;
            }
        }
        out.println(walked);
        out.close();
    }
}
