package TOIN;

import java.util.Arrays;

/**
 * @Author UGcris
 * @date 2019/9/24
 **/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int size=nums.length;
        int index=0;
        for (int i = 1; i < size; i++) {
            if(nums[i]!=nums[i-1]){
                index++;
                nums[index]=nums[i];
            }
        }
        return index+1;
    }
}
