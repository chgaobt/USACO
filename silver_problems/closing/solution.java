import java.io.*;
import java.util.*;

public class solution {
	
	static ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
	static boolean[] closed;
	static boolean[] used;
	
	static int countNodes(int current) {
		int count = 1;
		used[current] = true;
		
		for(int i: roads.get(current)) {
			if (!used[i] && !closed[i]) {
				count += countNodes(i);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	roads.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken()) - 1;
        	int b = Integer.parseInt(st.nextToken()) - 1;
        	
        	roads.get(a).add(b);
        	roads.get(b).add(a);
        }
        
        int goal = N;
        closed = new boolean[N];
        used = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	
        	Arrays.fill(used, false);
        	int nodes = 0;
        	
        	for(int j = 0; j < N; j++) {
        		if (!closed[j]) {
        			nodes = countNodes(j);
        			break;
        		}
        	}
        	
        	if (nodes == goal) {
        		System.out.println("YES");
        		pw.println("YES");
        	} else {
        		System.out.println("NO");
        		pw.println("NO");
        	}
        	
        	goal--;
        	closed[Integer.parseInt(br.readLine()) - 1] = true;
        }
        
        br.close();
        pw.close();
	}

}