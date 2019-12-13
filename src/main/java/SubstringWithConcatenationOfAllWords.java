import java.util.*;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/25
 */

public class SubstringWithConcatenationOfAllWords {
    /**
     * 一个list存储
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        int wdLength=words.length;
        int strLength=s.length();
        if(wdLength>0&&strLength>0){
            String temp=s;
            int beginIndex=strLength;
            int endIndex=0;
            int wordLength=0;
            Integer[][] beginIndexArray=new Integer[wdLength][strLength];
            Integer[][] endIndexArray=new Integer[wdLength][strLength];
            Map<Integer,String> wordMap=new HashMap<>();
            for (int i = 0; i < wdLength; i++) {
                String subString=words[i];
                if(!s.contains(subString)){
                    return result;
                }
                wordMap.put(i,subString);
                temp=s;
                wordLength+=subString.length();
                int index=0;
                int subIndex=temp.indexOf(subString);
                while (subIndex>0){
                    if(subIndex<beginIndex){
                        beginIndex=subIndex;
                    }
                    if(subIndex+subString.length()>endIndex){
                        endIndex=subIndex+subString.length();
                    }
                    beginIndexArray[i][index]=subIndex;
                    endIndexArray[i][index]=subIndex+subString.length();
                    temp=temp.substring(subIndex);
                    subIndex=temp.indexOf(subString);
                }
            }
            if(endIndex-beginIndex<wordLength){
                return result;
            }
            if(endIndex-beginIndex==wordLength){
                return Arrays.asList(beginIndex,endIndex);
            }
            for (int i = beginIndex; i < endIndex; i++) {

            }
        }
        return result;
    }

    /**
     * 抄作业
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    /**
     * 抄作业，滑动窗口
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                right += one_word;
                count++;
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if (count == word_num) res.add(left);

            }
        }

        return res;
    }

    /**
     * 抄完作业，自个来一遍
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring22(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if(null==s||s.isEmpty()||words.length==0){
            return result;
        }
        int wordLength=words[0].length();
        int totalWordLength=wordLength*words.length;
        int strLength=s.length();
        if(strLength<totalWordLength){
            return result;
        }
        Map<String,Integer> wordsMap=new HashMap<>();
        for (String word:words) {
            wordsMap.put(word,wordsMap.getOrDefault(word,0)+1);
        }
        for (int i = 0; i < strLength-totalWordLength+1; i++) {
            String temp=s.substring(i,i+totalWordLength);
            Map<String,Integer> comWordsMap=new HashMap<>();
            for (int j = 0; j < totalWordLength; j+=wordLength) {
                String word=temp.substring(j,j+wordLength);
                comWordsMap.put(word,comWordsMap.getOrDefault(word,0)+1);
            }
            if(wordsMap.equals(comWordsMap)) result.add(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        String str="test233";
        System.out.println(str.indexOf("te"));
        System.out.println(str.substring(str.indexOf("te")+2));
    }
}
