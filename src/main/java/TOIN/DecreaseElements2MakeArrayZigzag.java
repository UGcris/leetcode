package TOIN;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 *
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 *
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/29
 */

public class DecreaseElements2MakeArrayZigzag {
    /**
     * 找出偶数位和奇数位需要递减的值
     * 对于某些位置上，两个数同时减去这个数时，去最小的（负数）累加
     * @param nums
     * @return
     */
    public int movesToMakeZigzag(int[] nums) {
        int size=nums.length;
        int diOdd=0;
        int diEven=0;
        for (int i = 0; i < size; i++) {
            int temp1=0;
            int temp2=0;
            if(i%2==0){
                if(i-1>0) {
                    temp1=nums[i-1]-nums[i]<=0?nums[i-1]-nums[i]-1:0;
                }
                if(i+1<size) {
                    temp2=nums[i+1]-nums[i]<=0?nums[i+1]-nums[i]-1:0;
                }
                diOdd+=temp1>temp2?temp2:temp1;
            }else {
                if(i-1>=0) {
                    temp1=nums[i-1]-nums[i]<=0?nums[i-1]-nums[i]-1:0;
                }
                if(i+1<size) {
                    temp2=nums[i+1]-nums[i]<=0?nums[i+1]-nums[i]-1:0;
                }
                diEven+=temp1>temp2?temp2:temp1;
            }
        }
        if(diEven>diOdd) return Math.abs(diEven);
        else return Math.abs(diOdd);
    }

    public static void main(String[] args) {
        DecreaseElements2MakeArrayZigzag decreaseElements2MakeArrayZigzag=new DecreaseElements2MakeArrayZigzag();
        int[] nums={9,6,1,6,2};
        System.out.println(decreaseElements2MakeArrayZigzag.movesToMakeZigzag(nums));
    }
}
