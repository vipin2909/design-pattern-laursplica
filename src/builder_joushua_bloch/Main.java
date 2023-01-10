package builder_joushua_bloch;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static int maxPoints(int[][] points) {

        Map<Double, Integer> map = new HashMap<>();
        int n = points.length;
        int count = 0;
        if(n <= 2) return n;
        int ans = 0;
        for(int[] point1: points) {
            int x1 = point1[0], y1 = point1[1];
            for(int[] point2: points) {
                if(point1[0] == point2[0] && point1[1] == point2[1]) {
                    continue;
                }

                int x2 = point2[0], y2 = point2[1];
                double slope;
                if(x2 - x1 == 0) slope = Integer.MAX_VALUE;
                else {
                    slope = (y2 - y1) / (x2 - x1);
                    System.out.println("SLOPE " + slope);
                }

               map.put(slope, map.getOrDefault(slope, 0)+1);
                count = Math.max(count, map.get(slope));
            }
        }
        return (count+1)/2;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int ans = maxPoints(points);
        System.out.println(ans);
    }
}
