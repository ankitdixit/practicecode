package com.ankit.programs;

import java.util.Arrays;

public class CountDistinctPairsDiffK
{
    public static void main(String[] args)
    {
        int[] input = new int[] {8, 12, 16, 4, 0, 20};
        System.out.println(countDistinctPairsWithDiffK(input, 4));
    }

    private static int countDistinctPairsWithDiffK(int[] arr, int k)
    {
        if (arr.length == 0) return 0;
        if (k == 0) return arr.length*(arr.length-1)/2;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (searchElement(arr, arr[i] + k)) {
                count++;
            }
        }
        return count;
    }

    private static boolean searchElement(int[] arr, int elem)
    {
        int start = 0;
        int end = arr.length -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == elem) {
                return true;
            }
            else if (arr[mid] < elem) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
