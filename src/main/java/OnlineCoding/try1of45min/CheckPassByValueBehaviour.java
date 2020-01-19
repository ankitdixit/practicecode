package OnlineCoding.try1of45min;

import java.util.Arrays;

public class CheckPassByValueBehaviour
{
    public static void main(String[] args)
    {
      int[] primary = new int[2];
      Integer[] nonprim = new Integer[2];
      modify(primary);
      modify(nonprim);
      System.out.println(Arrays.toString(primary));
        System.out.println(nonprim.toString());
    }

    private static void modify(Integer[] nonprim)
    {
        nonprim[0] = 12;
    }

    private static void modify(int[] prim)
    {
        prim[0] = 12;
    }
}
