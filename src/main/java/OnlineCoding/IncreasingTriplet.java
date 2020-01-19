package OnlineCoding;

public class IncreasingTriplet
{
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            boolean[] shorter = populateMin(nums);
            boolean[] larger = populateMax(nums);
            for(int i = 1; i < nums.length -1; i++) {
                if ((shorter[i] == true) && (larger[i] == true)) {
                    return true;
                }
            }
            return false;
        }

        boolean[] populateMin(int[] nums) {
            boolean[] shorter = new boolean[nums.length];
            int minIndex = 0;
            shorter[0] = false;
            for(int i = 1; i < nums.length; i++) {
                if (nums[i] <= nums[minIndex]) {
                    shorter[i] = false;
                    minIndex = i;
                }
                else {
                    shorter[i] = true;
                }
            }
            return shorter;
        }

        boolean[] populateMax(int[] nums) {
            boolean[] larger = new boolean[nums.length];
            int largerIndex = 0;
            larger[0] = false;
            for(int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] >= nums[largerIndex]) {
                    larger[i] = false;
                    largerIndex = i;
                }
                else {
                    larger[i] = true;
                }
            }
            return larger;
        }
    }
}
