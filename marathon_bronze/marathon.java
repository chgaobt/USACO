/*
USACO 2014 Dec Bronze Problem 1: Marathon
https://usaco.org/index.php?page=viewproblem2&cpid=487
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class marathon{
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter out = new PrintWriter(new FileWriter("marathon.out"));

        int checkpoints = Integer.parseInt(f.readLine());
        int[] xCoordinates = new int[checkpoints];
        int[] yCoordinates = new int[checkpoints];
        int totalDistance = 0;
        int[] intermediateDistances = new int[checkpoints-1];                   //distance between two checkpoints
        int max = 0;                                                            //maximum distance between two checkpoints
        int index = -1;                                                         // checkpoint to be skipped

        //loop through each given checkpoint and update parameters
        for(int i = 0; i<checkpoints; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            xCoordinates[i] = Integer.parseInt(st.nextToken());
            yCoordinates[i] = Integer.parseInt(st.nextToken());

            if(i != 0) {
                intermediateDistances[i-1] = Math.abs(xCoordinates[i-1] - xCoordinates[i]) + Math.abs(yCoordinates[i-1]-yCoordinates[i]);
                totalDistance += intermediateDistances[i-1];
            }

            if(i > 1) {

                //Need to find the net change in distance if the checkpoint before is skipped 
                //Net Distance = IntermediateDist[1-2] + IntermediateDist[2-3] - IntermediateDist[1-3]
                //Want to remove the checkpoint with the largest net distance 

                int dist = intermediateDistances[i-1] + intermediateDistances[i-2] - (Math.abs(xCoordinates[i-2]-xCoordinates[i])+Math.abs(yCoordinates[i-2]-yCoordinates[i]));
                max = Math.max(max, dist);
                if(max == dist) {
                    index = i-1;
                }
            }
        }

        totalDistance -= (intermediateDistances[index-1] + intermediateDistances[index]); 
        totalDistance += Math.abs(xCoordinates[index-1]-xCoordinates[index+1]) + Math.abs(yCoordinates[index-1]-yCoordinates[index+1]);

        out.println(totalDistance);
        out.close();
    }
}