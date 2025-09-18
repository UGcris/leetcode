package D202007;

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/25
 **/
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int ans = 0, length = nums.length;
        if (length > 0 && m > 0) {
            int[] sum = new int[length + 1];
            for (int i = 1; i <= length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            int[][] dp = new int[length + 1][m + 1];
            for (int i = 1; i <= length; i++) {
                int value = sum[i];
                dp[i][0] = value;
                for (int j = 1; j <= m; j++) {
                    value = Math.min(value, dp[i][m - 1]);
                    dp[i][m] = Math.max(value, sum[length] - sum[i]);
                }
            }
//            for (int i = 1; i <= length; i++) {
//                dp[i][0]=sum[length]-sum[i+1];
//                for (int j = 1; j <= m; j++) {
//                    dp[i][j]=sum[0];
//                    for (int k = 0; k < i; k++) {
//                        System.out.println((i - k)+" 1 "+dp[i - k][j - 1]);
//                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - k][j - 1], sum[i - k]));
//                    }
//                    System.out.println("dp "+i+" "+j+" "+dp[i][j]);
//                }
//            }
            return dp[length][m];
        }
        return ans;
    }

}
