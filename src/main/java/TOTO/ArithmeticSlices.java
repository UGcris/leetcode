package TOTO;

import java.util.Arrays;
import java.util.List;

/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *  
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 *  
 *
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/14
 **/
public class ArithmeticSlices {
    /**
     * 先找到最长的N个
     * @param A
     * @return
     */
    private int index=1,subIndex=1;
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        return numberOfArithmeticSlices(A,A[0]-A[1]);
    }

    private int numberOfArithmeticSlices(int[] array, int diff) {
        int ans=0;
        if(array.length-index<2){
            return ans;
        }
        while (subIndex<array.length&&diff==array[subIndex-1]-array[subIndex]){
            subIndex++;
        }
        System.out.println(subIndex);
        if(subIndex-index==2) ans++;
        if(subIndex-index>2) ans+=(subIndex-index-1)*(subIndex-index-2)/2;
        index=subIndex+1;
        if(array.length>index+1){
            ans+=numberOfArithmeticSlices(array,array[subIndex]-array[index]);
        }
        return ans;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res + dp[i];
        }
        return res;
    }
}

