import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class speeding {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int roadSeg = Integer.parseInt(st.nextToken());
        int driveSeg = Integer.parseInt(st.nextToken());
        int[] roadLength = new int[roadSeg];
        int[] SpeedLimit = new int[roadSeg];
        int[] driveLength = new int[driveSeg];
        int[] driveSpeed = new int[driveSeg];

        for(int i =0; i<roadSeg; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            roadLength[i] = Integer.parseInt(st1.nextToken());
            SpeedLimit[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i =0; i<driveSeg; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            driveLength[i] = Integer.parseInt(st1.nextToken());
            driveSpeed[i] = Integer.parseInt(st1.nextToken());
        }

        int speed = 0;

    }
}
