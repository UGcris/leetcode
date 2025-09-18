package D202507;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 76. 最小覆盖子串
 * 已解答
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 * 提示：
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 *
 *
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 * https://leetcode.cn/problems/minimum-window-substring/submissions/?envType=problem-list-v2&envId=w8OJJIbl
 * @Author UGcris
 * @date 2025-07-09
 **/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        Map<Character, Integer> pairs = new HashMap<>();
        for (char ch : t.toCharArray()) {
            pairs.merge(ch, 1, Integer::sum);
        }
        Set<Character> keyWords = new HashSet<>(pairs.keySet());
        String result = s + "e";

        int len = keyWords.size();
        for (int sidx = 0, edix = 0; sidx <= s.length() - t.length(); sidx++) {
            while (sidx < s.length()) {
                if (keyWords.contains(s.charAt(sidx))) {
                    break;
                }
                sidx++;
            }
            if (sidx > s.length() - t.length()) {
                break;
            }
            edix = Math.max(edix, sidx);
            while (edix < s.length() && len > 0) {
                char ch = s.charAt(edix);
                if (keyWords.contains(ch)) {
                    pairs.merge(ch, -1, Integer::sum);
                    if (pairs.get(ch) == 0) {
                        len--;
                    }
                }
                edix++;
            }
            if (len == 0) {
                if (edix - sidx <= result.length()) {
                    result = s.substring(sidx, edix);
                }
                char sch = s.charAt(sidx);
                pairs.merge(sch, 1, Integer::sum);
                if (pairs.get(sch) > 0) {
                    len++;
                }
            } else {
                break;
            }
        }
        return result.length() > s.length() ? "" : result;
    }
    public String minWindow2(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        Map<Character, Integer> pairs = new HashMap<>();
        for (char ch : t.toCharArray()) {
            pairs.merge(ch, 1, Integer::sum);
        }
        Set<Character> keyWords = new HashSet<>(pairs.keySet());
        String result = s + "e";

        int len = keyWords.size(),sidx=0,eidx=0;
        while (sidx <= s.length() - t.length()) {
            if (eidx - sidx <= result.length() && len == 0 && eidx>sidx) {
                result = s.substring(sidx, eidx);
            }
            while (!keyWords.contains(s.charAt(sidx))) {
                sidx++;
            }
            eidx = Math.max(eidx, sidx);
            while (eidx < s.length() && len > 0) {
                char ch = s.charAt(eidx);
                if (keyWords.contains(ch)) {
                    pairs.merge(ch, -1, Integer::sum);
                    if (pairs.get(ch) == 0) len--;
                }
                eidx++;
            }
            char sch = s.charAt(sidx++);
            if (pairs.get(sch) > 0) len++;
            pairs.merge(sch, 1, Integer::sum);
        }
        return result.length() > s.length() ? "" : result;
    }

}