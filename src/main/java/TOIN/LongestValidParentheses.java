package TOIN;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/25
 **/
public class LongestValidParentheses {
    /**
     * 从1到最大N个组合的匹配
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {int result=0;
        //去除前后的异常括号
        while (s.startsWith(")")){
            s=s.substring(1);
        }
        while (s.endsWith("(")){
            s=s.substring(0,s.length()-1);
        }
        for (int i=0;i<s.length()-result;i++){
            int index=i;
            int arrIndex=0;
            int pair=0;
            char[] arr=new char[s.length()-i];
            do{
                if('('==s.charAt(index)){
                    index++;
                    arr[arrIndex++]='(';
                    pair=0;
                }else if(')'==s.charAt(index)){
                    index++;
                    if(--arrIndex>=0&&'('==arr[arrIndex]){
                        arr[arrIndex]='\0';//清空
                        pair++;
                        if(arr[0]=='\0'&&result<(index-i)){
                            result=index-i;
                        }
                        if(result<pair*2) result=pair*2;
                    }else {
                        break;
                    }
                }
            }while (index<s.length());
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses=new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
    }

}
