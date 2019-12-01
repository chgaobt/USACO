/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=259
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cowrace {
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("cowrace.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int BessieSize = Integer.parseInt(st.nextToken());
        int MaggieSize = Integer.parseInt(st.nextToken());
        int totalTIme = 0;
        ArrayList<Integer> BessieSpeed = new ArrayList<>();
        ArrayList<Integer> MaggieSpeed = new ArrayList<>();

        //Input data
        for (int i = 0; i < BessieSize; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int y =Integer.parseInt(st1.nextToken());
            BessieSpeed.add(y);
            int x = Integer.parseInt(st1.nextToken());
            totalTIme = totalTIme + x;
            for( int j = 1; j<x;j++) {
                BessieSpeed.add(y);
            }
        }
        for (int i = 0; i < MaggieSize; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int y = Integer.parseInt(st1.nextToken());
            MaggieSpeed.add(y);
            int x = Integer.parseInt(st1.nextToken());
            for( int j = 0; j<(x-1);j++) {
                MaggieSpeed.add(y);
            }
        }

        //Stimulate race by tracking both cows time segment by time segment 
        int LeadingCow = 3;
        int change = 0;
        int BCurrent = 0;
        int MCurrent = 0;
        for(int i = 0; i<totalTIme; i++) {
            int x = BessieSpeed.get(i);
            int y = MaggieSpeed.get(i);
            BCurrent = BCurrent + x;
            MCurrent = MCurrent + y;
            if(LeadingCow == 3) {
                if(BCurrent>MCurrent) {
                    LeadingCow = 0;
                }
                if(MCurrent>BCurrent) {
                    LeadingCow = 1;
                }
            }
            else {
                if(BCurrent>MCurrent && LeadingCow == 1) {
                    LeadingCow = 0;
                    change = change +1;
                }
                if(MCurrent>BCurrent && LeadingCow == 0) {
                    LeadingCow = 1;
                    change = change +1;
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileWriter("cowrace.out"));
        out.println(change);
        out.close();
    }
}
