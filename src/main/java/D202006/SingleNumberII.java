package D202006;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/9
 **/
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int x = 0, y = 0;
        for (int num : nums) {
            x = (x ^ num) & ~y;
            y = (y ^ num) & ~x;
        }
        return x;
    }

    /**
     * 错误
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int sum=0,trueSumn=0;
        for (int num : nums) {
            trueSumn+=num;
            set.add(num);
        }
        for (Integer num:set) {
            sum+=num*3;
        }
        return (trueSumn-sum)/2;
    }

    /**
     * 数据转为long
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for(int n : nums) {
            sumArray += n;
            set.add((long)n);
        }
        for(Long s : set) sumSet += s;
        return (int)((3 * sumSet - sumArray) / 2);
    }

}
