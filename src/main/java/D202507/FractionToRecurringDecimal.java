package D202507;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 *
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 *
 * 提示：
 *
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 * https://leetcode.cn/problems/fraction-to-recurring-decimal/?envType=problem-list-v2&envId=w8OJJIbl
 * @Author UGcris
 * @date 2025-07-09
 **/
public class FractionToRecurringDecimal {
    private static final int MAX_LEN = 10000;


    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal(numerator * 1L, denominator * 1L);
    }

    public String fractionToDecimal(Long numerator, Long denominator) {
        StringBuilder str = new StringBuilder();
        long pre = numerator / denominator;
        if (numerator >= 0 & denominator > 0) {
        } else if (numerator <= 0 & denominator < 0) {
        } else if (pre >= 0) {
            str.append("-");
        }
        str.append(pre);
        if (numerator % denominator == 0) {
            return str.toString();
        }
        str.append(".");
        Map<Long, Integer> stmap = new HashMap<>();
        str.append(div(Math.abs(numerator) % Math.abs(denominator) * 10, Math.abs(denominator), str.length(), stmap));
        return str.toString();
    }

    public String div(long numerator, long denominator, int len, Map<Long, Integer> stmap) {
        if (numerator == 0) {
            return "";
        }
        long sn = numerator;
        if (stmap.containsKey(sn)) {
            stmap.put(sn, len);
            return "";
        }
        stmap.put(sn, len);
        StringBuilder str = new StringBuilder();
        while (numerator < denominator) {
            str.append("0");
            numerator *= 10;
        }
        if (len + str.length() >= MAX_LEN) {
            return "";
        }
        str.append(numerator / denominator);
        if (len + str.length() == MAX_LEN) {
            return str.toString();
        } else if (len + str.length() > MAX_LEN) {
            return str.substring(0, MAX_LEN - len + 1);
        }
        String end = div(numerator % denominator * 10, denominator, len + str.length(), stmap);
        if (stmap.get(sn) > len) {
            return "(" + str + end + ")";
        } else {
            str.append(end);
        }
        return str.toString();
    }

}