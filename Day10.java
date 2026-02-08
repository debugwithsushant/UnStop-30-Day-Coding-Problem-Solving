// 7 Feb : Dynamic Stock Trading with Momentum and Variable Cooldowns

import java.util.*;

class Day10 {

    static int n;
    static int threshold;
    static int[] prices;
    static Integer[][][] memo;

    static int dfs(int day, int holding, int streak) {
        if(day >= n) return 0;

        if(memo[day][holding][streak] != null){
            return memo[day][holding][streak];
        }

        int best = dfs(day+1, holding, 0);

        if (holding == 0) {
            best = Math.max(best, dfs(day+1, 1, streak) - prices[day]);
        }

        if (holding == 1) {
            int profit = prices[day];
            int newStreak = streak;
            int bonus = 0;
            
            if (profit > 0) {
                newStreak++;

                if (newStreak ==  3) {
                    bonus = profit / 10;
                    newStreak = 0;
                }
            } else {
                newStreak = 0;
            }
            
            int cooldown = profit > 0 ? profit / threshold : 0;
            int nextDay = day + cooldown + 1;

            best = Math.max(best, profit + bonus + dfs(nextDay, 0, newStreak));            
        }

        memo[day][holding][streak] = best;
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        threshold = sc.nextInt();
        memo = new Integer[n][2][3];

        int result = dfs(0, 0, 0);
        System.out.println(result);

        sc.close();
    }
}