package TOTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/12
 **/
public class MaximumLengthOfRepeatedSubarray {
    /**
     * 最长公共前缀
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int result=0;
        int[][] preArray=new int[A.length+1][B.length+1];
        for (int i = 0; i < A.length ; i++) {
            for (int j = 0; j < B.length; j++) {
                if(A[i]==B[j]){
                    preArray[i+1][j+1]=preArray[i][j]+1;
                    if(preArray[i+1][j+1]>result) result=preArray[i+1][j+1];
                }
            }
        }
        return result;
    }
}
