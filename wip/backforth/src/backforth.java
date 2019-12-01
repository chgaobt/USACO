import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class backforth {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
        int[] barn1 = new int[10];
        int[] barn2 = new int[10];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int j = 0; j<10; j++) {
            barn1[j] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        for(int i = 0; i<10; i++) {
            barn2[i] = Integer.parseInt(st1.nextToken());
        }
        int total = 0;
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ridDuplicates(first, barn1);
        ridDuplicates(second,barn2);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<second.size(); i++) {
            for(int j = 0; j<first.size(); j++) {
                int x = second.get(i)-first.get(j);
                result.add(x);
                result.add(2*x);
            }
        }
        ArrayList<Integer> finalized = new ArrayList<>();
        ridDuplicates2(finalized, result);
        total = total + finalized.size();
        for(int i = 0; i<second.size(); i++) {
            System.out.println(second.get(i));
        }
        PrintWriter out = new PrintWriter(new FileWriter("backforth.out"));
        out.println(total);
        out.close();
    }

    static void ridDuplicates (ArrayList<Integer> arrayList, int[] barn) {
        for(int i = 0; i<10; i++) {
            boolean duplicate = false;
            int compare = barn[i];
            if(arrayList.size() == 0) {
                arrayList.add(compare);
            }
            else{
                for(int bucket: arrayList) {
                    if(bucket == compare) {
                        duplicate = true;
                        break;
                    }
                }
                if(duplicate == false) {
                    arrayList.add(compare);
                }
            }
        }
    }

    static void ridDuplicates2 (ArrayList<Integer> arrayList, ArrayList<Integer> result) {
        for(int i = 0; i<result.size(); i++) {
            boolean duplicate = false;
            int compare = result.get(i);
            if(arrayList.size() == 0) {
                arrayList.add(compare);
            }
            else{
                for(int bucket: arrayList) {
                    if(bucket == compare) {
                        duplicate = true;
                        break;
                    }
                }
                if(duplicate == false) {
                    arrayList.add(compare);
                }
            }
        }
    }
}
