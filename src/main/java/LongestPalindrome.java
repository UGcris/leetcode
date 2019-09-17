/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/9/17
 */

public class LongestPalindrome {
    /**
     * 以某个点为起点，找以该点为终点的字串是否回文
     * version 1：超市有误
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        //寻找一个字串的首位
        if(s.length()<=1){
            return s;
        }
        String result=s.charAt(0)+"";
        for(int i=0;i<s.length()-1;i++){
            Character ch=s.charAt(i);
            String subString=s.substring(i+1);
            if(subString.length()>=result.length()){
                if(subString.equals(ch+"")){
                    result=""+ch+ch;
                }
                if(subString.length()>1){
                    String value=find(subString,""+ch);
                    if(value.length()>result.length()){
                        result=value;
                    }
                }
            }else{
                break;
            }
        }
        return result;
    }
    private String find(String str, String ch) {
        String result="";
        int index=str.lastIndexOf(ch);
        while (index>=0&&result.length()==0){
            if(index==0){
                result=ch+ch;
            }else if(index==1){
                result=ch+str.charAt(0)+ch;
            }else{
                String value=find(str.substring(1,index),str.charAt(0)+"");
                if(value.length()==index){
                    result=ch+value+ch;
                }else{
                    index=str.substring(0,index).lastIndexOf(ch);
                }
            }
        }
        return  result;
    }

    /**
     * 最长公共字串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String result="";
        String reversalStr=new StringBuffer(s).reverse().toString();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==reversalStr.charAt(i)){
                result+=s.charAt(i);
            }else{
                result="";
            }
        }
        if(result.length()==0){
            result=s.charAt(0)+"";
        }
        return result;
    }
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome=new LongestPalindrome();
        System.out.println(System.currentTimeMillis());
        System.out.println(longestPalindrome.longestPalindrome("cbcdcbedcbc"));
        System.out.println(System.currentTimeMillis());
    }
}
