// 1 Feb : Mountain View Maximizer

import java.util.Scanner;

public class Day4 {
    public static int maxSunsetViews(int[] heights, int K) {

        int count = 1;
        int maxPoint = heights[0];

        for(int i = 1; i < heights.length; i++){
            if(heights[i] > maxPoint){
                count++;
                maxPoint = heights[i];
            }
        }

        return Math.min(count, K);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and K
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int[] heights = new int[N];
        
        // Read N space-separated integers
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }
        
        // Call the user logic function and print the result
        int result = maxSunsetViews(heights, K);
        System.out.println(result);
    }
}
