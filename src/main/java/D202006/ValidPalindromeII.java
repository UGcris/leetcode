package D202006;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/10
 **/
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s.length() < 2) return true;
        int left = 0, right = s.length() - 1;
        for (; left < right && s.charAt(left) == s.charAt(right); left++, right--) {

        }
        return find(s, left, right - 1) || find(s, left + 1, right);
    }

    private boolean find(String s, int left, int right) {
        for (; left < right && s.charAt(left) == s.charAt(right); left++, right--) {

        }
        return left >= right;
    }

    private boolean find(String s, int left, int right, boolean hasRemoved) {
        if (left >= right) return true;
        for (int i = 0; i < s.length() && right > left; i++) {
            if (s.charAt(left) == s.charAt(right) && find(s, left + 1, right - 1, hasRemoved)) {
                return true;
            }
            if (!hasRemoved && find(s, left + 1, right, true)) {
                return true;
            }
            if (!hasRemoved && find(s, left, right - 1, true)) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }
}
