package com.ankit.programs;

import java.util.Queue;
import java.util.Stack;

public class LongestIncreasingSubSequence
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        //System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(solution.lengthOfLIS(new int[] {0}));
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] mem = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, mem[j]+1);
                }
                mem[i] = max;
            }
        }
        int returnValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mem[i] > returnValue) returnValue = mem[i];
        }
        return returnValue;
    }
}
