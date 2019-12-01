/*
ID: chloe1
LANG: JAVA
TASK: paint
 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class paint {
    public static void main (String []args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paint.in"));

        Vector<Interval> fence = new Vector<>();

        for ( int i = 0; i<2; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int b = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Interval paintInterval = new Interval(b,e);
            fence = updateFence(fence, paintInterval);
        }

        int milkTime = 0;
        int vectorSize = fence.size();

        milkTime = paintDistance(fence,vectorSize,milkTime);

        PrintWriter out = new PrintWriter(new FileWriter("paint.out"));
        out.println(milkTime);
        out.close();

    }

    static Vector<Interval> updateFence (Vector<Interval> list, Interval another) {
        Vector<Interval> newList = new Vector<>();

        if (list.isEmpty()) {
            newList.add(another);
        }
        else {
            boolean merged = true;
            for (Interval interval : list) {
                merged = interval.merge(another);
                if (!merged) {
                    newList.add(interval);
                }
                else {
                    another = interval;
                }
            }
            newList.add(another);
        }
        return newList;
    }

    static int paintDistance (Vector<Interval> fence, int vectorSize, int milkTime) {
        if (vectorSize == 1) {
            milkTime = fence.get(0).end - fence.get(0).begin;
        }

        else {
            milkTime = fence.get(0).end - fence.get(0).begin + fence.get(1).end - fence.get(1).begin;
        }

        return milkTime;
    }

}

class Interval {
    public int begin;
    public int end;

    public Interval (int b, int e){
        begin = b;
        end = e;
    }

    public boolean merge (Interval another) {
        if ((another.begin <= this.end) && (another.end >= this.begin)) {

            begin = Math.min(begin, another.begin);
            end = Math.max(end, another.end);
            return true;
        }
        return false;
    }

}
