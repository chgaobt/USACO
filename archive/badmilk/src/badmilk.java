import java.io.*;
import java.util.*;

public class badmilk {
    public static void main (String []args) throws IOException {
        // Initial input values
        BufferedReader f = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new FileWriter("badmilk.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int people = Integer.parseInt(st.nextToken());
        int milks = Integer.parseInt(st.nextToken());
        int timesDrank = Integer.parseInt(st.nextToken());
        int sick = Integer.parseInt(st.nextToken());

        //Store all data values
        HashMap<Integer, TreeMap<Integer, ArrayList<Integer>>> record = new HashMap<>();
        HashMap<Integer, Set<Integer>> milkCount = new HashMap<>();

        for(int i = 0; i<timesDrank; i++) {
            StringTokenizer ft = new StringTokenizer(f.readLine());
            int person = Integer.parseInt(ft.nextToken());
            int milk = Integer.parseInt(ft.nextToken());
            int time = Integer.parseInt(ft.nextToken());
            if(record.get(person) == null) {
                TreeMap<Integer, ArrayList<Integer>> x = new TreeMap<>();
                ArrayList<Integer> y = new ArrayList<>();
                y.add(milk);
                x.put(time,y);
                record.put(person,x);
            }
            else {
                TreeMap<Integer, ArrayList<Integer>> x = record.get(person);
                if(x.get(time) == null) {
                    ArrayList<Integer> y = new ArrayList<>();
                    y.add(milk);
                    x.put(time,y);
                    record.put(person,x);
                }
                else {
                    ArrayList<Integer> y = x.get(time);
                    y.add(milk);
                    x.put(time,y);
                    record.put(person,x);
                }
            }
            //make sure that if the same person drinks the same type of milk twice it does not get double counted
            if(milkCount.get(milk) == null) {
                Set<Integer> t = new HashSet<>();
                t.add(person);
                milkCount.put(milk, t);
            }
            else {
                Set<Integer> b = milkCount.get(milk);
                b.add(person);
                milkCount.put(milk, b);
            }
        }

        HashMap<Integer, Set<Integer>> tracking = new HashMap<>();
        HashMap<Integer, Integer> possiblyBad = new HashMap<>();
        for(int i = 0; i<sick; i++) {
            StringTokenizer ft = new StringTokenizer(f.readLine());
            int person = Integer.parseInt(ft.nextToken());
            int time = Integer.parseInt(ft.nextToken());
            TreeMap<Integer, ArrayList<Integer>> x = record.get(person);
            for(Integer m : x.keySet()) { // go through and record all the types of milk the person drank before getting sick
                if(m<time) {
                    ArrayList<Integer> y = x.get(m);
                    int size = y.size();
                    for(int a = 0; a<size; a++) {
                        if(possiblyBad.get(y.get(a)) == null) {
                            possiblyBad.put(y.get(a),1);
                        }
                        else {
                            int hold = possiblyBad.get(y.get(a));
                            possiblyBad.put(y.get(a), hold+1);
                        }
                        // make sure nothing is double counted if the person drinks the same type of milk twice
                        if(tracking.get(y.get(a))== null) {
                            Set<Integer> e = new HashSet<>();
                            e.add(person);
                            tracking.put(y.get(a), e);
                        }
                        else {
                            Set e = tracking.get(y.get(a));
                            e.add(person);
                            tracking.put(y.get(a), e);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(Integer m : possiblyBad.keySet()) {
            if(tracking.get(m).size() == sick) { // make sure all possibilities recorded were drank by all the sick people
                Set t = milkCount.get(m);
                int size = t.size();
                if (size > max) {
                    max = size;
                }
            }
        }
        out.println(max);
        out.close();
    }
}
