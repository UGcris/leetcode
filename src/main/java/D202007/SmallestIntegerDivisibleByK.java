package D202007;

/**
 * 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 * <p>
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：1
 * 输出：1
 * 解释：最小的答案是 N = 1，其长度为 1。
 * 示例 2：
 * <p>
 * 输入：2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 N 。
 * 示例 3：
 * <p>
 * 输入：3
 * 输出：3
 * 解释：最小的答案是 N = 111，其长度为 3。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-integer-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/22
 **/
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int K) {
        if (1 != K % 10 && 3 != K % 10 && 7 != K % 10 && 9 != K % 10) return -1;
        int index = 1;
        int N = 1;
        while (N % K != 0) {
            N = N % K;
            N = N * 10 + 1;
            index += 1;
        }
        return index;
    }
}
