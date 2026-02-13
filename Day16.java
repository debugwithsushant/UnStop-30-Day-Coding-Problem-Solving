// 13 Feb : Minimum Time To Cross The Grid With Portal Network

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Day16 {
    static class State {
        int r, c, jumps, cost;

        State(int r, int c, int jumps, int cost) {
            this.r = r;
            this.c = c;
            this.jumps = jumps;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int P = sc.nextInt();
        Set<Integer> portalValues = new HashSet<>();
        for (int i = 0; i < P; i++) {
            portalValues.add(sc.nextInt());
        }

        int k = sc.nextInt();

        // Map: portal value → all cells having that value
        Map<Integer, List<int[]>> portalMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (portalValues.contains(grid[i][j])) {
                    portalMap
                        .computeIfAbsent(grid[i][j], x -> new ArrayList<>())
                        .add(new int[]{i, j});
                }
            }
        }

        // dist[row][col][jumpsUsed]
        int[][][] dist = new int[m][n][k + 1];
        for (int[][] layer : dist)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<State> pq =
            new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[0][0][0] = 0;
        pq.add(new State(0, 0, 0, 0));

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.r == m - 1 && cur.c == n - 1) {
                System.out.println(cur.cost);
                return;
            }

            if (cur.cost > dist[cur.r][cur.c][cur.jumps]) continue;

            // Move to adjacent cells
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCost = cur.cost + grid[nr][nc];

                    if (newCost < dist[nr][nc][cur.jumps]) {
                        dist[nr][nc][cur.jumps] = newCost;
                        pq.add(new State(nr, nc, cur.jumps, newCost));
                    }
                }
            }

            // Use portal jump
            int val = grid[cur.r][cur.c];
            if (portalValues.contains(val) && cur.jumps < k) {
                for (int[] cell : portalMap.get(val)) {
                    int nr = cell[0];
                    int nc = cell[1];

                    if (dist[nr][nc][cur.jumps + 1] > cur.cost) {
                        dist[nr][nc][cur.jumps + 1] = cur.cost;
                        pq.add(new State(nr, nc, cur.jumps + 1, cur.cost));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
