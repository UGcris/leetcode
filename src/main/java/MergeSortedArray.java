import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/11/6
 **/
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp= Arrays.copyOf(nums1,m);
        int index1=0,index2=0,index=0;
        while (index<m+n){
            if(index1>=m||temp[index1]<=nums2[index2]) {
                nums1[index]=nums2[index2];
                index2++;
            }else if(index2>=n||temp[index1]>nums2[index2]) {
                nums1[index]=temp[index];
                index1++;
            }
            index++;
        }
    }
}
