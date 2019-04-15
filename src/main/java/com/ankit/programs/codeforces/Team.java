package com.ankit.programs.codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/231/problem/A
public class Team
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int solutions = 0;
        for (int i =0; i<n; i++) {
            int count = 0;
            count += scanner.nextInt();
            count += scanner.nextInt();
            count += scanner.nextInt();
            if (count>1) solutions++;
        }
        System.out.println(solutions);
    }
}
