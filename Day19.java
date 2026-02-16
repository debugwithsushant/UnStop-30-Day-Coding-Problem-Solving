// 16 Feb : Minimum Integer

public class Day19 {
    public static int userLogic(int n, int[] arr) {
        int x = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            x &= arr[i];
        }

        return x;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(userLogic(n, arr)); // Output: 0

        int[] arr2 = {1, 2, 3, 6, 5};
        System.out.println(userLogic(n, arr2)); // Output: 0
    }
}
