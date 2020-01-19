package com.ankit.programs.codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/102/problem/B
public class SumOfDigits
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.length() == 1) {
            System.out.println(0);
            return;
        }

        int count = 1;
        long sum = input.chars().map(x -> (Character.getNumericValue(x))).mapToLong(x -> x).sum();
        while (sum > 9) {
            count++;
            sum = findDigitSum(sum);
        }
        System.out.println(count);
    }

    private static long findDigitSum(long l)
    {
        long sum = 0;
        while (l > 0) {
            sum += l%10;
            l = l / 10;
        }
        return sum;
    }
}
