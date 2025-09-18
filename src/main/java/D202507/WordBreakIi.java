package D202507;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140. 单词拆分 II
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 *
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 *
 *
 *
 * 示例 1：
 *
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * 示例 2：
 *
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 * https://leetcode.cn/problems/word-break-ii/description/?envType=problem-list-v2&envId=w8OJJIbl&
 * @Author UGcris
 * @date 2025-07-08
 **/
public class WordBreakIi {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result=null;
        try {
            result=wordBreak(s,wordDict,0,1);
        }catch (Exception e){

        }
        return null==result?new ArrayList<>():result;
    }

    private List<String> wordBreak(String s, List<String> wordDict, int sidx, int edix) throws Exception{
        if(sidx>=s.length()){
            return null;
        }
        List<String> result=null;
        while (edix<=s.length()&&edix-sidx<=10){
            if(wordDict.contains(s.substring(sidx,edix))){
                try {
                    List<String> str=wordBreak(s,wordDict,edix,edix+1);
                    if(null==result) result=new ArrayList<>();
                    if(null==str||str.isEmpty()){
                        result.add(s.substring(sidx,edix));
                    }else {
                        for (String s1 : str) {
                            result.add(s.substring(sidx,edix)+" "+s1);
                        }
                    }
                }catch (Exception e){

                }
            }
            edix++;
        }
        if(null==result||result.isEmpty()){
            throw new Exception("non");
        }
        return result;
    }

}