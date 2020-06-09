package D202006;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/9
 **/
public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean ans = true;
        if (nums.length > 0) {
            ans = find(nums,  0);
        }
        return ans;
    }

    private boolean find(int[] nums, int index) {
        int stepLength = nums[index];
        if(stepLength==0)return false;
        if (index + stepLength >= nums.length - 1) {
            return true;
        }
        int maxIndex = index,newIndex=index;
        for (int i = 1; i <= stepLength; i++) {
            if(index + i + nums[index + i]>maxIndex){
                maxIndex=index + i + nums[index + i];
                newIndex=index + i;
            }
            if(maxIndex>=nums.length-1){
                return true;
            }
        }
        return find(nums, newIndex);
    }
}
