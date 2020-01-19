package com.ankit.programs.understanding;

import java.util.PriorityQueue;

public class PriorityQueueUnderstanding
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue.poll());
    }
}
