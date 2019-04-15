package com.ankit.programs.google;

import java.util.Scanner;
import java.util.Stack;

public class MaxHeightHistogram
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        if (size == 0) {
            System.out.println("0");
        }
        int hist[] = new int[size];
        for (int i = 0; i < size; i++) {
            hist[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack();

        int maxVal = 0;
        for (int i = 0; i < size; i++) {
           if(stack.empty() || (hist[i] > hist[stack.peek()])) {
               stack.push(i);
           }
           else if (hist[i] < hist[stack.peek()]){
               while((!stack.isEmpty()) && (hist[stack.peek()] > hist[i])) {
                   int index = stack.pop();
                   int height  = hist[index];
                   maxVal = Math.max(maxVal, height * (i -1 - (stack.isEmpty() ? -1 : stack.peek()) ));
               }
               if (stack.isEmpty() || ( hist[stack.peek()] < hist[i])) {
                   stack.push(i);
               }
           }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int height  = hist[index];
            maxVal = Math.max(maxVal, height * (size - index));
        }
        System.out.println("Output is :" + maxVal);
    }
}
