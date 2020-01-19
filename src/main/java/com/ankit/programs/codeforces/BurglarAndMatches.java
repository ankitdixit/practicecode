package com.ankit.programs.codeforces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BurglarAndMatches
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Integer[][] containers = new Integer[m][2];
        for( int i = 0; i < m; i++) {
            containers[i][0] = scanner.nextInt();
            containers[i][1] = scanner.nextInt();
        }

        /*Arrays.sort(containers, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                Integer quantityOne = o1[1];
                Integer quantityTwo = o2[1];
                // reverse sort on quantity
                return quantityTwo.compareTo(quantityOne);
            }
        });

        Arrays.sort(containers, (Integer[] first, Integer[] second) -> second[1].compareTo(first[1]));*/
        Arrays.sort(containers, Comparator.comparing((Integer[] x) -> x[1]));
        int count = 0;
        int spaceRemaining = n;
        int i = 0;
        while (spaceRemaining > 0 && i < m) {
            int containersTaken = (spaceRemaining >= containers[i][0]) ? containers[i][0] : spaceRemaining;
            count += containersTaken * containers[i][1];
            spaceRemaining -= containersTaken;
            i++;
        }
        System.out.println(count);
    }
}
