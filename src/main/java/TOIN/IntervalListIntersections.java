package TOIN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个由一些闭区间组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 注意：输入和所需的输出都是区间对象组成的列表，而不是数组或列表。
 *  
 *
 * 提示：
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/6
 **/
public class IntervalListIntersections {
    /**
     * 审题不清产物。。。
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aLength=A[A.length-1][1],bLength=B[B.length-1][1];
        int index1=0,index2=0;
        String str1="1",str2="1";
        for (int i = 0; i <= Math.max(aLength,bLength); i++) {
            if(index1<A.length&&i>=A[index1][0]&&i<=A[index1][1]){
                str1+="1";
                if(i==A[index1][1]) index1++;
            }else str1+="0";
            if(index2<B.length&&i>=B[index2][0]&&i<=B[index2][1]){
                str2+="1";
                if(i==B[index2][1]) index2++;
            }else str2+="0";
        }
        int resultNum=Integer.valueOf(str1,2) & Integer.valueOf(str2,2);
        String resultStr=Integer.toBinaryString(resultNum).substring(1);
        List<int[]> resultList=new ArrayList();
        Integer low=null;
        for (int i = 0; i < resultStr.length(); i++) {
            if('1'==resultStr.charAt(i)&&null==low){
                low=i;
            }
            if(null!=low&&(i+1==resultStr.length()||'0'==resultStr.charAt(i+1))){
                int[] subRsult=new int[2];
                subRsult[0]=low;
                subRsult[1]=i;
                resultList.add(subRsult);
                low=null;
            }
        }
        int[][] result=new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i]=resultList.get(i);
        }
        return result;
    }

    public int[][] intervalIntersection2(int[][] A, int[][] B) {

        List<int[]> resultList=new ArrayList();
        int index1=0,index2=0;
        while (index1<A.length&&index2<B.length){
            if(A[index1][0]<B[index2][0]&&A[index1][1]<B[index2][0]){
                index1++;
                continue;
            }
            if(B[index2][0]<A[index1][0]&&B[index2][1]<A[index1][0]){
                index2++;
                continue;
            }
            if(A[index1][0]==B[index2][1]){
                int[] subRsult=new int[2];
                subRsult[0]=A[index1][0];
                subRsult[1]=B[index2][1];
                resultList.add(subRsult);
                index2++;
            }else if(B[index2][0]==A[index1][1]){
                int[] subRsult=new int[2];
                subRsult[0]=B[index2][0];
                subRsult[1]=A[index1][1];
                resultList.add(subRsult);
                index1++;
            }else if(A[index1][1]>=B[index2][0]){
                int[] subRsult=new int[2];
                subRsult[0]=Math.max(A[index1][0],B[index2][0]);
                subRsult[1]=Math.min(A[index1][1],B[index2][1]);
                resultList.add(subRsult);
                index1++;
            }else if(B[index2][1]>=A[index1][0]){
                int[] subRsult=new int[2];
                subRsult[0]=Math.max(A[index1][0],B[index2][0]);
                subRsult[1]=Math.min(A[index1][1],B[index2][1]);
                resultList.add(subRsult);
                index2++;
            }else {
                index1++;
                index2++;
            }
        }
        int[][] result=new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i]=resultList.get(i);
        }
        return result;
    }
}
