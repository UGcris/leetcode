package D202006;

import java.util.Arrays;

/**
 * @Author UGcris
 * @date 2020/6/13
 **/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
