package TOIN;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/20
 **/
public class LetterCombinationsOfPhoneNumber {
    /**
     * 先过滤无效的数据
     * 再每次根据下一个字段的情况翻倍扩充
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String usfulStr="";
        for(int i=0;i<digits.length();i++){
            char ch=digits.charAt(i);
            if('1'==ch || '0'==ch || '*'==ch || '#'==ch){
                continue;
            }
            usfulStr+=ch;
        }
        if(usfulStr.length()<=0) return new ArrayList<>();
        List<String> result=new ArrayList<>(('7'==usfulStr.charAt(0)|| '9'==usfulStr.charAt(0))?4:3);
        for(int i=0;i<usfulStr.length();i++){
            char ch=usfulStr.charAt(i);
            if(result.isEmpty()){
                combineStr("",ch,result);
            }else{
                List<String> subResult=new ArrayList<>(result);
                result.clear();
                for (String prefix:subResult) {
                    combineStr(prefix,ch, result);
                }
            }
        }
        return result;
    }

    private void combineStr(String prefix, char ch, List<String> result) {
        switch (ch){
            case '2': result.add(prefix+"a"); result.add(prefix+"b"); result.add(prefix+"c"); break;
            case '3': result.add(prefix+"d"); result.add(prefix+"e"); result.add(prefix+"f"); break;
            case '4': result.add(prefix+"g"); result.add(prefix+"h"); result.add(prefix+"i"); break;
            case '5': result.add(prefix+"j"); result.add(prefix+"k"); result.add(prefix+"l"); break;
            case '6': result.add(prefix+"m"); result.add(prefix+"n"); result.add(prefix+"o"); break;
            case '7': result.add(prefix+"p"); result.add(prefix+"q"); result.add(prefix+"r"); result.add(prefix+"s"); break;
            case '8': result.add(prefix+"t"); result.add(prefix+"u"); result.add(prefix+"v"); break;
            case '9': result.add(prefix+"w"); result.add(prefix+"x"); result.add(prefix+"y"); result.add(prefix+"z"); break;
        }
    }
}
