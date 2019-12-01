import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class auto {
    static ArrayList<String> words;

    public static int bSearch(String prefix, int l, int h){

         while (l < h-1){
             int mid = (l+h)/2;
             if (words.get(mid).compareTo(prefix) < 0){
                 l = mid;
             }else
             {
                 h=mid;
             }
        }

         if (words.get(l).compareTo(prefix) <0) {
             l++;
         }
        return l;
    }

    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("auto.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int wordsCt = Integer.parseInt(st.nextToken());
        int part = Integer.parseInt(st.nextToken());
        TreeMap<String,Integer> dict = new TreeMap<>();
        PrintWriter out = new PrintWriter(new FileWriter("auto.out"));

        //add the word to the dict
        for(int i = 0; i<wordsCt; i++) {
            dict.put(f.readLine(),i+1);
        }

        //sorted dict words
        words = new ArrayList();
        Iterator iterator = dict.keySet().iterator();
        while (iterator.hasNext()){
            words.add((String)iterator.next());
        }

        //find matching words

        for(int i = 0; i<part; i++) {
            String answer = null;
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st1.nextToken());
            String prefix = st1.nextToken();


            //find the location
            int j = bSearch(prefix, 0,wordsCt);


            System.out.println("find " + prefix + " start at " + j);

            //find match
            if (words.get(j).startsWith(prefix)) {
                  //out of the words list
                  if((j+p) >= words.size()) {
                        out.println(-1);
                       }
                  else
                    if(words.get((j+p)-1).startsWith(prefix)) {
                        answer = words.get((j+p)-1);
                        out.println(dict.get(answer));
                       }
                    else {
                        out.println(-1);
                       }
                }
            else
            {
                out.println(-1);
            }


        }
        out.close();
    }
}
