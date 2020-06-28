package D202006;

import java.net.Inet4Address;
import java.util.*;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/17
 **/
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        if (length < 1) return "";
        if (length == 0) return String.valueOf(nums[0]);
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i; j++) {
                String str1 = new StringBuffer().append(nums[j - 1]).append(nums[j]).toString();
                String str2 = new StringBuffer().append(nums[j]).append(nums[j - 1]).toString();
                if (str1.equals(str2)) {
                    continue;
                }
                for (int k = 0; k < str1.length(); k++) {
                    if (str1.charAt(k) > str2.charAt(k)) {
                        break;
                    } else if (str2.charAt(k) > str1.charAt(k)) {
                        int temp = nums[j - 1];
                        nums[j - 1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        if (nums[0] == 0) {
            return "0";
        }
        for (int i = 0; i < length; i++) {
            ans.append(nums[i]);
        }
        return ans.toString();
    }

    /**
     * 通过实现Comparator的接口实现比较
     * 优化运行时间
     * @param nums
     * @return
     */
    public String largestNumber2(int[] nums) {
        int length = nums.length;
        if (length < 1) return "";
        if (length == 0) return String.valueOf(nums[0]);
        StringBuffer ans = new StringBuffer();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2, str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        list.forEach(str -> ans.append(str));
        if (ans.charAt(0) == '0') return "0";
        return ans.toString();
    }
}
