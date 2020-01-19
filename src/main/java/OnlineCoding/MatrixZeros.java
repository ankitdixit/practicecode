package OnlineCoding;

import java.util.Arrays;

public class MatrixZeros
{
    public static void main(String[] args)
    {
        int[][] input = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution solution = new Solution();
        solution.setZeroes(input);
        System.out.println(Arrays.deepToString(input));
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstColPlaceholder = false;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        firstColPlaceholder = true;
                    }
                    else {
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++)
            {
                matrix[0][j] = 0;
            }
        }

        if (firstColPlaceholder == true) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
