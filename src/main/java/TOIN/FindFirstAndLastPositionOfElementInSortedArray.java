package TOIN;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/27
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int[] result=new int[2];
        int index=-1;
        int size=nums.length;
        int begin=0,end=size-1;
        while (end>=begin){
            int mid=(end+begin)/2;
            if(target==nums[mid]){
                index= mid;
                break;
            }else if(target>nums[mid]){
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        if(index==-1){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        int preIndex=index;
        int endIndex=index;
        while (preIndex>0&&nums[preIndex-1]==target){
            preIndex--;
        }
        while (endIndex<size-1&&nums[endIndex+1]==target){
            endIndex++;
        }
        result[0]=preIndex;
        result[1]=endIndex;
        return result;
    }
}
