import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

public class scramble {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("scramble.in"));
        int words = Integer.parseInt(f.readLine());
        HashMap<Integer,int[]> record = new HashMap<>();
        String [] wordList = new String[words];
        for(int i = 0; i<words; i++) {
            String word = f.readLine();
            wordList[i] = word;
            record.put(i, null);
        }
        TreeMap<String, Integer> track = new TreeMap<>();
        TreeMap<String, Integer> trace = new TreeMap<>();
        int k = 0;
        for(String w: wordList) {
            char[] x = w.toCharArray();
            TreeMap<Character, Integer> t = new TreeMap<>();
            for(char c: x) {
                if(t.get(c) == null) {
                    t.put(c,1);
                }
                else {
                    int z = t.get(c) +1;
                    t.put(c,z);
                }
            }
            String y = "";
            for (char c :t.keySet()){
                int dup = t.get(c);
                for(int i = 0; i<dup; i++) {
                    y=y+c;
                }
            }
            String a = "";
            for (char c :t.descendingKeySet()){
                int dup = t.get(c);
                for(int i = 0; i<dup; i++) {
                    a=a+c;
                }
            }
            track.put(y,k);
            trace.put(a,k);
            k = k+1;
        }
        int i = 1;
        for(String word: track.keySet()) {
            int[] array = new int[2];
            array[0] = i;
            int ID = track.get(word);
            record.put(ID,array);
            i = i+1;
        }
        int j = 1;
        for(String word: trace.keySet()) {
            int ID = trace.get(word);
            int[] array = record.get(ID);
            array[1] = j;
            record.put(ID,array);
            j = j+1;
        }

        PrintWriter out = new PrintWriter(new FileWriter("scramble.out"));
        for(Integer id: record.keySet()) {
            int[] array= record.get(id);
            int x = array[0];
            int y = array[1];
            int min = Math.min(x,y);
            int max = Math.max(x,y);
            out.println(min+ " " + max);
        }
        out.close();
    }
}
