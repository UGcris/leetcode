package TOIN;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/10/24
 **/
public class ProductOfArrayExceptSelf {
    // 左积*右积 单次循环
    public int[] productExceptSelf(int[] nums) {
        int size=nums.length;
        int[] result=new int[size];
        int left=1;
        int right=1;
        for (int i = 0; i < size; i++) {
            result[i]=i<=(size-i-1)?left:(result[i]*left);
            left*=nums[i];

            result[size-i-1]=i<(size-i-1)?right:(result[size-i-1]*right);
            right*=nums[size-i-1];
        }
        return result;
    }
    //分别循环，速度更快
    public int[] productExceptSelf2(int[] nums) {
        int[] results = new int[nums.length];
        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            results[i] = k;
            k *= nums[i];
        }

        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= k;
            k *= nums[i];
        }

        return results;
    }

    /**
     * 重rewrite
     * @param nums
     * @return
     */
    public int[] productExceptSelf3(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        if (length > 0) {
            int[] left = new int[length + 1];
            int[] right = new int[length + 1];
            left[0] = 1;
            right[length] = 1;
            for (int i = 0; i < length; i++) {
                left[i + 1] = left[i] * nums[i];
                right[length - i - 1] = right[length-i] * nums[length - i - 1];
            }
            for (int i = 0; i < length; i++) {
                ans[i]=left[i]*right[i+1];
            }
        }
        return ans;
    }
}
