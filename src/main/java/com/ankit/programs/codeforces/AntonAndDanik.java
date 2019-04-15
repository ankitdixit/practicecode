package com.ankit.programs.codeforces;

import java.util.Scanner;

public class AntonAndDanik
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((s.charAt(i) == 'A')) {count--;}
            else {count++;}
        }
        if (count <0) {
            System.out.println("Anton");
        }
        else  if ( count == 0) {
            System.out.println("Friendship");
        }
        else {
            System.out.println("Danik");
        }
    }
}
