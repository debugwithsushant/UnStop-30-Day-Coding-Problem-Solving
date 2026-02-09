// 9 Feb : Alice’s K Negations

import java.util.Arrays;

public class Day12 {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        
        int[] arr = {9, 8, 8, 5};

        Arrays.sort(arr);

        int i = 0;
        while ( i < n && k > 0 && arr[i] < 0) {
            arr[i] = -arr[i];
            i++;
            k--;
        }

        Arrays.sort(arr);

        if (k % 2 == 1) {
            arr[0] = -arr[0];
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        System.out.print(sum);
    }
}
