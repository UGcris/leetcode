package D202007;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/14
 **/
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE, size = triangle.size();
        if (size == 1) return triangle.get(0).get(0);
        if (size > 1) {
            int[] arr = new int[size];
            arr[0] = triangle.get(0).get(0);
            for (int i = 1; i < size; i++) {
                List<Integer> list = triangle.get(i);
                for (int j = i; j >= 0; j--) {
                    int min = Integer.MAX_VALUE;
                    if (j < i) {
                        min = Math.min(min, arr[j] + list.get(j));
                    }
                    if (j > 0) {
                        min = Math.min(min, arr[j - 1] + list.get(j));
                    }
                    arr[j] = min;
                }
            }
            Arrays.sort(arr);
            ans = arr[0];
        }
        return ans;
    }

    /**
     * 优化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<Integer> list = triangle.get(size - 1);
        int[] arr = new int[size];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                int min = arr[j];
                if (j < size - 1) {
                    min = Math.min(min, arr[j + 1]);
                }
                arr[j] = min + list.get(j);
            }
        }
        return arr[0];
    }
}
