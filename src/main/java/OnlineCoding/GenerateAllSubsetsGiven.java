package OnlineCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateAllSubsetsGiven
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();

        if(nums==null){
            return result;
        }

        subsets(nums,new ArrayList<>(),result,0 );
        return result;
    }

    private static void subsets(int[] nums,List<Integer> subset,List<List<Integer>> result, int index)     {

        result.add(new ArrayList<>(subset));

        for(int i=index; i<nums.length; i++)
        {
            subset.add(nums[i]);

            subsets(nums,subset,result,i+1);

            subset.remove((Integer)nums[i]);
        }
    }
}
