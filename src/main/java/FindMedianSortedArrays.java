/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/17
 */

public class FindMedianSortedArrays {
    /**
     * 两个数组，依次抛弃最大值和最小值（最小的开始和最大的结束）
     * 获取最大值和最小值的平均值
     * 知道两个数据均循环结束
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0d;
        int beginIndex1 = 0;
        int endIndex1 = nums1.length - 1;
        int beginIndex2 = 0;
        int endIndex2 = nums2.length - 1;
        while (beginIndex1 <= endIndex1 || beginIndex2 <= endIndex2){
            Integer beginValue = null;
            Integer endValue = null;
            if (beginIndex1 <= endIndex1 && (beginIndex2 > endIndex2 || nums2[beginIndex2]>=nums1[beginIndex1])){
                beginValue=nums1[beginIndex1++];
            }else  if (beginIndex2 <= endIndex2 && (beginIndex1 > endIndex1 || nums1[beginIndex1]>nums2[beginIndex2])){
                beginValue=nums2[beginIndex2++];
            }
            if (beginIndex1 <= endIndex1 && (beginIndex2 > endIndex2 || nums2[endIndex2]<=nums1[endIndex1])){
                endValue=nums1[endIndex1--];
            }else if (beginIndex2 <= endIndex2 && (beginIndex1 > endIndex1 || nums1[endIndex1]<nums2[endIndex2])){
                endValue=nums2[endIndex2--];
            }
            result=null==beginValue?null==endValue?null:endValue/1.0d:null==endValue?beginValue/1.0d:(beginValue+endValue)/2.0d;
            System.out.println("nums1:\n beginIndex1:"+beginIndex1+",endIndex1:"+endIndex1);
            System.out.println("nums2:\n beginIndex2:"+beginIndex2+",endIndex2:"+endIndex2);
            System.out.println("final:\n beginValue:"+beginValue+",endValue:"+endValue+",result:"+result);
            System.out.println("------------------------------------");
        }
        return result;
    }

    /**
     * 优解
     * 将两个数组拼接成一个大数组，找大数组的中位数
     * @param num1
     * @param num2
     * @return
     */
    public double findMedianSortedArrays2(int[] num1, int[] num2) {
        int len1=num1.length;
        int len2=num2.length;
        int maxLen=len1+len2;
        int[] colNum=new int[maxLen/2+1];
        if(maxLen==1){
            return (len1==0?num2[0]:num1[0])/1.0;
        }
        for(int i=0,j=0;i+j<maxLen/2+1;){
            if(i>=len1&&j<len2){
                colNum[i+j]=num2[j];
                j++;
            }
            if(i<len1&&j>=len2){
                colNum[i+j]=num1[i];
                i++;
            }
            if(i<len1&&j<len2){
                if(num1[i]<=num2[j]){
                    colNum[i+j]=num1[i];
                    i++;
                }else{
                    colNum[i+j]=num2[j];
                    j++;
                }
            }
        }
        if(maxLen%2==1){
            return colNum[maxLen/2]/1.0;
        }else{
            return (colNum[maxLen/2]+colNum[maxLen/2-1])/2.0;
        }

    }
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        FindMedianSortedArrays findMedianSortedArrays=new FindMedianSortedArrays();
        findMedianSortedArrays.findMedianSortedArrays(nums1,nums2);
    }
}
