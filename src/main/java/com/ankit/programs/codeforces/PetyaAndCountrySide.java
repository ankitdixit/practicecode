package com.ankit.programs.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PetyaAndCountrySide
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> heights = new ArrayList(n);
        IntStream.range(0,n).forEach(x -> heights.add(scanner.nextInt()));
        int[ ] left = new int [n];
        left[0] = 0;
        for(int i = 1; i < n ; i++) {
            if (heights.get(i-1) <= heights.get(i)) {
                left[i] = left[i-1] + 1;
            }
        }
        int[ ] right = new int [n];
        right[n-1] = 0;
        for(int i = n-2; i >= 0 ; i--) {
            if (heights.get(i+1) <= heights.get(i)) {
                right[i] = right[i+1] + 1;
            }
        }

        int[] total =new int[n];
        for(int i =0; i<n; i++) {
            total[i] = left[i] + 1 + right[i];
        }
        int max = Arrays.stream(total).max().getAsInt();
        System.out.println(max);

    }
}
