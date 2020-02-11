import java.io.*;
import java.util.StringTokenizer;

public class proximity {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("proximity.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cow = Integer.parseInt(st.nextToken());
        int proximity = Integer.parseInt(st.nextToken());

        int[]cowLine = new int[cow];
        for (int i = 0; i < cow; i++) {
            cowLine[i] = Integer.parseInt(f.readLine());
        }

        int count = -1;
        for (int i = 0; i < cow; i++) {
            int ID = 0;
            int cow1 = cowLine[i];
            int x = i + proximity;
            if (x > (cow-1)) {
                x = cow-1;  //problem here!
            }

            for (int j = i+1; j <= x; j++) {
                int cow2 = cowLine[j];
                if (cow1 == cow2) {
                    ID = cow1;
                }

                if (ID > count) {
                    count = ID;
                }

            }
        }


        PrintWriter out = new PrintWriter(new FileWriter("proximity.out"));
        out.println(count);
        out.close();
    }
}
