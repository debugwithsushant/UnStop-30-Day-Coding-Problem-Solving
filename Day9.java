// 6 Feb : Mountain Cable Ride Optimizer

class Day9 {
    public static int maxAltitudeGain(int N, int K, int[] heights) {
        int[][] dp = new int[N][K+1];

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                dp[i][k] = dp[i][k-1];

                for (int j = 0; j < i; j++) {
                    if (heights[i] > heights[j]) {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (heights[i] -heights[j]));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k <= K; k++) {
                ans = Math.max(ans, dp[i][k]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        int[] heights = {100, 200, 150, 300, 250};

        int result = maxAltitudeGain(N, K, heights);
        System.out.println("Maximum altitude gain: " + result);
    }
}