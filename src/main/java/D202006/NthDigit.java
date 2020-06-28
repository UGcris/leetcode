package D202006;

import java.util.Map;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32位整数范围内 ( n < 231)。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * <p>
 * 输出:
 * 3
 * 示例 2:
 * <p>
 * 输入:
 * 11
 * <p>
 * 输出:
 * 0
 * <p>
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/28
 **/
public class NthDigit {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int power = 0, begin = 0;
        while (n > (begin + 9 * Math.pow(10, power) * (power + 1))) {
            begin += 9 * Math.pow(10, power) * (++power);
        }
        power++;
        int remainder = (n - begin) % power;
        int num = (int) ((n - begin + power - 1) / power + Math.pow(10, power - 1) - 1);
        if (remainder == 0) {
            remainder = power;
        }
        System.out.println((n - begin) / power);
        System.out.println(9 * Math.pow(10, power - 1));
        System.out.println("begin：" + begin + " power=" + power + " num:" + num + " remainder:" + remainder);
        return String.valueOf(num).charAt(remainder - 1) - '0';
    }
}
