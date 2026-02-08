// 8 Feb : Collections of Apples

public class Day11 {
    public static void main(String[] args) {
        int N = 4;
        int[] trees = {2, 2, 3, 3};
        int C = 5;

        long steps = 0;
        int backetLeft = C;

        for (int i = 0; i < N; i++) {
            if (trees[i] > backetLeft) {
                steps += 2L * i;
                backetLeft = C;
            }

            steps += 1;

            backetLeft -= trees[i];
        }

        System.out.println("Total number of steps needed: " + steps);
    }
}
