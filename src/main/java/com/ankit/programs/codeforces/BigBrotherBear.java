package com.ankit.programs.codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/791/problem/A
public class BigBrotherBear
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int years = 0;
        while (a <= b) {
            years++;
            a*=3;
            b*=2;
        }
        System.out.println(years);
    }
}
