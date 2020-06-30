package D202007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/30
 **/
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (length > 0) {
            Arrays.sort(nums);
            for (int i = 1; i < nums[0]; i++) {
                ans.add(i);
            }
            for (int i = 1; i < length; i++) {
                if (nums[i] - nums[i - 1] > 1) {
                    while (nums[i] - nums[i - 1] > 1) {
                        nums[i - 1] += 1;
                        ans.add(nums[i - 1]);
                    }
                }
            }
            while (length - nums[length - 1] > 0) {
                nums[length - 1] += 1;
                ans.add(nums[length - 1]);
            }
        }
        return ans;
    }
}
