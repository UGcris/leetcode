package D202007;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/7/18
 **/
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean ans = false;
        if (s1.length() + s2.length() == s3.length()) {
            if (s3.length() == 0) ans = true;
            if (!ans && s1.length() > 0 && s1.charAt(0) == s3.charAt(0)) ans = find(s1, s2, s3);
            if (!ans && s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) ans = find(s2, s1, s3);
        }
        return ans;
    }

    private boolean find(String s1, String s2, String s3) {
        int index1 = 1, index3 = 1;
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        while (s2.charAt(0) != s3.charAt(index3) && index1 < s1.length()) {
            if (s1.charAt(index1) != s3.charAt(index3)) return false;
            index1++;
            index3++;
        }
        return isInterleave(s1.substring(index1), s2, s3.substring(index3));
    }
}
