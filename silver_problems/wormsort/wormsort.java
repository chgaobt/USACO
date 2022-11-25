import java.io.*;
import java.util.*;

public class wormsort {
    static int[] order; 
    static ArrayList<wormhole> wormholes; 
    static ArrayList<ArrayList<Integer>> map; 
    public static void main (String []args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("wormsort.in")); 
        StringTokenizer st = new StringTokenizer(f.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        order = new int[n]; 
        wormholes = new ArrayList<>(); 
        st = new StringTokenizer(f.readLine()); 
        map = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<n; i++) {
            order[i] = Integer.parseInt(st.nextToken()); 
            map.add(new ArrayList<>()); 

        }
        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(f.readLine()); 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); 
            int w = Integer.parseInt(st.nextToken()); 
            wormholes.add(new wormhole(a, b, w));
        }
        Collections.sort(wormholes, new sort()); 
        PrintWriter out = new PrintWriter(new FileWriter("wormsort.out"));  
        for(int i = 0; i<m; i++) {
            wormhole x = wormholes.get(i); 
            ArrayList<Integer> arrayList = map.get(x.a-1); 
            arrayList.add(x.b-1); 
            arrayList = map.get(x.b-1); 
            arrayList.add(x.a-1);  
            boolean sorted = false;
            int[] copy = order.clone(); 
            //search and sort 
            sorted = sort(copy); 
            if(sorted) {
                out.print(x.w);
                break; 
            }
        }
        out.close();
    }
    public static boolean sort (int[] array){
        boolean sorted = false; 
        for(int i = 0; i<array.length; i++) {
            if(array[i] != i+1) {
                int x = swap(array, i);
                if(x == -1) {
                    return false; 
                }
            }
        }
        return sorted; 
    }
    public static int swap (int[] array, int index) {
        ArrayList<Integer> arrayList = map.get(index); 
        if(arrayList == null) {
            return -1; 
        }
        else{
            for(int x: arrayList) {
                
            }
        }
        return 1; 
    }
}

class wormhole{
    int a; 
    int b; 
    int w; 

    public wormhole(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w; 
    }
    
}

class sort implements Comparator<wormhole> {
    public int compare (wormhole a, wormhole b) {
        if(a.w < b.w) {
            return 1;
        } 
        else {
            return -1; 
        }
    }
}