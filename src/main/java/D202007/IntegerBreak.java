package D202007;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/30
 **/
public class IntegerBreak {
    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index = 2;
        while (index < n) {
            int left = 0, right = index - 1, max = 0;
            while (left <= right) {
                max = Math.max(max, Math.max(left + 1, dp[left]) * Math.max(right + 1, dp[right]));
                left++;
                right--;
            }
            dp[index++] = max;
        }
        return dp[n - 1];
    }


    /**
     * 0ms
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        if (n <= 3)
            return n - 1;
        int x = n / 3, y = n % 3;
        //整除属于情况1，直接返回3的x次方
        if (y == 0) return (int) Math.pow(3, x);
        //余数为1属于情况2，相当于余数是4=2*2组合，返回3的x-1次方*2*2
        if (y == 1) return (int) Math.pow(3, x - 1) * 4;
        //余数是2属于情况3，直接返回3和2的组合
        return (int) (Math.pow(3, x) * 2);
    }
}
