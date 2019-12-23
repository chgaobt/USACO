import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class lineup {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lineup.in")); //Read Input File
        int rules = Integer.parseInt(f.readLine());
        String [] cow1 = new String[rules];
        String [] cow2 = new String[rules];
        for(int i = 0; i<rules; i++) { // Input special cows that have to be next to other cows into array
            StringTokenizer st = new StringTokenizer(f.readLine());
            String cowA = st.nextToken();
            cow1[i] = cowA;
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            String d = st.nextToken();
            String cowB = st.nextToken();
            cow2[i] = cowB;
        }
        //Create master key of all the cows in alphabetical order
        TreeMap<String, Integer> alpha = new TreeMap<>();
        alpha.put("Beatrice",1);
        alpha.put("Belinda", 2);
        alpha.put("Bella", 3);
        alpha.put("Bessie", 4);
        alpha.put("Betsy", 5);
        alpha.put("Blue", 6);
        alpha.put("Buttercup", 7);
        alpha.put("Sue", 8);
        //Main loop that will sort the cows based on the special requirements and in alphabetical order
        int returnCount = 0;
        String[] answer = new String[8];
        while(returnCount<8) {
            for(String cow : alpha.keySet()) {
                boolean next = false;

                //the cow is not in the answer list
                if(location(answer,cow) == 999) {
                    next = next(cow, cow1, cow2,answer,rules,returnCount);
                }
                if(next) {
                    answer[returnCount] = cow;
                    returnCount = returnCount+1;
                    break;
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
        for(int i = 0; i<8; i++) {
            out.println(answer[i]);
        }
        out.close();
    }
    static int location (String[] answer, String cow) {
        for(int i = 0; i<8; i++) {
            if(answer[i] != null) {
                if (answer[i].equalsIgnoreCase(cow)) {
                    return i;
                }
            }
        }
        int out = 999;
        return out;
    }
    static boolean next (String cow, String[] cow1, String[] cow2,String[] answer, int rules, int Count) {
        boolean next = true;
        int nbrs = 0;
        for(int i = 0; i<rules; i++) {
            if(cow1[i].equalsIgnoreCase(cow) && location(answer,cow2[i])== 999) {
                nbrs = nbrs+1;
            }
            if(cow2[i].equalsIgnoreCase(cow) && location(answer,cow1[i])==999) {
                nbrs = nbrs+1;
            }
        }
        if(nbrs == 2) {
            next = false;
            return next;
        }
        if(Count>0) {
            String prev = answer[Count-1];
            String looking = null;
            for(int i = 0; i<rules; i++) {
                if(cow1[i].equalsIgnoreCase(prev)) {
                    if(location(answer,cow2[i]) == 999) {
                        looking = cow2[i];
                    }
                }
                if(cow2[i].equalsIgnoreCase(prev)) {
                    if(location(answer,cow1[i]) == 999) {
                        looking = cow1[i];
                    }
                }
            }
            if(looking!=null) {
                if(cow.equalsIgnoreCase(looking)) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}