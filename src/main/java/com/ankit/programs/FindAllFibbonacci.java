package com.ankit.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//Given array find subset which is fibbonacci
public class FindAllFibbonacci
{
    public static void main(String[] args)
    {
        int[] input = new int[] {0, 2, 8, 5, 2, 1, 4, 13, 23};
        System.out.println(Arrays.toString(findFibbonacci(input)));
    }

    private static int[] findFibbonacci(int[] input) {
        if (input.length == 0) {
            return new int[0];
        }

        int max = Arrays.stream(input).max().getAsInt();
        HashSet<Integer> fibs = getFibbonacciUpto(max);
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (fibs.contains(input[i])) {
                matches.add(input[i]);
            }
        }

        return arrayListToArray(matches);
    }

    private static int[] arrayListToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()){
            result[i++] = iterator.next();
        }
        return result;
    }

    private static HashSet<Integer> getFibbonacciUpto(int max)
    {
        int a = 0;
        int b = 1;

        HashSet<Integer> fibs = new HashSet<>();
        fibs.add(0);
        while (b <= max)
        {
            fibs.add(b);
            int temp = b;
            b = a + b;
            a = temp;
        }
        return fibs;
    }
}
