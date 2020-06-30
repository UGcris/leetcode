package D202007;

import java.util.ArrayList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/30
 **/
public class PowerSetLcci {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        build(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void build(int[] nums, int begin, List<List<Integer>> ans, ArrayList<Integer> preList) {
        ans.add(new ArrayList<>(preList));
        for (int i = begin; i < nums.length; i++) {
            preList.add(nums[i]);
            build(nums, i + 1, ans, preList);
            preList.remove(preList.size() - 1);
        }
    }
}
