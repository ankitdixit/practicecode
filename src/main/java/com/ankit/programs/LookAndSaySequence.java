package com.ankit.programs;

public class LookAndSaySequence
{
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println(getNthNumber(n));
    }

    private static int getNthNumber(int n)
    {
        if (n ==1) return 1;
        else if (n ==2) return 11;

        int currIndex = 2;
        String num = "11$";

        while (currIndex != n) {
            StringBuilder nextNum = new StringBuilder();
            char lastDigit = num.charAt(0);
            int count = 1;
            for (int i = 1; i <num.length(); i++) {
                if (lastDigit == num.charAt(i)) {
                    count++;
                }
                else {
                    nextNum.append(count).append(lastDigit);
                    lastDigit = num.charAt(i);
                    count = 1;
                }
            }
            num = nextNum.append("$").toString();
            currIndex++;
        }
        return Integer.parseInt(num.substring(0, num.length()-1));
    }
}
