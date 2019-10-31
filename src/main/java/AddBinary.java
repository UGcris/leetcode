/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/10/31
 **/
public class AddBinary {
    public String addBinary(String a, String b) {
        String result="";
        int carry=0,aLength=a.length()-1,bLength=b.length()-1;
        while (aLength>=0||bLength>=0){
            char aSub=aLength>=0?a.charAt(aLength):'0';
            char bSbu=bLength>=0?b.charAt(bLength):'0';
            int sum=aSub+bSbu+carry-'0'-'0';
            if(sum==2||sum==0){
                result+="0";
                carry=sum==2?1:0;
            }else if(sum==3||sum==1){
                result+="1";
                carry=sum==3?1:0;
            }
            aLength--;
            bLength--;
        }
        if(carry!=0) result+=carry;
        return new StringBuffer(result).reverse().toString();
    }
}
