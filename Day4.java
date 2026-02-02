// 1 Feb : Mountain View Maximizer


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
        int N = 5;
        int K = 3;
        
        int[] heights = new int[N];
        
        heights[0] = 2;
        heights[1] = 4;
        heights[2] = 1;
        heights[3] = 5;
        heights[4] = 3;
        
        int result = maxSunsetViews(heights, K);
        System.out.println(result);
    }
}
