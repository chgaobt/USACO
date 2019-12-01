import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class circlecross {
    static public void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
        String string = f.readLine();  //52  letters
        char[] field = string.toCharArray(); // change to char array
        LinkedList<Character> linkedList = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < 51; i++) {
            if(field[i] != field[i+1]) {
                if ((i+1) == 51) {
                    linkedList.add(field[i]);
                    linkedList.add(field[i+1]);
                }
                else {
                    linkedList.add(field[i]);
                }
            }

            else{
                i = i+1;
            }
        }

        count = calculatePairs(linkedList);
        PrintWriter out = new PrintWriter(new FileWriter("circlecross.out"));
        out.println(count);
        out.close();
    }

    static int calculatePairs (LinkedList<Character> linkedList) {
        int count = 0;
        int size = linkedList.size();
        HashMap<Character,Integer> index = new HashMap<>();

        for (int i = 0; i < size; i++) {
            index.put(linkedList.get(i),0);
        }

        size = index.size();
        count = size/2;
        return count;
    }
}
