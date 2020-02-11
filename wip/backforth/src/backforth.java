import java.io.*;
import java.util.*;

public class backforth {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
        HashMap<Integer, Integer> barn1 = new HashMap<>();  //bucket
        HashMap<Integer, Integer> barn2 = new HashMap<>();
        Set<Integer> b1 = new HashSet<>();
        Set<Integer> b2 = new HashSet<>();
        Set<Integer> ori1 = new HashSet<>();
        Set<Integer> ori2 = new HashSet<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i<10; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(barn1.get(x) == null) {
                barn1.put(x,1);
                b1.add(x);
                ori1.add(x);
            }
            else {
                int y = barn1.get(x);
                barn1.put(x,y+1);
            }
        }
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        for(int i = 0; i<10; i++) {
            int x = Integer.parseInt(st1.nextToken());
            if(barn2.get(x) == null) {
                barn2.put(x,1);
                b2.add(x);
                ori2.add(x);
            }
            else {
                int y = barn2.get(x);
                barn2.put(x,y+1);
            }
        }
        Set<Integer> possible = new HashSet<>();

        for(int bucket1 : b1) {
            int milk = 1000;
            int y = barn1.get(bucket1);
            barn1.put(bucket1,y-1);
            milk = milk-bucket1;
            b2.add(bucket1);
            if(barn2.get(bucket1) == null) {
                barn2.put(bucket1,1);
            }
            else {
                int g = barn2.get(bucket1);
                barn2.put(bucket1, g+1);
            }

            //Reset
            Set <Integer> b11 = new HashSet<>();
            b11.addAll(b1);
            Set <Integer> b21 = new HashSet<>();
            b21.addAll(b2);

            for(int bucket2 : b21) {
                milk = milk+bucket2;
                int a = barn2.get(bucket2);
                barn2.put(bucket2,a-1);
                if(barn1.get(bucket2) == null) {
                    barn1.put(bucket2,1);
                }
                else {
                    int b = barn1.get(bucket2);
                    barn1.put(bucket2,b+1);
                }
                b11.add(bucket2);

                Set <Integer> b12 = new HashSet<>();
                b12.addAll(b11);
                Set <Integer> b22 = new HashSet<>();
                b22.addAll(b21);

                for (int bucket3 : b12) {
                    if(barn1.get(bucket3) < 1) {
                        continue;
                    }
                    milk = milk - bucket3;
                    int c = barn1.get(bucket3);
                    barn1.put(bucket3, c-1);
                    if(barn2.get(bucket3) == null) {
                        barn2.put(bucket3,1);
                    }
                    else {
                        int b = barn2.get(bucket3);
                        barn2.put(bucket3,b+1);
                    }
                    b21.add(bucket3);

                    for(int bucket4 : b22) {
                        if (barn2.get(bucket4) < 1) {
                            continue;
                        }
                        milk = milk + bucket4;
                        possible.add(milk);
                    }

                 }

            }
            b1 = new HashSet<>();
            b1.addAll(ori1);
            b2 = new HashSet<>();
            b2.addAll(ori2);
        }
        PrintWriter out = new PrintWriter(new FileWriter("backforth.out"));
        out.println(possible.size());
        out.close();
    }
}
