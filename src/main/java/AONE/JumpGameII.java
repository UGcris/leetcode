package AONE;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/6
 **/
public class JumpGameII {
    /**
     * 超出时间限制
     */
    public int jump2(int[] nums) {
        if (nums.length == 1) return 1;
        find(nums[0], nums, 0, 0);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private void find(int stepLength, int[] nums, int beginIndex, int step) {
        step++;
        System.out.println(step);
        if (stepLength + beginIndex >= nums.length - 1) {
            ans = Math.min(ans, step);
            return;
        }
        for (int i = 1; i <= stepLength && i < nums.length; i++) {
            find(nums[i + beginIndex], nums, beginIndex + i, step);
        }
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    int ans = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums.length <2) return 0;
        find(nums, 0, 0);
        return ans;
    }

    private void find(int[] nums, int index, int step) {
        step++;
        int stepLength = nums[index];
        if (index + stepLength >= nums.length - 1) {
            ans = Math.min(ans, step);
            return;
        }
        int maxIndex = index,newIndex=index;
        for (int i = 1; i <= stepLength; i++) {
            if(index + i + nums[index + i]>maxIndex){
                maxIndex=index + i + nums[index + i];
                newIndex=index + i;
            }
            if(maxIndex>=nums.length-1){
                ans = Math.min(ans, step+1);
                return;
            }
        }
        find(nums, newIndex, step);
    }
}
