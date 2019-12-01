import java.io.*;
import java.util.StringTokenizer;

public class shell {
    static int swaps;
    static int [] firstS;
    static int [] secondS;
    static int [] guess;
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shell.in"));
        swaps = Integer.parseInt(f.readLine());
        firstS = new int[swaps];
        secondS = new int[swaps];
        guess = new int[swaps];

        for(int i = 0; i<swaps; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            firstS[i] = Integer.parseInt(st.nextToken());
            secondS[i] = Integer.parseInt(st.nextToken());
            guess[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        int [] case1 = new int[3];
        case1[0] = 1;
        case1[1] = 0;
        case1[2] = 0;
        int a = stimulate(case1);
        int [] case2 = new int[3];
        case2[0] = 0;
        case2[1] = 1;
        case2[2] = 0;
        int b = stimulate(case2);
        int [] case3 = new int[3];
        case3[0] = 0;
        case3[1] = 0;
        case3[2] = 1;
        int c = stimulate(case3);
        a = Math.max(a,b);
        total = Math.max(a,c);
        PrintWriter out = new PrintWriter(new FileWriter("shell.out"));
        out.println(total);
        out.close();
    }

    static int stimulate (int[] caseNum) {
        int correct = 0;
        for(int i = 0; i<swaps; i++) {
            int x = firstS[i]-1;
            int y = secondS[i]-1;
            swap(x,y,caseNum);
            if(caseNum[guess[i]-1]==1) {
                correct = correct+1;
            }
        }
        return correct;
    }

    static void swap (int x, int y, int[]caseNum) {
        int z = caseNum[x];
        caseNum[x] = caseNum[y];
        caseNum[y] = z;
    }
}
