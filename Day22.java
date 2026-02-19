// 19 Feb : The Kingdom's Fair Division

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day22 {
    static List<Integer>[] tree;
    static long[] gold;
    static int regions;
    static long target;

    static long findMaximumMinimumGold(int N, int K) {
        long low = 0;
        long high = 0;

        for(long g : gold) {
            high += g;
        }

        long best = 0;

        while(low <= high) {
            long mid = (low + high) / 2;

            regions= 0;
            target = mid;

            dfs(0, -1);

            if(regions >= K+1) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return best;
    }

    static long dfs(int node, int parent) {
        long sum = gold[node];

        for(int child : tree[node]) {
            if(child != parent) {
                sum += dfs(child, node);
            }
        }

        if(sum >= target) {
            regions++;
            return 0;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        tree = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            tree[u].add(v);
            tree[v].add(u);
        }

        gold = new long[N];
        for(int i = 0; i < N; i++) {
            gold[i] = sc.nextLong();
        }

        long result = findMaximumMinimumGold(N, K);
        System.out.println(result);
    }
}
