import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class notlast {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
        int log = Integer.parseInt(f.readLine());
        HashMap<String,Integer> cowLog = new HashMap<>();
        cowLog.put("Bessie",0);
        cowLog.put("Maggie",0);
        cowLog.put("Elsie",0);
        cowLog.put("Henrietta",0);
        cowLog.put("Gertie",0);
        cowLog.put("Daisy",0);
        cowLog.put("Annabelle",0);
        ArrayList<String> cows = new ArrayList<>();
        cows.add("Bessie");
        cows.add("Maggie");
        cows.add("Elsie");
        cows.add("Henrietta");
        cows.add("Gertie");
        cows.add("Daisy");
        cows.add("Annabelle");

        for (int i = 0; i<log; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String name = st.nextToken();
            int x = cowLog.get(name) + Integer.parseInt(st.nextToken());
            cowLog.put(name,x);
        }

        ArrayList<Integer> milkAmount = new ArrayList<>();
        milkAmount.add(cowLog.get("Bessie"));
        milkAmount.add(cowLog.get("Maggie"));
        milkAmount.add(cowLog.get("Elsie"));
        milkAmount.add(cowLog.get("Henrietta"));
        milkAmount.add(cowLog.get("Gertie"));
        milkAmount.add(cowLog.get("Daisy"));
        milkAmount.add(cowLog.get("Annabelle"));

        Collections.sort(milkAmount);
        int second = milkAmount.get(0);
        int smallest = milkAmount.get(0);
        for(Integer amount:milkAmount) {
            if(amount != smallest) {
                second = amount;
                break;
            }
        }

        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i<7;i++) {
            int compare = cowLog.get(cows.get(i));
            if(compare == second) {
                names.add(cows.get(i));
            }
        }

        int size = names.size();
        PrintWriter out = new PrintWriter(new FileWriter("notlast.out"));
        if(size > 1) {
            out.println("Tie");
        }
        else {
            for (String name : names) {
                out.println(name);
            }
        }
        out.close();
    }
}