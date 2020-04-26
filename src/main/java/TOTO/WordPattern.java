package TOTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2020/4/14
 **/
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        boolean ans=true;
        if(pattern.length()<2&&str.length()<2){
            return ans;
        }
        String[] array=str.split(" ");
        if(pattern.length()!=array.length){
            return false;
        }
        List<Character> aimList=new ArrayList<>();
        List<String> list=new ArrayList<>();
        aimList.add(pattern.charAt(0));
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            char aimChar=pattern.charAt(i);
            String temp=array[i];
            if(aimList.contains(aimChar)&&list.contains(temp)&&aimList.indexOf(aimChar)==list.indexOf(temp)){
                continue;
            }else if(!aimList.contains(aimChar)&&!list.contains(temp)){
                aimList.add(aimChar);
                list.add(temp);
            }else{
                ans=false;
                break;
            }
        }
        return ans;
    }
}