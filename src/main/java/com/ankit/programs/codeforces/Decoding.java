package com.ankit.programs.codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/746/problem/B
public class Decoding
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        char[] s = scanner.next().toCharArray();
        char[] ans = new char[s.length];
        int pos = size-1;
        for(int i = size-1; i >=0; i=i-2) {
            ans[pos--] = s[i];
        }

        for(int i = size%2; i < size; i=i+2) {
            ans[pos--] = s[i];
        }
        System.out.println(ans);
    }
}
