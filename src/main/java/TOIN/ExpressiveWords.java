package TOIN;

import java.util.*;

/**
 * 输入：
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 *  
 *
 * 说明：
 *
 * 0 <= len(S) <= 100。
 * 0 <= len(words) <= 100。
 * 0 <= len(words[i]) <= 100。
 * S 和所有在 words 中的单词都只由小写字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expressive-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/10/28
 */

public class ExpressiveWords {
    /**
     * 截取最长相同字符组成的字串，对比原有数据
     * 1、等于目标数据截取的长度
     * 2、大于目标数据截取的长度，且源数据截取的长度大于3
     * @param s
     * @param words
     * @return
     */
    public int expressiveWords(String s, String[] words) {
        int count=0;
        int indexBegin=0;
        List<String> tempArr= new ArrayList<>(Arrays.asList(words));
        for (int i = 0; i < s.length(); i++) {
            if(i+1>=s.length()||s.charAt(i+1)!=s.charAt(i)){
                char ch=s.charAt(i);
                for (int j = 0; j < tempArr.size(); ) {
                    String wd=tempArr.get(j);
                    int index=0;
                    while (index<wd.length()&&wd.charAt(index)==ch){
                        index++;
                    }
                    tempArr.remove(j);
                    if(index!=0&&index<(i+1-indexBegin)?(i+1-indexBegin)>2:index==(i+1-indexBegin)){
                        String sub=wd.substring(index);
                        tempArr.add(j,sub);
                        if(i+1>=s.length()&&sub.isEmpty()){
                            count++;
                        }
                        j++;
                    }
                }
                indexBegin=i+1;
            }
        }
        return count;
    }

}
