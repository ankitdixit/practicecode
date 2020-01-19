package com.ankit.programs.codeforces;

import java.util.Scanner;

//http://codeforces.com/contest/463/problem/B
public class CaisaAndPylons
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] hieghts = new int[n+1];
        for(int i =1; i <=n; i++ ) hieghts[i] = scanner.nextInt();
        int totalEneryNeeded = 0;
        int currEnergy = 0;
        for(int i = 1; i <= n; i++) {
            int energyNeededForJump = hieghts[i] - hieghts[i-1];
            if (energyNeededForJump > currEnergy ) {
                totalEneryNeeded += energyNeededForJump - currEnergy;
                currEnergy = 0;
            }
            else {
                currEnergy += hieghts[i-1] - hieghts[i];
            }
        }
        System.out.println(totalEneryNeeded);
    }
}
