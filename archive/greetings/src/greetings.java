import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class greetings {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("greetings.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int bessie = Integer.parseInt(st.nextToken());
        int elise = Integer.parseInt(st.nextToken());
        int btot = 0;
        int[] b = new int[bessie];
        int etot = 0;
        int[] e = new int[elise];
        for(int i = 0; i<bessie; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st1.nextToken());
            btot = btot + x;
            String y = st1.nextToken();
            if(y.equalsIgnoreCase("L")){
                x=x*-1;
            }
            b[i] = x;
        }
        ArrayList<Integer> bes = new ArrayList<>();
        for(int i = 0; i<bessie; i++) {
            int x = b[i];
            int input = 1;
            if(x < 0) {
                input = input*-1;
            }
            for(int j = 0; j<Math.abs(x); j++) {
                bes.add(input);
            }
        }
        for(int i = 0; i<elise; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st1.nextToken());
            etot = etot + x;
            String y = st1.nextToken();
            if(y.equalsIgnoreCase("L")){
                x=x*-1;
            }
            e[i] = x;
        }
        ArrayList<Integer> eli = new ArrayList<>();
        for(int i = 0; i<elise; i++) {
            int x = e[i];
            int input = 1;
            if(x < 0) {
                input = input*-1;
            }
            for(int j = 0; j<Math.abs(x); j++) {
                eli.add(input);
            }
        }
        int index = Math.min(btot,etot);
        int be = 0;
        int el = 0;
        int greetings = 0;
        for (int i = 0; i<index; i++) {
            int x = bes.get(i);
            int y = eli.get(i);
            be = be+x;
            el = el+y;
            if(be==el && x!=y) {
                greetings = greetings +1;
            }
        }
        if(index == btot) {
            int index2 = Math.max(etot,btot);
            for(int i = index; i<index2;i++){
                int y = eli.get(i);
                el = el+y;
                if(be==el) {
                    greetings = greetings +1;
                }
            }
        }
        else {
            int index2 = Math.max(etot,btot);
            for(int i = index; i<index2;i++){
                int y = bes.get(i);
                be = be+y;
                if(be==el) {
                    greetings = greetings +1;
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("greetings.out"));
        out.println(greetings);
        out.close();
    }
}