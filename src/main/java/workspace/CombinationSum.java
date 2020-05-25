package workspace;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/12/13
 */

public class CombinationSum {
    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        if(candidates.length>0){
            Arrays.sort(candidates);
            find(candidates,ans,target,0,new ArrayDeque<Integer>());
        }
        return ans;
    }

    /**
     * 剪枝法
     * @param candidates
     * @param ans
     * @param target
     * @param begin
     * @param path
     */
    private void find(int[] candidates, List<List<Integer>> ans, int target, int begin, Deque<Integer> path) {
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(target<candidates[i]){
                break;
            }
            path.addLast(candidates[i]);
            find(candidates, ans, target-candidates[i], i, path);
            path.removeLast();
        }
    }
}
