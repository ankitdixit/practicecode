
package OnlineCoding;

public class Farzi
{
    public static void main(String[] args)
    {
        System.out.println(findPivot(new int[]{3,5,1}));
    }

    private static int findPivot(int[] nums)
    {
        if(nums[nums.length-1] > nums[0]) return 0;
        int left = 0;
        int right = nums.length -1 ;
        int mid = 0;
        while (left != right) {
            mid = (left + right) / 2;
            if (mid == 0) {
                return nums[0] < nums[1]? 0: 1;
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return mid;
    }
}

