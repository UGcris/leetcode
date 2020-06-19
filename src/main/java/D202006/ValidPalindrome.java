package D202006;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/19
 **/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        boolean ans = true;
        s = s.toLowerCase().replace(" ", "");
        if (s.length() > 0) {
            StringBuffer validStr = new StringBuffer();
            for (char ch : s.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    validStr.append(ch);
                    continue;
                }
                if (ch >= '0' && ch <= '9') {
                    validStr.append(ch);
                    continue;
                }
            }
            int length = validStr.length();
            if (length > 0) {
                for (int i = 0; i < length / 2; i++) {
                    if (validStr.charAt(i) != validStr.charAt(length - i - 1)) {
                        return false;
                    }
                }
            }
        }
        return ans;
    }
}
