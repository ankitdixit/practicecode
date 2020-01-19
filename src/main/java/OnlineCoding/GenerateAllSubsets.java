package OnlineCoding;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {1,2,3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums.length == 0) {
            return result;
        }

        List<Integer> input = new ArrayList<>();
        for ( int n : nums) {
            input.add(n);
        }

        result.addAll(allSubsets(new ArrayList<>(), input));
        return result;
    }

    private static List<List<Integer>> allSubsets(List<Integer> prefix, List<Integer> rem)
    {
        List<List<Integer>> result =  new ArrayList<>();
        if (rem.size() == 1) {
            if (prefix.size() > 0) {
                result.add(new ArrayList<>(prefix));
            }
            List<Integer> copyPrefix = new ArrayList<>(prefix);
            copyPrefix.add(rem.get(0));
            result.add(copyPrefix);
        }
        else {
            List<Integer> copyRem = new ArrayList<>(rem);
            copyRem.remove(rem.get(0));
            result.addAll(allSubsets(prefix, copyRem));
            List<Integer> copyPrefix = new ArrayList<>(prefix);
            copyPrefix.add(rem.get(0));
            result.addAll(allSubsets(copyPrefix, copyRem));
        }
        return result;
    }
}
