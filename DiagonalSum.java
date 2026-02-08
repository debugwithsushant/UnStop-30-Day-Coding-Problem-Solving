// Diagonal Sum

public class DiagonalSum {
    public static void diagonalSum(int[][] matrix, int n) {
        long sum = 2 * n;

        if(n % 2 == 1) {
            sum -= 1;
        }

        System.out.println(sum);
    }
    
    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = 1;
            }
        }

        diagonalSum(matrix, n);
    }
}