/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=807
 */

import java.io.*;
import java.util.StringTokenizer;

public class teleport {
    public static void main (String []args) throws IOException{
        // read and store input data
        BufferedReader f = new BufferedReader(new FileReader("teleport.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken()); // teleportation start point
        int b = Integer.parseInt(st.nextToken());// teleportations end point
        int x = Integer.parseInt(st.nextToken()); // delivery start point
        int y = Integer.parseInt(st.nextToken());// delivery end point

        if (a > b) { // make sure that a is the smaller value out of the two
            int buffer = a;
            a = b;
            b = buffer;
        }

        if (x < y) { // make sure x is the smaller value of the two
            int buffer = x;
            x = y;
            y = buffer;
        }

        int moved = 0;
        int c = Math.abs(x - b); // the value of the difference between teleportation start point and delivery start point
        moved = moved+c;
        int d = Math.abs(y - a); // value of the difference between teleportation end point and delivery end point
        moved = moved+d;

        int z = b-a;

        if (z < moved) { //exceptional case where the distance travelled is shorter if teleportation is not used
            moved = z;
        }

        PrintWriter out = new PrintWriter(new FileWriter("teleport.out"));
        out.println(moved);
        out.close();
    }
}
