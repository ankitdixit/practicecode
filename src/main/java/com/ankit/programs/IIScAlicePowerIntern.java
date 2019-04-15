package com.ankit.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Tuple
{
    public int x;
    public int y;

    public Tuple (int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public static Tuple newTuple(int x, int y) {
        return new Tuple(x, y);
    }
}

public class IIScAlicePowerIntern
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");
        int initialPower = Integer.parseInt(values[0]);
        int oppCount = Integer.parseInt(values[1]);

        List<Tuple> tuples  = new ArrayList<Tuple>();

        for(int i = 0; i < oppCount; i++) {
            String[] readVals = scanner.nextLine().split(" ");
            tuples.add(new Tuple(Integer.parseInt(readVals[0]), Integer.parseInt(readVals[1])));
        }
        Comparator<Tuple> comparator = new Comparator<Tuple>() {
            public int compare(Tuple o1, Tuple o2)
            {
                return (o1.x < o2.x)? -1 : ((o1.x == o2.x) ? 0:1);
            }
        };
        Collections.sort(tuples, comparator);
        int power = initialPower;
        for (Iterator<Tuple> it = tuples.iterator(); it.hasNext(); ) {
            Tuple tuple = it.next();
            if(power <= tuple.x) {
                System.out.println("NO");
                return;
            }
            else {
                power += tuple.y;
            }
        }
        System.out.println("YES");
    }
}
