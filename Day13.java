// 10 Feb : Small Big Pattern

public class Day13 {
    public static int bigSmallSequence(int[] arr, int n) {
        int up = 1;
        int down = 1;

        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) {
                up = down + 1;
            } else if(arr[i] < arr[i-1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 5, 4, 3, 2, 6};

        System.out.print(bigSmallSequence(arr, n));
    }
}
