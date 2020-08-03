package D20208;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/8/3
 **/
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int carry = 0, length1 = num1.length(), length2 = num2.length();
        for (int i = 0; i < length1 || i < length2; i++) {
            int left = i < num1.length() ? (num1.charAt(length1 - i - 1) - '0') : 0;
            int right = i < num2.length() ? (num2.charAt(length2 - i - 1) - '0') : 0;
            int sum = left + right + carry;
            if (sum < 10) {
                ans.append(sum);
                carry = 0;
                continue;
            }
            ans.append(sum - 10);
            carry = 1;
        }
        if (carry > 0) {
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
