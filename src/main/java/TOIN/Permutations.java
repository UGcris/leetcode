package TOIN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/12/2
 **/
public class Permutations {
    /**
     * 剪枝
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> numArray=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numArray.add(nums[i]);
        }
        int n=nums.length;
        reCombine(n,numArray,result,0);
        return result;
    }

    private void reCombine(int n, List<Integer> numArray, List<List<Integer>> result, int first) {
        if(first==n){
            result.add(new ArrayList<>(numArray));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(numArray,first,i);
            reCombine(n,numArray,result,first+1);
            Collections.swap(numArray,first,i);
        }
    }


}
