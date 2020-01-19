package OnlineCoding;

import java.util.Arrays;

public class RotateMatrix
{
    public static void main(String[] args)
    {
        int n = 5;
        int[][] matrix = new int[n][n];
        for ( int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = n*i+j+1;
            }
        }
        rotateMatrix(matrix);
        Arrays.stream(matrix).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    private static void rotateMatrix(int[][] matrix)
    {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n - i -1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i];
                matrix[n-j-1][i] = temp;
            }
        }
    }

}
