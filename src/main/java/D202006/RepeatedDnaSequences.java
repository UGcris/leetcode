package D202006;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author UGcris
 * @date 2020/6/13
 **/
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i < s.length(); i++) {
            String subAns = s.substring(i - 10, i);
            map.put(subAns, map.getOrDefault(subAns, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    /**
     * 超时
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 10; i < s.length(); i++) {
            String subAns = s.substring(i - 10, i);
            if (!ans.contains(subAns) && s.lastIndexOf(subAns) > i - 10) {
                ans.add(subAns);
            }
        }
        return ans;
    }
}
