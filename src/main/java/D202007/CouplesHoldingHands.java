package D202007;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * <p>
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 * <p>
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/30
 **/
public class CouplesHoldingHands {
    /**
     * 贪心算法
     * @param row
     * @return
     */
    public int minSwapsCouples2(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if (row[i+1] == (x ^ 1)) continue;
            ans++;
            for (int j = i+1; j < row.length; ++j) {
                if (row[j] == (x^1)) {
                    row[j] = row[i+1];
                    row[i+1] = x^1;
                    break;
                }
            }
        }
        return ans;
    }

    public int minSwapsCouples(int[] row) {
        int ans = 0, length = row.length;
        if (length > 0) {
            int circle = 0;
            int[] arr = new int[length / 2];
            for (int i = 0; i < length / 2; i++) {
                arr[i] = i;
            }
            for (int i = 0; i < length; i += 2) {
                union(arr, row[i] / 2, row[i + 1] / 2);
            }
            for (int i = 0; i < length / 2; i++) {
                if (i == find(arr, i)) {
                    circle++;
                }
            }
            ans -= circle;
        }
        return ans;
    }

    private int find(int[] arr, int index) {
        while (arr[index] != index) {
            arr[index] = arr[arr[index]];
            index = arr[index];
        }
        return index;
    }

    private void union(int[] arr, int index1, int index2) {
        arr[find(arr, index1)] = find(arr, index2);
    }
}
