package com.ankit.programs.codeforces;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

//http://codeforces.com/contest/680/problem/B
public class BearAndFindingCriminals
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

    public static void main(String[] args)
    {
        int n = readInt();
        int pos = readInt() - 1;
        int[] thieves = scanNInts(n);
        int maxDistance = max(pos, n -1 - pos);
        int distBothSides = min(pos, n -1 - pos);
        int caught = (thieves[pos] == 1) ? 1 : 0;

        for(int dist = 1;  dist <= maxDistance; dist++) {
            if (dist <= distBothSides) {
                if (thieves[pos-dist] == 1 && thieves[pos+dist] == 1) {
                    caught += 2;
                }
            }
            else {
                if (pos - dist < 0 ) {
                    if (thieves[dist + pos] > 0) caught++;
                }
                else {
                    if(thieves[pos-dist] > 0) caught++;
                }
            }
        }
        System.out.println(caught);
    }
}
