import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class hopscotch {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] board = new char[length][width];

        for (int i = 0; i < length; i++) {
            String row = f.readLine();
            char[] rowchar = row.toCharArray();
            for (int j = 0; j < width; j++) {
                board[i][j] = rowchar[j];
            }
        }


    }
}
