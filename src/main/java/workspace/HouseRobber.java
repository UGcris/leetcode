package workspace;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author UGcris
 * @date 2020/5/29
 */

public class HouseRobber {
    /**
     * dp[n] = MAX( dp[n-1], dp[n-2] + num )
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int[] temp = new int[nums.length + 1];
        temp[0] = 0;
        temp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i+1]=Math.max(temp[i],temp[i-1]+nums[i]);
        }
        return temp[nums.length];
    }

    /**
     * 超出时间限制
     *
     * @param sum
     * @param beginIndex
     * @param nums
     * @return
     */
    private int rob(int sum, int beginIndex, int[] nums) {
        int ans = sum;
        for (int i = beginIndex; i < nums.length; i++) {
            ans = Math.max(ans, rob(nums[i] + sum, i + 2, nums));
        }
        return ans;
    }
}