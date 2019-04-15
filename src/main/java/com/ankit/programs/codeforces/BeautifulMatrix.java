package com.ankit.programs.codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/263/problem/A
public class BeautifulMatrix
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int oneRow = -1;
        int oneCol = -1;
        for(int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                //System.out.println(scanner.next());
                if (scanner.nextInt() == 1) {
                    oneRow = i;
                    oneCol = j;
                }
            }
        }
        System.out.println(Math.abs(oneRow-3) + Math.abs(oneCol-3));
    }
}
