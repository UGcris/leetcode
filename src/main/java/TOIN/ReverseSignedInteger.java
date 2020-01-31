package TOIN;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author UGcris
 * @date 2019/9/18
 **/
public class ReverseSignedInteger {
    /**
     * NOTE:    -2^31=-2,147,483,648
     *          2^31− 1=2,147,483,647‬
     *          先提取符号
     *          再反转字符串
     *          最后判断是否越界
     *
     *  优化：直接转换，捕获异常，返回0
     * @param x
     * @return
     */
    public int reverse(int x) {
        if(x>-10&&x<10){
            return x;
        }
        Integer result=new Integer(0);
        String str=""+x;
//        String resultStr="";
//        String boundary="2147483647";
        char symble='\0';
        if('-'==str.charAt(0)){
            symble='-';
            str=str.substring(1);
//            boundary="2147483648";
        }
//        boolean isBeginOfZero=true;
//        boolean isLower=false;
        try{
            result=new Integer(('\0'==symble?"":symble)+new StringBuffer(str).reverse().toString());
        }catch (Exception e){
            return 0;
        }

//        str=new StringBuffer(str).reverse().toString();
//        if(str.length()<=10){
//            if(str.length()<10){
//                isLower=true;
//            }
//            for (int i = 0 ; i <str.length(); i++) {
//                if(!isBeginOfZero){
//                    resultStr+=str.charAt(i);
//                }else if('0'!=str.charAt(i)){
//                    resultStr+=str.charAt(i);
//                    isBeginOfZero=false;
//                }
//                if(!isLower){
//                    if(boundary.charAt(i)<str.charAt(i)){
//                        break;
//                    }
//                    if(i==9?boundary.charAt(i)>=str.charAt(i):boundary.charAt(i)>str.charAt(i)){
//                        isLower=true;
//                    }
//                }
//            }
//        }
//        if(isLower&&resultStr.length()>0){
//            result=new Integer(('\0'==symble?"":symble)+resultStr);
//        }
        return result;
    }

    public static void main(String[] args) {
        ReverseSignedInteger reverseSignedInteger=new ReverseSignedInteger();
        System.out.println(reverseSignedInteger.reverse(1563847412));
    }
}
