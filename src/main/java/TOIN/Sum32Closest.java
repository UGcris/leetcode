package TOIN;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/20
 **/
public class Sum32Closest {
    public int threeSumClosest(int[] nums, int target) {
        int result=0;
        int len=nums.length;
        if(null==nums||len<3){
            return result;
        }
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums); // 排序
        for(int i=0;i<len-2;i++){
            int value1=nums[i];
            if(i>0&&value1==nums[i-1]) continue;
            int indexL=i+1;
            int indexR=len-1;
            while (indexL<indexR){
                int valueL=nums[indexL];
                int valueR=nums[indexR];
                int sum=value1+valueL+valueR;
                int subDiff=Math.min(Math.abs(sum-target),Math.abs(target-sum));
                if(sum-target==0){
                    return target;
                }else if(subDiff<diff){
                    diff=subDiff;
                    result=sum;
                }
                if(sum<target){
                    while (indexL<indexR &&nums[indexL]==nums[indexL+1]) indexL++;
                    indexL++;
                }else if(sum>target){
                    while (indexL<indexR &&nums[indexR]==nums[indexR-1]) indexR--;
                    indexR--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Sum32Closest sum32Closest=new Sum32Closest();
        int[] nums={1,1,1,1};
        System.out.println(sum32Closest.threeSumClosest(nums,0));
    }
}
