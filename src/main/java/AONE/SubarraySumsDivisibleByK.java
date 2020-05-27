package AONE;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/5/27
 **/
public class SubarraySumsDivisibleByK {
    /**
     * 同余定理
     *哈希表 + 逐一统计
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : A) {
            sum += num;
            int mod = (sum % K + K) % K;
            int same = record.getOrDefault(mod, 0);
            Math.floorMod(sum,K);
            ans += same;
            record.put(mod, same + 1);
        }
        return ans;
    }

    /**
     * 超出时间限制
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK2(int[] A, int K) {
        int ans = 0;
        int beginIndex = 0, endIndex = 0;
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
            for (int j = i; j >= 0; j--) {
                if ((sum[i + 1] - sum[i]) % K == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
