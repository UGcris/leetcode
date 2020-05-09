package TOIN;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/23
 **/
public class ValidParentheses {
    /**
     * 找到和第一个符号闭合的另一半
     * 递归寻找字串是否完全闭合
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()%2==1){
            return false;
        }
        return subIsValid(s.charAt(0),s);
    }

    private boolean subIsValid(char charAt, String substring) {
        if(substring.length()%2==1){
            return false;
        }
        boolean result=false;
        char otherCh='\0';
        switch (charAt){
            case '(':otherCh=')';break;
            case '{':otherCh='}';break;
            case '[':otherCh=']';break;
            default:return result;
        }
        if (substring.length()==2){
            return substring.equals(""+charAt+otherCh);
        }

        for (int i=substring.indexOf(otherCh);i!=-1;){
            boolean subResult=i-1==0?true:subIsValid(substring.charAt(1),substring.substring(1,i));
            boolean otResult=true;
            if(subResult){
                if(i+1< substring.length()){
                    otResult=subIsValid(substring.charAt(i+1),substring.substring(i+1,substring.length()));
                }
            }
            if(subResult&&otResult){
                return true;
            }else {
                i=substring.indexOf(otherCh,i+1);
            }
        }
        return result;
    }

    /**
     * 数组模拟栈
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()%2==1){
            return false;
        }
        boolean result=true;
        int index=0;
        char[] stack=new char[s.length()];
        for (int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                case '{':
                case '[':
                    //进栈
                    stack[index++]=s.charAt(i);
                    continue;
                case ')':
                    if(index==0|| stack[--index]!='('){
                        return false;
                    }
                    continue;
                case '}':
                    if(index==0|| stack[--index]!='{'){
                        return false;
                    }
                    continue;
                case ']':
                    if(index==0|| stack[--index]!='['){
                        return false;
                    }
                    continue;
            }
        }
        return index==0;
    }
    public static void main(String[] args) {
        ValidParentheses validParentheses=new ValidParentheses();
        System.out.println(validParentheses.isValid2("[({(())}[()])]"));
    }
}
