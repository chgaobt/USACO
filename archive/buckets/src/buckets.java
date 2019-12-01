import java.io.*;
import java.util.HashMap;

public class buckets {
    public static void main (String []args) throws IOException {
        char [][] farm = new char[10][10];
        HashMap <Character,Pair> location = new HashMap<>();
        BufferedReader f = new BufferedReader(new FileReader("buckets.in"));
        for (int i = 0; i <10; i++) {
            char[] demo = (f.readLine().toCharArray());
            for(int j = 0; j<10; j++) {
                farm[i][j] = demo[j];
                if (demo[j] == 'B') {
                    Pair loca = new Pair(i,j);
                    location.put('B', loca);
                }

                if (demo[j] == 'R') {
                    Pair loca = new Pair(i,j);
                    location.put('R', loca);
                }

                if (demo[j] == 'L') {
                    Pair loca = new Pair(i,j);
                    location.put('L', loca);
                }
            }
        }

        int cows = 0;
        int b_length = (int)location.get('B').getFirst()+1;
        int l_length = (int) location.get('L').getFirst()+1;
        int b_width = (int) location.get('B').getSecond()+1;
        int l_width = (int) location.get('L').getSecond()+1;
        int length = Math.abs(b_length-l_length);
        int width = Math.abs(b_width-l_width);
        if(width == 0) {
            cows = length-1;
        }
        else {
            if (length == 0) {
                cows = width - 1;
            }
            else{
                cows = (length+width)-1;
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("buckets.out"));
        out.println(cows);
        out.close();
    }
}

class Pair<A, B> {
    private A first = null;
    private B second = null;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}
