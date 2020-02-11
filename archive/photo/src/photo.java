import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class photo {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("photo.in"));
        int cows = Integer.parseInt(f.readLine());
        int [] cowNum = new int[cows];
        for(int i = 0; i<cows; i++) {
            cowNum[i] = i+1;
        }
        int []Bessie = new int[cows-1];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i<cows-1; i++) {
            Bessie[i] = Integer.parseInt(st.nextToken());
        }
        int[] done = new int[cows];
        PrintWriter out = new PrintWriter(new FileWriter("photo.out"));
        for (int i = 1; i<cows; i++) {
            Set<Integer> repeat = new HashSet<>();
            repeat.add(i);
            int before = i;
            done[0] = before;
            int size = 1;
            for(int j = 0; j<cows-1; j++) {
                boolean wrong = false;
                int finding = Bessie[j];
                int num = finding-before;
                if(num<=cows) {
                    repeat.add(num);
                    int y = repeat.size();
                    if(y == size) {
                        wrong = true;
                    }
                    size = size+1;
                }
                else {
                    wrong = true;
                }
                if(wrong) {
                    break;
                }
                before = num;
                done[j+1] = before;
            }
            if(repeat.size() == cows) {
                break;
            }
        }
        String results = "";
        results = results + done[0];
        for(int i = 1; i<cows; i++) {
            results = results + " " + done[i];
        }
        out.println(results);
        out.close();
    }
}
