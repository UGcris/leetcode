package TOIN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/23
 **/
public class Sum42Target {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int size=nums.length;
        if(size>3){
            Arrays.sort(nums);
            for(int i=0;i<size-3;i++){
                for(int j=i+1;j<size-2;j++){
                    int value1=nums[i]+nums[j];
                    int indexL=j+1;
                    int indexR=size-1;
                    while (indexL<indexR){
                        int valueL=nums[indexL];
                        int valueR=nums[indexR];
                        int sum=value1+valueL+valueR;
                        if(sum==target){
                            result.add(Arrays.asList(nums[i],nums[j],valueL,valueR));
                            while (indexL<indexR &&nums[indexL]==nums[indexL+1]) indexL++;
                            while (indexL<indexR &&nums[indexR]==nums[indexR-1]) indexR--;
                            indexL++;
                            indexR--;
                        }else if(sum<target){
                            indexL++;
                        }else if(sum>target){
                            indexR--;
                        }
                    }
                    while (j<size-2&&nums[j]==nums[j+1])j++;
                }
                while (i<size-3&&nums[i]==nums[i+1])i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={0,0,0,0};
        Sum42Target sum42Target=new Sum42Target();
        System.out.println(sum42Target.fourSum(arr,0));
    }
}
