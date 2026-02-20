// 20 Feb : IPL 2025 - The Secret Strategy

import java.util.List;

class Day23 {
    public static String encryptMessage(List<Integer> arr) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < arr.size(); i++) {
            if(isPrime(arr.get(i))){
                result.append("*");
            } else {
                result.append(arr.get(i));
            }

            if(i != arr.size() - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static boolean isPrime(int n) {
        if(n <= 1) return false;

        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        String encryptedMessage = encryptMessage(arr);
        System.out.println(encryptedMessage); // Output: "* * 4 * 6 * 8 9 10"
    }
}