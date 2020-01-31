package TOTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/1/31
 **/
public class Combinations {
    int n;
    int k;
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.k=k;
        this.n=n;
        backtrack(1,new LinkedList<>());
        return result;
    }

    private void backtrack(int first, LinkedList<Object> curr) {
        if(curr.size()==k) result.add(new LinkedList(curr));
        for (int i = first; i < n+1; i++) {
            curr.add(i);
            backtrack(i+1,curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> numArray=new ArrayList<>();
        for (int i = 0; i < k;) {
            numArray.add(++i);
        }
        numArray.add(n+1);
        int index=0;
        while (index < k){
            result.add(new LinkedList(numArray.subList(0,k)));
            index=0;
            while ((index<k)&&(numArray.get(index+1) == numArray.get(index)+1)){
                numArray.set(index,++index);
            }
            numArray.set(index, numArray.get(index)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        nums.add(4);
        nums.add(4);
        nums.add(4);
        int i=0;
        nums.set(i,++i);
        nums.set(i,++i);
        System.out.println(i);
        System.out.println(nums);
    }
}
