package OnlineCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum
{
    public static void main(String[] args)
    {
        int[] input = new int[] {-1,0,1,2,-1,-4};
        Arrays.sort(input);
        System.out.println(threeSum(input));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<Triplet> result = new HashSet<>();

        if(nums.length < 3) {
            return new ArrayList<>();
        }

        for (int i = 0; i < nums.length -2; i++) {
            int leftIndex = i+1;
            int rightIndex = nums.length - 1;
            while(leftIndex < rightIndex) {

                int twoSum = nums[i] + nums[leftIndex];

                if (twoSum + nums[rightIndex] > 0) {
                    rightIndex--;
                }
                else if (twoSum + nums[rightIndex] == 0) {
                    System.out.println("Adding result");
                    result.add(new Triplet(nums[i], nums[leftIndex], nums[rightIndex]));
                    leftIndex++;
                    rightIndex--;
                }
                else if (twoSum + nums[rightIndex] < 0)
                {
                    leftIndex++;
                }
            }
        }
        System.out.println("Result size :" + result.size());

        List<List<Integer>> resultChanged = new ArrayList<>();

        for(Triplet t : result) {
            List<Integer> temp = new ArrayList<>(3);
            temp.add(t.list.get(0));
            temp.add(t.list.get(1));
            temp.add(t.list.get(2));
            resultChanged.add(temp);
        }
        return resultChanged;
    }

    static class Triplet
    {
        public final List<Integer> list;

        public Triplet(int x, int y, int z)
        {
            list = new ArrayList<>();
            list.add(x);
            list.add(y);
            list.add(z);
            Collections.sort(list);
        }

        @Override
        public boolean equals(Object other)
        {
            Triplet otherTriplet = (Triplet) other;
            if (this.list.get(0) == otherTriplet.list.get(0) && this.list.get(1) == otherTriplet.list.get(1) && this.list.get(2) == otherTriplet.list.get(2)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 31 * hash + list.get(0);
            hash = 31 * hash + list.get(1);
            hash = 31 * hash + list.get(2);
            return hash;
        }
    }
}
