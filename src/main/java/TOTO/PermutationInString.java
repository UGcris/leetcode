package TOTO;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/7
 **/
public class PermutationInString {
    /**
     * 滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] s1Arr=new int[26];
        int[] s2Arr=new int[26];
        for (char ch:s1.toCharArray()) {
            s1Arr[ch-'a']++;
        }
        int left=0,right=0,total=s1.length();
        while (right<s2.length()){
            char ch=s2.charAt(right);
            if(s1Arr[ch-'a']>0){
                s2Arr[ch-'a']++;
                if(s1Arr[ch-'a']>=s2Arr[ch-'a']) total--;
            }
            while (total==0){
                if(right-left+1==s1.length()) return true;
                char ch2=s2.charAt(left);
                if(s1Arr[ch2-'a']>0){
                    s2Arr[ch2-'a']--;
                    if(s1Arr[ch2-'a']>s2Arr[ch2-'a']) total++;
                }
                left++;
            }
            right++;
        }
        return false;
    }
}

