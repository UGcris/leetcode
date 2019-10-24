/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/10/24
 **/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result=nums[0];
        int sum=1;
        int minValue=1;
        for (int i = 0; i < nums.length; i++) {
            result=Math.max(nums[i],result);
            if(nums[i]==0){
                sum=1;
                minValue=1;
            }else{
                sum*=nums[i];
                result=Math.max(sum<0?sum/minValue:sum,result);
                if(sum<0){
                    minValue=minValue>0?sum:Math.max(sum,minValue);
                }
            }
        }
        return result;
    }
}
