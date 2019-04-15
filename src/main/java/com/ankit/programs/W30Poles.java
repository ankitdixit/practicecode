package com.ankit.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ankit on 26/03/17.
 */
public class W30Poles {
    static int[][] poles;
    static int[][][] memoise;
    public static void main(String[] args) {
        //this programs calculates stuff

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        poles = new int[n][2];
        memoise = new int[n][n][n];
        for(int i = 0; i < n; i++) {
            poles[i][0] = in.nextInt();
            poles[i][1] = in.nextInt();
        }
        if(k>n) System.out.println("i would if i could, bitch!!!");
        System.out.println(minCost(n, k, n, 0));

        //System.out.println(calcCost(poles,"100100"));
        //System.out.println(bruteForce(n,k, poles));
        //testGenerator();


    }

    public static int minCost(int n, int k, int currPos, int costTillNow) {
        if(k>n) return -1;
        int bundleCost = getBundleCost(n, currPos);
        if(k==currPos){
            return bundleCost+costTillNow;
        }
        /*if(n == 1) {
            klocs[1] = true;
            return costTillNow+bundleCost;
        }*/
        if (k==1) {
            return costTillNow + getBundleCost(n,1);
        }
        if (currPos ==1) {
            return costTillNow + getBundleCost(n,1);
        }
        int minval =  Math.min(minCost(n ,k ,currPos-1, costTillNow), minCost(currPos-1, k-1, currPos-1 , costTillNow + bundleCost));
        return  minval;
     }

    private static int getBundleCost(int n, int currPos) {
        //System.out.println("called with :" + n + " " + currPos);
        int bundleCost = 0;
        for(int i = n ; i > currPos; i--) {
            bundleCost += (poles[i-1][0] - poles[currPos-1][0])*poles[i-1][1];
        }
        return bundleCost;
    }

    private static void testGenerator() {
        int poleStackSizeBound = 5;
        int weightBound = 5;
        int numberofTestCases = 1000;
        for(int t=0; t<numberofTestCases; t++) {
            int n = new Random().nextInt(poleStackSizeBound) + 1;
            int k = new Random().nextInt(n) + 1;
            System.out.println("k = " + k);
            System.out.println("n = " + n);
            Random weightRandom = new Random();
            poles = new int[n][2];
            for (int i = 1; i <= n; i++) {
                poles[i - 1][0] = i;
                poles[i - 1][1] = weightRandom.nextInt(weightBound) + 1;
            }
            printArray(poles);
            int minCostBruteForce = bruteForce(n, k, poles);
            System.out.println("minCostBruteForce = " + minCostBruteForce);
            int minCostRec = minCost(n, k, n, 0);
            System.out.println("minCostRec = " + minCostRec);
            if (minCostBruteForce != minCostRec) {
                System.out.println("found mismatch brute=" + minCostBruteForce + " rec=" + minCostRec);
                return;
            }
        }
    }

    public static void printArray(int[][] arr) {
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static int bruteForce(int n, int k, int[][] poles) {

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<n; i++) {
            stringBuilder.append((i<k)?'1':'0');
        }
        return permutation(stringBuilder.toString(), n, k, poles);

    }

    public static int calcCost(int poles[][], String locs) {
        if(locs.charAt(0) != '1') return Integer.MAX_VALUE;
        int stackedTill = poles.length;
        int totalCost=0;
        for(int i=poles.length-1; i>=0; i--) {
            if(locs.charAt(i) == '1') {
                for(int j=stackedTill-1; j>i; j-- ) {
                    totalCost += (poles[j][0] - poles[i][0])*poles[j][1];
                }
                stackedTill=i;
            }
        }
        return totalCost;
    }

    public static int permutation(String str, int n, int k, int[][] poles) {
        return permutation("", str, n, k, poles);
    }

    private static int permutation(String prefix, String str, int n, int k, int[][] poles) {
        int minCost = Integer.MAX_VALUE;
        int strlen = str.length();
        if (strlen == 0) {
            //System.out.println("in for permutation :" + prefix);
            minCost = Math.min(minCost,calcCost(poles, prefix));
        }
        else {
            for (int i = 0; i < strlen; i++)
                minCost = Math.min(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, strlen), n, k , poles), minCost);
        }
        return minCost;
    }
}
/*
5 3
1 4
2 3
3 3
4 3
5 2 */
