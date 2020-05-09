package TOIN;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/10/31
 **/
public class MultiplyStrings {
    /**
     * 数组存在对应位上的值
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)) return "0";
        int length1=num1.length(),length2=num2.length();
        int[] value=new int[length1+length2];
        for (int i = length1-1; i >=0; i--) {
            char a=num1.charAt(i);
            for (int j = length2-1; j >=0; j--) {
                char b=num2.charAt(j);
                int product=(a-'0')*(b-'0')+value[i+j+1];
                value[i+j+1]=product%10;
                value[i+j]+=product/10;
            }
        }
        String result="";
        int beginIndex=0;//起始index
        while (value[beginIndex]==0) beginIndex++;
        for (int i = beginIndex; i <length1+length2; i++) {
            result+=value[i];
        }
        return result;
    }
}
