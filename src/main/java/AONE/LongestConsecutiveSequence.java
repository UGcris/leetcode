package AONE;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/6
 **/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1]==1){
                count++;
            }else if(nums[i]-nums[i-1]==0){
                continue;
            }else {
                ans=Math.max(ans,count);
                count=1;
            }
        }
        ans=Math.max(ans,count);
        return ans;
    }
}
