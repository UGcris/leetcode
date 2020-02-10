package TOTO;

import java.util.Arrays;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/10
 **/
public class MinimumWindowSubstring {
    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String result="";
        if(s.length()<t.length()||s.length()==0) return result;
        if(s.equals(t)) return s;
        int[] sArray=new int[58];
        int[] tArray=new int[58];
        result=s+s;
        for (char ch:t.toCharArray()) {
            tArray[ch-'A']++;
        }
        int left=0,right=0,total=t.length();
        while (right<s.length()){
            char ch=s.charAt(right);
            if(tArray[ch-'A']>0){
                sArray[ch-'A']++;
                if(tArray[ch-'A']>=sArray[ch-'A']) total--;
            }
            while (0==total){
                if(right-left+1<result.length()) result=s.substring(left,right+1);
                char chSub=s.charAt(left++);
                if(tArray[chSub-'A']>0){
                    sArray[chSub-'A']--;
                    if(tArray[chSub-'A']>sArray[chSub-'A']) total++;
                }
            }
            right++;
        }
        return result.length()>s.length()?"":result;
    }
}
