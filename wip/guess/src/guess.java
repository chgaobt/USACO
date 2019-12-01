/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=893
 */


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class guess {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("guess.in"));
        int animals = Integer.parseInt(f.readLine());
        HashMap<String, String[]> record = new HashMap<>();
        HashMap<String, Integer> track = new HashMap<>();
        for(int i = 0; i<animals; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String aniName = st.nextToken();
            int numChara = Integer.parseInt(st.nextToken());
            String [] array = new String[numChara];
            for(int j = 0; j<numChara;j++) {
                String chara = st.nextToken();
                array[j] = chara;
                if(track.get(chara) == null) {
                    track.put(chara, 1);
                }
                else {
                    int ori = track.get(chara)+1;
                    track.put(chara,ori);
                }
            }
            record.put(aniName,array);
        }

        int max = 0;
        for(String ani : record.keySet()) {
            String [] cha = record.get(ani);
            int compare = 0;
            for(String ch : cha) {
                int share = track.get(ch);
                if(share > 1) {
                    compare = compare+1;
                }
            }
            if(compare>max) {
                max = compare;
            }
        }

        PrintWriter out = new PrintWriter(new File("guess.out"));
        out.println(max+1);
        out.close();
    }
}
