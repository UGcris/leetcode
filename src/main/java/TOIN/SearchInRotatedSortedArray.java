package TOIN;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/26
 **/
public class SearchInRotatedSortedArray {
    /**
     * 几乎就是排列组合了
     * 代码太多了
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int size=nums.length;
        if(size==0) return -1;
        int index=size/2;
        int beginIndex=0;
        int endIndex=size-1;
        if(target>=nums[0]){
            if (target==nums[0]) return 0;
            while (nums[index]!=target){
                if (beginIndex==endIndex) {
                    if(target==nums[index]) {
                        return index;
                    }else {
                        return -1;
                    }
                } else if(endIndex-beginIndex==1){
                    if(nums[beginIndex]==target){
                        return beginIndex;
                    }else if(nums[endIndex]==target){
                        return endIndex;
                    }else {
                        return -1;
                    }
                }else {
                    if(nums[index]==target){
                        return index;
                    }if(nums[index]>target){
                        endIndex=index;
                        index=beginIndex+(index-beginIndex)/2+(index-beginIndex)%2;
                    }else {
                        if(nums[index]>nums[0]){
                            beginIndex=index;
                            index=endIndex-(endIndex-index)/2-(endIndex-index)%2;
                        }else if(nums[index]<nums[size-1]){
                            endIndex=index;
                            index=beginIndex+(index-beginIndex)/2+(index-beginIndex)%2;
                        }
                    }
                }
            }
            return index;
        }else if(target<=nums[size-1]){
            if (target==nums[size-1]) return size-1;
            while (nums[index]!=target){
                if (beginIndex==endIndex) {
                    if(target==nums[index]) {
                        return index;
                    }else {
                        return -1;
                    }
                } else if(endIndex-beginIndex==1){
                    if(nums[beginIndex]==target){
                        return beginIndex;
                    }else if(nums[endIndex]==target){
                        return endIndex;
                    }else {
                        return -1;
                    }
                }else {
                    if (nums[index] == target) {
                        return index;
                    }else if(nums[index]<target){
                        beginIndex=index;
                        index=endIndex-(endIndex-index)/2-(endIndex-index)%2;
                    }else {
                        if(nums[index]>nums[0]){
                            beginIndex=index;
                            index=endIndex-(endIndex-index)/2-(endIndex-index)%2;
                        }else if(nums[index]<nums[size-1]){
                            endIndex=index;
                            index=beginIndex+(index-beginIndex)/2+(index-beginIndex)%2;
                        }
                    }
                }
            }
            return index;
        }else{
            return -1;
        }
    }

    /**
     * 大佬的代码
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int s= 0,e =nums.length - 1;
        while(s <= e){
            int mid = (s + e) >> 1;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[s] <= nums[mid]){
                if(target >= nums[s] && target <= nums[mid]){
                    e = mid;
                }else{
                    s= mid + 1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[e]){
                    s = mid;
                }else{
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray=new SearchInRotatedSortedArray();
        int[] nums = {3,1};
        System.out.println(searchInRotatedSortedArray.search(nums,1));

    }
}
