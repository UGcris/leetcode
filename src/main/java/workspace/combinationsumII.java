package workspace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2020/5/11
 */

public class combinationsumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(candidates.length>0){
            Arrays.sort(candidates);
            find(candidates,ans,target,0,new ArrayDeque<Integer>());
        }
        return ans;
    }

    private void find(int[] candidates, List<List<Integer>> ans, int target, int begin, ArrayDeque<Integer> path) {
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(target<candidates[i]){
                break;
            }
            if(i>begin&&candidates[i]==candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            find(candidates, ans, target-candidates[i], i+1, path);
            path.removeLast();
        }
    }
}
