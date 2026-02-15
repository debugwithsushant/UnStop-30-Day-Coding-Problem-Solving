// 14 Feb : Maximizing Nutritional Value

import java.util.Arrays;

public class Day17 {
    public static int maximizeNutritionalValue(int n, int m, int k, int[] price, int[] nutrition){
        // dp[i][money][coupons]
        int[][][] dp = new int[n + 1][m + 1][k + 1];

        // Initialize DP with -1 (unreachable states)
        for (int i = 0; i <= n; i++) {
            for (int money = 0; money <= m; money++) {
                Arrays.fill(dp[i][money], -1);
            }
        }

        // Base case: no fruits, no cost, no coupons → nutrition = 0
        dp[0][0][0] = 0;

        // Process fruits one by one
        for (int i = 1; i <= n; i++) {
            int cost = price[i - 1];
            int value = nutrition[i - 1];
            int discountedCost = cost / 2;

            for (int money = 0; money <= m; money++) {
                for (int coupons = 0; coupons <= k; coupons++) {

                    // Case 1: Skip this fruit
                    if (dp[i - 1][money][coupons] != -1) {
                        dp[i][money][coupons] =
                                Math.max(dp[i][money][coupons],
                                         dp[i - 1][money][coupons]);
                    }

                    // Case 2: Buy at full price
                    if (money >= cost && dp[i - 1][money - cost][coupons] != -1) {
                        dp[i][money][coupons] =
                                Math.max(dp[i][money][coupons],
                                         dp[i - 1][money - cost][coupons] + value);
                    }

                    // Case 3: Buy with coupon
                    if (coupons > 0 && money >= discountedCost &&
                        dp[i - 1][money - discountedCost][coupons - 1] != -1) {

                        dp[i][money][coupons] =
                                Math.max(dp[i][money][coupons],
                                         dp[i - 1][money - discountedCost][coupons - 1] + value);
                    }
                }
            }
        }

        // Find maximum nutrition within budget and coupons
        int answer = 0;
        for (int money = 0; money <= m; money++) {
            for (int coupons = 0; coupons <= k; coupons++) {
                answer = Math.max(answer, dp[n][money][coupons]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3; // number of fruits
        int m = 100; // budget
        int k = 1; // coupons
        int[] price = {50, 30, 20}; // prices of fruits
        int[] nutrition = {60, 40, 30}; // nutritional values

        int result = maximizeNutritionalValue(n, m, k, price, nutrition);
        System.out.println(result); // Expected output: 90 (buy fruit 1 with coupon and fruit 2 at full price)
    }
}
