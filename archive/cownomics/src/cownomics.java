import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cownomics {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(st.nextToken());
        int positions = Integer.parseInt(st.nextToken());
        String[] spotted = new String[cows];
        String[] plain = new String[cows];
        for(int i = 0; i<cows; i++) {
            spotted[i] = f.readLine();
        }
        for(int i = 0; i<cows; i++) {
            plain[i] = f.readLine();
        }
        int count = 0;
        for(int i = 0; i<positions; i++) {
            count = count + solve(spotted, plain, i,cows);
        }
        PrintWriter out = new PrintWriter(new FileWriter("cownomics.out"));
        out.println(count);
        out.close();
    }

    static int solve (String[] spotted, String[] plain, int i,int cows) throws IOException {
        int count = 0;
        HashMap<Character, Integer> genes = new HashMap<>();
        genes.put('A',0);
        genes.put('C',0);
        genes.put('G',0);
        genes.put('T',0);

        for(int t = 0; t<cows; t++) {
            int k = genes.get(spotted[t].charAt(i)) + 1;
            genes.put(spotted[t].charAt(i),k);
        }
        HashMap<Character, Integer> geneP = new HashMap<>();
        geneP.put('A',0);
        geneP.put('C',0);
        geneP.put('G',0);
        geneP.put('T',0);
        for(int t = 0; t<cows; t++) {
            int k = geneP.get(plain[t].charAt(i)) + 1;
            geneP.put(plain[t].charAt(i),k);
        }

        count = compare(geneP,genes,spotted,plain);
        return count;
    }

    static int compare(HashMap<Character,Integer> geneP, HashMap<Character,Integer> genes, String[]spotted, String[] plain) {
        int count = 0;
        if(genes.get('A') > 0) {
            if(geneP.get('A') == 0) {
                count = count +1;
            }
        }
        else {
            count = count+1;
        }
        if(genes.get('C') > 0) {
            if(geneP.get('C') == 0) {
                count = count +1;
            }
        }
        else {
            count = count+1;
        }
        if(genes.get('G') > 0) {
            if(geneP.get('G') == 0) {
                count = count +1;
            }
        }
        else {
            count = count+1;
        }
        if(genes.get('T') > 0) {
            if(geneP.get('T') == 0) {
                count = count +1;
            }
        }
        else {
            count = count+1;
        }

        if(count == 4) {
            count = 1;
        }
        else {
            count = 0;
        }
        return count;
    }
}
