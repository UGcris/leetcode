package TOTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/2/3
 **/
public class GroupAnagrams {
    /**
     * 质数表示
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> resultMap=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        map.put('a',2);
        map.put('b',3);
        map.put('c',5);
        map.put('d',7);
        map.put('e',11);
        map.put('f',13);
        map.put('g',17);
        map.put('h',19);
        map.put('i',23);
        map.put('j',29);
        map.put('k',31);
        map.put('l',37);
        map.put('m',41);
        map.put('n',43);
        map.put('o',47);
        map.put('p',53);
        map.put('q',59);
        map.put('r',61);
        map.put('s',67);
        map.put('t',71);
        map.put('u',73);
        map.put('v',79);
        map.put('w',83);
        map.put('x',89);
        map.put('y',97);
        map.put('z',101);
        for (int i = 0; i < strs.length; i++) {
            int sum=1;
            char[] chars=strs[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                sum*=map.get(chars[j]);
            }
            List<String> subList=resultMap.containsKey(sum)?resultMap.get(sum):new ArrayList<>();
            subList.add(strs[i]);
            resultMap.put(sum,subList);
        }
        resultMap.forEach((k,v)->{
            result.add(v);
        });
        return result;
    }

    /**
     * 参考优化
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<Long,List<String>> resultMap=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        int[] table = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (String str:strs) {
            Long sum=1L;
            for (char ch:str.toCharArray()) {
                sum*=table[ch-'a'];
            }

            List<String> subList=resultMap.get(sum);
            if(null!=subList){
                subList.add(str);
            }else {
                subList=new ArrayList<>();
                subList.add(str);
                resultMap.put(sum,subList);
                result.add(subList);
            }
        }
//        resultMap.forEach((k,v)->{
//            result.add(v);
//        });
        return result;
    }
}
