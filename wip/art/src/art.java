import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class art {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("art.in"));
        int canvas = Integer.parseInt(f.readLine());
        char[][] painting = new char[canvas][canvas];
        for(int i = 0; i<4; i++) {
            String x = f.readLine();
            char[] y = x.toCharArray();
            painting[i] = y;
        }


    }
}
