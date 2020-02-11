package TOTO;

/**
 *给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/10
 **/
public class MinimumSizeSubarraySum {
    /**
     * 滑动窗口
     * 在第一个大于等于往后，
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int size=nums.length;
        if(size<1) return 0;
        int step=0,left=0,right=0;
        int[] sum=new int[size+1];
        int result=size+1;
        while (right<size&&right>=left){
            int total=sum[right]+nums[right];
            sum[right+1]=total;
            if(total-sum[left]<s){
                right++;
                if(right-left+1>=result) left++;
            }else {
                result=Math.min(result,right-left+1);
                left++;
            }
        }
        return result>size?0:result;
    }
}
