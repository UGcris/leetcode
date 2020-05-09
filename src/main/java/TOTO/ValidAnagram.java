package TOTO;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/3
 **/
public class ValidAnagram {
    /**
     * 排序后对比
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] ch1=s.toCharArray();
        char[] ch2=t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return String.valueOf(ch1).equals(String.valueOf(ch2));
    }

    /**
     * 数组记录字母出现次数，比较
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        if(s.length()==0) return true;
        int[] arr=new int[26];
        for (char ch:s.toCharArray()) {
            arr[ch-'a']++;
        }
        for (char ch:t.toCharArray()) {
            arr[ch-'a']--;
        }
        for (int count:arr) {
            if(count!=0) return false;
        }
        return true;
    }

}
