package TOIN;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 2 行 n 列的二进制数组：
 *
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 *
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 *
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：upper = 2, lower = 1, colsum = [1,1,1]
 * 输出：[[1,1,0],[0,0,1]]
 * 解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
 * 示例 2：
 *
 * 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
 * 输出：[]
 * 示例 3：
 *
 * 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * 输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 *  
 *
 * 提示：
 *
 * 1 <= colsum.length <= 10^5
 * 0 <= upper, lower <= colsum.length
 * 0 <= colsum[i] <= 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/12
 **/
public class ReconstructA2RowBinaryMatrix {
    /**
     * 有两行数据 colsum.length列
     * 贪心算法
     * 贪心策略，当和为1时，仅加在行和最大的行
     * bad
     * @param upper
     * @param lower
     * @param colsum
     * @return
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            int num=colsum[i];
            if(0==num){
                arr1.add(0);
                arr2.add(0);
            }else if(2==num){
                if(upper<=0&&lower<=0) return new ArrayList<>();
                arr1.add(1);
                arr2.add(1);
                upper--;
                lower--;
            }else{
                if(upper<=0&&lower<=0) return new ArrayList<>();
                if(upper>lower){
                    arr1.add(1);
                    arr2.add(0);
                    upper--;
                }else {
                    arr1.add(0);
                    arr2.add(1);
                    lower--;
                }
            }
        }
        if(upper>0||lower>0) return new ArrayList<>();
        result.add(arr1);
        result.add(arr2);
        return result;
    }
    public List<List<Integer>> reconstructMatrix2(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> loweList = new ArrayList<>();
        if (colsum == null || colsum.length == 0) return res;
        int sum = 0;
        for (int num : colsum) {
            sum += num;
        }

        if (upper + lower != sum) return res;
        for (int num : colsum) {
            if (num == 2) {
                upperList.add(1);
                loweList.add(1);
                upper--;
                lower--;
            } else if (num == 1) {
                if (upper > lower) {
                    upperList.add(1);
                    loweList.add(0);
                    upper--;
                } else {
                    upperList.add(0);
                    loweList.add(1);
                    lower--;
                }
            } else {
                upperList.add(0);
                loweList.add(0);
            }
            if (upper < 0 || lower < 0) {
                return res;
            }
        }
        res.add(upperList);
        res.add(loweList);
        return res;

    }
}
