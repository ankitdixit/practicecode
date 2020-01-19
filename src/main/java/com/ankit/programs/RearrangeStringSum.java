package com.ankit.programs;

/*
Given a string containing uppercase alphabets and integer digits (from 0 to 9), the task is to print the alphabets in the order followed by the sum of digits.

Examples:

Input : AC2BEW3
Output : ABCEW5
Alphabets in the lexicographic order
followed by the sum of integers(2 and 3).
 */
public class RearrangeStringSum
{
    public static void main(String[] args)
    {
        String input = "ACCBA10D2EW30";
        System.out.println(rearrange(input));
    }

    private static String rearrange(String input)
    {
        int[] count = new int[26];
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if ('A' <= input.charAt(i) && 'Z' >= input.charAt(i)) {
                count[input.charAt(i) - 'A']++;
            }
            else if ('0' <= input.charAt(i) && '9' >= input.charAt(i)){
                sum += input.charAt(i) - '0';
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <26; i++) {
            for(int j = 0; j < count[i]; j++) {
                result.append((char)(i+'A'));
            }
        }
        return result.append(sum).toString();
    }
}

