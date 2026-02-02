// 2 Feb : The Galactic Alliance

import java.util.*;

public class Day5 {
    static int N = 5, K = 5;
    static long[] energy = {0, 10, 10, 10, 10, 10};
    static List<Integer>[] tree;
    static long[][][] dp;

    public static void dfs(int u, int parent) {
        dp[u][0] = new long[K+1];
        dp[u][1] = new long[K+1];

        Arrays.fill(dp[u][0], -1);
        Arrays.fill(dp[u][1], -1);

        dp[u][0][0] = 0;
        if(K >= 1) {
            dp[u][1][1] = energy[u];
        }

        for (int v : tree[u]) {
            if (v == parent) continue;

            dfs(v, u);

            long[] newTake = new long[K+1];
            long[] notTake = new long[K+1];

            Arrays.fill(newTake, -1);
            Arrays.fill(notTake, -1);

            for (int i = 0; i <= K; i++) {
                if (dp[u][0][i] == -1 && dp[u][1][i] == -1) continue;

                for (int j = 0; j+i <= K; j++) {
                    long child = Math.max(dp[v][0][j], dp[v][1][j]);

                    if (dp[u][0][i] != -1 && child != -1) {
                        notTake[i+j] = Math.max(notTake[i+j], dp[u][0][i] + child);
                    }

                    if(dp[u][1][i] != -1 && dp[v][0][j] != -1) {
                        newTake[i+j] = Math.max(newTake[i+j], dp[u][1][i] + dp[v][0][j]);
                    }
                }
            }

            dp[u][0] = notTake;
            dp[u][1] = newTake;
        }
    }

    public static void main(String[] args) {
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        tree[1].add(2);
        tree[2].add(1);
        tree[2].add(3);
        tree[3].add(2);
        tree[3].add(4);
        tree[4].add(3);
        tree[4].add(5);
        tree[5].add(4);

        dp = new long[N+1][2][];

        dfs(1, 0);

        long ans = Math.max(dp[1][0][K], dp[1][1][K]);

        if (ans == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
