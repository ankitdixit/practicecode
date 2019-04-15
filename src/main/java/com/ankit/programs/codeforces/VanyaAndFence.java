package com.ankit.programs.codeforces;

import java.util.Scanner;

public class VanyaAndFence
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int h = scanner.nextInt();
        int width = 0;
        for(int i = 0; i < size; i++) {
            width = (scanner.nextInt()>h) ? width+2 : width + 1;
        }
        System.out.println(width);
    }
}
