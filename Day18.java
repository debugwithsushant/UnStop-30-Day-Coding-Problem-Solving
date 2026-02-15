// 15 Feb : Magical Index

public class Day18 {
    public static int magicalIndex(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for(int num : arr) {
            sum += num;
        }

        int leftSum = 0;
        for(int i = 0; i < n; i++) {
            if(2 * leftSum + arr[i] == sum) {
                return i+1;
            }

            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(magicalIndex(arr)); // Output: -1

        int[] arr2 = {1, 2, 3, 6, 5};
        System.out.println(magicalIndex(arr2)); // Output: 4
    }
}
