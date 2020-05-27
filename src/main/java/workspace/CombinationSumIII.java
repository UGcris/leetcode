package workspace;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author UGcris
 * @date 2020/5/27
 */

public class CombinationSumIII {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 0 && n < 46) {
            find(Math.min(9, n), n, k, new ArrayList<>());
        }
        return ans;
    }

    private void find(int num, int sum, int size, List<Integer> list) {
        if (num == 0 || sum < 0) return;
        find(num - 1, sum, size, new ArrayList<>(list));
        list.add(num);
        if (sum == num && list.size() == size) {
            ans.add(new ArrayList<>(list));
        } else {
            find(num - 1, sum - num, size, list);
        }
    }
}
