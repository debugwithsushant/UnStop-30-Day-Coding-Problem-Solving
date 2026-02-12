// 12 Feb : Mall Escalator Optimization

import java.util.*;

class Day15 {
    public static void calculateMinimumMinutes(int N, int M, List<int[]> escalators, int[] result) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : escalators) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
        }

        Arrays.fill(result, -1);
        result[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph.get(current)) {
                if(result[next] == -1) {
                    result[next] = result[current] + 1;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] arges) {
        int N = 5;
        int M = 6; 
        
        List<int[]> escalators = Arrays.asList( 
            new int[]{0, 1}, new int[]{0, 2}, 
            new int[]{1, 3}, new int[]{2, 3}, 
            new int[]{3, 4}, new int[]{1, 4} ); 
        
            int[] result = new int[N]; 
            
            calculateMinimumMinutes(N, M, escalators, result); 
            
            System.out.println(Arrays.toString(result));
    }
}