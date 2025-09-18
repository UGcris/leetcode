package D202507;

/**
 * 273. 整数转换英文表示
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 将非负整数 num 转换为其对应的英文表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 *
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 *
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 *
 * 提示：
 *
 * 0 <= num <= 231 - 1
 * https://leetcode.cn/problems/integer-to-english-words/description/?envType=problem-list-v2&envId=w8OJJIbl&
 * @Author UGcris
 * @date 2025-07-08
 **/
public class IntegerToEnglishWords {
    private static final String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res="";
        int bit=1;
        int div=10;

        StringBuffer sb = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
//                StringBuffer curr = new StringBuffer();
                recursion(sb, curNum);
                sb.append(thousands[i]).append(" ");
//                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    private void recursion(StringBuffer curr, int curNum) {
        if(curNum==0) return;
        if (curNum < 10) {
            curr.append(singles[curNum]).append(" ");
        } else if (curNum < 20) {
            curr.append(teens[curNum - 10]).append(" ");
        } else if (curNum < 100) {
            curr.append(tens[curNum / 10]).append(" ");
            recursion(curr, curNum % 10);
        } else {
            curr.append(singles[curNum / 100]).append(" Hundred ");
            recursion(curr, curNum % 100);
        }
    }

}