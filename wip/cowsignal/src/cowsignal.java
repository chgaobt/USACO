import java.io.*;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int sizeIncrease = Integer.parseInt(st.nextToken());

        char[][] oriSignal = new char[length][width];
        for(int i = 0; i<length; i++) {
            char[] row = f.readLine().toCharArray();
            oriSignal[i] = row;
        }

        PrintWriter out = new PrintWriter(new FileWriter("cowsignal.out"));
        char[][] newSignal = new char[(length*sizeIncrease)][(width*sizeIncrease)];
        for(int i = 0; i<length; i++) {
            for(int j = 0; j<width; j++) {
                char x = oriSignal[i][j];
                int rowStart = i * sizeIncrease;
                for(int k = 0; k<sizeIncrease; k++) {
                    rowStart = rowStart+k;
                    int columnStart = j*sizeIncrease;
                    for(int h = 0; h<sizeIncrease; h++) {
                        columnStart = columnStart+h;
                        newSignal[rowStart][columnStart] = x;
                    }
                    if( j == width-1) {
                        out.println(newSignal[rowStart]);
                    }
                }
            }
        }
        out.close();
    }
}
