package com.ankit.programs.codeforces;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ScannerBase
{
    static Scanner scanner = new Scanner(System.in);

    public static int[] scanNInts(int n)
    {
        return IntStream.range(0, n).map(x -> scanner.nextInt()).toArray();
    }

    public static int readInt()
    {
        return scanner.nextInt();
    }
}
