// 4 Feb : Binary String Pairs

public class Day7 {
    public int user_logic(int n, String s) {
        // int count = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (s.charAt(i) == s.charAt(j)) {
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // Optimized approach
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        return count0 * count0 + count1 * count1;
    }

    public static void main(String[] args) {
        Day7 day7 = new Day7();

        String s = "00110";
        int n = s.length();

        int result = day7.user_logic(n, s);
        
        System.out.println(result); // Output: 13
    }
}
