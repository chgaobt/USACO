import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class blocks {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        int blocks = Integer.parseInt(f.readLine());
        HashMap<Character,Integer> alphabet = new HashMap<>();
        fillHashmap(alphabet);
        String[] block = new String[blocks*2];
        for(int i = 0; i<blocks*2; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            block[i] = st.nextToken();
            i=i+1;
            block[i] = st.nextToken();
        }

        for(int i = 0; i<blocks*2; i++) {
            String x = block[i];
            String y = block[i+1];
            int z = x.length();
            for(int j = 0; j<z; j++) {
                char k = (x.charAt(j));
                char h = (y.charAt(j));
                int a = alphabet.get(x.charAt(j)) +1;
                int b = alphabet.get(y.charAt(j)) +1;
                if(k!=h) {
                    alphabet.put(x.charAt(j), a);
                    alphabet.put(y.charAt(j),b);
                }

                else {
                    alphabet.put(x.charAt(j),a);
                }
            }

            i=i+1;
        }

        PrintWriter out = new PrintWriter(new FileWriter("blocks.out"));
        out.println(alphabet.get('a'));
        out.println(alphabet.get('b'));
        out.println(alphabet.get('c'));
        out.println(alphabet.get('d'));
        out.println(alphabet.get('e'));
        out.println(alphabet.get('f'));
        out.println(alphabet.get('g'));
        out.println(alphabet.get('h'));
        out.println(alphabet.get('i'));
        out.println(alphabet.get('j'));
        out.println(alphabet.get('k'));
        out.println(alphabet.get('l'));
        out.println(alphabet.get('m'));
        out.println(alphabet.get('n'));
        out.println(alphabet.get('o'));
        out.println(alphabet.get('p'));
        out.println(alphabet.get('q'));
        out.println(alphabet.get('r'));
        out.println(alphabet.get('s'));
        out.println(alphabet.get('t'));
        out.println(alphabet.get('u'));
        out.println(alphabet.get('v'));
        out.println(alphabet.get('w'));
        out.println(alphabet.get('x'));
        out.println(alphabet.get('y'));
        out.println(alphabet.get('z'));
        out.close();

    }

    static void fillHashmap(HashMap<Character,Integer> hashMap){
        hashMap.put('a',0);
        hashMap.put('b',0);
        hashMap.put('c',0);
        hashMap.put('d',0);
        hashMap.put('e',0);
        hashMap.put('f',0);
        hashMap.put('g',0);
        hashMap.put('h',0);
        hashMap.put('i',0);
        hashMap.put('j',0);
        hashMap.put('k',0);
        hashMap.put('l',0);
        hashMap.put('m',0);
        hashMap.put('n',0);
        hashMap.put('o',0);
        hashMap.put('p',0);
        hashMap.put('q',0);
        hashMap.put('r',0);
        hashMap.put('s',0);
        hashMap.put('t',0);
        hashMap.put('u',0);
        hashMap.put('v',0);
        hashMap.put('w',0);
        hashMap.put('x',0);
        hashMap.put('y',0);
        hashMap.put('z',0);
    }
}
