import java.io.*;
import java.util.HashMap;

public class art {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("art.in"));
        int canvas = Integer.parseInt(f.readLine());
        char [][] painting = new char[canvas][canvas];
        for(int i = 0; i<4; i++) {
            String x = f.readLine();
            char[] y = x.toCharArray();
            painting[i] = y;
        }
        HashMap<Integer,Integer> answers = new HashMap<>();
        HashMap<Integer, int[]> colors = new HashMap<>();
        for(int i = 0; i<canvas; i++) {
            for (int j = 0; j<canvas; j++) {
                int compare = painting[i][j]-48;
                if(compare == 0) {
                    continue;
                }
                else {
                    if (colors.get(compare) == null) {
                        int[] x = new int[4];
                        x[0] = i;
                        x[1] = i;
                        x[2] = j;
                        x[3] = j;
                        colors.put(compare, x);
                        answers.put(compare,1);
                    } else {
                        int[] x = colors.get(compare);
                        if (i > x[1] ) {
                            x[1] = i;
                        }
                        if(i<x[0]) {
                            x[0] = i;
                        }
                        if(j> x[3] ) {
                            x[3] = j;
                        }
                        if(j<x[2]) {
                            x[2] = j;
                        }
                    }
                }
            }
        }
        for (int col : colors.keySet()) {
            int[] para = colors.get(col);
            for(int i = para[0]; i<=para[1]; i++) {
                for (int j = para[2]; j<=para[3]; j++) {
                    int comp = painting[i][j]-48;
                    if(comp != col ) {
                        answers.remove(comp);
                    }
                }
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("art.out"));
        out.println(answers.size());
        out.close();
    }
}
