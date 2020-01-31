package TOIN;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/10/24
 **/
public class MaximumSubarray {
    //暴力
    public int maxSubArray(int[] nums) {
        int result=Integer.MIN_VALUE;
        //二维数组，存储最大值
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp=nums[i]+sum[i-1];
            sum[i]=temp;
            result=Math.max(temp,result);
            result=Math.max(nums[i],result);
            for (int j = 0; j <i ; j++) {
                if(sum[j]<0){
                    result=Math.max(result,temp-sum[j]);
                }
            }
        }
        return result;
    }
    //投机取巧，用当前统计值减去之前最小的（负数），获取的值于result比较
    //0(n)
    public int maxSubArray2(int[] nums) {
        int result=Integer.MIN_VALUE;
        int minValue=0;
        //二维数组，存储最大值
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        result=nums[0];
        minValue=Math.min(result,minValue);
        for (int i = 1; i < nums.length; i++) {
            int temp=nums[i]+sum[i-1];
            sum[i]=temp;
            result=Math.max(temp-minValue,result);
            result=Math.max(nums[i],result);
            minValue=Math.min(temp,minValue);
        }
        return result;
    }

}
