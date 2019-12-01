/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=688
 */

import java.io.*;
import java.util.StringTokenizer;

public class hps {
    static public void main (String []args) throws IOException {
        // read and store input data
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        int rounds = Integer.parseInt(f.readLine());
        int[] cow1 = new int[rounds];
        int[] cow2 = new int[rounds];
        for (int i = 0; i < rounds; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cow1[i] = Integer.parseInt(st.nextToken());
            cow2[i] = Integer.parseInt(st.nextToken());
        }

        int wins = 0;
        for (int i = 0; i < 3; i++) {
            int rock = 1;
            int paper = 2;
            int scissor = 3;
            for (int t = 0; t < 3; t++) {
                int win = 0;
                for (int j = 0; j < rounds; j++) {
                    int x = cow1[j];
                    int y = cow2[j];
                    win = win + calculatePlay(rock,paper,scissor,x,y); //Stimulate the actual game; create conditionals that act like the rules in rock, paper, sisors where rock beats sissors, sissors beats paper, and paper beats rock

                }
                if (win > wins) {
                    wins = win;
                }
                int z = paper;
                paper = scissor;
                scissor = z; // repeat the process so that the input data represent different actions in the game
            }
            rock = (rock+1) % 3;
            paper = (rock+1) % 3;
            scissor = (scissor+1) % 3;
        }

        PrintWriter out = new PrintWriter(new FileWriter("hps.out"));
        out.println(wins);
        out.close();
    }

    static int calculatePlay (int rock, int paper, int scissor, int x, int y) {
        int win = 0;
        int cow1 = 0;
        int cow2 = 0;

        if (rock == x) {
            cow1 = 1;
        }
        else {
            if (paper == x) {
                cow1 = 2;
            }

            else {
                cow1 = 3;
            }
        }
        if (rock == y) {
            cow2 = 1;
        }
        else {
            if (paper == y) {
                cow2 = 2;
            }

            else {
                cow2 = 3;
            }
        }

        if (cow1 == 1 && cow2 == 3) {
            win = win +1;
        }

        if (cow1 == 2 && cow2 == 1) {
            win = win +1;
        }

        if (cow1 == 3 && cow2 == 2) {
            win = win+1;
        }

        return win;
    }
}
