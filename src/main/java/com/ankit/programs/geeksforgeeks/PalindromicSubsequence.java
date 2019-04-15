package com.ankit.programs.geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;

public class PalindromicSubsequence
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        //pre-compute the matrix
        int[][] prefixMatrix = new int [26][input.length()];
        int[][] postfixMatrix = new int [26][input.length()];

        for (int i=0; i < input.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (j == input.charAt(i) - 'a' )
                {
                    if (i == 0) {
                        prefixMatrix[j][0]++;
                        continue;
                    }
                    else {
                        prefixMatrix[j][i] = prefixMatrix[j][i-1] + 1;
                        continue;
                    }
                }
            }
        }
        printMatrix(prefixMatrix);
    }

    public static void printMatrix(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("\n");
        }
    }
}
