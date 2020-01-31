package TOIN;

/**
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。
 *
 * 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
 *
 * 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
 *
 * 示例 1 :
 *
 * 输入: "*"
 * 输出: 9
 * 解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * 示例 2 :
 *
 * 输入: "1*"
 * 输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
 * 说明 :
 *
 * 输入的字符串长度范围是 [1, 105]。
 * 输入的字符串只会包含字符 '*' 和 数字'0' - '9'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/10/29
 */

public class DecodeWaysII {
    /**
     * 动态规划
     * 1.当s[i]=='0',r[i]=r[i-2];
     * 2.当s[i-1]=='1',r[i]=r[i-1]+r[i-2];若s[i]=='*' r[i]=r[i-1]*9+r[i-2]*8
     * 3.当s[i-1]=='2' and 0<s[i]<7 ,r[i]=r[i-1]+r[i-2];若s[i]=='*',r[i]=r[i-1]*6+r[i-2]*8
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if('0'==s.charAt(0)) return 0;
        int m = 1000000007;
        long pre=1L,curr='*'==s.charAt(0)?9L:1L;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            Long temp=curr;
            if('0'==s.charAt(i)){
                if('1'==s.charAt(i-1)||'2'==s.charAt(i-1)){
                    curr=pre;
                }else if('*'==s.charAt(i-1)){
                    curr=pre*2;
                }else {
                    return 0;
                }
            }else if('*'==s.charAt(i)){
                    curr=9*temp;
                    if('*'==s.charAt(i-1)){
                        curr+=15*pre;
                    }else if('1'==s.charAt(i-1)){
                        curr+=9*pre;
                    }else if('2'==s.charAt(i-1)){
                        curr+=6*pre;
                    }
            }else if('6'>=s.charAt(i)){
                if ('*'==s.charAt(i-1)) {
                    curr += (2 * pre);
                } else if ('1'==s.charAt(i-1) || '2'==s.charAt(i-1)) {
                    curr += pre;
                }
            }else if ('6'<s.charAt(i)) {
                if ('*'==s.charAt(i-1) || '1'==s.charAt(i-1) ) {
                    curr += pre;
                }
            }
            curr%=m;
            pre=temp;
        }
        return (int)curr;
    }

}
