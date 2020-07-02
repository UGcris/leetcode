package D202007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 *  
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/2
 **/
public class KthSmallestElementInASortedMatrix {
    /**
     * 暴力
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int ans = 0, length = matrix.length;
        if (length > 0) {
            int colLength = matrix[0].length;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < colLength; j++) {
                    list.add(matrix[i][j]);
                }
            }
            Collections.sort(list);
            return list.get(k - 1);
        }
        return ans;

    }

    public int kthSmallest1(int[][] matrix, int k) {
        int ans = 0, length = matrix.length;
        if (length > 0) {
            int colLength = matrix[0].length;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < colLength && i < k; i++) {
                list.add(matrix[0][i]);
            }
            for (int i = 1; i < length; i++) {
                int index = 0;
                for (int j = 0; j < colLength; j++) {
                    if (index >= k) {
                        break;
                    }
                    while (index < k && index < list.size() && list.get(index) <= matrix[i][j]) {
                        index++;
                    }
                    list.add(index, matrix[i][j]);
                }
            }
            return list.get(k - 1);
        }
        return ans;
    }

}
