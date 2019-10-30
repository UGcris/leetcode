/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author UGcris
 * @date 2019/10/28
 */

public class DecodeWays {
    /**
     * 递归，使用当前开头与前一个匹配，是否匹配
     * 执行用时感人
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int count=0;
        if(s.isEmpty()||s.startsWith("0")){
            return count;
        }

        if(s.indexOf("0")>0){
            String copy=""+s;
            for (int i = copy.indexOf("0"); i > -1;) {
                if(i==0||('1'!=copy.charAt(i-1)&&'2'!=copy.charAt(i-1))){
                    return count;
                }
                copy=copy.length()>1?copy.substring(i+1):"";
                i=copy.indexOf("0");
            }
        }
        count+=find(s,'9');
        return count;
    }

    private int find(String sub, char ch){
        int count=0;
        char beginCh=sub.charAt(0);
        if('0'==beginCh&&'1'!=ch&&'2'!=ch) return count;
        if('1'==ch||('2'==ch&&beginCh>='0'&&beginCh<='6')){
            if(sub.length()>2&&'0'!=sub.charAt(1)){
                count+=find(sub.substring(2),sub.charAt(1));
            }else if(sub.length()==1||'0'!=sub.charAt((1))){
                count++;
            }
        }
        if(sub.length()==1&&'0'!=beginCh){
            count++;
        }
        if(sub.length()>1&&'0'!=beginCh){
            count+=find(sub.substring(1),beginCh);
        }
        return count;
    }

    /**
     * 参照大佬的思路
     * 本题利用动态规划比较容易解决，但需要注意分晴况讨论 〇 dp[i]为str[0..i]的译码方法总数 〇分情况讨论：（建立最优子结构）
     *  ■若 s[i] = •〇’，那么若 s[i-l] = T or ’2•，则 dp[i] = dp[i-2];否则 return 0 □解择：s[i-l]+s【i]唯一被译码，不增加情况
     *  ■若 s[i-l] = 1•，则 dp[i] = dp[i-l] + dp[i-2]
     *      □解释：s[i-l]与s[i]分开译码，为dp[i-l];合并译码，为dp[i-2]
     *  ■若s[i-l]=，2, and T<=s[i]<=，6•，则 dp[i] = dp[i-l] + dp[i-2]
     *      □解释：同上
     * 〇由分析可知，dP[i]仅可能与前两项有关，S文可以用单变量代替dp[]数组，将空间复杂度从0 ( n )降到0 (1)
     * https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if('0'==s.charAt(0)) return 0;
        int pre=1,curr=1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            int temp=curr;
            if('0'==s.charAt(i)){
                if('1'==s.charAt(i-1)||'2'==s.charAt(i-1)){
                    curr=pre;
                }else {
                    return 0;
                }
            }else if('1'==s.charAt(i-1)||('2'==s.charAt(i-1)&&'0'<s.charAt(i)&&'7'>s.charAt(i))){
                curr+=pre;
            }
            pre=temp;
        }
        return curr;
    }
}
