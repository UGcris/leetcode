package TOIN;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/27
 **/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int size=nums.length;
        for (int i = 0; i < size; i++) {
            if(nums[i]>=target) return i;
        }
        return size;
    }
    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int size=nums.length;
        int begin=0,end=size-1;
        while (end>=begin){
            int mid=(end+begin)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                begin=mid+1;
            }else {
                end=mid-1;
            }
        }
        return begin;
    }
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition=new SearchInsertPosition();
        int[] nums={1,3,5,6};
        System.out.println(searchInsertPosition.searchInsert2(nums,5));
    }
}
