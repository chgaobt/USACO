/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=893
 */


import java.io.*;
import java.util.*;

public class guess {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("guess.in"));
        int animals = Integer.parseInt(f.readLine());
        ArrayList<Set<String>> record = new ArrayList<>();
        for(int i = 0; i<animals; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String aniName = st.nextToken();
            int numChara = Integer.parseInt(st.nextToken());
            Set<String> array = new HashSet<>();
            for(int j = 0; j<numChara;j++) {
                String chara = st.nextToken();
                array.add(chara);
            }
            record.add(array);
        }

        int max = 0;
        for(int i = 0; i<animals-1; i++) {
            for(int j = i+1; j<animals;j++) {
                int overlap = 0;
                Set<String> x = record.get(i);
                int size = x.size();
                Set<String> y = record.get(j);
                size = size + y.size();
                Set<String> combine = new HashSet<>();
                combine.addAll(x);
                combine.addAll(y);
                int csize = combine.size();
                overlap = size - csize;
                if(overlap>max) {
                    max = overlap;
                }
            }
        }

        PrintWriter out = new PrintWriter(new File("guess.out"));
        out.println(max+1);
        out.close();
    }
}
